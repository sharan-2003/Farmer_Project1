package Farmer;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Publish extends Frame implements ActionListener{
    public Publish()
    {
        initComponents();
    }
    private void initComponents()
    {
        setVisible(true);
        setLayout(null);
        setBackground(new Color(255,204,0));
        l1 = new JLabel("Publishing Crop Details");
        l1.setForeground(new Color(255,0,51));
        l1.setFont(new Font("Tahoma",3,24));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setBounds(250,50,400,100);
        add(l1);
        l2 = new JLabel("please enter your crop details");
        l2.setBounds(100,100,300,100);
        l2.setForeground(new Color(255,0,51));
        l2.setFont(new Font("Tahoma",3,16));
        add(l2);
        l3 = new JLabel("Name");
        l3.setBounds(150,200,100,40);
        l3.setFont(new Font("Tahoma",3,16));
        add(l3);
        t1 = new JTextField();
        t1.setBounds(270,210,200,25);
        add(t1);
        l4 = new JLabel("Crop Name");
        l4.setBounds(150,250,100,40);
        l4.setFont(new Font("Tahoma",3,16));
        add(l4);
        t2 = new JTextField();
        t2.setBounds(270,260,200,25);
        add(t2);
        l5 = new JLabel("Quantity");
        l5.setBounds(150,300,100,40);
        l5.setFont(new Font("Tahoma",3,16));
        add(l5);
        t3 = new JTextField();
        t3.setBounds(270,310,100,25);
        add(t3);
        l6 = new JLabel("in");
        l6.setBounds(400,310,100,16);
        l6.setFont(new Font("Tahoma",3,16));
        add(l6);
        r1 = new JRadioButton("kg");
        r1.setBounds(440,310,40,20);
        add(r1);
        r2 = new JRadioButton("quintal");
        r2.setBounds(520,310,70,20);
        add(r2);
        r3 = new JRadioButton("gram");
        r3.setBounds(620,310,60,20);
        add(r3);
        l7 = new JLabel("Price");
        l7.setBounds(150,360,100,40);
        l7.setFont(new Font("Tahoma",3,16));
        add(l7);
        t4 = new JTextField();
        t4.setBounds(270,360,100,25);
        add(t4);
        l6 = new JLabel("per");
        l6.setBounds(400,360,100,16);
        l6.setFont(new Font("Tahoma",3,16));
        add(l6);
        r4 = new JRadioButton("kg");
        r4.setBounds(440,360,40,20);
        add(r4);
        r4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kgActionPerformed(e);
            }
        });
        r5 = new JRadioButton("quintal");
        r5.setBounds(520,360,70,20);
        add(r5);
        r5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quintalActionPerformed(e);
            }
        });
        r6 = new JRadioButton("gram");
        r6.setBounds(620,360,60,20);
        add(r6);
        r6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gramActionPerformed(e);
            }
        });
        l8 = new JLabel("Place");
        l8.setFont(new Font("Tahoma",3,16));
        l8.setBounds(150,420,100,40);
        add(l8);
        t5 = new JTextField();
        t5.setBounds(270,420,200,25);
        add(t5);
        t5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phoneActionPerformed(e);
            }
        });
        l9 = new JLabel("Phone number");
        l9.setFont(new Font("Tahoma",3,16));
        l9.setBounds(150,475,200,40);
        add(l9);
        t6 = new JTextField();
        t6.setBounds(320,475,200,25);
        add(t6);
        b1 = new JButton("Submit");
        b1.setBounds(220,570,120,25);
        b1.setFont(new Font("Tahoma",3,16));
        b1.setBackground(new Color(51,255,0));
        add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               b1ActionPerformed(e);
            }
        });
        b2 =new JButton("Reset");
        b2.setBounds(400,570,120,25);
        b2.setFont(new Font("Tahoma",3,16));
        b2.setBackground(new Color(51,102,255));
        add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b2ActionPerformed(e);
            }
        });
        b3 = new JButton("Back");
        b3.setBounds(320,620,120,25);
        b3.setBackground(Color.RED);
        b3.setForeground(Color.WHITE);
        add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b3ActionPerformed(e);
            }
        });
        l10 =new JLabel();
        l10.setIcon(new ImageIcon(getClass().getResource("\\PublishingCrops.jpeg")));
        l10.setBounds(550,420,700,350);
        add(l10);
        MyWindowAdapter3 m=new MyWindowAdapter3();
        addWindowListener(m);



    }
    private void phoneActionPerformed(ActionEvent e)
    {
    }
    private void kgActionPerformed(ActionEvent e)
    {}
    private void quintalActionPerformed(ActionEvent e)
    {}
    private void gramActionPerformed(ActionEvent e)
    {}

    private void b1ActionPerformed(ActionEvent e)
    {
        String name = t1.getText();
        String crop_n = t2.getText();
        float qua;
        qua = Float.parseFloat(t3.getText());
        String q="";
        float pri;
        pri = Float.parseFloat(t4.getText());
        String p="";
        String place = t5.getText();
        String pn = t6.getText();
        String phonenumber= "(0/91)?[7-9][0-9]{9}";
        if(pn.matches(phonenumber))
        {}
        else
        {
            t6.setText("invalid phone number");
        }
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/MyDatabase?"+ "user=root&password=Chitti@123");
            System.out.println("connected");
            if(r1.isSelected())
            {
                q="kg";
            }
            if(r2.isSelected())
            {
                q="quintal";
            }
            if(r3.isSelected())
            {
                q="gram";
            }
            if(r4.isSelected())
            {
                p="kg";
            }
            if(r5.isSelected())
            {
                p="quintal";
            }
            if(r6.isSelected())
            {
                p="gram";
            }
            String sql = "Insert into crops1(FARMER_NAME,CROP_NAME,QUANTITY,QUANTITY_INT,PRICE,PRICE_PER,PLACE,PHONE_NUMBER) values(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,crop_n);
            pst.setFloat(3,qua);
            pst.setString(4,q);
            pst.setFloat(5,pri);
            pst.setString(6,p);
            pst.setString(7,place);
            pst.setString(8,pn);
            pst.execute();
            new Publish().setVisible(true);
            setVisible(false);
            dispose();
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
    }


    private void b2ActionPerformed(ActionEvent e)
    {
        t1.setText(null);
        t2.setText(null);
        t3.setText(null);
        t4.setText(null);
        t5.setText(null);
        t6.setText(null);
    }
    private void b3ActionPerformed(ActionEvent e)
    {
        new Home().setVisible(true);
        setVisible(false);

    }

    public static void main(String[] args) {
        try
        {
            for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if("Nimbus".equals(info.getName()))
                {
                    UIManager.setLookAndFeel((info.getClassName()));
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            Logger.getLogger(Publish.class.getName()).log(Level.SEVERE,null,e);
        } catch (InstantiationException e) {
            Logger.getLogger(Publish.class.getName()).log(Level.SEVERE,null,e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }catch (UnsupportedLookAndFeelException e) {
            Logger.getLogger(Publish.class.getName()).log(Level.SEVERE,null,e);
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Publish().setVisible(true);
            }
        });
    }


    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JLabel l5;
    private JLabel l6;
    private JLabel l7;
    private JLabel l8;
    private JLabel l9;
    private JLabel l10;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t5;
    private JTextField t6;

    private JRadioButton r1;
    private JRadioButton r2;
    private JRadioButton r3;
    private JRadioButton r4;
    private JRadioButton r5;
    private JRadioButton r6;

    private JButton b1;
    private JButton b2;
    private JButton b3;

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    class MyWindowAdapter3 extends WindowAdapter {
        public void windowClosing(WindowEvent w) {
            System.exit(0);
        }
    }

}

