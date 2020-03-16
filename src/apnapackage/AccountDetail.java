package apnapackage;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDetail extends JFrame implements  ActionListener{
    Account a;
    int count;
JLabel l1,l2,l3,l4,l5,l6,l7;
JTextField t1,t4,t5,t6,t7;
JPasswordField t2,t3;
JRadioButton R, check,s;JButton done,back;
JPanel pan;Account d;
    public AccountDetail(){setTitle("\t\t\t\t\t\tAccount Details");
d=new Account();d.setVisible(false);



    count=0;
        setBounds(350,50,750,500);
        setBackground(Color.white);setFont(new Font("Raleway",Font.BOLD,20));
        pan=new JPanel();pan.setBounds(80,30,700,400);pan.setBackground(Color.white);pan.setLayout(null);add(pan);
        l1=new JLabel("ACCOUNT DETAILS");l1.setFont(new Font("Raleway",Font.BOLD,20));l1.setBounds(280, 0, 300, 100);
        pan.add(l1);

        l2=new JLabel("Initial Deposit");l2.setFont(new Font("Times new Roman",Font.BOLD,15));l2.setBounds(10, 70, 100, 100);
       pan.add(l2);t1=new JTextField();t1.setBounds(150,110,170,20);pan.add(t1);
        t4=new JTextField();t4.setBounds(500,110,170,20);pan.add(t4);
        t5=new JTextField();t5.setBounds(500,190,170,20);pan.add(t5);
        l3=new JLabel("Account password");l3.setFont(new Font("Times new Roman",Font.BOLD,15));l3.setBounds(10, 150, 150, 100);
        pan.add(l3);t2=new JPasswordField();t2.setBounds(150,190,170,20);pan.add(t2);
        l4=new JLabel("Confirm password");l4.setFont(new Font("Times new Roman",Font.BOLD,15));l4.setBounds(10, 230, 150, 100);
        pan.add(l4);t3=new JPasswordField();t3.setBounds(150,270,170,20);pan.add(t3);
        l5=new JLabel("Account type");l5.setFont(new Font("Times new Roman",Font.BOLD,15));l5.setBounds(10, 300, 100, 100);
        pan.add(l5);s=new JRadioButton("Saving");s.setBounds(10,370,100,20);pan.add(s);s.setBackground(Color.white);R=new JRadioButton("Retirement");R.setBounds(110,370,100,20);pan.add(R);R.setBackground(Color.white);
        check =new JRadioButton("Check Account");
        check.setBounds(210,370,150,20);pan.add(check);
        check.setBackground(Color.white);
        l6=new JLabel("Branch ID");l6.setFont(new Font("Times new Roman",Font.BOLD,15));l6.setBounds(400, 70, 100, 100);
        pan.add(l6);
        l7=new JLabel("Customer ID  " );l7.setFont(new Font("Times new Roman",Font.BOLD,15));l7.setBounds(400, 150, 400, 100);
        pan.add(l7);
        done=new JButton("Done");back=new JButton("Back");back.setBackground(Color.black);back.setForeground(Color.WHITE);
        back.setBounds(370, 400, 100, 40);
        pan.add(back);
        done.setBackground(Color.black);done.setForeground(Color.WHITE);
        done.setBounds(540, 400, 100, 40);
        pan.add(done);done.addActionListener(this);back.addActionListener(this);
ButtonGroup group=new ButtonGroup();group.add(R);group.add(s);group.add(check);
         setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
String query;

        Conn c=new Conn();
        CallableStatement st=null;
        ResultSet rs;
String q;
        String password, Balance, password2,Branch_id,cus_id;
        Balance=t1.getText();
        password = t2.getText();
        password2 = t3.getText();
        Branch_id=t4.getText();
        cus_id=t5.getText();
        String Acc_type;
        Statement sta;
        if (password.equals(password2)) {


            if (e.getSource() == back) {
                setVisible(false);
                a = new Account();

            }
            if (e.getSource() == done) {


            if (s.isSelected()) {
                Acc_type="saving";

                try {

                    st= c.con2.prepareCall("{call GACC(?,?,?,?,?)}");
                    st.setString(1,password);
                    st.setString(2,Balance);
                    st.setString(3,Branch_id);
                    st.setString(4, cus_id);
                    st.setString(5,Acc_type);
                    st.execute();
          sta=c.con2.createStatement();
          JOptionPane.showMessageDialog(null, "Account created");
                    q="select Acc_id,customer_id from Acc where Acc_id=(select max(Acc_id) from Acc)";
                    rs=sta.executeQuery(q);
int owner;
int Assigned; String msg;
while(rs.next()) {
 Assigned = rs.getInt("Acc_id");
 owner=rs.getInt("customer_id");
    System.out.println(Assigned);
    System.out.println(owner);
     msg="Assigned Account ID is :"+Assigned;
        q="select c_name,c_id from customer where c_id= '"+owner+"' ";
    System.out.println(owner);
    rs=sta.executeQuery(q);
    while(rs.next()){
       String  bnda=rs.getString("c_name");

        msg="Assigned Account ID is :"+Assigned+"\nTo MR/MS :  "+bnda;
        JOptionPane.showMessageDialog(null,msg);
        setVisible(false);
        new Menu();
    }
}





                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null,e1);
                }

            }
                if (R.isSelected()) {

                    Acc_type="Retirement";

                    try {

                        st= c.con2.prepareCall("{call GACC(?,?,?,?,?)}");
                        st.setString(1,password);
                        st.setString(2,Balance);
                        st.setString(3,Branch_id);
                        st.setString(4, cus_id);
                        st.setString(5,Acc_type);
                        st.execute();
                        sta=c.con2.createStatement();
                        JOptionPane.showMessageDialog(null, "Account created");
                        q="select Acc_id,customer_id from Acc where Acc_id=(select max(Acc_id) from Acc)";
                        rs=sta.executeQuery(q);
                        int owner;
                        int Assigned; String msg;
                        while(rs.next()) {
                            Assigned = rs.getInt("Acc_id");
                            owner=rs.getInt("customer_id");

                            msg="Assigned Account ID is :"+Assigned;
                            q="select c_name,c_id from customer where c_id= '"+owner+"' ";
                            System.out.println(owner);
                            rs=sta.executeQuery(q);
                            while(rs.next()){
                                String  bnda=rs.getString("c_name");

                                msg="Assigned Account ID is :"+Assigned+"\nTo MR/MS :  "+bnda;
                                JOptionPane.showMessageDialog(null,msg);
                                setVisible(false);
                                new Menu();
                            }

                        }




                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null,e1);
                    }

                }
                    if (check.isSelected()) {
                        Acc_type="Check";
                        System.out.println("check k andr");
                        try {

                            st= c.con2.prepareCall("{call GACC(?,?,?,?,?)}");
                            st.setString(1,password);
                            st.setString(2,Balance);
                            st.setString(3,Branch_id);
                            st.setString(4, cus_id);
                            st.setString(5,Acc_type);
                            st.execute();
                            sta=c.con2.createStatement();
                            JOptionPane.showMessageDialog(null, "Account created");
                            q="select Acc_id,customer_id from Acc where Acc_id=(select max(Acc_id) from Acc)";
                            rs=sta.executeQuery(q);
                            int owner;
                            int Assigned; String msg;
                            while(rs.next()) {
                                Assigned = rs.getInt("Acc_id");
                                owner=rs.getInt("customer_id");

                                msg="Assigned Account ID is :"+Assigned;
                                q="select c_name,c_id from customer where c_id= '"+owner+"' ";
                                System.out.println(owner);
                                rs=sta.executeQuery(q);
                                while(rs.next()){
                                    String  bnda=rs.getString("c_name");

                                    msg="Assigned Account ID is :"+Assigned+"\nTo MR/MS :  "+bnda;
                                    JOptionPane.showMessageDialog(null,msg);
                                    setVisible(false);
                                    new Menu();
                                }
                            }


                        } catch (SQLException e1) {
                            JOptionPane.showMessageDialog(null,e1);
                        }

                    }}

        }
        else{
            JOptionPane.showMessageDialog(null,"password confirmation failed !! ");

        }



    }

    public Account getA() {
        return a;
    }

    public static void main(String[] args) {
        AccountDetail g=new AccountDetail();
    }

}
