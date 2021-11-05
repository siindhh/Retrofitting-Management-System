import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class login extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1,b2,b3;


    public login() {
        super("RETROFITTING AUTOMOTIVE MANAGEMENT SYSTEM");
        setBounds(400, 230, 600, 406);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);



        JLabel l = new JLabel(" WELCOME ");
        l.setForeground(Color.black);
        l.setFont(new Font("Georgia", Font.PLAIN, 30));
        l.setBounds(200, 10, 330, 56);
        contentPane.add(l);

        JLabel l1 = new JLabel("Username :");
        l1.setFont(new Font("Tahoma", Font.BOLD, 15));
        l1.setBounds(120, 90, 100, 26);
        contentPane.add(l1);


        textField = new JTextField();
        textField.setBounds(265, 95, 155, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblPassword.setBounds(120, 140, 100, 26);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setColumns(10);
        passwordField.setBounds(265, 143, 155, 20);
        contentPane.add(passwordField);


        b1 = new JButton("Login");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 13));
        b1.setBounds(160, 200, 90, 30);
        b1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(10, 10, 10)));
        b1.setForeground(Color.white);
        contentPane.add(b1);

        b2 = new JButton("Signup");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 13));
        b2.setBounds(310, 200, 90, 30);
        b2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(10, 10, 10)));
        b2.setForeground(Color.white);
        contentPane.add(b2);

        b3 = new JButton("Forgot Password");
        b3.addActionListener(this);
        b3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(10, 10, 10)));
        b3.setForeground(Color.white);
        b3.setBounds(200, 271, 160, 39);
        contentPane.add(b3);


        JLabel l5 = new JLabel("Trouble in Login?");
        l5.setFont(new Font("Tahoma", Font.BOLD,15));
        l5.setForeground(new Color(14, 14, 14));
        l5.setBounds(62, 279, 250, 20);
        contentPane.add(l5);



        JLabel l9 = new JLabel("");
        ImageIcon i21  = new ImageIcon(ClassLoader.getSystemResource("icons/RFT.jpg"));
        Image i22 = i21.getImage().getScaledInstance(150, 135, Image.SCALE_DEFAULT);
        ImageIcon i23 = new ImageIcon(i22);
        l9 = new JLabel(i23);
        l9.setBounds(400, 210, 200, 160);
        contentPane.add(l9);

        JLabel l6 = new JLabel("");
        ImageIcon i13  = new ImageIcon(ClassLoader.getSystemResource("icons/RFT2.jpg"));
        Image i14 = i13.getImage().getScaledInstance(600, 450,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        l6 = new JLabel(i15);
        l6.setBounds(0, 0, 600, 400);
        contentPane.add(l6);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            Boolean status = false;
            try {
                conn con = new conn();
                String sql = "select * from signup_db where Username=? and Password=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, passwordField.getText());

                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        this.setVisible(false);
                        new loading().setVisible(true);
                    } else
                        JOptionPane.showMessageDialog(null, "Invalid Login...!.");
                }

            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }
        if (ae.getSource() == b2) {
            setVisible(false);
            signup su = new signup();
            su.setVisible(true);

        }
        if (ae.getSource() == b3) {
            setVisible(false);
            forgot forgot = new forgot();
            forgot.setVisible(true);

        }
    }
    public static void main(String[] args) {

        new login().setVisible(true);
    }

}