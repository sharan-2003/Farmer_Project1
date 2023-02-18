package Farmer;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;
public class Login extends Frame implements ActionListener{
    public Login()
    {
        initComponents();
    }
    private void initComponents()
    {
        setVisible(true);
        setLayout(null);
        setBackground(Color.ORANGE);
        setForeground(Color.black);
        l = new JLabel("Welcome to Farmers Trade with Organization");
        l.setBounds(230,100,800,50);
        l.setForeground(new Color(0,104,203));
        l.setFont(new Font("Tahoma",1,28));
        add(l);
        validation = new JLabel();
        validation.setFont(new Font("Tahoma",0,14));
        validation.setForeground(new Color(255,0,0));
        validation.setBounds(550,420,190,30);
        add(validation);

        l4 = new JLabel("Login Page");
        l4.setFont(new Font("Tahoma",1,24));
        l4.setForeground(new Color(0,102,102));
        l4.setBounds(450,180,200,40);
        add(l4);
        l1 = new JLabel("Username");
       l1.setFont(new Font("Arial",1,24));
       l1.setBounds(300,300,150,40);
       l1.setIcon(new ImageIcon(getClass().getResource("\\mail-24.png")));
       add(l1);
       t1 = new TextField();
       t1.setBounds(470,310,200,25);
       add(t1);

       l2 = new JLabel("Password");
       l2.setFont(new Font("Arial",1,24));
       l2.setIcon(new ImageIcon(getClass().getResource("\\lock-24.png")));
       l2.setBounds(300,370,150,40);
       add(l2);
       t2 = new JPasswordField();
       t2.setBounds(470,377,200,28);
       add(t2);
       c1 = new JCheckBox();
       c1.setBackground(new Color(255,204,0));
       c1.setBounds(470,420,20,20);
       add(c1);
       c1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               CheckBoxActionPerformed(e);
           }
       });
       l3 = new JLabel();
       l3.setBounds(500,425,30,10);
       l3.setIcon(new ImageIcon(getClass().getResource("\\eye-3-16.png")));
       add(l3);
       sign = new JButton("Sign in");
       sign.setBackground(new Color(51,255,51));
       sign.setFont(new Font("Arial",1,16));
       sign.setBounds(530,470,90,30);
       add(sign);
       sign.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               signActionPerformed(e);
           }
       });

       register = new JButton("Register");
       register.setBackground(new Color(255,153,0));
       register.setFont(new Font("Dialog",1,16));
       register.setBounds(450,530,110,30);
       add(register);
       register.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               registerActionPerformed(e);
           }
       });
       reset = new JButton("Reset");
       reset.setBackground(new Color(255,121,255));
       reset.setFont(new Font("Dialog",1,16));
       reset.setBounds(600,530,110,30);
       add(reset);
       reset.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               resetActionPerformed(e);
           }
       });
       back = new JButton("Back");
       back.setBackground(new Color(51,255,51));
       back.setFont(new Font("Dialog",1,16));
       back.setBounds(530,600,100,30);
       add(back);
       back.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               backActionPerformed(e);
           }
       });
        MyWindowAdapter3 m=new MyWindowAdapter3();
        addWindowListener(m);


    }
    private void CheckBoxActionPerformed(ActionEvent e)
    {
        if(c1.isSelected())
        {
            t2.setEchoChar((char)0);
        }
        else
        {
            t2.setEchoChar('*');
        }
    }
    private void signActionPerformed(ActionEvent e)
    {
        //validation.setText(null);
       String user = t1.getText();
       char[] p = t2.getPassword();
       String password = new String(p);
        //String password = t2.getText();
       try
       {

           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/MyDatabase?"+ "user=root&password=Chitti@123");
           String sql;
           sql = "select * from REGISTRATION";
           Statement st;
           st = con.createStatement();
           ResultSet rs=st.executeQuery(sql);
           boolean flag = false;

           if (user.equals("") || password.equals(""))
           {
               JOptionPane.showMessageDialog(this,"ALL FIELDS ARE MANDATORY");
           }
           else {
               while(rs.next())
               {
                   if(user.equals(rs.getString(1)) && password.equals(rs.getString(2)))
                   {
                       flag = true;
                       break;
                   }
               }
               if(flag)
               {
                   JOptionPane.showMessageDialog(this,"SIGN IN SUCCESSFULLY");
                   new Home().setVisible(true);
                   setVisible(false);

               }
               else
               {
                   JOptionPane.showMessageDialog(this,"INVALID CREDENTIALS");
               }
           }


       } catch (SQLException  ex) {
           throw new RuntimeException(ex);
       }

    }
    private void registerActionPerformed(ActionEvent e)
    {
        Login l = new Login();
        Registration r = new Registration();
        r.setVisible(true);
        l.setVisible(false);
        dispose();

    }
    private void resetActionPerformed(ActionEvent e)
    {
            t1.setText(null);
            t2.setText(null);
    }
    private void backActionPerformed(ActionEvent e)
    {
        new Registration().setVisible(true);
        setVisible(false);
    }
    public static void main(String[] args)
    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    private JLabel l;

    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private TextField t1;
    private JLabel validation;
    private JPasswordField t2;
    private JCheckBox c1;
    private JButton sign;
    private JButton reset;
    private JButton register;
    private JButton back;
    private JPanel p1;
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
