
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class Login extends JFrame implements ActionListener {
    JButton cancel,loginButton;
    JTextField txtUsername;
    JPasswordField passwordField;
    public  Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblUsername = new JLabel("User Name :");
        lblUsername.setBounds(100,20,100,30);
        add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(220,20,250,30);
        add(txtUsername);

        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setBounds(100,60,100,30);
        add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(220,60,250,30);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(150,140,100,30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Roboto",Font.BOLD,16));
        loginButton.addActionListener(this);
        add(loginButton);

        cancel = new JButton("Cancel");
        cancel.setBounds(320,140,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Roboto",Font.BOLD,16));
        cancel.addActionListener(this);
        add(cancel);


        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("./icons/second.jpg"));
        Image i1 = icon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(500,50,200,200);
        add(image);


        setVisible(true);
        setBounds(150,50,800,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel){
            setVisible(false);
        }else{
            String username = txtUsername.getText();
            String password = String.valueOf(passwordField.getPassword());
            String query = "select * from login where username = '"+username+"' and password = '"+password+"' ";
            Connect c = new Connect();
            try {
                ResultSet set =  c.s.executeQuery(query);
                if (set.next()){
                    setVisible(false);
                    new Project();
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect credentials");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
