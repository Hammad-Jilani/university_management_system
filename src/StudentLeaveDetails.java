import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentLeaveDetails extends JFrame implements ActionListener {
    Choice choose;
    JTable table;
    JButton searchBtn,printBtn,cancelBtn;
    public StudentLeaveDetails()  {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel search = new JLabel("Search by roll number");
        search.setBounds(30,50,150,30);
        add(search);

        choose = new Choice();
        Connect c = new Connect();
        try {
            ResultSet set =c.s.executeQuery("select * from sudentLeave");
            while (set.next()){
                choose.add(set.getString("rollNumber"));
            }
            choose.setBounds(200,50,180,30);
            add(choose);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        table = new JTable();
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0,110,600,400);

        try {
            ResultSet set =c.s.executeQuery("select * from sudentLeave");
            table.setModel(DbUtils.resultSetToTableModel(set));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        add(pane);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(50,80,100,20);
        searchBtn.addActionListener(this);
        add(searchBtn);

        printBtn = new JButton("Print");
        printBtn.setBounds(200,80,100,20);
        printBtn.addActionListener(this);
        add(printBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(350,80,100,20);
        cancelBtn.addActionListener(this);
        add(cancelBtn);


        setVisible(true);
        setBounds(200,30,600,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new StudentLeaveDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelBtn){
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(false);
            new Project();
        } else if (e.getSource() == printBtn) {
            try {
                table.print();
            } catch (PrinterException ex) {
                throw new RuntimeException(ex);
            }
        }else{
            String selected = choose.getSelectedItem();
            Connect c = new Connect();
            try {
                ResultSet set = c.s.executeQuery("select * from sudentLeave where rollNumber = '"+selected+"'");
                table.setModel(DbUtils.resultSetToTableModel(set));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
