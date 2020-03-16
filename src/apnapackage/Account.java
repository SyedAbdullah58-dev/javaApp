package apnapackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account extends JFrame implements ActionListener {
    String di;
    int count;
    Account ref;
    AccountDetail ad;
    JTextField id, name, phone, mail;
    JTextField Address;
    JLabel top, Customer_ID, Name, Phone_no, Email, Genger, Marital, Addd, DOB, GengerM, GengerF, single, married;
    JRadioButton M, F, s, m;
    JButton next, submit;
    JComboBox c1, c2, c3;
    String date[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
    String month[] = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
    String year[] = {"1890", "1891", "1892", "1893", "1894", "1895", "1896", "1897", "1898", "1899", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2001", "2002"};

    public Account() {
        Color cc1=Color.LIGHT_GRAY;
        Color cc2=new Color(19, 19, 19);
        count = 0;
        setLayout(null);
        setBounds(100, 40, 1000, 700);
        setBackground(Color.LIGHT_GRAY);
        JPanel dodo = new JPanel();
        dodo.setBounds(80, 30, 800, 600);
        dodo.setLayout(null);
        dodo.setBackground(cc1);
        dodo.setFont(new Font("Arial", Font.BOLD, 20));
        add(dodo);

        c1 = new JComboBox(date);
        c2 = new JComboBox(month);
        c3 = new JComboBox(year);
        top = new JLabel("CUSTOMER INFORMATION");
        top.setBounds(280, 0, 300, 100);
        top.setFont(new Font("Arial", Font.BOLD, 16));
        dodo.add(top);
        Customer_ID = new JLabel("Customer_ID");
        Customer_ID.setBounds(10, 70, 100, 100);Customer_ID.setFont(new Font("System",Font.BOLD,14));
        dodo.add(Customer_ID);
        Name = new JLabel(" Name");
        Name.setBounds(10, 170, 100, 100);Name.setFont(new Font("System",Font.BOLD,14));
        dodo.add(Name);
        Phone_no = new JLabel("Phone_no");
        Phone_no.setBounds(10, 270, 100, 100);Phone_no.setFont(new Font("System",Font.BOLD,14));
        dodo.add(Phone_no);
        Genger = new JLabel("Gender");Genger.setFont(new Font("System",Font.BOLD,14));
        Genger.setBounds(10, 370, 100, 100);
        dodo.add(Genger);
        GengerM = new JLabel("Male");GengerM.setFont(new Font("System",Font.BOLD,14));
        GengerM.setBounds(10, 400, 100, 100);
        dodo.add(GengerM);
        GengerF = new JLabel("Female");GengerF.setFont(new Font("System",Font.BOLD,14));
        GengerF.setBounds(90, 400, 100, 100);
        dodo.add(GengerF);
        Email = new JLabel("Email ");Email.setFont(new Font("System",Font.BOLD,14));
        Email.setBounds(430, 70, 100, 100);
        dodo.add(Email);
        Marital = new JLabel("Marital Status");Marital.setFont(new Font("System",Font.BOLD,14));
        Marital.setBounds(450, 170, 100, 100);
        dodo.add(Marital);
        single = new JLabel("Single");single.setFont(new Font("System",Font.BOLD,14));
        single.setBounds(450, 210, 100, 100);
        dodo.add(single);
        married = new JLabel("Married");married.setFont(new Font("System",Font.BOLD,14));
        married.setBounds(600, 210, 100, 100);
        dodo.add(married);
        DOB = new JLabel("Date of Birth");DOB.setFont(new Font("System",Font.BOLD,14));
        DOB.setBounds(450, 250, 100, 100);
        c1.setBounds(450, 340, 70, 30);
        dodo.add(c1);
        c2.setBounds(550, 340, 70, 30);
        dodo.add(c2);
        c3.setBounds(650, 340, 70, 30);
        dodo.add(c3);
        dodo.add(DOB);
        Addd = new JLabel("Address");Addd.setFont(new Font("System",Font.BOLD,14));
        Addd.setBounds(450, 350, 100, 100);
        dodo.add(Addd);
        Address = new JTextField();
        Address.setBounds(450, 450, 250, 50);
        dodo.add(Address);
        id = new JTextField();
        id.setBounds(100, 110, 200, 20);
        dodo.add(id);
        name = new JTextField();
        name.setBounds(100, 210, 200, 20);
        dodo.add(name);
        phone = new JTextField();
        phone.setBounds(100, 310, 200, 20);
        dodo.add(phone);
        mail = new JTextField();
        mail.setBounds(500, 110, 200, 20);
        dodo.add(mail);
        M = new JRadioButton("Male");
        F = new JRadioButton();
        M.setBounds(50, 440, 20, 20);
        F.setBounds(140, 440, 20, 20);
        M.setBackground(Color.LIGHT_GRAY);
        dodo.add(M);
        F.setBackground(Color.LIGHT_GRAY);
        dodo.add(F);
        s = new JRadioButton();
        m = new JRadioButton();
        s.setBounds(500, 250, 20, 20);
        s.setBackground(Color.LIGHT_GRAY);
        m.setBounds(670, 250, 20, 20);
        s.setBackground(Color.LIGHT_GRAY);
        dodo.add(s);
        m.setBackground(Color.LIGHT_GRAY);
        dodo.add(m);

        submit = new JButton("SUBMIT");
        submit.setBackground(cc2);submit.setForeground(Color.white);
        submit.setBounds(200, 550, 100, 40);
        dodo.add(submit);
        submit.addActionListener(this);
        next = new JButton("NEXT");
        next.setBackground(cc2);next.setForeground(Color.white);
        next.setBounds(370, 550, 100, 40);
        dodo.add(next);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ButtonGroup grp1 = new ButtonGroup();
        ButtonGroup grp2 = new ButtonGroup();
        grp2.add(s);
        grp2.add(m);
        grp1.add(M);
        grp1.add(F);
        setVisible(true);
        next.addActionListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent e) {


        try {
            Conn c = new Conn();
            CallableStatement st = null;
            ResultSet rs;
            String name1, phone1, email, adress, gender = null, status = null, ad, day, mon = "-";
            String yr, date;
            yr = "-";
            day = c1.getSelectedItem().toString();
            mon += c2.getSelectedItem().toString();
            yr += c3.getSelectedItem().toString();
            date = day + mon + yr;


            if (e.getSource() == submit) {
                if (id.getText().equals("") || name.getText().equals("") || phone.getText().equals("") || mail.getText().equals("") || !(F.isSelected() || M.isSelected()) || !(m.isSelected() || s.isSelected())) {
                    JOptionPane.showMessageDialog(null, "Fill the all columns");
                } else {

                    if (M.isSelected()) {
                        gender = "Male";
                    } else if (F.isSelected()) {
                        gender = "Female";
                    } else {
                        JOptionPane.showMessageDialog(null, "choose Gender");
                    }
                    if (m.isSelected()) {
                        status = "Married";
                    } else if (s.isSelected()) {
                        status = "Single";
                    } else {
                        JOptionPane.showMessageDialog(null, "chooe marital status");
                    }

                    di = id.getText();
                    name1 = name.getText();
                    phone1 = phone.getText();
                    email = mail.getText();
                    ad = Address.getText();

                    st = c.con2.prepareCall("{call cus_info(?,?,?,?,?,?,?,?)}");
                    st.setString(1, di);
                    st.setString(2, name1);
                    st.setString(3, email);
                    st.setString(4, phone1);
                    st.setString(5, date);
                    st.setString(6, gender);
                    st.setString(7, status);
                    st.setString(8, ad);
                    st.execute();


                    JOptionPane.showMessageDialog(null, "Record has been added");
                }
            }

        } catch (SQLException so) {
            JOptionPane.showMessageDialog(null, so);
        }

        if (e.getSource() == next) {
            setVisible(false);
            AccountDetail ac = new AccountDetail();

        }

    }

    public String getDi() {
        return di;
    }

//    public class AccountDetail extends JFrame implements ActionListener {
//        Account a;
//        int count;
//        JLabel l1, l2, l3, l4, l5, l6, l7;
//        JTextField t1, t4, t5, t6, t7;
//        JPasswordField t2, t3;
//        JRadioButton R, C, s;
//        JButton done, back;
//        String cus;
//        JPanel pan;
//        Account d;
//        String br;
//
//        public AccountDetail() {
//            setTitle("\t\t\t\t\t\tAccount Details");
//            d = new Account();
//            d.setVisible(false);
//            cus = di;
//
//
//            count = 0;
//            setBounds(350, 50, 750, 500);
//            setBackground(Color.white);
//            setFont(new Font("Raleway", Font.BOLD, 20));
//            pan = new JPanel();
//            pan.setBounds(80, 30, 700, 400);
//            pan.setBackground(Color.white);
//            pan.setLayout(null);
//            add(pan);
//            l1 = new JLabel("ACCOUNT DETAILS");
//            l1.setFont(new Font("Raleway", Font.BOLD, 20));
//            l1.setBounds(280, 0, 300, 100);
//            pan.add(l1);
//
//            l2 = new JLabel("Initial Deposit");
//            l2.setFont(new Font("Times new Roman", Font.BOLD, 15));
//            l2.setBounds(10, 70, 100, 100);
//            pan.add(l2);
//            t1 = new JTextField();
//            t1.setBounds(150, 110, 170, 20);
//            pan.add(t1);
//            l3 = new JLabel("Account password");
//            l3.setFont(new Font("Times new Roman", Font.BOLD, 15));
//            l3.setBounds(10, 150, 150, 100);
//            pan.add(l3);
//            t2 = new JPasswordField();
//            t2.setBounds(150, 190, 170, 20);
//            pan.add(t2);
//            l4 = new JLabel("Confirm password");
//            l4.setFont(new Font("Times new Roman", Font.BOLD, 15));
//            l4.setBounds(10, 230, 150, 100);
//            pan.add(l4);
//            t3 = new JPasswordField();
//            t3.setBounds(150, 270, 170, 20);
//            pan.add(t3);
//            t4 = new JTextField();
//            t4.setBounds(500, 110, 170, 20);
//            pan.add(t4);
//            l5 = new JLabel("Account type");
//            l5.setFont(new Font("Times new Roman", Font.BOLD, 15));
//            l5.setBounds(10, 300, 100, 100);
//            pan.add(l5);
//            s = new JRadioButton("Saving");
//            s.setBounds(10, 370, 100, 20);
//            pan.add(s);
//            s.setBackground(Color.white);
//            R = new JRadioButton("Retirement");
//            R.setBounds(110, 370, 100, 20);
//            pan.add(R);
//            R.setBackground(Color.white);
//            C = new JRadioButton("Check Account");
//            C.setBounds(210, 370, 150, 20);
//            pan.add(C);
//            C.setBackground(Color.white);
//            l6 = new JLabel("Branch ID");
//            l6.setFont(new Font("Times new Roman", Font.BOLD, 15));
//            l6.setBounds(400, 70, 100, 100);
//            pan.add(l6);
//            l7 = new JLabel("Customer ID  " + cus);
//            l7.setFont(new Font("Times new Roman", Font.BOLD, 15));
//            l7.setBounds(400, 150, 400, 100);
//            pan.add(l7);
//            done = new JButton("Done");
//            back = new JButton("Back");
//            back.setBackground(Color.black);
//            back.setForeground(Color.WHITE);
//            back.setBounds(370, 400, 100, 40);
//            pan.add(back);
//            done.setBackground(Color.black);
//            done.setForeground(Color.WHITE);
//            done.setBounds(540, 400, 100, 40);
//            pan.add(done);
//            done.addActionListener(this);
//            back.addActionListener(this);
//            ButtonGroup group = new ButtonGroup();
//            group.add(R);
//            group.add(s);
//            group.add(C);
//            setVisible(true);
//
//            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//            setLayout(null);
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            br = t4.getText();
//            Conn c = new Conn();
//            CallableStatement st = null;
//            ResultSet rs;
//            String q;
//            String password, Balance, password2;
//            Balance = t1.getText();
//            password = t2.getText();
//            password2 = t3.getText();
//            if (password.equals(password2)) {
//
//
//                if (e.getSource() == back) {
//                    setVisible(false);
//                    a = new Account();
//
//                }
//                if (e.getSource() == done) {
//                    if (C.isSelected()) {
//                        try {
//                            st = c.con2.prepareCall("{call ACC_CHINS(?,?,?,?)}");
//                            st.setString(1, password);
//                            st.setString(2, Balance);
//                            st.setString(3, "5555");
//                            st.setString(4, br);
//
//                            st.execute();
//                        } catch (SQLException e1) {
//                            e1.printStackTrace();
//                        }
//                        JOptionPane.showMessageDialog(null, "Account successfully created");
//                        t1.setText("");
//                        t2.setText("");
//                        t3.setText("");
//                        t4.setText("");
//                        R.setSelected(false);
//                        C.setSelected(false);
//                        s.setSelected(false);
//
//
//                        if (R.isSelected()) {
//                            String organization = JOptionPane.showInputDialog("enter the organization you have served ");
//                            try {
//                                st = c.con2.prepareCall("{call Acc_RTINS(?,?,?,?,?)}");
//                                st.setString(1, password);
//                                st.setString(2, Balance);
//                                st.setString(3, cus);
//                                st.setString(4, br);
//                                st.setString(5, organization);
//                                st.execute();
//                            } catch (SQLException e1) {
//                                e1.printStackTrace();
//                            }
//                            JOptionPane.showMessageDialog(null, "Account successfully created");
//                            t1.setText("");
//                            t2.setText("");
//                            t3.setText("");
//                            t4.setText("");
//                            R.setSelected(false);
//                            C.setSelected(false);
//                            s.setSelected(false);
//
//                        }
//                    }
//                    if (s.isSelected()) {
//                        try {
//                            st = c.con2.prepareCall("{call SAV_ACCINS(?,?,?,?)}");
//                            st.setString(1, password);
//                            st.setString(2, Balance);
//                            st.setString(3, br);
//                            st.setString(4, cus);
//                            System.out.println("done");
//                            st.execute();
//                            JOptionPane.showMessageDialog(null, "Account successfully created");
//                            t1.setText("");
//                            t2.setText("");
//                            t3.setText("");
//                            t4.setText("");
//                            R.setSelected(false);
//                            C.setSelected(false);
//                            s.setSelected(false);
//
//
//                        } catch (SQLException e1) {
//                            JOptionPane.showMessageDialog(null, e1);
//                        }
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(null, "password confirmation failed !! ");
//
//                }
//
//
//            }
//
//
//        }
//    }
//        public static void main(String[] args) {
//            new Account();
//        }

    }

