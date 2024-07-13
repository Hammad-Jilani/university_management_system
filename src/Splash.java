import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {
    public Splash() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i1 = icon.getImage().getScaledInstance(1000,650,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,1000,650);
        add(image);

        JLabel heading = new JLabel("FAST NUCES KARACHI CAMPUS");
        heading.setFont(new Font("Roboto", Font.BOLD,30));
        heading.setBounds(280,20,600,100);
        heading.setForeground(Color.BLACK);
        image.add(heading);

        setVisible(true);
        setLocation(150,50);
        setSize(1000,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton continued = new JButton("Click here to continue");
        continued.setBounds(370,350,200,50);
        continued.setBackground(Color.BLACK);
        continued.setForeground(Color.white);
        continued.addActionListener(this);
        image.add(continued);

        while(true){
            heading.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            heading.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new Splash();
        Thread.sleep(1000);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
}
