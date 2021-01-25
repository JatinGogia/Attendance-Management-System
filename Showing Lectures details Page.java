package attendance;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import java.sql.*;


public class Lecture {
    
    private JComboBox sub;
    
    private JButton fetch;
    
    private JLabel subject, date, time, dateformat, timeformat;
    
    private JTextField dateField, timeField;
    
    private JFrame f;
    
    private DefaultTableModel model;
    
    private JTable table;
    
    private JScrollPane jp;
    
    public Lecture() {
        
        f = new JFrame("ShowRecord");
        JButton logout = new JButton("GO TO MENU");
        logout.setBounds(1050, 50, 120, 20);
        
        
        logout.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                button o = new button();

            }
        });

        f.add(logout);

        Container c = f.getContentPane();
        c.setBackground(Color.YELLOW);

        subject = new JLabel("Subject");
        subject.setHorizontalAlignment(JLabel.CENTER);
        subject.setBounds(50, 50, 100, 25);
        f.add(subject)
        
        ;
        sub = new JComboBox();
        addSubject();
        
        sub.setEditable(false);
        sub.setBounds(150, 50, 100, 25);
        f.add(sub);
        
        date = new JLabel("Date");
        date.setHorizontalAlignment(JLabel.CENTER);
        date.setBounds(250, 50, 100, 25);
        f.add(date);
        
        dateField = new JTextField();
        dateField.setEditable(true);
        dateField.setHorizontalAlignment(JTextField.CENTER);
        dateField.setBounds(350, 50, 100, 25);
        f.add(dateField);
        
        
        dateformat = new JLabel("( YYYY-MM-DD )");
        dateformat.setHorizontalAlignment(JLabel.CENTER);
        dateformat.setBounds(350, 75, 100, 25);
        f.add(dateformat);
        
        
        time = new JLabel("Time");
        time.setHorizontalAlignment(JLabel.CENTER);
        time.setBounds(450, 50, 100, 25);
        f.add(time);
        
        timeField = new JTextField();
        timeField.setEditable(true);
        timeField.setHorizontalAlignment(JTextField.CENTER);
        timeField.setBounds(550, 50, 100, 25);
        f.add(timeField);
        
        
        timeformat = new JLabel("(HH:MM:SS)");
        timeformat.setHorizontalAlignment(JLabel.CENTER);
        timeformat.setBounds(550, 75, 100, 25);
        f.add(timeformat);
        
        
        fetch = new JButton("FETCH DATAILS");
        fetch.setHorizontalAlignment(JButton.CENTER);
        fetch.setBounds(700, 50, 150, 25);
        
        
        fetch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
	    		try {
	    		while(model.getRowCount()>0)
		    		model.removeRow(0);
                        

	    		Class.forName("com.mysql.jdbc.Driver");
	    		Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12380525","sql12380525","C8RBbgcdnp");
	    		
	    		/*
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_master?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
	    	      */
	    		Statement stmt = con.createStatement();
	    		String sql = "SELECT roll_no,student_name FROM Student WHERE roll_no IN(SELECT roll_no FROM Attendace_record WHERE lect_id IN (SELECT lecture_id FROM Lecture_record WHERE sub_id in (SELECT sub_id FROM subject_table WHERE subject = '"+sub.getSelectedItem()+"') AND date = '"+dateField.getText()+"' AND time = '"+timeField.getText()+"' )) ORDER BY roll_no ASC";
	    		ResultSet rs = stmt.executeQuery(sql);
	    		
	    		if(rs.next())
	    		{do
	    		{
	    			model.addRow(new Object[] {rs.getString(1),rs.getString(2)});
	    		}while(rs.next());
	    		}
	    		else
	    		{
	    			
	    			JOptionPane.showMessageDialog(new JFrame(), "NO RECORD FOUND");
	    		}
	    		con.close();
	    		}
	    		catch(Exception ex)
	    		{
	    			while(model.getRowCount()>0)
			    		model.removeRow(0);
	    			JOptionPane.showMessageDialog(new JFrame(), "NO RECORD FOUND");
	    		}
            }
        });
        f.add(fetch);
        model = new DefaultTableModel();
        model.addColumn("ROLL NO");
        model.addColumn("Name");
        
        table = new JTable(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        
        jp = new JScrollPane(table);
        jp.setBounds(50, 150, 850, 200);
        jp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        f.add(jp);

        f.setLayout(null);
        
        f.setBounds(0, 0, 1200, 600);
        
        f.setVisible(true);

    }
    private void addSubject() {
        
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12380525","sql12380525","C8RBbgcdnp");
	
	/*
	Class.forName("com.mysql.cj.jdbc.Driver");
	*/	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_master?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");	
		
		Statement stmt = con.createStatement();
		ResultSet r = stmt.executeQuery("SELECT subject FROM Subject_table");
		while(r.next())
		{
			String s = r.getString("subject");
			System.out.print(s);
			sub.addItem(s);
		}
		
		con.close();
		}
		
		catch(Exception e)
		{
			System.out.print(e);
		}
    }


}