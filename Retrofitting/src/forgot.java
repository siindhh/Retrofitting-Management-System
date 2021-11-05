import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class forgot extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5;
    private JButton b1,b2,b3;

    public static void main(String[] args) {
        new forgot().setVisible(true);
    }

    public forgot() {

        setBounds(400, 230, 600, 406);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        JLabel l = new JLabel("Forgot Password ");
        l.setForeground(Color.black);
        l.setFont(new Font("Georgia", Font.PLAIN, 30));
        l.setBounds(215, 30, 330, 56);
        contentPane.add(l);

        JLabel l1 = new JLabel("Username");
        l1.setFont(new Font("Tahoma", Font.BOLD, 13));
        l1.setBounds(109, 100, 87, 29);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setFont(new Font("Tahoma", Font.BOLD, 13));
        l2.setBounds(109, 145, 75, 21);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Your Security Question");
        l3.setFont(new Font("Tahoma", Font.BOLD, 13));
        l3.setBounds(109, 188, 156, 27);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Answer");
        l4.setFont(new Font("Tahoma", Font.BOLD, 13));
        l4.setBounds(109, 242, 104, 21);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Password");
        l5.setFont(new Font("Tahoma", Font.BOLD, 13));
        l5.setBounds(109, 290, 104, 21);
        contentPane.add(l5);

        t1 = new JTextField();
        t1.setFont(new Font("Tahoma", Font.BOLD, 13));
        t1.setForeground(new Color(105, 105, 105));
        t1.setBounds(277, 100, 139, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setEditable(false);
        t2.setFont(new Font("Tahoma", Font.BOLD, 13));
        t2.setForeground(new Color(165, 42, 42));
        t2.setColumns(10);
        t2.setBounds(277, 145, 139, 20);
        contentPane.add(t2);

        t3 = new JTextField();
        t3.setEditable(false);
        t3.setFont(new Font("Tahoma", Font.BOLD, 12));
        t3.setForeground(new Color(72, 61, 139));
        t3.setColumns(10);
        t3.setBounds(277, 190, 221, 20);
        contentPane.add(t3);

        t4 = new JTextField();
        t4.setFont(new Font("Tahoma", Font.BOLD, 13));
        t4.setForeground(new Color(205, 92, 92));
        t4.setColumns(10);
        t4.setBounds(277, 243, 139, 20);
        contentPane.add(t4);

        t5 = new JTextField();
        t5.setEditable(false);
        t5.setFont(new Font("Tahoma", Font.BOLD, 13));
        t5.setForeground(new Color(10, 10, 10));
        t5.setColumns(10);
        t5.setBounds(277, 290, 139, 20);
        contentPane.add(t5);

        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 12));
        b1.setBounds(428, 98, 80, 29);
        b1.setBackground(Color.white);
        b1.setForeground(Color.blue);
        contentPane.add(b1);

        b2 = new JButton("Retrieve");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 12));
        b2.setBounds(426, 239, 85, 29);
        b2.setBackground(Color.white);
        b2.setForeground(Color.blue);
        contentPane.add(b2);

        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setFont(new Font("Tahoma", Font.BOLD, 13));
        b3.setBounds(233, 370, 101, 29);
        b3.setBackground(Color.white);
        b3.setForeground(Color.blue);
        contentPane.add(b3);


        JLabel l9 = new JLabel("");
        ImageIcon i21  = new ImageIcon(ClassLoader.getSystemResource("icons/forgot-password.png"));
        Image i22 = i21.getImage().getScaledInstance(75, 75,Image.SCALE_DEFAULT);
        ImageIcon i23 = new ImageIcon(i22);
        l9 = new JLabel(i23);
        l9.setBounds(120, 10, 75, 75);
        contentPane.add(l9);

        JLabel l6 = new JLabel("");
        ImageIcon i13  = new ImageIcon(ClassLoader.getSystemResource("icons/RFT2.jpg"));
        Image i14 = i13.getImage().getScaledInstance(650, 500,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        l6 = new JLabel(i15);
        l6.setBounds(0, 0, 650, 500);
        contentPane.add(l6);



    }

    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();
            if(ae.getSource() == b1){
                String sql = "select * from signup_db where username=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t1.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    t2.setText(rs.getString("Name"));
                    t3.setText(rs.getString("Question"));
                }

            }
            if(ae.getSource() == b2){
                String sql = "select * from signup_db where Answer=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t4.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    t5.setText(rs.getString("password"));
                }

            }
            if(ae.getSource() == b3){
                this.setVisible(false);
                new login().setVisible(true);

            }
        }catch(Exception e){

        }
    }


}

