

//REGISTRATION PAGE

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Sign Up Page extends JFrame implements ActionListener {
    JButton b1;
    JLabel L3;
    JDialog d;
    JTextField t1;
    JTextField t2;
    
    
    public Sign Up Page() {
        b1 = new JButton("Register");
        b1.addActionListener(this);

        JLabel L1 = new JLabel("Enter new username:");
        JLabel L2 = new JLabel("Enter new password:");
        
        L3 = new JLabel("register successfull !!");

        t1 = new JTextField();
        t2 = new JPasswordField(8);
        setTitle("Sign up");
        
        setBounds(0, 0, 1200, 600);
        
        setLayout(null);

        Font font = new Font("Arial", Font.BOLD, 40);

        L1.setFont(font);
        L2.setFont(font);
        b1.setFont(font);


        L1.setBounds(130, 150, 450, 60);
        L2.setBounds(130, 250, 450, 60);
        t1.setBounds(560, 150, 400, 60);
        t2.setBounds(560, 250, 400, 60);
        b1.setBounds(100, 350, 200, 60);
        L3.setBounds(100, 200, 250, 20);

        add(t1);
        add(L1);
        add(L2);
        add(t2);
        add(b1);

        getContentPane().setBackground(Color.YELLOW);
        setVisible(true);
        
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
    
    
    public void actionPerformed(ActionEvent e) {
        String value1 = t1.getText();
        String value2 = t2.getText();

        if (value1.equals("") && value2.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter login name or password", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        String sql="insert into users values('"+value1+"','"+value2+"')";
        
       
        try{
                	Class.forName("com.mysql.jdbc.Driver");
         		Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12380525","sql12380525","C8RBbgcdnp")
        /*	    
                      Class.forName("com.mysql.cj.jdbc.Driver");
        */	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_master?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");  

        		Statement stt = con.createStatement();
        stt.executeUpdate(sql);
        con.close();
        JOptionPane.showMessageDialog(null,"REGISTRATION SUCCESSFULL");
        }
        catch(Exception ex)
        {
        	  System.out.print(ex.getMessage());
        }
        
        t1.setText("");
        t2.setText("");
        
        setVisible(false);
        
        Login o = new Login();


    }

}
