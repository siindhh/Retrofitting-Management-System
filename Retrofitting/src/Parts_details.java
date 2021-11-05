import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Parts_details extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTable table;
    private JTextField search;
    private JButton b1,b2;

    public static void main(String[] args) {
        new Parts_details().setVisible(true);
    }

    public void Parts() {
        try {
            conn con = new conn();
            String sql = "select * from parts_db";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {

        }
    }

    public Parts_details() {
        super("Parts Details");
        setBounds(350, 200, 890, 475);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(79, 133, 771, 282);
        contentPane.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 1).toString());
            }
        });
        table.setBackground(new Color(240, 248, 255));
        table.setForeground(Color.DARK_GRAY);
        table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        scrollPane.setViewportView(table);

        JButton b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(24, 23, 23), 2, true));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b1.setIcon(i3);
        b1.setForeground(new Color(28, 25, 27));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        b1.setBounds(564, 89, 138, 33);
        contentPane.add(b1);

        JButton b2 = new JButton("Delete");
        b2.addActionListener(this);
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/nineth.png"));
        Image i5 = i4.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b2.setIcon(i6);
        b2.setForeground(new Color(26, 23, 24));
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        b2.setBorder(new LineBorder(new Color(21, 20, 20), 2, true));
        b2.setBounds(712, 89, 138, 33);
        contentPane.add(b2);


        JLabel l1 = new JLabel("Parts Details");
        l1.setForeground(new Color(17, 19, 17));
        l1.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
        l1.setBounds(300, 15, 400, 47);
        contentPane.add(l1);


        search = new JTextField();
        search.setBackground(new Color(243, 240, 240));
        search.setBorder(new LineBorder(new Color(23, 22, 22), 2, true));
        search.setForeground(new Color(21, 23, 23));
        search.setFont(new Font("Trebuchet MS", Font.BOLD , 17));
        search.setBounds(189, 89, 357, 33);
        contentPane.add(search);
        search.setColumns(10);

        JLabel l3 = new JLabel("Back");
        l3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                Main_page home = new Main_page();
                home.setVisible(true);
            }
        });
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.png"));
        Image i8 = i7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        l3.setIcon(i9);
        l3.setBounds(97, 89, 72, 33);
        contentPane.add(l3);

        JLabel l6 = new JLabel("");
        ImageIcon i13  = new ImageIcon(ClassLoader.getSystemResource("icons/RFT2.jpg"));
        Image i14 = i13.getImage().getScaledInstance(900, 500,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        l6 = new JLabel(i15);
        l6.setBounds(0, 0, 900, 500);
        contentPane.add(l6);
        Parts();
    }

    public void actionPerformed(ActionEvent ae){
        try{

            conn con = new conn();
            if(ae.getSource() == b1){

                String sql = "select * from parts_db where concat(Product_name, Product_id) like ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, "%" + search.getText() + "%");
                ResultSet rs = st.executeQuery();

                table.setModel(DbUtils.resultSetToTableModel(rs));
                rs.close();
                st.close();

            }
            if(ae.getSource() == b2){
                String sql = "delete from parts_db where Product_name = '" + search.getText() + "'";
                PreparedStatement st = con.c.prepareStatement(sql);

                JDialog.setDefaultLookAndFeelDecorated(true);
                int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.NO_OPTION) {

                } else if (response == JOptionPane.YES_OPTION) {
                    int rs = st.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Deleted !!");
                } else if (response == JOptionPane.CLOSED_OPTION) {

                }
                st.close();


            }

            con.c.close();
        }catch(Exception e){

        }
    }
}
