import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class loading extends JFrame implements Runnable {

    private JPanel contentPane;
    private JProgressBar progressBar;
    Connection conn;
    int s;
    Thread th;


    public static void main(String[] args) {
        new loading().setVisible(true);
    }

    public void setUploading() {
        setVisible(false);
        th.start();
    }

    public void run() {
        try {
            for (int i = 0; i < 200; i++) {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if (v < m) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 201;
                    setVisible(false);
                    new Main_page().setVisible(true);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public loading() {

        super("Loading");
        th = new Thread((Runnable) this);

        setBounds(400, 230, 600, 406);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel retrofittingManagement = new JLabel("Loading ");
        retrofittingManagement.setForeground(new Color(2, 52, 50));
        retrofittingManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        retrofittingManagement.setBounds(220, 56, 500, 35);
        contentPane.add(retrofittingManagement);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130, 160, 300, 25);
        contentPane.add(progressBar);

        JLabel retroNewLabel_2 = new JLabel("Please Wait....");
        retroNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        retroNewLabel_2.setForeground(new Color(68, 35, 22));
        retroNewLabel_2.setBounds(220, 300, 150, 20);
        contentPane.add(retroNewLabel_2);


        JLabel l6 = new JLabel("");
        ImageIcon i13  = new ImageIcon(ClassLoader.getSystemResource("icons/RFT2.jpg"));
        Image i14 = i13.getImage().getScaledInstance(600, 450,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        l6 = new JLabel(i15);
        l6.setBounds(0, 0, 600, 400);
        contentPane.add(l6);
        setUploading();
    }
}
