import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherLeave extends JFrame implements ActionListener {
    JComboBox id;
    JButton submit, cancel;
    JDateChooser start,end;
    public TeacherLeave(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(170,30,300,40);
        heading.setFont(new Font("Roboto",Font.BOLD,20));
        add(heading);

        JLabel search = new JLabel("Search by Employee ID");
        search.setBounds(50,100,200,15);
        add(search);

        id = new JComboBox();
        Connect c = new Connect();
        try {
            ResultSet set = c.s.executeQuery("select * from teacher");
            while (set.next()){
                id.addItem(set.getString("rollNumber"));
            }
            id.setBounds(50,130,200,20);
            add(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        JLabel lblstartDate = new JLabel("Leave Starts");
        lblstartDate.setBounds(50,180,200,20);
        add(lblstartDate);

        start = new JDateChooser();
        start.setBounds(50,210,200,20);
        add(start);

        JLabel lblendDate = new JLabel("Leave End");
        lblendDate.setBounds(50,210+50,200,20);
        add(lblendDate);

        end = new JDateChooser();
        end.setBounds(50,210+80,200,20);
        add(end);

        submit = new JButton("Submit");
        submit.setBounds(100,350,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(250,350,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
        setBounds(250,30,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new TeacherLeave();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit){
            String starting = ((JTextField) start.getDateEditor().getUiComponent()).getText();
            String ending = ((JTextField) end.getDateEditor().getUiComponent()).getText();
            String rollNumber = String.valueOf(id.getSelectedItem());
            Connect c = new Connect();
            try {
                c.s.execute("insert into teacherLeave values('"+starting+"','"+ending+"','"+rollNumber+"')");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(null,"Insertion Successful");
        }else{
            setVisible(false);
            new Project();
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }
}
