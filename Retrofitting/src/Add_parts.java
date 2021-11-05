import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class Add_parts extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    private JButton b1,b2;

    public static void main(String[] args) {
        new Add_parts().setVisible(true);
    }

    public void random() {
        Random rd = new Random();
        t1.setText("" + rd.nextInt(1000 + 1));
    }

    public Add_parts() {
        super("Add Parts");
        setBounds(400, 230, 600, 406);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Product name");
        l1.setForeground(new Color(255, 255, 255));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(73, 84, 90, 22);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Brand");
        l2.setForeground(new Color(255, 255, 255));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(73, 117, 90, 22);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Retailer");
        l3.setForeground(new Color(255, 255, 255));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(73, 150, 90, 22);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setForeground(new Color(255, 255, 255));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(73, 216, 90, 22);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Quantity");
        l5.setForeground(new Color(255, 255, 255));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(73, 249, 90, 22);
        contentPane.add(l5);

        JLabel l6 = new JLabel("Product_id");
        l6.setForeground(new Color(255, 255, 255));
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(73, 51, 90, 22);
        contentPane.add(l6);

        JLabel l7 = new JLabel("Model_no");
        l7.setForeground(new Color(255, 255, 255));
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        l7.setBounds(73, 183, 90, 22);
        contentPane.add(l7);

        t1 = new JTextField();
        t1.setForeground(new Color(13, 14, 14));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(169, 54, 198, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setForeground(new Color(3, 3, 3));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setColumns(10);
        t2.setBounds(169, 87, 198, 20);
        contentPane.add(t2);

        t3 = new JTextField();
        t3.setForeground(new Color(14, 14, 14));
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t3.setColumns(10);
        t3.setBounds(169, 120, 198, 20);
        contentPane.add(t3);

        t4 = new JTextField();
        t4.setForeground(new Color(7, 7, 7));
        t4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t4.setColumns(10);
        t4.setBounds(169, 153, 198, 20);
        contentPane.add(t4);

        t5 = new JTextField();
        t5.setForeground(new Color(7, 7, 7));
        t5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t5.setColumns(10);
        t5.setBounds(169, 219, 198, 20);
        contentPane.add(t5);

        t6 = new JTextField();
        t6.setForeground(new Color(7, 7, 7));
        t6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t6.setColumns(10);
        t6.setBounds(169, 252, 198, 20);
        contentPane.add(t6);

        t7 = new JTextField();
        t7.setForeground(new Color(7, 7, 7));
        t7.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t7.setColumns(10);
        t7.setBounds(169, 183, 198, 20);
        contentPane.add(t7);


        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBorder(new CompoundBorder(new LineBorder(new Color(2, 2, 2)), null));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b1.setBounds(102, 300, 100, 33);
        b1.setBackground(Color.black);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBorder(new CompoundBorder(new LineBorder(new Color(2, 2, 2)), null));
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b2.setBounds(212, 300, 108, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        contentPane.add(b2);

        JLabel l8;
        ImageIcon i21  = new ImageIcon(ClassLoader.getSystemResource("icons/RFT2.jpg"));
        Image i22 = i21.getImage().getScaledInstance(1000, 900,Image.SCALE_DEFAULT);
        ImageIcon i23 = new ImageIcon(i22);
        l8 = new JLabel(i23);
        l8.setBounds(0, 0, 1000, 900);
        contentPane.add(l8);


        random();

    }

    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();
            if(ae.getSource() == b1){
                String sql = "insert into parts_db(Product_name,Brand,Retailer,Price,Model_no ,Product_id ,Quantity ) values(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);
                // st.setInt(1, Integer.parseInt(textField.getText()));
                st.setString(1, t2.getText());
                st.setString(2, t3.getText());
                st.setString(3, t4.getText());
                st.setString(4, t5.getText());
                st.setString(5, t6.getText());
                st.setString(6, t7.getText());
                st.setString(7, t1.getText());


                int rs = st.executeUpdate();
                if (rs > 0)
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                else
                    JOptionPane.showMessageDialog(null, "Error");

                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t1.setText("");
                st.close();
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new Main_page().setVisible(true);

            }
            con.c.close();
        }catch(Exception e){

        }
    }
}

