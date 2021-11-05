import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class  Add_customer  extends JFrame implements ActionListener {

    private final JTextField t1;
    private final JTextField t2;
    private final JTextField t3;
    private final JTextField t4;
    private final JTextField t5;
    private final JTextField t6;

    JButton b1,b2;

    public static void main(String[] args) {
        new  Add_customer().setVisible(true);
    }

    public void random() {
        Random rd = new Random();
        t1.setText("" + rd.nextInt(10000 + 1));
    }

    public Add_customer() {
        super("Add Customer");
        setBounds(400, 230, 600, 406);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l = new JLabel("Add Customer");
        l.setForeground(new Color(255, 255, 255));
        l.setFont(new Font("Georgia", Font.BOLD , 28));
        l.setBounds(180, 8, 400, 47);
        contentPane.add(l);

        JLabel l1 = new JLabel("Customer_id");
        l1.setForeground(new Color(218, 218, 229));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(94, 63, 102, 22);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setForeground(new Color(231, 231, 239));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(94, 97, 102, 22);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Surname");
        l3.setForeground(new Color(235, 235, 243));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(94, 130, 102, 22);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Email ID");
        l4.setForeground(new Color(233, 233, 238));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(94, 163, 102, 22);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Phone No");
        l5.setForeground(new Color(218, 218, 231));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(94, 193, 102, 22);
        contentPane.add(l5);

        JLabel l6 = new JLabel("Vaccination status");
        l6.setForeground(new Color(234, 234, 238));
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(94, 223, 144, 22);
        contentPane.add(l6);

        t1 = new JTextField();
        t1.setEditable(false);
        t1.setForeground(new Color(10, 10, 10));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(266, 66, 156, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setForeground(new Color(231, 231, 239));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setColumns(10);
        t2.setBounds(266, 100, 156, 20);
        contentPane.add(t2);

        t3 = new JTextField();
        t3.setForeground(new Color(235, 235, 243));
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t3.setColumns(10);
        t3.setBounds(266, 133, 156, 20);
        contentPane.add(t3);

        t4 = new JTextField();
        t4.setForeground(new Color(255, 255, 255));
        t4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t4.setColumns(10);
        t4.setBounds(266, 163, 156, 20);
        contentPane.add(t4);

        t5 = new JTextField();
        t5.setForeground(new Color(255, 255, 255));
        t5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t5.setColumns(10);
        t5.setBounds(266, 193, 156, 20);
        contentPane.add(t5);

        t6 = new JTextField();
        t6.setForeground(new Color(255, 255, 255));
        t6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t6.setColumns(10);
        t6.setBounds(266, 223, 156, 20);
        contentPane.add(t6);

        JTextField t7 = new JTextField();
        t7.setForeground(new Color(255, 255, 255));
        t7.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t7.setColumns(10);
        t7.setBounds(266, 133, 156, 20);
        contentPane.add(t7);



        b1 = new JButton("ADD");
        b1.addActionListener(this);
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b1.setBounds(177, 321, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.blue);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b2.setBounds(299, 321, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.blue);
        contentPane.add(b2);


        JLabel l8;
        ImageIcon i13  = new ImageIcon(ClassLoader.getSystemResource("icons/RFT2.jpg"));
        Image i14 = i13.getImage().getScaledInstance(900, 500,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        l8 = new JLabel(i15);
        l8.setBounds(0, 0, 900, 500);
        contentPane.add(l8);

        random();
    }

    public void actionPerformed(ActionEvent ae){
        try{

            if(ae.getSource() == b1){
                try{
                    conn con = new conn();
                    String sql = "insert into Student_db(Customer_id, Name, Surname, EmailID, PhoneNo, VaccinationStatus) values(?, ?, ?, ?, ?, ?)";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, t1.getText());
                    st.setString(2, t2.getText());
                    st.setString(3, t3.getText());
                    st.setString(4, t4.getText());
                    st.setString(5, t5.getText());
                    st.setString(6, t6.getText());

                    int i = st.executeUpdate();
                    if (i > 0){
                        JOptionPane.showMessageDialog(null, "Successfully Added");
                        this.setVisible(false);
                        new Main_page().setVisible(true);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "error");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            if(ae.getSource() == b2){
                this.setVisible(false);
                new Main_page().setVisible(true);
            }
        }catch(Exception ignored){

        }
    }

}

