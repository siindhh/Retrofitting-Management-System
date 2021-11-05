import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Sold extends JFrame implements ActionListener{

    private JPanel contentPane;
    JDateChooser dateChooser;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
    private JButton b1,b2,b3,b4;

    public static void main(String[] args) {
        new Sold().setVisible(true);

    }

    public Sold() {
        super("SOLD PARTS");
        setBounds(300, 200, 900, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        JLabel l = new JLabel(" Sold parts ");
        l.setForeground(Color.black);
        l.setFont(new Font("Georgia", Font.PLAIN, 28));
        l.setBounds(340, 5, 330, 50);
        contentPane.add(l);

        JLabel l1 = new JLabel("Product Id");
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setForeground(new Color(135, 161, 161));
        l1.setBounds(47, 63, 100, 23);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Pname");
        l2.setForeground(new Color(135, 161, 161));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(47, 97, 100, 23);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Brand");
        l3.setForeground(new Color(135, 161, 161));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(47, 131, 100, 23);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Retailer");
        l4.setForeground(new Color(135, 161, 161));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(47, 165, 100, 23);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Price");
        l5.setForeground(new Color(135, 161, 161));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(47, 199, 100, 23);
        contentPane.add(l5);

        JLabel l6 = new JLabel("Quantity");
        l6.setForeground(new Color(135, 161, 161));
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(47, 233, 100, 23);
        contentPane.add(l6);

        JLabel l7 = new JLabel("Model No");
        l7.setForeground(new Color(135, 161, 161));
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        l7.setBounds(47, 267, 100, 23);
        contentPane.add(l7);

        t1 = new JTextField();
        t1.setForeground(new Color(14, 14, 14));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(126, 66, 86, 20);
        contentPane.add(t1);

        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Georgia", Font.BOLD, 14));
        b1.setBounds(234, 59, 100, 30);

        contentPane.add(b1);

        t2 = new JTextField();
        t2.setEditable(false);
        t2.setForeground(new Color(14, 14, 14));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setBounds(126, 100, 208, 20);
        contentPane.add(t2);
        t2.setColumns(10);

        t3 = new JTextField();
        t3.setEditable(false);
        t3.setForeground(new Color(14, 14, 14));
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t3.setColumns(10);
        t3.setBounds(126, 131, 208, 20);
        contentPane.add(t3);

        t4 = new JTextField();
        t4.setEditable(false);
        t4.setForeground(new Color(14, 14, 14));
        t4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t4.setColumns(10);
        t4.setBounds(126, 168, 208, 20);
        contentPane.add(t4);

        t5 = new JTextField();
        t5.setEditable(false);
        t5.setForeground(new Color(14, 14, 14));
        t5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t5.setColumns(10);
        t5.setBounds(126, 202, 208, 20);
        contentPane.add(t5);

        t6 = new JTextField();
        t6.setEditable(false);
        t6.setForeground(new Color(14, 14, 14));
        t6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t6.setColumns(10);
        t6.setBounds(126, 236, 208, 20);
        contentPane.add(t6);

        t7 = new JTextField();
        t7.setEditable(false);
        t7.setForeground(new Color(14, 14, 14));
        t7.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t7.setColumns(10);
        t7.setBounds(126, 270, 208, 20);
        contentPane.add(t7);

        JLabel l8 = new JLabel("Customer Id");
        l8.setForeground(new Color(47, 79, 79));
        l8.setFont(new Font("Tahoma", Font.BOLD, 14));
        l8.setBounds(384, 63, 100, 23);
        contentPane.add(l8);

        JLabel l9 = new JLabel("Name");
        l9.setForeground(new Color(47, 79, 79));
        l9.setFont(new Font("Tahoma", Font.BOLD, 14));
        l9.setBounds(384, 103, 100, 23);
        contentPane.add(l9);

        JLabel l10 = new JLabel("SurName");
        l10.setForeground(new Color(47, 79, 79));
        l10.setFont(new Font("Tahoma", Font.BOLD, 14));
        l10.setBounds(384, 147, 100, 23);
        contentPane.add(l10);

        JLabel l11 = new JLabel("Email ID");
        l11.setForeground(new Color(47, 79, 79));
        l11.setFont(new Font("Tahoma", Font.BOLD, 14));
        l11.setBounds(384, 187, 100, 23);
        contentPane.add(l11);

        JLabel l12 = new JLabel("Phone No");
        l12.setForeground(new Color(47, 79, 79));
        l12.setFont(new Font("Tahoma", Font.BOLD, 14));
        l12.setBounds(384, 233, 100, 23);
        contentPane.add(l12);

        JLabel l13 = new JLabel("VaccinationStatus");
        l13.setForeground(new Color(47, 79, 79));
        l13.setFont(new Font("Tahoma", Font.BOLD, 14));
        l13.setBounds(384, 284, 150, 23);
        contentPane.add(l13);

        t8 = new JTextField();
        t8.setForeground(new Color(7, 7, 7));
        t8.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t8.setColumns(10);
        t8.setBounds(508, 66, 86, 20);
        contentPane.add(t8);

        b2 = new JButton("Search");
        b2.addActionListener(this);
        b2.setFont(new Font("Georgia", Font.BOLD, 14));
        b2.setBorder(new LineBorder(new Color(235, 235, 243), 1, true));
        b2.setBounds(604, 59, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        t10 = new JTextField();
        t10.setForeground(new Color(14, 14, 14));
        t10.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t10.setEditable(false);
        t10.setColumns(10);
        t10.setBounds(508, 150, 208, 20);
        contentPane.add(t10);

        t11 = new JTextField();
        t11.setForeground(new Color(14, 14, 14));
        t11.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t11.setEditable(false);
        t11.setColumns(10);
        t11.setBounds(508, 190, 208, 20);
        contentPane.add(t11);

        t13 = new JTextField();
        t13.setForeground(new Color(14, 14, 14));
        t13.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t13.setEditable(false);
        t13.setColumns(10);
        t13.setBounds(508, 286, 208, 20);
        contentPane.add(t13);


        t9 = new JTextField();
        t9.setForeground(new Color(14, 14, 14));
        t9.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t9.setEditable(false);
        t9.setColumns(10);
        t9.setBounds(508, 106, 208, 20);
        contentPane.add(t9);


        t12 = new JTextField();
        t12.setForeground(new Color(14, 14, 14));
        t12.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t12.setEditable(false);
        t12.setColumns(10);
        t12.setBounds(508, 236, 208, 20);
        contentPane.add(t12);


        JLabel l15 = new JLabel(" Sold Date :");
        l15.setForeground(new Color(3, 3, 3));
        l15.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        l15.setBounds(270, 340, 118, 26);
        contentPane.add(l15);

        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("YYYY-MM-dd\n\n");
        dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        dateChooser.setForeground(new Color(33, 32, 32));
        dateChooser.setBounds(357, 337, 200, 29);
        contentPane.add(dateChooser);

        b3 = new JButton("Sold");
        b3.addActionListener(this);
        b3.setFont(new Font("Georgia", Font.BOLD, 14));
        b3.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b3.setBounds(280, 387, 118, 33);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        contentPane.add(b3);

        b4 = new JButton("Back");
        b4.addActionListener(this);
        b4.setFont(new Font("Georgia", Font.BOLD, 14));
        b4.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b4.setBounds(480, 387, 100, 33);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        contentPane.add(b4);


        JLabel l22 = new JLabel("");
        ImageIcon i17  = new ImageIcon(ClassLoader.getSystemResource("icons/RFT2.jpg"));
        Image i18 = i17.getImage().getScaledInstance(1000, 500,Image.SCALE_DEFAULT);
        ImageIcon i16 = new ImageIcon(i18);
        l22 = new JLabel(i16);
        l22.setBounds(0, 0, 900, 500);
        contentPane.add(l22);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();
            if(ae.getSource() == b1){
                String sql = "select * from parts_db where Product_id = ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t1.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    t2.setText(rs.getString("Product_name"));
                    t3.setText(rs.getString("Brand"));
                    t4.setText(rs.getString("Retailer"));
                    t5.setText(rs.getString("Price"));
                    t6.setText(rs.getString("Quantity"));
                    t7.setText(rs.getString("Model_NO"));
                }
                st.close();
                rs.close();

            }
            if(ae.getSource() == b2){
                String sql = "select * from Customer_db where Customer_id = ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t8.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    t9.setText(rs.getString("Name"));
                    t10.setText(rs.getString("Surname"));
                    t11.setText(rs.getString("EmailID"));
                    t12.setText(rs.getString("Phoneno"));
                    t13.setText(rs.getString("Vaccinationstatus"));

                }
                st.close();
                rs.close();

            }
            if(ae.getSource() == b3){
                try{
                    String sql = "insert into Soldparts_db(Product_id, Customer_id, Product_Name, Name, EmailID, SoldDate ) values(?, ?, ?, ?, ?, ?)";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, t1.getText());
                    st.setString(2, t8.getText());
                    st.setString(3, t2.getText());
                    st.setString(4, t9.getText());
                    st.setString(5, t11.getText());
                    st.setString(6, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
                    int i = st.executeUpdate();
                    if (i > 0)
                        JOptionPane.showMessageDialog(null, "Successfull added to cart..!");
                    else
                        JOptionPane.showMessageDialog(null, "Error");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(ae.getSource() == b4){
                this.setVisible(false);
                new Main_page().setVisible(true);

            }

            con.c.close();
        }catch(Exception e){

        }
    }
}
