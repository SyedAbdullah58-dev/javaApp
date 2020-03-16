package apnapackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class Employee extends JFrame implements ActionListener {
    String di;
    int count;
    Account ref;
    Account AccountDetail ;
    JTextField pass, name, phone, B_id, m_id, s_id;
    JTextField Address;
    JLabel top, password, Name, Phone_no, Branch_id, Job_type, Addd, DOB, GengerM, GengerF, ST1, Manager_id, Supervisor_id;
    JRadioButton M, S, ST;
    JButton next, submit;
    JComboBox c1, c2, c3;
    String date[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
    String month[] = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
    String year[] = {"1890", "1891", "1892", "1893", "1894", "1895", "1896", "1897", "1898", "1899", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2001", "2002"};

    public Employee() {

        Color cc1= new Color(156, 154, 142);
        Color cc2=new Color(156, 161, 166);
        count = 0;
        setLayout(null);
        setBounds(100, 40, 1000, 700);
        setBackground(Color.lightGray);
        JPanel dodo = new JPanel();
        dodo.setBounds(80, 30, 800, 600);
        dodo.setLayout(null);
        dodo.setBackground(cc1);
        dodo.setFont(new Font("Arial", Font.BOLD, 20));
        add(dodo);

        c1 = new JComboBox(date);
        c2 = new JComboBox(month);
        c3 = new JComboBox(year);

        top = new JLabel("     EMPLOYEE RECORD");
        top.setBounds(280, 0, 300, 100);
        top.setFont(new Font("Arial", Font.BOLD, 16));
        dodo.add(top);
        password = new JLabel("Password");
        password.setFont(new Font("System", Font.BOLD, 14));
        password.setBounds(10, 70, 100, 100);
        dodo.add(password);
        Name = new JLabel(" Name");
        Name.setFont(new Font("System", Font.BOLD, 14));
        Name.setBounds(10, 170, 100, 100);
        dodo.add(Name);
        Phone_no = new JLabel("Phone_no");
        Phone_no.setFont(new Font("System", Font.BOLD, 14));
        Phone_no.setBounds(10, 270, 100, 100);
        dodo.add(Phone_no);
        Job_type = new JLabel("Job Type");
        Job_type.setBounds(10, 370, 100, 100);
        Job_type.setFont(new Font("System", Font.BOLD, 14));
        dodo.add(Job_type);
        GengerM = new JLabel("Manager");
        GengerM.setBounds(5, 400, 100, 100);
        dodo.add(GengerM);
        GengerF = new JLabel("Supervisor");
        GengerF.setBounds(100, 400, 100, 100);
        dodo.add(GengerF);
        ST1 = new JLabel("Staff");
        ST1.setBounds(200, 400, 100, 100);
        dodo.add(ST1);
        Branch_id = new JLabel("Branch_ID");
        Branch_id.setFont(new Font("System", Font.BOLD, 14));
        Branch_id.setBounds(420, 70, 100, 100);
        dodo.add(Branch_id);
        Manager_id = new JLabel("Manager_ID");
        Manager_id.setFont(new Font("System", Font.BOLD, 14));
        Manager_id.setBounds(420, 140, 100, 100);
        dodo.add(Manager_id);
        Supervisor_id = new JLabel("Supervisor_ID");
        Supervisor_id.setFont(new Font("System", Font.BOLD, 14));
        Supervisor_id.setBounds(410, 210, 100, 100);
        dodo.add(Supervisor_id);


        DOB = new JLabel("Date of Birth");
        DOB.setBounds(450, 250, 100, 100);
        c1.setBounds(450, 340, 70, 30);
        dodo.add(c1);
        c2.setBounds(550, 340, 70, 30);
        dodo.add(c2);
        c3.setBounds(650, 340, 70, 30);
        dodo.add(c3);
        dodo.add(DOB);
        Addd = new JLabel("Address");
        Addd.setBounds(450, 350, 100, 100);
        dodo.add(Addd);
        Address = new JTextField();
        Address.setBounds(450, 450, 250, 50);
        dodo.add(Address);
        pass = new JTextField();
        pass.setBounds(100, 110, 200, 20);
        dodo.add(pass);
        name = new JTextField();
        name.setBounds(100, 210, 200, 20);
        dodo.add(name);
        phone = new JTextField();
        phone.setBounds(100, 310, 200, 20);
        dodo.add(phone);
        B_id = new JTextField();
        B_id.setBounds(520, 110, 200, 20);
        dodo.add(B_id);
        m_id = new JTextField();
        m_id.setBounds(520, 180, 200, 20);
        dodo.add(m_id);
        s_id = new JTextField();
        s_id.setBounds(520, 250, 200, 20);
        dodo.add(s_id);
        M = new JRadioButton("Manager");
        S = new JRadioButton();
        M.setBounds(70, 440, 20, 20);
        S.setBounds(180, 440, 20, 20);
        M.setBackground(Color.lightGray);
        dodo.add(M);
        S.setBackground(Color.lightGray);
        dodo.add(S);
        ST = new JRadioButton("Staff");
        ST.setBackground(Color.lightGray);
        ST.setBounds(250, 440, 20, 20);
        dodo.add(ST);
        submit = new JButton("Register");
        submit.setBackground(cc2);
        submit.setBounds(200, 550, 100, 40);
        dodo.add(submit);
        submit.addActionListener(this);
        next = new JButton("Cancel");
        next.setBackground(cc2);
        next.setBounds(370, 550, 100, 40);
        dodo.add(next);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ButtonGroup grp1 = new ButtonGroup();
        ButtonGroup grp2 = new ButtonGroup();

        grp1.add(M);
        grp1.add(S);
        grp1.add(ST);
        setVisible(true);
        next.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Boolean check=false;
        String b_id, M_id, S_id, passwrd, Name, phoneee, address, contact;
        String yr, date;
        String mon;
        yr = "-";
        mon = "-";
        String day = c1.getSelectedItem().toString();
        mon += c2.getSelectedItem().toString();
        yr += c3.getSelectedItem().toString();
        date = day + mon + yr;
        phoneee = phone.getText();
        passwrd = pass.getText();
        b_id = B_id.getText();
        M_id = m_id.getText();
        S_id = s_id.getText();
        Name = name.getText();

        address = Address.getText();
        Conn c = new Conn();

        CallableStatement st;
        if (e.getSource() == submit) {
            if (password.getText().equals("") || name.getText().equals("") || phone.getText().equals("") || B_id.getText().equals("") || !(M.isSelected() || !S.isSelected() || !ST.isSelected())) {
                JOptionPane.showMessageDialog(null, "Fill the all columns");
            } else {
            }
            if (M.isSelected()) {
                try {
                    st = c.con2.prepareCall("{call INS_MANAGER(?,?,?,?,?,?) }");
                    st.setString(1, passwrd);
                    st.setString(2, Name);
                    st.setString(3, phoneee);
                    st.setString(4, address);
                    st.setString(5, date);
                    st.setString(6, b_id);
                    st.execute();
                    m_id.setBackground(Color.red);
                    s_id.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Successful");
                } catch (SQLException e1) {
                    System.out.println(e1);
                }


            } else if (S.isSelected()) {
                try {
                    st = c.con2.prepareCall("{call INS_SUPER(?,?,?,?,?,?,?) }");
                    st.setString(1, passwrd);
                    st.setString(2, Name);
                    st.setString(3, phoneee);
                    st.setString(4, address);
                    st.setString(5, date);
                    st.setString(6, b_id);
                    st.setString(7, M_id);


                    st.execute();
                    JOptionPane.showMessageDialog(null, "Successful");
                } catch (SQLException e1) {
                    System.out.println(e1);
                }


            } else if (ST.isSelected()) {
                try {
                    st = c.con2.prepareCall("{call INS_STAFF(?,?,?,?,?,?,?,?) }");
                    st.setString(1, passwrd);
                    st.setString(2, Name);
                    st.setString(3, phoneee);
                    st.setString(4, address);
                    st.setString(5, date);
                    st.setString(6, b_id);
                    st.setString(7, S_id);
                    st.setString(8,M_id);

                    st.execute();
                    JOptionPane.showMessageDialog(null, "Successful");
                } catch (SQLException e1) {
                    System.out.println(e1);
                }

            }
            check=true;
        }
        if(check)
        {
            setVisible(false);
        }
        if (e.getSource() == next) {
setVisible(false);
new Main();

        }
    }
    public static void main(String[] args) {
        Employee e = new Employee();
    }
}

