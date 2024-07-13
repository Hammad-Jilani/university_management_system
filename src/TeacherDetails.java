import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class TeacherDetails extends JFrame implements ActionListener {
    Choice select;
    JTable table;
    JButton search,print,add,update,back;
    public TeacherDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search By ID");
        heading.setBounds(100,10,250,30);
        heading.setFont(new Font("roboto",Font.BOLD,20));
        add(heading);

        Connect c = new Connect();
        try {
            ResultSet set = c.s.executeQuery("select * from teacher");

            select = new Choice();
            select.setBounds(400,10,200,30);
            add(select);
            while (set.next()){
                select.add(set.getString("rollNumber"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet set = null;
        try {
            set = c.s.executeQuery("select * from teacher");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        table = new JTable();
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0,110,1100,600);
        add(pane);
        table.setModel(DbUtils.resultSetToTableModel(set));

        search = new JButton("Search");
        search.setBounds(50,60,100,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(180,60,100,20);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add");
        add.setBounds(310,60,100,20);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(440,60,100,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.addActionListener(this);
        back.setBounds(570,60,100,20);
        add(back);

        setVisible(true);
        setBounds(0,10,1100,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new TeacherDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == print){
            try {
                table.print();
            } catch (PrinterException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == add) {
            new AddTeacher();
            setVisible(false);
        }else if(e.getSource() == update){
            setVisible(false);
        } else if (e.getSource() == back) {
            setVisible(false);
            new Project();
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }else{
            String query = "select * from teacher where rollNumber = '"+select.getSelectedItem()+"'";
            Connect c = new Connect();
            try {
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
    }
}
