import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class StudentUpdate extends JFrame implements ActionListener {
    JButton back,submit;
    Choice select;
    JTextField address,phone,email;
    JComboBox course;
    public  StudentUpdate(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(230,0,350,40);
        heading.setFont(new Font("Roboto",Font.BOLD,30));
        add(heading);

        JLabel selectRoll = new JLabel("Select Roll Number :");
        selectRoll.setBounds(100,50,150,20);
        add(selectRoll);

        select = new Choice();
        Connect c = new Connect();
        try {
            ResultSet set = c.s.executeQuery("select * from student");
            while (set.next()){
                select.addItem(set.getString("rollNumber"));
            }
            select.setBounds(270,50,150,30);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        add(select);

        JLabel lblName = new JLabel("Name :");
        lblName.setBounds(100,80,60,30);
        lblName.setFont(new Font("serif",Font.PLAIN,16));
        add(lblName);

        JLabel name = new JLabel();
        name.setBounds(200,80,200,30);
        add(name);

        JLabel lblFatherName = new JLabel("Father Name :");
        lblFatherName.setBounds(450,80,100,30);
        lblFatherName.setFont(new Font("serif",Font.PLAIN,16));
        add(lblFatherName);

        JLabel fname = new JLabel();
        fname.setBounds(560,80,200,30);
        add(fname);

        JLabel rollNumber = new JLabel("Roll Number :");
        rollNumber.setBounds(100,120,100,30);
        rollNumber.setFont(new Font("serif",Font.PLAIN,16));
        add(rollNumber);

        JLabel lblRoll = new JLabel();
        lblRoll.setBounds(200,120,200,30);
        add(lblRoll);

        JLabel dateBirth = new JLabel("Date of Birth :");
        dateBirth.setBounds(450,120,100,30);
        dateBirth.setFont(new Font("serif",Font.PLAIN,16));
        add(dateBirth);

        JLabel dob = new JLabel();
        dob.setBounds(560,120,200,30);
        add(dob);

        JLabel lblAddress = new JLabel("Address :");
        lblAddress.setBounds(100,160,60,30);
        lblAddress.setFont(new Font("serif",Font.PLAIN,16));
        add(lblAddress);

        address = new JTextField();
        address.setBounds(200,160,200,30);
        add(address);

        JLabel lblPhone = new JLabel("Phone :");
        lblPhone.setBounds(450,160,100,30);
        lblPhone.setFont(new Font("serif",Font.PLAIN,16));
        add(lblPhone);

        phone = new JTextField();
        phone.setBounds(560,160,200,30);
        add(phone);

        JLabel lblEmail = new JLabel("Email ID :");
        lblEmail.setBounds(100,200,100,30);
        lblEmail.setFont(new Font("serif",Font.PLAIN,16));
        add(lblEmail);

        email = new JTextField();
        email.setBounds(200,200,200,30);
        add(email);

        JLabel lblClass10 = new JLabel("Class X(%) :");
        lblClass10.setBounds(450,200,100,30);
        lblClass10.setFont(new Font("serif",Font.PLAIN,16));
        add(lblClass10);

        JLabel tenClass = new JLabel();
        tenClass.setBounds(560,200,200,30);
        add(tenClass);

        JLabel lblClass12 = new JLabel("Class XII (%) :");
        lblClass12.setBounds(100,240,100,30);
        lblClass12.setFont(new Font("serif",Font.PLAIN,16));
        add(lblClass12);

        JLabel twelveClass = new JLabel();
        twelveClass.setBounds(200,240,200,30);
        add(twelveClass);

        JLabel lblCNIC = new JLabel("CNIC :");
        lblCNIC.setBounds(450,240,100,30);
        lblCNIC.setFont(new Font("serif",Font.PLAIN,16));
        add(lblCNIC);

        JLabel CNIC = new JLabel();
        CNIC.setBounds(560,240,200,30);
        add(CNIC);

        JLabel lblCourse = new JLabel("Course :");
        lblCourse.setBounds(100,280,100,30);
        lblCourse.setFont(new Font("serif",Font.PLAIN,16));
        add(lblCourse);

        course = new JComboBox();
        course.addItem("BS-SE");
        course.addItem("BS-CS");
        course.addItem("BA");
        course.addItem("BS-CYS");
        course.addItem("BS-AI");
        course.setBounds(200,280,200,30);
        course.setBackground(Color.WHITE);
        add(course);

        try {
            ResultSet set = c.s.executeQuery("select * from student where rollNumber = '"+select.getSelectedItem()+"'");
            if (set.next()){
                name.setText(set.getString("name"));
                fname.setText(set.getString("fname"));
                tenClass.setText(set.getString("x"));
                twelveClass.setText(set.getString("xii"));
                CNIC.setText(set.getString("cnic"));
                lblRoll.setText(set.getString("rollNumber"));
                dob.setText(set.getString("dob"));
                address.setText(set.getString("address"));
                phone.setText(set.getString("phone"));
                email.setText(set.getString("email"));
                course.setSelectedItem(set.getString("course"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        select.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    ResultSet set = c.s.executeQuery("select * from student where rollNumber = '"+select.getSelectedItem()+"'");
                    if (set.next()){
                        name.setText(set.getString("name"));
                        fname.setText(set.getString("fname"));
                        tenClass.setText(set.getString("x"));
                        twelveClass.setText(set.getString("xii"));
                        CNIC.setText(set.getString("cnic"));
                        lblRoll.setText(set.getString("rollNumber"));
                        dob.setText(set.getString("dob"));
                        address.setText(set.getString("address"));
                        phone.setText(set.getString("phone"));
                        email.setText(set.getString("email"));
                        course.setSelectedItem(set.getString("course"));
                    }

                } catch (SQLException ew) {
                    throw new RuntimeException(ew);
                }
            }
        });

        submit = new JButton("Submit");
        submit.setBounds(220,360,100,30);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        submit.setForeground(Color.WHITE);
        add(submit);


        back = new JButton("Back");
        back.setBounds(380,360,100,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);


        setVisible(true);
        setBounds(300,50,900,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new StudentUpdate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            setVisible(false);
            new Project();
        }else{
            String nAddress = address.getText();
            String nPhone = phone.getText();
            String nEmail = email.getText();
            String nCourse = String.valueOf(course.getSelectedItem());
            Connect c = new Connect();
            try {
                c.s.executeUpdate("update student set phone = '"+nPhone+"',address = '"+nAddress+"',course = '"+nCourse+"',email='"+nEmail+"' where rollNumber ='"+select.getSelectedItem()+"' ");
                JOptionPane.showMessageDialog(null,"Updated Successfully");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
