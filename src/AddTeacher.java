import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

public class AddTeacher extends JFrame implements ActionListener {
    JButton back,submit;
    JTextField name,fname,address,phone,email,CNIC;
    JComboBox qualification,designation,department;
    JLabel lblEID;
    JDateChooser dob;
    public AddTeacher(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("New Teacher Details");
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

        JLabel lblEmployeeID = new JLabel("Employee ID :");
        lblEmployeeID.setBounds(100,120,100,30);
        lblEmployeeID.setFont(new Font("serif",Font.PLAIN,16));
        add(lblEmployeeID);


        Random random = new Random();
        lblEID = new JLabel(String.valueOf(random.nextInt(9999)));
        lblEID.setBounds(200,120,200,30);
        add(lblEID);

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


        JLabel lblDesignation = new JLabel("Designation :");
        lblDesignation.setBounds(450,200,100,30);
        lblDesignation.setFont(new Font("serif",Font.PLAIN,16));
        add(lblDesignation);

        designation = new JComboBox();
        designation.setBounds(560,200,200,30);
        designation.addItem("Lecturer");
        designation.addItem("Instructor");
        designation.addItem("Professor");
        designation.addItem("Assistant Professor");
        designation.addItem("Associate Professor");
        add(designation);


        JLabel lblClass12 = new JLabel("Department :");
        lblClass12.setBounds(100,240,100,30);
        lblClass12.setFont(new Font("serif",Font.PLAIN,16));
        add(lblClass12);

        department = new JComboBox();
        department.setBounds(200,240,200,30);
        department.addItem("Software Engineering");
        department.addItem("Artificial Intelligence");
        department.addItem("Computer Science");
        department.addItem("Cyber Security");
        add(department);


        JLabel lblCNIC = new JLabel("CNIC :");
        lblCNIC.setBounds(450,240,100,30);
        lblCNIC.setFont(new Font("serif",Font.PLAIN,16));
        add(lblCNIC);

        CNIC = new JTextField();
        CNIC.setBounds(560,240,200,30);
        add(CNIC);

        JLabel lblQualifications = new JLabel("Qualification :");
        lblQualifications.setBounds(100,280,100,30);
        lblQualifications.setFont(new Font("serif",Font.PLAIN,16));
        add(lblQualifications);
 
        qualification = new JComboBox();
        qualification.addItem("BS");
        qualification.addItem("MS");
        qualification.addItem("PHD");
        qualification.addItem("B-Tech");
        qualification.addItem("BA");
        qualification.setBounds(200,280,200,30);
        qualification.setBackground(Color.WHITE);
        add(qualification);

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
        new AddTeacher();
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
            String Employee = lblEID.getText();
            String dateOfBirth = ((JTextField) dob.getDateEditor().getUiComponent()).getText();
            String qualifications = String.valueOf(qualification.getSelectedItem());
            String designations = String.valueOf(designation.getSelectedItem());
            String depart = String.valueOf(department.getSelectedItem());
            String Email = email.getText();
            Connect c = new Connect();
            String query = "insert into teacher values('"+Name+"','"+father+"','"+cnic+"','"+Phone+"','"+Address+"','"+Employee+"','"+dateOfBirth+"','"+qualifications+"','"+depart+"','"+designations+"','"+Email+"')";
            try {
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Teacher Information Inserted Successfully");
                setVisible(false);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
