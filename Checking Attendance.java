


import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Checking Attendance extends JFrame {
    
    JTable table;
    DefaultTableModel tab1;
    JButton b, b1;
    JLabel L1, L2;
    JTextField t;


    public next() {
        setLayout(null);
        Container cd = getContentPane();
        cd.setBackground(Color.YELLOW);

        Choice c = new Choice();


        Font font = new Font("Arial", Font.BOLD, 35);
        Font font1 = new Font("Arial", Font.BOLD, 20);

        String[] columns = {
            "rollno",
            "name",
            "lec_attended",
            "percentage"
        };
        
        Object[][] data = {};
        
        tab1 = new DefaultTableModel(data, columns);
        table = new JTable(tab1);
        
        table.setPreferredScrollableViewportSize(new Dimension(500, 50));
        table.setFillsViewportHeight(true);
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(70, 100, 1100, 400);


        b = new JButton("FETCH");
        b.setFont(font);
        b.setBounds(800, 30, 200, 50);


        b.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                while (tab1.getRowCount() > 0)
                    tab1.removeRow(0);

                 String sub;
                 sub = c.getSelectedItem().toString();
                 String query1, query2, query3, query4;



                  Vector < Integer > lec = new Vector < Integer > ();
                
  	           
  	           
  	           try{
  	           	//SELECTIN SUB_ID ON THE BASIS OF THE SUBJECT
  	        	   Class.forName("com.mysql.jdbc.Driver");
  	        		Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12380525","sql12380525","C8RBbgcdnp");
                    
  	        	/*   Class.forName("com.mysql.cj.jdbc.Driver");
  	        	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_master?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root",""); 
  	        	  */ 
  	             int k =0;
  	             System.out.print(sub);
  	             query1="select sub_id from subject_table where subject='"+sub+"';"; 
  	             
   	              Statement st1 = con.createStatement();
   	              Statement st2 = con.createStatement();

  	              ResultSet rs =st1.executeQuery(query1);

  	                while(rs.next()){
  	                    k=rs.getInt("sub_id");
  	                    //System.out.print(k);
  	                   
  	                }

  	           	
  	              //FINDING THE LECTURE ID OF THAT SUBJECT
  	                query2="select lecture_id from lecture_record where sub_id='"+k+"';";
  	                
  	                ResultSet rst =st1.executeQuery(query2);
  	                
  	                //ADDING THAT LECTURE INTO THE VECTOR
  	                while(rst.next()){
  	                    lec.add(rst.getInt("lecture_id"));
  	                    //System.out.print(lec);
  	                    
  	                   
  	                 }
  	                
  	                
  	                //SELECTING THE STUDENT
  	                
  	                int rollno,i;
  	                float attended;
  	                query3="select roll_no,student_name from student;";
  	                
                       ResultSet rst1 =st1.executeQuery(query3);
  	                
  	               
  	                while(rst1.next()){
  	                	
  	                	String name = rst1.getString("student_name");
  	                	System.out.print(name);
  	                	rollno=rst1.getInt("roll_no");
  	                	attended=0;
  	                     	query4="select * from attendace_record;";
  	                     	ResultSet rst2 =st2.executeQuery(query4);
      	                   	
  	                     	//NESTED QUERY
  	                     	while(rst2.next()){
  	                     		
  	                     		   if(rollno==rst2.getInt("roll_no")){
  	                     		
  	                     			  for(i=0;i<lec.size();i++){
  	                     				
  	                     				  if(lec.elementAt(i)==rst2.getInt("lect_id") ){
  	                     					attended++; 
  	                     					System.out.print(attended);
  	                     				  }
  	                     			  
  	                     			  
  	                     			    }
  	                     			
  	                     			
  	                     		   }
  	                     		
  	                     		
  	                     		
  	                     		
  	                     	}
                           //CONERTING INTEGER TO  THE STRING 	                	 
  	                     
  	                     String r=Integer.toString(rollno);
  	                     int temp = (int)attended;
  	                     String at=Integer.toString(temp); 
  	                    float f= (attended / lec.size())*100;
  	                    if(lec.size() == 0)
  	                    	throw new Exception();
  	                    System.out.print(f);
  	                    System.out.print(lec.size());
  	                    String total=Float.toString(f);
  	                    
  	                    
  	                	//ADDING INTO THE TABLE
  	                	tab1.insertRow(table.getRowCount(),new Object[]{r,name,at,total});
  	                	
                               	                	
  	                	
  	                	
  	                 }    	                

  	                System.out.print("Daon");
  	                
  	                
  	                
  	                
  	           	
  	           	
  	           }
  	           catch(Exception z){
  	        	   System.out.print(z.getMessage());
  	        	   JOptionPane.showMessageDialog(new JFrame(), "NO RECORD FOUND");
  	           }

  	      
                t.setText(lec.size() + "");

            }
        });









        L1 = new JLabel("SUBJECT :");
        L1.setFont(font);
        L1.setBounds(300, 20, 200, 70);

        c.setFont(font);
        c.setBounds(500, 30, 200, 70);



        L2 = new JLabel("total lecuture :");
        L2.setFont(font1);
        L2.setBounds(900, 550, 150, 30);


        t = new JTextField();
        t.setBounds(1050, 550, 100, 30);

        b1 = new JButton("GO TO MENU");
        b1.setBounds(1150, 20, 130, 20);

        b1.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Menu o = new Menu();

            }
        });



        setTitle("STUDENT RECORD");
        setBounds(0, 0, 1200, 600);




        add(b1);
        add(L1);
        add(c);
        add(b);

        add(L2);
        add(t);
        add(sp);

        
        //INSERTING CODE INTO THE COMBOBOX
        try{
        	
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12380525","sql12380525","C8RBbgcdnp");

        /*	
        	Class.forName("com.mysql.cj.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_master?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
       */    	
        String k;
        String sql3 ="select subject from subject_table;";

        PreparedStatement st = con.prepareStatement(sql3);

        ResultSet rs =st.executeQuery(sql3);

           while(rs.next()){
               k=rs.getString("subject");
               c.add(k);
         }

        	
        	
        	
        }
        catch(Exception e){}

        




        setVisible(true);
    }




}
