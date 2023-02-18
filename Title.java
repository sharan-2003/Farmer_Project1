package Farmer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Title extends JFrame implements ActionListener{
        public Title()
        {
            initComponents();
        }
        public void initComponents()
        {
            JPanel p = new JPanel();
            p.setBackground(Color.red);
            p.setLayout(null);
            p.setBounds(0,0,1000,2000);
            l = new JLabel("FARMER'S ");
            l.setFont(new Font("Tahoma",1,36));
            l.setForeground(Color.DARK_GRAY);
            l.setBounds(270,100,580,100);
            p.add(l);
            l1 = new JLabel("TRADE WITH ORGANIZATION");
            l1.setFont(new Font("Tahoma",1,36));
            l1.setForeground(Color.DARK_GRAY);
            l1.setBounds(100,165,600,100);
            p.add(l1);
            l2 = new JLabel();
            l2.setIcon(new ImageIcon(getClass().getResource("\\specialized-farming-2.jpg")));
            l2.setBounds(0,0,1000,800);
            p.add(l2);

            JPanel p1 = new JPanel();
            p1.setBackground(Color.white);
            p1.setBounds(700,0,900,2200);
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


            //p.setBackground();




            b = new JButton("Registration");
            b.setFont(new Font("Arial",1,22));
            b.setForeground(Color.WHITE);
            b.setBackground(Color.red);
            b.setBounds(1180,410,170,35);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    registerActionPerformed(e);
                }
            });
            b1 = new JButton("Login");
            b1.setFont(new Font("Arial",1,22));
            b1.setForeground(Color.WHITE);
            b1.setBackground(Color.blue);
            b1.setBounds(1180,480,170,35);
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    loginActionPerformed(e);
                }
            });
            l4 = new JLabel();
            l4.setIcon(new ImageIcon(getClass().getResource("\\gruopicon.png")));
            l4.setBounds(1160,130,300,300);

            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLayout(null);
            f.setSize(new Dimension(3000,3000));
            f.setVisible(true);
            f.setBackground(Color.green);
            f.add(p);
            f.add(b);
            f.add(b1);
            f.add(l4);
            f.add(p1);
        }
        private void registerActionPerformed(ActionEvent e)
        {
            new Registration().setVisible(true);
            setVisible(false);
        }
        private void loginActionPerformed(ActionEvent e)
        {
            new Login().setVisible(true);
            setVisible(false);

        }

    public static void main(String[] args) {
            new Title();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    private JButton b;
    private JButton b1;
    private JLabel l;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;

}
