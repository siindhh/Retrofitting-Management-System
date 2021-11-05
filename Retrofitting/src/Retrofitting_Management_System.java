import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Retrofitting_Management_System extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1;
    private JPanel Pane;

    public Retrofitting_Management_System () {
        super("RETROFITTING AUTOMOTIVE MANAGEMENT SYSTEM");
        setBounds(400, 200, 750, 405);
        setLayout(null);

        Pane = new JPanel();
        Pane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(Pane);
        Pane.setBackground(Color.WHITE);
        Pane.setLayout(null);
        JLabel l3 = new JLabel("Retrofitting Automotive");
        JLabel l4 = new JLabel("Management System");
        l3.setForeground(Color.black);
        l3.setFont(new Font("Georgia", Font.BOLD, 40));
        l3.setBounds(120, 70, 600, 56);
        Pane.add(l3);

        l4.setForeground(Color.blue);
        l4.setFont(new Font("Georgia", Font.BOLD, 40));
        l4.setBounds(130, 120, 600, 56);
        Pane.add(l4);


        l1 = new JLabel("");
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/RFT2.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1000,1500,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i2);

        b1 = new JButton("Next");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 13));
        b1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(14, 22, 31), new Color(18, 41, 52)));
        b1.setForeground(Color.BLACK);
        Pane.add(b1);
        b1.setBounds(450,290,120,40);
        l1.setBounds(0, 0, 750, 370);

        l1.add(b1);
        add(l1);

        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        new login().setVisible(true);
        this.setVisible(false);

    }

    public static void main(String[] args) {
        // TODO code application logic here
        new Retrofitting_Management_System().setVisible(true);

    }

}




