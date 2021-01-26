
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Add_student {
    private JFrame f;
    private JLabel name, rollno, mobile, email;
    private JTextField tn, tr, tm, te;
    private JButton addi;
    private JPanel data;
    
    
    public Add_student() {
        f = new JFrame("ADD STUDENT");
        f.setLayout(null);

        JButton logout = new JButton("GO TO MENU");
        logout.setBounds(1050, 50, 120, 20);
        

        logout.addActionListener(
            new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                Menu o = new Menu();   

            }
        }
    );

        f.add(logout);

        Container c = f.getContentPane();
        c.setBackground(Color.YELLOW);

        data = new JPanel(new GridLayout(4, 2, 10, 10));
        data.setBounds(100, 50, 900, 500);
        data.setBackground(Color.LIGHT_GRAY);
        
        rollno = new JLabel("Roll NO");
        rollno.setHorizontalAlignment(JLabel.CENTER);
        
        data.add(rollno);
        
        tr = new JTextField();
        tr.setEditable(true);
        tr.setHorizontalAlignment(JTextField.CENTER);
        
        data.add(tr);
        name = new JLabel("Name of the student");
        name.setHorizontalAlignment(JLabel.CENTER);
        
        data.add(name);
        
        tn = new JTextField();
        tn.setHorizontalAlignment(JTextField.CENTER);
        tn.setEditable(true);
        
        data.add(tn);
        
        mobile = new JLabel("Contact NO");
        mobile.setHorizontalAlignment(JLabel.CENTER);
        
        data.add(mobile);
        
        tm = new JTextField();
        tm.setHorizontalAlignment(JTextField.CENTER);
        tm.setEditable(true);
        
        
        data.add(tm);
        
        email = new JLabel("e-mail address");
        email.setHorizontalAlignment(JLabel.CENTER);
        
        
        data.add(email);
        
        
        te = new JTextField();
        te.setHorizontalAlignment(JTextField.CENTER);
        te.setEditable(true);
        
        
        data.add(te);
        
        
        f.add(data);
        
        
        addi = new JButton("Click To Add");
        addi.setBounds(280, 580, 200, 50);
        
        
          addi.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                
    		try {
    	           	Class.forName("com.mysql.jdbc.Driver");
    			Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12380525","sql12380525","C8RBbgcdnp");
    	              /*
    			Class.forName("com.mysql.cj.jdbc.Driver");
    		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_master?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
    		   */
    		Statement stmt = con.createStatement();
    		String sql;
    		sql = "INSERT INTO student VALUES ("+tr.getText()+",'"+tn.getText()+"','"+tm.getText()+"','"+te.getText()+"')";
    		//System.out.print(sql);
    		stmt.executeUpdate(sql);
    		JDialog d = new JDialog(f,"SUCCES");
    		JLabel j = new JLabel("The student data has been added successfully");
    		d.add(j);
    		d.setSize(100,100);
    		d.setVisible(true);
    		con.close();
    		}
    		catch(Exception ex)
    		{
    			JOptionPane.showMessageDialog(new JFrame(), "Server error");
    		}
    	
                } 
            }
        );

        
        f.add(addi);
        f.setVisible(true);
        f.setBounds(0, 0, 1200, 600);
    }




   





}