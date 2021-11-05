import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class signup extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    JButton b1, b2;
    JComboBox comboBox;


    public static void main(String[] args) {
        new signup().setVisible(true);
    }

    public signup() {
        setBounds(400, 230, 600, 406);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        JLabel l = new JLabel("Create Account ");
        l.setForeground(Color.black);
        l.setFont(new Font("Georgia", Font.PLAIN, 30));
        l.setBounds(185, 25, 330, 56);
        contentPane.add(l);

        JLabel lblUsername = new JLabel("Username :");
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsername.setBounds(99, 99, 92, 26);
        contentPane.add(lblUsername);

        JLabel lblName = new JLabel("Name :");
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(99, 138, 92, 26);
        contentPane.add(lblName);

        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(99, 173, 92, 26);
        contentPane.add(lblPassword);

        JLabel lblAnswer = new JLabel("Answer :");
        lblAnswer.setForeground(Color.WHITE);
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAnswer.setBounds(99, 250, 92, 26);
        contentPane.add(lblAnswer);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?","Your pets Name?",
                "Your child SuperHero?", "Your childhood Name ?" }));
        comboBox.setBounds(265, 216, 148, 20);
        contentPane.add(comboBox);

        JLabel lblSecurityQuestion = new JLabel("Security Question :");
        lblSecurityQuestion.setForeground(Color.WHITE);
        lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSecurityQuestion.setBounds(99, 213, 140, 26);
        contentPane.add(lblSecurityQuestion);

        textField = new JTextField();
        textField.setBounds(265, 102, 148, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(265, 139, 148, 20);
        contentPane.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(265, 175, 148, 20);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(265, 252, 148, 20);
        contentPane.add(textField_3);

        b1 = new JButton("Create");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 13));
        b1.setBounds(140, 305, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.BLUE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 13));
        b2.setBounds(300, 305, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.BLUE);
        contentPane.add(b2);


        JLabel l9 = new JLabel("");
        ImageIcon i21  = new ImageIcon(ClassLoader.getSystemResource("icons/Create account.png"));
        Image i22 = i21.getImage().getScaledInstance(80, 85,Image.SCALE_DEFAULT);
        ImageIcon i23 = new ImageIcon(i22);
        l9 = new JLabel(i23);
        l9.setBounds(90, 10, 80, 85);
        contentPane.add(l9);

        JLabel l6 = new JLabel("");
        ImageIcon i13  = new ImageIcon(ClassLoader.getSystemResource("icons/RFT2.jpg"));
        Image i14 = i13.getImage().getScaledInstance(600, 450,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        l6 = new JLabel(i15);
        l6.setBounds(0, 0, 600, 400);
        contentPane.add(l6);

    }

    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();

            if(ae.getSource() == b1){
                String sql = "insert into signup_db(username, Name, password, Question, Answer) values(?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, textField_1.getText());
                st.setString(3, textField_2.getText());
                st.setString(4, (String) comboBox.getSelectedItem());
                st.setString(5, textField_3.getText());

                int i = st.executeUpdate();
                if (i > 0){
                    JOptionPane.showMessageDialog(null, "successfully Created");
                }

                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new login().setVisible(true);

            }
        }catch(Exception e){

        }
    }
}


