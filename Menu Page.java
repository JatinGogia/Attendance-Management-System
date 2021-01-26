
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


class Menu Page {
      JFrame frame;

      JRadioButton jRadioButton1;
      JRadioButton jRadioButton2;
      JRadioButton jRadioButton3;
      JRadioButton jRadioButton4;
      JRadioButton jRadioButton5;
      JButton jButton;
      ButtonGroup G1;

    JLabel L1;


    public Menu Page() {
         
         frame = new JFrame();
         frame.setLayout(null);
         
         
         Container c = frame.getContentPane();
         c.setBackground(Color.YELLOW);

         jRadioButton1 = new JRadioButton();
         jRadioButton2 = new JRadioButton();
         jRadioButton3 = new JRadioButton();
         jRadioButton4 = new JRadioButton();
         jRadioButton5 = new JRadioButton();

         jButton = new JButton("GO");
          G1 = new ButtonGroup();
          
          Font f = new Font("Arial", Font.BOLD, 20);

        L1 = new JLabel();
        L1.setFont(f);
        L1.setText("MENU");
        L1.setBounds(300, 0, 200, 20);
        
        
        jRadioButton1.setText("Check record of a lecture");
        jRadioButton3.setText("Check attendance of a subject");
        jRadioButton2.setText("Timetable/Subject");
        jRadioButton4.setText("Add a student ");
        jRadioButton5.setText("Check Student database");



        jRadioButton1.setBounds(300, 40, 500, 70);
        jRadioButton2.setBounds(300, 140, 500, 70);
        jRadioButton3.setBounds(300, 240, 500, 70);
        jRadioButton4.setBounds(300, 340, 500, 70);
        jRadioButton5.setBounds(300, 440, 500, 70);

        jRadioButton1.setFont(f);
        jRadioButton2.setFont(f);
        jRadioButton3.setFont(f);
        jRadioButton4.setFont(f);
        jRadioButton5.setFont(f);

        jButton.setBounds(300, 540, 100, 70);
        
        
        G1.add(jRadioButton1);
        G1.add(jRadioButton2);
        G1.add(jRadioButton3);
        G1.add(jRadioButton4);
        G1.add(jRadioButton5);


        G1.add(jButton);



        frame.add(L1);
        frame.add(jRadioButton1);
        frame.add(jRadioButton2);
        frame.add(jRadioButton3);
        frame.add(jRadioButton4);
        frame.add(jRadioButton5);
        frame.add(jButton);

        JButton logout = new JButton("LOGOUT");
        
        logout.setBounds(900, 50, 120, 20);
        
        
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);


            }
        });

        
        frame.add(logout);



        frame.setSize(1000, 1000);
        frame.setVisible(true);
        jButton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {

                if (jRadioButton2.isSelected()) {
                    frame.setVisible(false);
                    Timetable o = new Timetable();
                }


                if (jRadioButton3.isSelected()) {
                    frame.setVisible(false);
                    checking Attendance o = Checking Attendance next();
                }


                if (jRadioButton5.isSelected()) {
                    frame.setVisible(false);
                    Show Student details page o = new Show Student details page();
                }

                if (jRadioButton4.isSelected()) {
                    frame.setVisible(false);
                    Add_student o = new Add_student();
                }

                if (jRadioButton1.isSelected()) {
                    frame.setVisible(false);
                    Showing Lectures details Page o = new Showing Lectures details Page();
                }


            }
        });


        frame.setBounds(0, 0, 1200, 600);

    }



}
