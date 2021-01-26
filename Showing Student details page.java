
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Showing Student details page{
    
    private JFrame f;
    
    private JLabel name, rollno, mobile, email;
    
    private JTextField tn, tr, tm, te;
    
    private JButton addi;
    
    private JPanel data;

    public Showing Student details page() {
        
        f = new JFrame("Search Student");
        f.setLayout(null);


        Container c = f.getContentPane();
        c.setBackground(Color.YELLOW);

        data = new JPanel(new GridLayout(3, 2, 10, 10));
        data.setBounds(40, 250, 1000, 350);
        data.setBackground(Color.LIGHT_GRAY);
        
        name = new JLabel("Name of the student");
        name.setHorizontalAlignment(JLabel.CENTER);
        data.add(name);
        
        tn = new JTextField();
        tn.setHorizontalAlignment(JTextField.CENTER);
        tn.setEditable(false);
        data.add(tn);
        
        mobile = new JLabel("Contact NO");
        mobile.setHorizontalAlignment(JLabel.CENTER);
        data.add(mobile);
        
        tm = new JTextField();
        tm.setHorizontalAlignment(JTextField.CENTER);
        tm.setEditable(false);
        data.add(tm);
        
        email = new JLabel("e-mail address");
        email.setHorizontalAlignment(JLabel.CENTER);
        data.add(email);
        
        
        te = new JTextField();
        te.setHorizontalAlignment(JTextField.CENTER);
        te.setEditable(false);
        data.add(te);
        f.add(data);
        
        
        addi = new JButton("Click to fetch Details");
        
        rollno = new JLabel("Enter the Roll NO:");
        rollno.setHorizontalAlignment(JLabel.CENTER);
        rollno.setBounds(20, 50, 245, 50);
        
        Font fr = new Font("Arial", Font.BOLD, 20);
        rollno.setFont(fr);
        f.add(rollno);
        
        tr = new JTextField();
        tr.setEditable(true);
        tr.setHorizontalAlignment(JTextField.CENTER);
        tr.setBounds(275, 50, 245, 50);
        f.add(tr);
        
        addi.setBounds(300, 150, 200, 50);

        JButton logout = new JButton("GO TO MENU");
        logout.setBounds(1050, 50, 120, 20);
        
        logout.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                Menu o = new Menu();

            }
        });

        f.add(logout);
        addi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                  		try {
                			
                  			Class.forName("com.mysql.jdbc.Driver");
                  		  Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12380525","sql12380525","C8RBbgcdnp");
                  		
                  		/*	Class.forName("com.mysql.cj.jdbc.Driver");
                  		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_master?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
                  		*/
                  		Statement stmt = con.createStatement();
                  		String sql;
                  		sql = "SELECT * FROM student where roll_no in (" + tr.getText()+");";
                  		System.out.print(sql);
                  		ResultSet r = stmt.executeQuery(sql);
                  		r.next();
                  		tn.setText(r.getString(2));
                  		tm.setText(r.getString(3));
                  		te.setText(r.getString(4));
                  		con.close();
                  		}
                  		catch(Exception ex)
                  		{
                  			tn.setText("");
                      		tm.setText("");
                      		te.setText("");
                      		JOptionPane.showMessageDialog(new JFrame(), "NO RECORD FOUND");
                  		}
            }
        });
        f.add(addi);
        f.setVisible(true);
        f.setBounds(0, 0, 1200, 600);

    }


}
