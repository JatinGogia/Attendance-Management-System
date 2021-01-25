package lib;

//TIMETABLE CODE

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.table.*;

public class solve extends JFrame implements ActionListener {
    public JTextField a6, a5, a7, a8, k9, k10, k11;

    public JButton a4, a11, b1, b10, b11, k6, k7, k8;

    public Object r[][] = new Object[0][0];

    public DefaultTableModel tab1, tab3;

    public JTable tab2, tab;

    public String sub[] = new String[1];

    public String s[] = {
        "Subject",
        "ProfessorName",
        "MeetURL"
    };

    public JComboBox a12, a13, a14, a15, a16, a17, a18, a19;

    public JLabel k1, k2;

    public JScrollPane sp, sp1;

    public JLabel k3, k4, k5, k12;


    //CONSTRUCTOR
    public solve() {

        setLayout(null);


        Container c = getContentPane();
        c.setBackground(Color.YELLOW);



        Font font = new Font("Arial", Font.BOLD, 35);

        JLabel l1 = new JLabel();
        l1.setFont(font);
        l1.setText("Timetable");
        l1.setBounds(250, 0, 500, 50);
        add(l1);

        //Second Label
        JLabel l2 = new JLabel();
        l2.setFont(font);
        l2.setText("Update");
        l2.setBounds(850, 0, 500, 50);
        add(l2);

        //Third label
        JLabel l3 = new JLabel();
        Font font1 = new Font("Arial", Font.BOLD, 20);
        l3.setFont(font1);
        l3.setText("Slot   :");
        l3.setBounds(750, 40, 100, 50);
        add(l3);

        //Third label
        JLabel l6 = new JLabel();
        l6.setFont(font1);
        l6.setText("Roll no  :");
        l6.setBounds(750, 80, 100, 50);
        add(l6);

        //Fourth label
        JLabel l4 = new JLabel();
        l4.setFont(font1);
        l4.setText("Subject  :");
        l4.setBounds(750, 120, 100, 50);
        add(l4);

        //Fifth label
        JLabel l5 = new JLabel();
        l5.setFont(font1);
        l5.setText("Date   :");
        l5.setBounds(750, 160, 100, 50);
        add(l5);


        //Table
        String col[] = {
            "  ",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday"
        };
        String row[][] = new String[8][7];
        row[0][0] = "1";
        row[1][0] = "2";
        row[2][0] = "3";
        row[3][0] = "4";
        row[4][0] = "5";
        row[5][0] = "6";
        row[6][0] = "7";

        tab3 = new DefaultTableModel(row, col);

        tab = new JTable(tab3);
        sp1 = new JScrollPane(tab);

        sp1.setBounds(20, 100, 600, 130);
        tab.setEnabled(false);
        add(sp1);

        JTextField t1 = new JTextField();
        t1.setBounds(850, 170, 100, 20);
        add(t1);



        //Textfield 3
        JTextField t3 = new JTextField();
        t3.setBounds(850, 90, 100, 20);
        add(t3);


        //Button
        b1 = new JButton();
        b1.setText("CLICK TO ADD");
        b1.setBorderPainted(true);
        b1.setBounds(990, 140, 150, 50);



        JLabel l7 = new JLabel();
        l7.setFont(font);
        l7.setText("Subject Record");
        l7.setBounds(50, 220, 400, 100);
        //p2.add(l7);

        //Labels
        JLabel a1 = new JLabel("Subject :");
        JLabel a2 = new JLabel("Professor name :");
        JLabel a3 = new JLabel("Meet URL :");
        a1.setBounds(60, 280, 70, 70);
        a2.setBounds(300, 280, 150, 70);
        a3.setBounds(660, 280, 70, 70);
        //button


        a11 = new JButton();
        a11.setText("Click To add Timetable");
        a11.setBounds(540, 60, 170, 30);
        a11.addActionListener(this);

        //TextFields
        a5 = new JTextField(" ");
        a6 = new JTextField(" ");
        a7 = new JTextField(" ");
        a5.setBounds(120, 300, 150, 30);
        a6.setBounds(420, 300, 225, 30);
        a7.setBounds(740, 300, 150, 30);


        //Labels
        JLabel a8 = new JLabel("Subject :");
        JLabel a9 = new JLabel("Day :");
        JLabel a10 = new JLabel("Slot :");
        a8.setBounds(40, 50, 70, 40);
        a9.setBounds(200, 50, 70, 40);
        a10.setBounds(360, 50, 70, 40);



        //Initialization
        //TABLE


        tab1 = new DefaultTableModel(r, s);
        tab2 = new JTable(tab1);
        sp = new JScrollPane(tab2);
        sp.setBounds(40, 420, 1000, 230);

        tab2.setEnabled(false);
        tab2.setRowHeight(30);

        //CLICK TO JOIN METHOD
        k12 = new JLabel("Select Subject to join meet");
        k12.setBounds(1060, 330, 170, 200);

        k8 = new JButton("Click  To Join");
        k8.setBounds(1060, 530, 130, 30);
        k8.addActionListener(this);




        //BUTTON
        a4 = new JButton();
        a4.setText("Click To add");
        a4.setBounds(910, 300, 120, 30);
        a4.setBorderPainted(true);
        a4.addActionListener(this);

        String slot[] = {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7"
        };

        //ComboBox
        a12 = new JComboBox(col);
        a12.setBounds(250, 60, 100, 30);

        a13 = new JComboBox(slot);
        a13.setBounds(400, 60, 100, 30);

        a14 = new JComboBox(sub);
        a14.setBounds(100, 60, 90, 30);

        a17 = new JComboBox(slot);
        a17.setBounds(850, 50, 100, 20);
        add(a17);


        a18 = new JComboBox(sub);
        a18.setBounds(850, 130, 100, 20);
        add(a18);

        a19 = new JComboBox(sub);
        a19.setBounds(1060, 460, 170, 20);


        k1 = new JLabel("Select Subject to Update : ");
        k1.setBounds(20, 340, 270, 30);
        k1.setFont(font1);

        k2 = new JLabel("Select Subject to Delete : ");
        k2.setBounds(20, 380, 270, 30);
        k2.setFont(font1);

        a15 = new JComboBox(sub);
        a15.setBounds(290, 340, 90, 20);
        a15.addActionListener(this);

        a16 = new JComboBox(sub);
        a16.setBounds(290, 390, 90, 20);
        a16.addActionListener(this);

        k3 = new JLabel("Subject :");
        k4 = new JLabel("Professor name :");
        k5 = new JLabel("Meet URL :");

        k3.setBounds(400, 340, 70, 20);
        k4.setBounds(600, 340, 120, 20);
        k5.setBounds(850, 340, 70, 20);

        k9 = new JTextField();
        k10 = new JTextField();
        k11 = new JTextField();

        k9.setBounds(460, 340, 130, 20);
        k10.setBounds(710, 340, 120, 20);
        k11.setBounds(920, 340, 120, 20);


        k6 = new JButton("Click To Update");
        k7 = new JButton("Click To Delete");
        k6.setBounds(1050, 340, 140, 20);
        k7.setBounds(390, 390, 140, 20);
        k6.addActionListener(this);
        k7.addActionListener(this);

        add(k8);
        add(a19);
        add(k12);
        add(k6);
        add(k7);
        add(k9);
        add(k10);
        add(k11);
        add(k3);
        add(k4);
        add(k5);
        add(a16);
        add(a15);
        add(k2);
        add(k1);
        add(a1);
        add(a2);
        add(a3);
        add(a4);
        add(a5);
        add(a6);
        add(a7);
        add(a8);
        add(a9);
        add(a10);
        add(b1);
        add(sp);
        add(l7);
        add(a11);
        add(a12);
        add(a13);
        add(a14);
        setBounds(0, 0, 500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        //CONNECTION TO THE DATABASE

        String sql = "select * from subject;";
        String x, y, z;


        //CODE FOR GETTING THE RESULT RETRIEVED WHEN THE PROGRAM IS CALLED
        try {


            if (tab2.getRowCount() != 0) {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12380525","sql12380525","C8RBbgcdnp");


                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    x = rs.getString("subject");
                    y = rs.getString("proff_name");
                    z = rs.getString("meet_link");
                    tab1.insertRow(tab2.getRowCount(), new Object[] {
                        x,
                        y,
                        z
                    });
                }
                con.close();
            }



        } catch (Exception e) {}




    }

    public void actionPerformed(ActionEvent e) {
        //BUTTON TO ADD RECORD FOR SUBJECT
        if (e.getSource() == a4) {

            if (a5.getText().equals("") || a6.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill subject and professor name");
                return;
            }
            tab1.insertRow(tab2.getRowCount(), new Object[] {
                a5.getText(), a6.getText(), a7.getText()
            });

            a14.addItem(a5.getText());
            a15.addItem(a5.getText());
            a16.addItem(a5.getText());
            a18.addItem(a5.getText());
            a19.addItem(a5.getText());

            //INSERTING THE RECORD IN THE SUBJECT TABLE
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12380525","sql12380525","C8RBbgcdnp");

                String sql2 = "Insert into subject_table(subject,proff_name,meet_link) values('" + a5.getText() + "','" + a6.getText() + "','" + a7.getText().toString() + "');";
                Statement st = con.createStatement();
                st.executeUpdate(sql2);

                con.close();
            } catch (Exception o) {}

            a5.setText("");
            a6.setText("");
            a7.setText("");

        }


        //BUTTON TO ADD LECTURE IN THE TIMETABLE
        if (e.getSource() == a11) {
            //a12 day
            //a13 slot a14 subject
            int i, j = 0;
            i = Integer.parseInt(a13.getSelectedItem().toString()) - 1;
            String s;
            s = a12.getSelectedItem().toString();
            switch (s) {
                case "Monday":
                    j = 1;
                    break;
                case "Tuesday":
                    j = 2;
                    break;

                case "Wednesday":
                    j = 3;
                    break;
                case "Thursday":
                    j = 4;
                    break;
                case "Friday":
                    j = 5;
                    break;
                case "Saturday":
                    j = 6;
                    break;

            }
            tab3.setValueAt(a14.getSelectedItem(), i, j);

            //ADDING LECTURE ON THAT PARTICULAR DAY


            try {
               Class.forName("com.mysql.jdbc.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12380525","sql12380525","C8RBbgcdnp");
                String sql2 = "Insert into timetable values(j,i+1);";
                Statement stt = con.createStatement();
                stt.executeUpdate(sql2);
                con.close();

            } catch (Exception o) {}



        }


        //ACTION LISTENER FOR JCOMBOBOX
        if (e.getSource() == a15) {
            int i;
            for (i = 0; i < tab2.getRowCount(); i++) {

                if (a15.getSelectedItem().equals(tab2.getModel().getValueAt(i, 0))) {
                    break;
                }

            }
            k9.setText(tab2.getModel().getValueAt(i, 0).toString());
            k10.setText(tab2.getModel().getValueAt(i, 1).toString());
            k11.setText(tab2.getModel().getValueAt(i, 2).toString());

        }




        //BUTTON FOR UPDATION
        if (e.getSource() == k6) {
            int i;
            for (i = 0; i < tab2.getRowCount(); i++) {

                if (a15.getSelectedItem().equals(tab2.getModel().getValueAt(i, 0))) {
                    break;
                }

            }
            tab2.getModel().setValueAt(k9.getText(), i, 0);
            tab2.getModel().setValueAt(k10.getText(), i, 1);
            tab2.getModel().setValueAt(k11.getText(), i, 2);


            //UPDATING THE RECORD
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12380525","sql12380525","C8RBbgcdnp");

                String sql2 = "update subject set subject=k9.getText().toString(),proff_name=k10.getText().toString(),meet_link=k11.getText().toString() where sub_id=i;";
                Statement stt = con.createStatement();
                stt.executeUpdate(sql2);
                con.close();

            } catch (Exception o) {}

            k9.setText("");
            k10.setText("");
            k11.setText("");








        }



        //CCLICK TO DELETE CODE
        if (e.getSource() == k7) {
            int i;
            for (i = 0; i < tab2.getRowCount(); i++) {

                if (a16.getSelectedItem().equals(tab2.getModel().getValueAt(i, 0))) {
                    break;
                }

            }


            tab1.removeRow(i);

        }


        if (e.getSource() == k8) {
            int i;
            for (i = 0; i < tab2.getRowCount(); i++) {

                if (a19.getSelectedItem().equals(tab2.getModel().getValueAt(i, 0))) {
                    break;
                }

            }
            try {


                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {

                    Desktop.getDesktop().browse(new URL(tab2.getModel().getValueAt(i, 2).toString()).toURI());

                }

            } catch (Exception l) {
                JOptionPane.showMessageDialog(null, "Link is invalid");
            }

        }







    }




   






}