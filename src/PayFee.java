import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PayFee extends JFrame implements ActionListener {
    Choice rollNumber,course,semester;
    JButton submit,back;
    public PayFee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblRoll = new JLabel("Select Roll Number :");
        lblRoll.setBounds(60,20,150,20);
        add(lblRoll);

        rollNumber = new Choice();
        Connect c = new Connect();
        try {
            ResultSet set = c.s.executeQuery("select * from student");
            while (set.next()){
                rollNumber.addItem(set.getString("rollNumber"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        rollNumber.setBounds(240,20,150,20);
        add(rollNumber);

        JLabel lblName = new JLabel("Name :");
        lblName.setBounds(60,60,150,20);
        add(lblName);

        JLabel Name = new JLabel();
        Name.setBounds(240,60,150,20);
        Name.setFont(new Font("Roboto",Font.PLAIN,13));
        add(Name);

        JLabel lblFName = new JLabel("Father Name :");
        lblFName.setBounds(60,100,150,20);
        add(lblFName);

        JLabel fName = new JLabel();
        fName.setBounds(240,100,150,20);
        fName.setFont(new Font("Roboto",Font.PLAIN,13));
        add(fName);

        JLabel lblCourse = new JLabel("Course :");
        lblCourse.setBounds(60,140,150,20);
        add(lblCourse);

        JLabel course = new JLabel();
        course.setBounds(240,140,150,20);
        course.setFont(new Font("Roboto",Font.PLAIN,13));
        add(course);

        JLabel lblSemester = new JLabel("Semester :");
        lblSemester.setBounds(60,180,150,20);
        add(lblSemester);

        String sem[] = {"semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
        semester = new Choice();
        for (String e:sem) {
            semester.addItem(e);
        }
        semester.setBounds(240,180,150,20);
        add(semester);

        rollNumber.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    ResultSet set = c.s.executeQuery("select * from student where rollNumber = '"+rollNumber.getSelectedItem()+"'");
                    if (set.next()){
                        Name.setText(set.getString("name"));
                        fName.setText(set.getString("fname"));
                        course.setText(set.getString("course"));
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });


        JLabel lblFee = new JLabel("Fees :");
        lblFee.setBounds(60,220,150,20);
        add(lblFee);

        JLabel fee = new JLabel();
        fee.setBounds(240,220,150,20);
        fee.setFont(new Font("Roboto",Font.PLAIN,13));
        add(fee);

        semester.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    ResultSet set = c.s.executeQuery("select * from fee where course1 = '"+course.getText()+"'");
                    if (set.next()){
                        fee.setText(set.getString(String.valueOf(semester.getSelectedItem())));
                    }
                } catch (SQLException ee) {
                    throw new RuntimeException(ee);
                }
            }
        });

        submit = new JButton("Submit");
        submit.setBounds(80,280,100,30);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        submit.setForeground(Color.WHITE);
        add(submit);

        back = new JButton("Back");
        back.setBounds(240,280,100,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(420,80,350,350);
        add(image);

        setVisible(true);
        setBounds(200,40,800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new PayFee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit){
            Connect c = new Connect();
            try {
                c.s.execute("insert into pay values('"+rollNumber.getSelectedItem()+"','"+semester.getSelectedItem()+"','Paid')");
                JOptionPane.showMessageDialog(null,"Fees Paid");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }else{
            new Project();
            setVisible(false);
        }
    }
}
