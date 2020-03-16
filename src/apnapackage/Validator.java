package apnapackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Validator extends JFrame  implements ActionListener {
    JTextField AccountID;
    JPasswordField t2;
    JButton b1,b2,b3;
    JPanel pan;boolean con;
    JLabel top,id,pass;
    public Validator(){
        setLayout(null);setBounds(200,20,700,700);setBackground(Color.black);
        pan=new JPanel();pan.setLayout(null);pan.setBounds(30,30,600,600);pan.setBackground(Color.lightGray);add(pan);
        setFont(new Font("System",Font.BOLD,22));
        top=new JLabel("                            Account Information ");top.setFont(new Font("System",Font.BOLD,20));pan.add(top);top.setBounds(50,40,400,100);
        b1=new JButton("submit");b1.setBackground(Color.black);b1.setForeground(Color.white);b1.setBounds(200,350,100,30);pan.add(b1);b1.setFont(new Font("System",Font.BOLD,14));
        b2=new JButton("Cancel");b2.setBackground(Color.black);b2.setForeground(Color.white);b2.setBounds(320,350,100,30);pan.add(b2);b2.setFont(new Font("System",Font.BOLD,14));
        b3=new JButton("Exit");b3.setBackground(Color.black);b3.setForeground(Color.white);b3.setBounds(260,420,100,30);pan.add(b3);b3.setFont(new Font("System",Font.BOLD,14));
AccountID =new JTextField();
        AccountID.setBounds(200,200,230,30);pan.add(AccountID);
        t2=new JPasswordField();t2.setBounds(200,300,230,30);pan.add(t2);
        id=new JLabel("Account ID");id.setBounds(80,185,90,60);pan.add(id);id.setFont(new Font("System",Font.BOLD,16));
        pass=new JLabel("PIN/Password");pass.setBounds(60,285,120,60);pan.add(pass);pass.setFont(new Font("System",Font.BOLD,16));
        setVisible(true);
        b1.addActionListener(this);b2.addActionListener(this);b3.addActionListener(this);
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



    }
    public boolean confirm(boolean bawa) {
     return  bawa;

         }


    @Override
    public void actionPerformed(ActionEvent e)  {
int flag=0;
        try {
            Conn c=new Conn();
            Statement st=c.con2.createStatement();
            ResultSet rs= st.executeQuery("select Acc_id,Acc_password from Acc");
            if(e.getSource()==b1){

                while (rs.next())
                {
                    if(AccountID.getText().equals(rs.getString(1))&&(t2.getText().equals(rs.getString(2))))
                    {
                        JOptionPane.showMessageDialog(null,"Vallidation Successful");
                        flag=1;
                        setVisible(false);
                        new Transaction();
                    }
                }
           if (flag==0){
                    JOptionPane.showMessageDialog(null,"ID or Password not correct");
                    AccountID.setText("");
                    t2.setText("");
                    con=false; }
            }


        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        if(e.getSource()==b2){
            AccountID.setText("");
            t2.setText("");

        }

        if(e.getSource()==b3){
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        Validator v=new Validator();
    }


}
