import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Warranty extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JButton b1,b2,b3;
    private JDateChooser dateChooser;

    public static void main(String[] args) {
        new Warranty().setVisible(true);
    }

    public void delete() {
        try {
            conn con = new conn();
            String sql = "delete from Warranty_db where Customer_id=?";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1, textField_1.getText());
            int i = st.executeUpdate();
            if (i > 0)
                JOptionPane.showConfirmDialog(null, "Warranty Applied");
            else
                JOptionPane.showMessageDialog(null, "error in Deleting");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }


    public Warranty() {
        super("Warranty");
        setBounds(450, 300, 617, 363);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.BLACK);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Product_id");
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(52, 52, 87, 24);
        contentPane.add(lblNewLabel);

        JLabel lblCustomerId = new JLabel("Customer_id");
        lblCustomerId.setForeground(Color.BLACK);
        lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCustomerId.setBounds(243, 52, 120, 24);
        contentPane.add(lblCustomerId);

        JLabel lblParts = new JLabel("parts");
        lblParts.setForeground(Color.BLACK);
        lblParts.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblParts.setBounds(52, 98, 71, 24);
        contentPane.add(lblParts);

        JLabel lblName = new JLabel("Name");
        lblName.setForeground(Color.BLACK);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(300, 98, 71, 24);
        contentPane.add(lblName);

        JLabel lblEmailId = new JLabel("EmailID");
        lblEmailId.setForeground(Color.BLACK);
        lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblEmailId.setBounds(52, 143, 87, 24);
        contentPane.add(lblEmailId);

        JLabel lblSoldDate = new JLabel("SoldDate");
        lblSoldDate.setForeground(Color.BLACK);
        lblSoldDate.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSoldDate.setBounds(303, 144, 68, 24);
        contentPane.add(lblSoldDate);

        JLabel lblWarranty = new JLabel("Warranty");
        lblWarranty.setForeground(Color.BLACK);
        lblWarranty.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblWarranty.setBounds(52, 188, 105, 29);
        contentPane.add(lblWarranty);

        textField = new JTextField();
        textField.setForeground(new Color(105, 105, 105));
        textField.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        textField.setBounds(133, 56, 105, 20);
        contentPane.add(textField);
        textField.setColumns(10);


        textField_1 = new JTextField();
        textField_1.setForeground(new Color(105, 105, 105));
        textField_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        textField_1.setBounds(340, 56, 93, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBounds(443, 52, 105, 29);
        b1.setBackground(Color.white);
        b1.setForeground(Color.blue);
        contentPane.add(b1);

        textField_2 = new JTextField();
        textField_2.setEditable(false);
        textField_2.setForeground(new Color(0, 100, 0));
        textField_2.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        textField_2.setBounds(128, 102, 162, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setEditable(false);
        textField_3.setForeground(new Color(0, 100, 0));
        textField_3.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        textField_3.setColumns(10);
        textField_3.setBounds(369, 102, 179, 20);
        contentPane.add(textField_3);

        textField_4 = new JTextField();
        textField_4.setEditable(false);
        textField_4.setForeground(new Color(0, 100, 0));
        textField_4.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        textField_4.setColumns(10);
        textField_4.setBounds(128, 147, 162, 20);
        contentPane.add(textField_4);

        textField_5 = new JTextField();
        textField_5.setForeground(new Color(0, 100, 0));
        textField_5.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        textField_5.setEditable(false);
        textField_5.setColumns(10);
        textField_5.setBounds(369, 147, 179, 20);
        contentPane.add(textField_5);

        textField_6 = new JTextField();
        textField_6.setForeground(new Color(0, 100, 0));
        textField_6.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        textField_6.setEditable(false);
        textField_6.setColumns(10);
        textField_6.setBounds(128, 194, 162, 20);
        contentPane.add(textField_6);

        b2 = new JButton("Warranty");
        b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b2.setBounds(169, 228, 149, 30);
        b2.setBackground(Color.white);
        b2.setForeground(Color.blue);

        contentPane.add(b2);

        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b3.setBounds(369, 228, 149, 30);
        b3.setBackground(Color.white);
        b3.setForeground(Color.blue);
        contentPane.add(b3);

        JLabel l6 = new JLabel("");
        ImageIcon i13  = new ImageIcon(ClassLoader.getSystemResource("icons/RFT2.jpg"));
        Image i14 = i13.getImage().getScaledInstance(900, 500,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        l6 = new JLabel(i15);
        l6.setBounds(0, 0, 900, 500);
        contentPane.add(l6);

    }

    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();
            if(ae.getSource() == b1){
                String sql = "select * from soldParts_db where Customer_id = ? and Product_id =?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, textField_1.getText());
                st.setString(2, textField.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    textField_2.setText(rs.getString("Product_Name"));
                    textField_3.setText(rs.getString("Name"));
                    textField_4.setText(rs.getString("EmailID"));
                    textField_5.setText(rs.getString("SoldDate"));
                    textField_6.setText(rs.getString("Warranty"));
                }
                st.close();
                rs.close();

            }
            if(ae.getSource() == b2){
                String sql = "select * from Warranty_db where Customer_id = ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, textField_1.getText());
                //.setString(2, textField.getText());
                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Processing....");
                    JOptionPane.showMessageDialog(null, "warranty details - " + rs.getString("warranty_details"));
                    delete();
                } else
                    JOptionPane.showMessageDialog(null, "Error");

            }
            if(ae.getSource() == b3){
                this.setVisible(false);
                new Main_page().setVisible(true);

            }
        }catch(Exception e){

        }
    }
}
