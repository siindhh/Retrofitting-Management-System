import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Statistics extends JFrame{

    private JPanel contentPane;
    private JTable table;
    private JTable table_1;

    public static void main(String[] args) {
        new Statistics().setVisible(true);
    }

    public void Sold() {
        try {
            conn con =  new conn();
            String sql = "select * from soldParts_db";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void Warranty() {
        try {
            conn con = new conn();
            String sql = "select * from Warranty_db";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            table_1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public Statistics() {
        super("Statistics");
        setBounds(400, 200, 810, 594);
        contentPane = new JPanel();
        //contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l = new JLabel("Sold Parts Details ");
        l.setForeground(Color.black);
        l.setFont(new Font("Georgia", Font.PLAIN, 30));
        l.setBounds(240, 5, 330, 56);
        contentPane.add(l);


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(40, 51, 708, 217);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(224, 255, 255));
        table.setForeground(new Color(128, 128, 0));
        table.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        scrollPane.setViewportView(table);

        JLabel l1 = new JLabel("Back");
        l1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                setVisible(false);
                Main_page home = new Main_page();
                home.setVisible(true);
            }
        });
        l1.setForeground(new Color(204, 0, 102));
        l1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1.setIcon(i3);
        l1.setBounds(690, 13, 96, 27);
        contentPane.add(l1);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(40, 316, 717, 217);
        contentPane.add(scrollPane_1);

        table_1 = new JTable();
        table_1.setBackground(new Color(204, 255, 255));
        table_1.setForeground(new Color(153, 51, 0));
        table_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        scrollPane_1.setViewportView(table_1);

        JLabel l10 = new JLabel("Warranty Details ");
        l10.setForeground(Color.black);
        l10.setFont(new Font("Georgia", Font.PLAIN, 30));
        l10.setBounds(240, 270, 330, 56);
        contentPane.add(l10);

        JLabel l8 = new JLabel("");
        ImageIcon i17  = new ImageIcon(ClassLoader.getSystemResource("icons/RFT2.jpg"));
        Image i18 = i17.getImage().getScaledInstance(1000, 700,Image.SCALE_DEFAULT);
        ImageIcon i19 = new ImageIcon(i18);
        l8 = new JLabel(i19);
        l8.setBounds(0, 0, 1000, 700);
        contentPane.add(l8);


        Sold();
        Warranty();
    }
}
