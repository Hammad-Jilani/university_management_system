import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FeeStructure extends JFrame implements ActionListener {

    JButton button;
    public  FeeStructure(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(250,20,200,30);
        heading.setFont(new Font("Roboto",Font.BOLD,20));
        add(heading);

        button = new JButton("Back");
        button.setBounds(500,20,100,20);
        button.addActionListener(this);
        add(button);

        JTable table = new JTable();
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0,100,1000,500);
        add(pane);

        Connect c = new Connect();
        try {
            ResultSet set = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(set));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        setBounds(100,30,1000,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }
    public static void main(String[] args) {
        new FeeStructure();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){
            setVisible(false);
            new Project();
        }
    }
}
