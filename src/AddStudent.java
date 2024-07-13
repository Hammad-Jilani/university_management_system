import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {
    JButton back,submit;
    JTextField name,fname,address,phone,email,tenClass,twelveClass,CNIC;
    JComboBox course,branch;
    JLabel lblRoll;
    JDateChooser dob;
    public  AddStudent(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(230,10,350,40);
        heading.setFont(new Font("Roboto",Font.BOLD,30));
        add(heading);

        JLabel lblName = new JLabel("Name :");
        lblName.setBounds(100,80,60,30);
        lblName.setFont(new Font("serif",Font.PLAIN,16));
        add(lblName);

        name = new JTextField();
        name.setBounds(200,80,200,30);
        add(name);

        JLabel lblFatherName = new JLabel("Father Name :");
        lblFatherName.setBounds(450,80,100,30);
        lblFatherName.setFont(new Font("serif",Font.PLAIN,16));
        add(lblFatherName);

        fname = new JTextField();
        fname.setBounds(560,80,200,30);
        add(fname);

        JLabel rollNumber = new JLabel("Roll Number :");
        rollNumber.setBounds(100,120,100,30);
        rollNumber.setFont(new Font("serif",Font.PLAIN,16));
        add(rollNumber);


        Random random = new Random();
        lblRoll = new JLabel(String.valueOf(random.nextInt(9999)));
        lblRoll.setBounds(200,120,200,30);
        add(lblRoll);

        JLabel dateBirth = new JLabel("Date of Birth :");
        dateBirth.setBounds(450,120,100,30);
        dateBirth.setFont(new Font("serif",Font.PLAIN,16));
        add(dateBirth);

        dob = new JDateChooser();
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

        tenClass = new JTextField();
        tenClass.setBounds(560,200,200,30);
        add(tenClass);

        JLabel lblClass12 = new JLabel("Class XII (%) :");
        lblClass12.setBounds(100,240,100,30);
        lblClass12.setFont(new Font("serif",Font.PLAIN,16));
        add(lblClass12);

        twelveClass = new JTextField();
        twelveClass.setBounds(200,240,200,30);
        add(twelveClass);

        JLabel lblCNIC = new JLabel("CNIC :");
        lblCNIC.setBounds(450,240,100,30);
        lblCNIC.setFont(new Font("serif",Font.PLAIN,16));
        add(lblCNIC);

        CNIC = new JTextField();
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

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icon1.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,300,200,200);
        add(image);

        setVisible(true);
        setBounds(300,50,900,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new AddStudent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            setVisible(false);
            new Project();
        }else{
            String Name = name.getText();
            String father = fname.getText();
            String cnic = CNIC.getText();
            String Phone = phone.getText();
            String Address =address.getText();
            String RNumber = lblRoll.getText();
            String dateOfBirth = ((JTextField) dob.getDateEditor().getUiComponent()).getText();
            String Course = String.valueOf(course.getSelectedItem());
            String x = tenClass.getText();
            String xii = twelveClass.getText();
            String Email = email.getText();
            Connect c = new Connect();
            String query = "insert into student values('"+Name+"','"+father+"','"+cnic+"','"+Phone+"','"+Address+"','"+RNumber+"','"+dateOfBirth+"','"+Course+"','"+x+"','"+xii+"','"+Email+"')";
            try {
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Insertion Done Successfully");
                setVisible(false);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
