import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_page extends JFrame implements ActionListener {
    private JButton b1,b2,b3,b4,b5;

    public static void main(String[] args) {
        new Main_page().setVisible(true);
    }


    public Main_page() {
        super("RETROFITTING AUTOMOTIVE MANAGEMENT SYSTEM");
        setBounds(120, 20, 1000, 730);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 245, 245), new Color(225, 225, 225)));
        menuBar.setBackground(Color.black);
        menuBar.setBounds(0, 0, 1500, 35);
        contentPane.add(menuBar);

        JMenu mnExit = new JMenu("Exit");
        mnExit.setFont(new Font("Trebuchet MS", Font.BOLD, 17));


        JMenu mnRecord = new JMenu("Option");
        mnRecord.setFont(new Font("Trebuchet MS", Font.BOLD, 17));


        JMenuItem parts_details = new JMenuItem("Parts Details");
        parts_details.addActionListener(this);
        parts_details.setBackground(new Color(211, 211, 211));
        parts_details.setForeground(Color.blue);
        mnRecord.add(parts_details);

        JMenuItem customer_details = new JMenuItem("Customer Details");
        customer_details.setBackground(new Color(211, 211, 211));
        customer_details.setForeground(Color.blue);
        customer_details.addActionListener(this);
        mnRecord.add(customer_details);

        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.setForeground(Color.blue);
        mntmExit.setBackground(new Color(211, 211, 211));
        mntmExit.addActionListener(this);
        mnRecord.add(mntmExit);

        menuBar.add(mnRecord);

        JLabel l1 = new JLabel("Retrofitting automotive Management System");
        l1.setForeground(new Color(12, 12, 12));
        l1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 30));
        l1.setBounds(138, 30, 1400, 80);
        contentPane.add(l1);

        JLabel l2 = new JLabel("");
        l2.setVerticalAlignment(SwingConstants.TOP);
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/car_parts.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l2 = new JLabel(i3);
        l2.setBounds(110, 140, 159, 152);
        contentPane.add(l2);

        JLabel l3;
        ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("icons/statistics.jpg"));
        Image i5 = i4.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        l3 = new JLabel(i6);
        l3.setBounds(410, 160, 134, 128);
        contentPane.add(l3);

        JLabel l4;
        ImageIcon i7  = new ImageIcon(ClassLoader.getSystemResource("icons/add_customer.png"));
        Image i8 = i7.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        l4 = new JLabel(i9);
        l4.setBounds(650, 140, 225, 152);
        contentPane.add(l4);

        b1 = new JButton("Add Parts");
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.BLACK);
        b1.setBounds(110, 320, 159, 44);
        contentPane.add(b1);

        b2 = new JButton("Statistics");
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.BLACK);
        b2.setBounds(413, 320, 139, 44);
        contentPane.add(b2);

        b3 = new JButton("Add Customer");
        b3.addActionListener(this);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.BLACK);
        b3.setBounds(682, 320, 159, 44);
        contentPane.add(b3);


        b4 = new JButton("Sold Parts");
        b4.addActionListener(this);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.BLACK);
        b4.setBounds(110, 620, 139, 41);
        contentPane.add(b4);

        b5 = new JButton("Warranty");
        b5.addActionListener(this);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.BLACK);
        b5.setBounds(413, 620, 159, 41);
        contentPane.add(b5);

        JButton b6 = new JButton("Logout");
        b6.addActionListener(this);
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.BLACK);
        b6.setBounds(680, 620, 139, 41);
        contentPane.add(b6);
        mnExit.add(mnExit);

        JLabel l5;
        ImageIcon i10  = new ImageIcon(ClassLoader.getSystemResource("icons/sold.png"));
        Image i11 = i10.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        l5 = new JLabel(i12);
        l5.setBounds(110, 440, 159, 163);
        contentPane.add(l5);

        JLabel l6;
        ImageIcon i13  = new ImageIcon(ClassLoader.getSystemResource("icons/warranty.png"));
        Image i14 = i13.getImage().getScaledInstance(200, 150,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        l6 = new JLabel(i15);
        l6.setBounds(410, 440, 139, 152);
        contentPane.add(l6);

        JLabel l7;
        ImageIcon i16  = new ImageIcon(ClassLoader.getSystemResource("icons/logout.jpg"));
        Image i17 = i16.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
        ImageIcon i18 = new ImageIcon(i17);
        l7 = new JLabel(i18);
        l7.setBounds(680, 430, 139, 152);
        contentPane.add(l7);

        JLabel l8;
        ImageIcon i21  = new ImageIcon(ClassLoader.getSystemResource("icons/RFT2.jpg"));
        Image i22 = i21.getImage().getScaledInstance(1000, 900,Image.SCALE_DEFAULT);
        ImageIcon i23 = new ImageIcon(i22);
        l8 = new JLabel(i23);
        l8.setBounds(0, 0, 1000, 900);
        contentPane.add(l8);

        getContentPane().setBackground(Color.WHITE);
        contentPane.setBackground(Color.BLUE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        switch (msg) {
            case "Logout" -> {
                setVisible(false);
                new login().setVisible(true);
            }
            case "Exit" -> System.exit(ABORT);
            case "Parts Details" -> {
                setVisible(false);
                new Add_parts().setVisible(true);
            }
            case "Customer Details" -> {
                setVisible(false);
                new Customer_details().setVisible(true);
            }
        }

        if(ae.getSource() == b1){
            this.setVisible(false);
            new Add_parts().setVisible(true);
        }
        if(ae.getSource() == b2){
            this.setVisible(false);
            new Statistics().setVisible(true);
        }
        if(ae.getSource() == b3){
            this.setVisible(false);
            new Add_customer().setVisible(true);
        }
        if(ae.getSource() == b4){
            this.setVisible(false);
            new Sold().setVisible(true);
        }
        if(ae.getSource() == b5){
            this.setVisible(false);
            new Warranty().setVisible(true);

        }


    }
}


