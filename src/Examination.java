import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Examination extends JFrame implements ActionListener {
    JTextField search;
    JButton submit,cancel;
    JTable table;
    public Examination(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Check Result");
        heading.setBounds(400,30,200,30);
        heading.setFont(new Font("Roboto",Font.BOLD,20));
        add(heading);

        search = new JTextField();
        search.setBounds(100,70,200,30);
        add(search);

        submit = new JButton("Result");
        submit.setBounds(340,70,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Back");
        cancel.setBounds(460,70,100,30);
        cancel.addActionListener(this);
        add(cancel);

        table = new JTable();

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0,100,900,400);
        add(pane);

        Connect c = new Connect();
        try {
            ResultSet set =  c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(set));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,5).toString());
            }
        });

        setVisible(true);
        setBounds(200,40,900,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Examination();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit){

            new Marks(search.getText());
            setVisible(false);
        }else{
            setVisible(false);
            new Project();
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }
}
