package Farmer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Registration extends Frame implements ActionListener {
    public Registration() {
        initComponents();
    }
    private void initComponents() {

        setLayout(null);
        setVisible(true);
        setBackground(Color.cyan);
        setForeground(Color.black);
        l = new Label("REGISTRATION");
        l.setFont(new Font("Tahoma",1,24) );
        l.setForeground(new Color(255,153,51));
        l.setBackground(new Color(255,255,51));
        l.setBounds(470,50,190,28);
        add(l);
        l1 = new JLabel("Username");
        l1.setFont(new Font("Tahoma",1,14));
        l1.setBounds(100,120,140,25);
        l1.setIcon(new ImageIcon(getClass().getResource("\\mail-24.png")));
        add(l1);
        t1 = new TextField();
        t1.setBounds(250,120,200,25);
        add(t1);
        l2  = new JLabel("Password");
        l2.setBounds(100,170,140,40);
        l2.setFont(new Font("Tahoma",1,14));
        l2.setIcon(new ImageIcon(getClass().getResource("\\lock-24.png")));
        add(l2);
        t2 = new TextField();
        t2.setBounds(250,180,200,25);
        add(t2);
        l3 = new Label("Confirm Password");
        l3.setBounds(100,230,140,60);
        l3.setFont(new Font("Tahoma",1,14));
        add(l3);
        t3 = new TextField();
        t3.setBounds(250,250,200,25);
        add(t3);
        l4 = new Label("First Name");
        l4.setBounds(100,290,120,80);
        l4.setFont(new Font("Tahoma",1,14));
        add(l4);
        t4 = new TextField();
        t4.setBounds(250,320,200,25);
        add(t4);
        l5 = new Label("Last Name");
        l5.setBounds(100,340,120,80);
        l5.setFont(new Font("Tohamo",1,14));
        add(l5);
        t5 = new TextField();
        t5.setBounds(250,360,200,25);
        add(t5);
        l6 = new Label("Gender");
        l6.setBounds(100,390,120,80);
        l6.setFont(new Font("Tahoma",1,14));
        add(l6);
        male = new JRadioButton("male");
        male.setBounds(250,415,80,25);
        male.setFont(new Font("Tahoma",1,14));
        add(male);
        female = new JRadioButton("female");
        female.setBounds(330,415,100,25);
        female.setFont(new Font("Tahoma",1,14));
        add(female);
        l7 = new Label("Mobile Number");
        l7.setBounds(100,450,120,80);
        l7.setFont(new Font("Tahoma",1,14));
        add(l7);
        t6 = new TextField();
        t6.setBounds(250,475,200,25);
        add(t6);
        l8 = new Label("Country");
        l8.setBounds(100,500,120,80);
        l8.setFont(new Font("Tahoma",1,14));
         add(l8);
         c = new TextField();
         c.setBounds(250,530,200,25);
         add(c);
         l9 = new Label("State");
         l9.setBounds(100,550,120,80);
         l9.setFont(new Font("Tahoma",1,14));
         add(l9);
         state = new TextField();
         state.setBounds(250,575,200,25);
         add(state);
         l10 = new Label("District");
         l10.setBounds(100,600,120,80);
         l10.setFont(new Font("Tahoma",1,14));
         add(l10);
         district = new TextField();
         district.setBounds(250,625,200,25);
         add(district);
         register =new JButton("Register");
         register.setBounds(220,680,100,30);
         add(register);
         logo  = new JLabel();
         logo.setIcon(new ImageIcon(getClass().getResource("\\Farmer Logo.jpg")));
         logo.setBounds(580,150,1000,500);
         add(logo);
         register.setBackground(new Color(0,255,51));
         register.setFont(new Font("Dialog",1,16));
         login = new JButton("Login");
         login.setBounds(270,740,120,30);
         login.setIcon(new ImageIcon(getClass().getResource("\\account-login-24.png")));
         add(login);
         login.setBackground(new Color(0,255,102));
         login.setFont(new Font("Dialog",1,16));
         login.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 loginActionPerformed(e);
             }
         });
         MyWindowAdapter2 m=new MyWindowAdapter2();
         addWindowListener(m);

         register.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 registerActionPerformed(e);
             }
         });
         reset = new JButton("Reset");
         reset.setBounds(350,680,80,30);
         add(reset);
         reset.setBackground(new Color(0,255,51));
         reset.setFont(new Font("Dialog",1,16));
         reset.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 resetActionPerformed(e);
             }
         });
    }
    private void loginActionPerformed(ActionEvent a)
    {
        Registration r = new Registration();
        Login l = new Login();
        l.setVisible(true);
        r.setVisible(false);
        dispose();
    }
    private void registerActionPerformed(ActionEvent a)
    {
        String user = t1.getText();
        String pswrd = t2.getText();
        String cpswrd = t3.getText();
        String first = t4.getText();
        String last = t5.getText();
        String phone = t6.getText();
        String ctr = c.getText();
        String st = state.getText();
        String dist = district.getText();
        String g="";
        String email = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        String phonenumber = "(0/91)?[7-9][0-9]{9}";

        if(user.equals("")||pswrd.equals("")||cpswrd.equals("")||first.equals("")||last.equals("")||phone.equals("")||ctr.equals("")||st.equals("")||dist.equals(""))
        {
            JOptionPane.showMessageDialog(this,"ALL FIELDS ARE MANDATORY");
        }
        else if(!user.matches(email)||!phone.matches(phonenumber)|| !pswrd.equals(cpswrd))
        {
             if(!user.matches(email))
            {
                t1.setText("invalid email");
            }
             if(!phone.matches(phonenumber))
            {
                t6.setText("Invalid mobile number");
            }
            if(!pswrd.equals(cpswrd))
            {
                 t2.setText("password did not match");
            }
        }
        else
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/MyDatabase?"+ "user=root&password=Chitti@123");
                if(male.isSelected())
                {
                    g="male";
                }
                if(female.isSelected())
                {
                    g="female";
                }
                String sql = "Insert into REGISTRATION(USER_NAME,PASSWORDS,FIRST_NAME,LAST_NAME,GENDER,MOBILE_NUMBER,COUNTRY,STATE,DISTRICT) values(?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1,user);
                pst.setString(2,pswrd);
                pst.setString(3,first);
                pst.setString(4,last);
                pst.setString(5,g);
                pst.setString(6,phone);
                pst.setString(7,ctr);
                pst.setString(8,st);
                pst.setString(9,dist);
                pst.execute();
                JOptionPane.showMessageDialog(this,"REGISTER SUCCESSFULLY");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        
    }
    private void resetActionPerformed(ActionEvent e) {
        t1.setText(null);
        t2.setText(null);
        t3.setText(null);
        t4.setText(null);
        t5.setText(null);
        t6.setText(null);
        c.setText(null);
        state.setText(null);
        district.setText(null);

    }
        public static void main(String[] args)
        {
            try{
                for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
                {
                    if("Nimbus".equals(info.getName()))
                    {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            }
            catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Registration().setVisible(true);
                }
            });
        }
    private TextField district;
    private Label l;
    private JLabel l1;
    private JLabel l2;
    private Label l3;
    private Label l4;
    private TextField t1;
    private TextField t2;
    private TextField t3;
    private TextField t4;
    private Label l5;
    private Label l6;
    private Label l7;
    private Label l8;
    private Label l9;
    private Label l10;
    private JLabel logo;
    private JRadioButton male;
    private JRadioButton female;
    private TextField t5;
    private TextField t6;
    private TextField c;
    private JButton login;
    private JButton register;
    private JButton reset;
    private TextField state;

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

