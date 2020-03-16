package apnapackage;
import org.omg.CORBA.INTERNAL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Menu extends JFrame implements ActionListener {
    JLabel cus;
    JButton create ,delete,search,transacation,update;
    Account g;
    Color c= new Color(71, 154, 156);
    Color c0=new Color(41,175,121);
    public Menu(){

        setBounds(40,40,700,700);
        setLayout(null);
        JPanel pan=new JPanel();
       cus=new JLabel("  Customer Accounts");cus.setFont(new Font("Arial Black",Font.BOLD,16)); cus.setBounds(210,0,250,100);pan.add(cus);
        pan.setBounds(40,40,600,600);pan.setLayout(null);
        create=new JButton("Create");create.setFont(new Font("Times new Roman",Font.BOLD,20));
        pan.add(create);create.addActionListener(this);create.setBounds(225,100,200,50);
        delete=new JButton("Delete");delete.setFont(new Font("Times new Roman",Font.BOLD,20));
       pan.add(delete);delete.addActionListener(this);delete.setBounds(225,200,200,50);
        search=new JButton("Search");search.setFont(new Font("Times new Roman",Font.BOLD,20));
        pan.add(search);search.addActionListener(this);search.setBounds(225,300,200,50);
        update=new JButton("update");update.setFont(new Font("Times new Roman",Font.BOLD,20));
        transacation=new JButton("Transaction");transacation.setBounds(225,400,200,50);transacation.addActionListener(this);
        //pan.add(update);update.addActionListener(this);update.setBounds(225,400,200,50);
pan.add(transacation);
        create.setBackground(c0);
        delete.setBackground(c0);
        search.setBackground(c0);
        update.setBackground(c0);
        transacation.setBackground(c0);


        setBackground(Color.white);add(pan,BorderLayout.WEST);pan.setBackground(c);
      transacation.setFont(new Font("Times new Roman",Font.BOLD,20));
        pan.add(transacation);transacation.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==create){

             g=new Account();}
 if(e.getSource()==transacation){

Validator v=new Validator();

            }
if(e.getSource()==search){
    setVisible(false);
    new Search();}
if(e.getSource()==delete){setVisible(false);new Delete();}
    }

    public static void main(String[] args) {
        new Menu();
    }
    }




class create extends JFrame{
    JLabel welcome;
    public create(){
        setBounds(40,40,600,600);
    setBackground(Color.gray);
    welcome=new JLabel("Welcome sir");
    welcome.setFont(new Font("Raleway",Font.CENTER_BASELINE,34));
        setVisible(true);
    }
}
class Search extends JFrame implements ActionListener{
    JPanel pan;
    JLabel enter;
    JTextField tf,acc_type,Bal,date,password;

    JButton search,back;
    public Search(){
        Color c1= new Color(170, 169, 158);
        Color c2=new Color(30, 30, 30);
        setLayout(null);
        setBounds(40,40,1100,500);
        JLabel l1=new JLabel("Account Type");
        l1.setBounds(500,100,100,25);
        acc_type=new JTextField();acc_type.setBounds(600,100,200,25);
        JLabel l2=new JLabel("Balance");
        l2.setBounds(500,160,100,25);
        Bal=new JTextField();Bal.setBounds(600,160,200,25);
        JLabel l3=new JLabel("Customer ID");
        l3.setBounds(500,230,100,25);
        date=new JTextField();date.setBounds(600,230,200,25);
        password=new JTextField();password.setBounds(300,250,200,30);
        pan=new JPanel();pan.setLayout(null);pan.setBackground(c1);pan.setBounds(40,40,1000,400);
        enter=new JLabel("Enter Accont ID");enter.setBounds(80,80,200,30);enter.setFont(new Font("Raleway",Font.BOLD,16));pan.add(enter);
        tf=new JTextField();tf.setBounds(80,140,200,30);pan.add(tf);pan.add(acc_type);pan.add(l1);pan.add(l2);pan.add(Bal);
        pan.add(l3);
        pan.add(date);
       search=new JButton("Search"); search.setBounds(80,200,100,25);search.setFont(new Font("Raleway",Font.BOLD,16));search.setBackground(Color.black);search.setForeground(Color.white);pan.add(search);
        back=new JButton("back"); back.setBounds(0,0,100,25);back.setFont(new Font("Raleway",Font.BOLD,16));back.setBackground(Color.black);back.setForeground(Color.white);pan.add(back);
        add(pan);
        search.setBackground(c2);
        setVisible(true); back.addActionListener(this);search.setVisible(true);
search.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Conn c=new Conn();


        if(e.getSource()==search){
            try {
                PreparedStatement pst=c.con2.prepareStatement("select Balance,Acc_type,customer_id from Acc where Acc_id=? ");
                pst.setInt(1,Integer.parseInt(tf.getText()));
                ResultSet rs=pst.executeQuery();
                rs.next();
                String n1=rs.getString(2);
                String n2=rs.getString(1);
                String n3=rs.getString(3);

acc_type.setText(n1);
Bal.setText(n2);
date.setText(n3);
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null,e1);
            }


        }

        if(e.getSource()==back){setVisible(false);
        new Menu().setVisible(true);
        }
    }
}

class Delete extends JFrame implements ActionListener{
    JPanel pan;
    JLabel delete;
    JTextField tf;
    JButton Delete,back;
    public Delete(){
        Color cc1= new Color(232, 227, 206);
        Color cc2=new Color(41,175,121);
        setLayout(null);
        setBounds(40,40,500,500);
        back=new JButton();
        pan=new JPanel();pan.setLayout(null);pan.setBackground(Color.white);pan.setBounds(40,40,400,400);add(pan);
        delete=new JLabel("Accont ID to delete");delete.setBounds(110,80,200,30);delete.setFont(new Font("Raleway",Font.BOLD,16));pan.add(delete);
        tf=new JTextField();tf.setBounds(80,140,200,30);pan.add(tf);
        Delete =new JButton("Delete"); Delete.setBounds(120,200,100,25);
        Delete.setFont(new Font("Raleway",Font.BOLD,16));
        Delete.setBackground(Color.black);
        Delete.setForeground(Color.white);pan.add(Delete);
        setVisible(true);
        delete.setBackground(cc2);
        back.setBackground(cc2);
        Delete.addActionListener(this);
        back=new JButton("back"); back.setBounds(0,0,100,25);back.setFont(new Font("Raleway",Font.BOLD,16));back.setBackground(Color.black);back.setForeground(Color.white);pan.add(back);
    back.addActionListener(this);
    setVisible(true);
    pan.setBackground(cc1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String q;Conn c=new Conn();
        ResultSet rs;
        CallableStatement cl;
        if(e.getSource()== Delete) {
            if (tf.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the Account ID");

                tf.setBackground(Color.white);

            } else {
                int VAR= Integer.parseInt(tf.getText());

                try {
                    tf.setBackground(Color.WHITE);
                    cl=c.con2.prepareCall("{call ACC_DEL(?)}");
                    cl.setInt(1,VAR);
                    cl.execute();

                    String msg="Account no :"+VAR+"deleted ";
                    JOptionPane.showMessageDialog(null, msg);
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null,e1);
                }


                tf.setText(""); }
        }if(e.getSource()==back){
                setVisible(false);
                new Menu().setVisible(true);
            }

        }
    }
