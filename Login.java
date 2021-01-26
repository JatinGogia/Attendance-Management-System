
//LOGIN PAGE
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class Login extends JFrame implements ActionListener {

    JButton b1;
    JButton b2;
    JLabel L1;
    JLabel L2;
    JTextField t1;
    JTextField t2;


    public Login() {
        setLayout(null);
        
        Font font = new Font("Arial", Font.BOLD, 40);
        
        b1 = new JButton("login");
        b1.addActionListener(this);

        b2 = new JButton(" Sign up");
        b2.addActionListener(this);

        L1 = new JLabel("username");
        L1.setFont(font);

        L2 = new JLabel("password");
        L2.setFont(font);
        
        t1 = new JTextField();
        t2 = new JPasswordField();
        
        setTitle("loginForm");
        setBounds(0, 0, 1200, 600);
        setLayout(null);
        
        L1.setBounds(130, 150, 200, 60);
        L2.setBounds(130, 250, 200, 60);
        t1.setBounds(450, 150, 200, 60);
        t2.setBounds(450, 250, 200, 60);
        
        b1.setBounds(200, 350, 200, 50);
        b1.setFont(font);
        b2.setFont(font);
        b2.setBounds(450, 350, 200, 50);

        JButton logout = new JButton("LOGOUT");
        logout.setBounds(900, 50, 120, 20);
        
        
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

            }
        });

        add(logout);

        add(t1);
        add(L1);
        add(L2);
        add(t2);
        add(b1);
        add(b2);
        getContentPane().setBackground(Color.YELLOW);
        setVisible(true);


        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);



    }



    public void actionPerformed(ActionEvent e) {
        int f = 1;
        String value1 = t1.getText().toString();
        String value2 = t2.getText().toString();
        if (e.getSource() == b1) {
            if (value1.equals("") && value2.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter login name or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
            String sql = "select * from users;";
            
            try{
            Class.forName("com.mysql.jdbc.Driver");
            		Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12380525","sql12380525","C8RBbgcdnp");
            	
            /*	  Class.forName("com.mysql.cj.jdbc.Driver");
            	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_master?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            */	
            	  Statement st = con.createStatement();
            	  ResultSet rs =st.executeQuery(sql);

            	  while(rs.next()){
            	      if(value1.equals(rs.getString("username")) && value2.equals(rs.getString("password")))
            	      {  f=0;
            	      break;
            	      }
            	      }

            	  con.close();  
            	  
            	  
            	  
            }
            catch(Exception ex){ 
            	  System.out.print(ex);
            	  }


            

            if (value1.equals("Admin") && value2.equals("user")) {
                JOptionPane.showMessageDialog(null, "register successfull !!");
                setVisible(false);
                Menu o = new Menu();


            } else {
                JOptionPane.showMessageDialog(null, "Invalid login name or password", "Error", JOptionPane.ERROR_MESSAGE);
                t1.setText("");
                t2.setText("");
            }




        }
        if (e.getSource() == b2) //b2 for sign up
        {
            setVisible(false);
             Sign_Up_Page o= new Sign_Up_Page();

        }
    }


}