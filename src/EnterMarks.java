import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnterMarks extends JFrame implements ActionListener {
    Choice select,semester;
    JButton submit,back;
    JTextField[] subject,marks;

    public EnterMarks(){
        setLayout(null);

        JLabel heading = new JLabel("Enter Student Marks");
        heading.setBounds(80,20,200,30);
        heading.setFont(new Font("Roboto",Font.BOLD,20));
        add(heading);

        JLabel selectRoll = new JLabel("Select Roll Number :");
        selectRoll.setBounds(80,80,150,20);
        selectRoll.setFont(new Font("Roboto",Font.PLAIN,16));
        add(selectRoll);

        select = new Choice();
        Connect c = new Connect();
        try {
            ResultSet set = c.s.executeQuery("select * from student");
            while (set.next()){
                select.addItem(set.getString("rollNumber"));
            }
            select.setBounds(270,80,150,30);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        add(select);

        JLabel lblSemester = new JLabel("Select Semester :");
        lblSemester.setBounds(80,120,150,20);
        lblSemester.setFont(new Font("Roboto",Font.PLAIN,16));
        add(lblSemester);

        semester = new Choice();
        semester.addItem("1st Semester");
        semester.addItem("2nd Semester");
        semester.addItem("3rd Semester");
        semester.addItem("4th Semester");
        semester.addItem("5th Semester");
        semester.addItem("6th Semester");
        semester.addItem("7th Semester");
        semester.addItem("8th Semester");
        semester.setBounds(270,120,150,20);
        add(semester);

        JLabel lblsubject = new JLabel("Enter Subjects");
        lblsubject.setBounds(120,200,150,20);
        lblsubject.setFont(new Font("Roboto",Font.PLAIN,16));
        add(lblsubject);

        subject = new JTextField[5];
        int count =10;
        for (int i = 0; i < 5; i++) {
            subject[i] = new JTextField();
            subject[i].setBounds(100,240+count,150,20);
            add(subject[i]);
            count+=40;
            revalidate();
            repaint();
        }

        marks = new JTextField[5];
        count =10;
        for (int i = 0; i < 5; i++) {
            marks[i] = new JTextField();
            marks[i].setBounds(320,240+count,150,20);
            add(marks[i]);
            count+=40;
            revalidate();
            repaint();
        }



        JLabel marks = new JLabel("Enter Marks");
        marks.setFont(new Font("Roboto",Font.PLAIN,16));
        marks.setBounds(320,200,100,20);
        add(marks);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(520,200,250,250);
        add(image);

        submit = new JButton("Submit");
        submit.setBounds(200,450,100,20);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");
        back.setBounds(320,450,100,20);
        back.addActionListener(this);
        add(back);

        setVisible(true);
        setBounds(250,30,800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new EnterMarks();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit){
            Connect c = new Connect();
            try {
                c.s.execute("insert into examMarks values('"+select.getSelectedItem()+"','"+semester.getSelectedItem()+"','"+subject[0].getText()+"','"+subject[1].getText()+"','"+subject[2].getText()+"', '"+subject[3].getText()+"','"+subject[4].getText()+"', '"+marks[0].getText()+"','"+marks[1].getText()+"','"+marks[2].getText()+"','"+marks[3].getText()+"','"+marks[4].getText()+"')");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(null,"Successful");
        }else {
            setVisible(false);
            new Project();
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }
}
