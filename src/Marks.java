import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Marks extends JFrame  {
    String roll;
    public  Marks(String roll){
        this.roll = roll;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("FAST NUCES");
        heading.setBounds(200,30,200,30);
        heading.setFont(new Font("Roboto",Font.BOLD,20));
        add(heading);

        JLabel subHeading = new JLabel("Examination Result");
        subHeading.setBounds(150,80,200,30);
        subHeading.setFont(new Font("Roboto",Font.BOLD,20));
        add(subHeading);

        JLabel rollNumber = new JLabel("Roll Number "+roll);
        rollNumber.setBounds(160,110,200,30);
        rollNumber.setFont(new Font("Roboto",Font.BOLD,20));
        add(rollNumber);

        JLabel semester = new JLabel();
        semester.setBounds(160,140,200,30);
        semester.setFont(new Font("Roboto",Font.BOLD,20));
        add(semester);

        JLabel s1 = new JLabel();
        s1.setBounds(160,160+40,200,30);
        s1.setFont(new Font("Roboto",Font.BOLD,20));
        add(s1);
        JLabel s2 = new JLabel();
        s2.setBounds(160,180+40,200,30);
        s2.setFont(new Font("Roboto",Font.BOLD,20));
        add(s2);
        JLabel s3 = new JLabel();
        s3.setBounds(160,200+40,200,30);
        s3.setFont(new Font("Roboto",Font.BOLD,20));
        add(s3);
        JLabel s4 = new JLabel();
        s4.setBounds(160,220+40,200,30);
        s4.setFont(new Font("Roboto",Font.BOLD,20));
        add(s4);
        JLabel s5 = new JLabel();
        s5.setBounds(160,240+40,200,30);
        s5.setFont(new Font("Roboto",Font.BOLD,20));
        add(s5);

        JLabel m1 = new JLabel();
        m1.setBounds(240+40,160+40,200,30);
        m1.setFont(new Font("Roboto",Font.BOLD,20));
        add(m1);
        JLabel m2 = new JLabel();
        m2.setBounds(240+40,180+40,200,30);
        m2.setFont(new Font("Roboto",Font.BOLD,20));
        add(m2);
        JLabel m3 = new JLabel();
        m3.setBounds(240+40,200+40,200,30);
        m3.setFont(new Font("Roboto",Font.BOLD,20));
        add(m3);
        JLabel m4 = new JLabel();
        m4.setBounds(240+40,220+40,200,30);
        m4.setFont(new Font("Roboto",Font.BOLD,20));
        add(m4);
        JLabel m5 = new JLabel();
        m5.setBounds(240+40,240+40,200,30);
        m5.setFont(new Font("Roboto",Font.BOLD,20));
        add(m5);

        Connect c = new Connect();
        try {
            ResultSet set = c.s.executeQuery("select * from examMarks where rollNumber = '"+roll+"'");
            if (set.next()){
                semester.setText(set.getString("semester"));
                s1.setText(set.getString("s1"));
                s2.setText(set.getString("s2"));
                s3.setText(set.getString("s3"));
                s4.setText(set.getString("s4"));
                s5.setText(set.getString("s5"));
                m1.setText(set.getString("m1"));
                m2.setText(set.getString("m2"));
                m3.setText(set.getString("m3"));
                m4.setText(set.getString("m4"));
                m5.setText(set.getString("m5"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        setVisible(true);
        setBounds(500,50,500,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Marks("");
    }
}
