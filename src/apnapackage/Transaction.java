package apnapackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame  implements ActionListener {
    JLabel top;
    JButton b1,b2,b3,b4,b5,b6,b7;
    JPanel pan;
    public Transaction(){
        setLayout(null);setBounds(200,20,700,700);setBackground(Color.black);
        pan=new JPanel();pan.setLayout(null);pan.setBounds(30,30,600,600);pan.setBackground(Color.lightGray);add(pan);
        setFont(new Font("System",Font.BOLD,22));
        top=new JLabel("                    Please Select Your Choice ");top.setFont(new Font("System",Font.BOLD,20));pan.add(top);top.setBounds(50,40,400,100);
        b1=new JButton("Deposit");b1.setBackground(Color.black);b1.setForeground(Color.white);b1.setBounds(40,150,200,50);pan.add(b1);b1.setFont(new Font("System",Font.BOLD,14));
        b2=new JButton("Withdrawl");b2.setBackground(Color.black);b2.setForeground(Color.white);b2.setBounds(350,150,200,50);pan.add(b2);b2.setFont(new Font("System",Font.BOLD,14));
        b3=new JButton("Pay Bill");b3.setBackground(Color.black);b3.setForeground(Color.white);b3.setBounds(40,250,200,50);pan.add(b3);b3.setFont(new Font("System",Font.BOLD,14));
        b4=new JButton("Business");b4.setBackground(Color.black);b4.setForeground(Color.white);b4.setBounds(350,250,200,50);pan.add(b4);b4.setFont(new Font("System",Font.BOLD,14));
        b5=new JButton("Change Pin");b5.setBackground(Color.black);b5.setForeground(Color.white);b5.setBounds(40,350,200,50);pan.add(b5);b5.setFont(new Font("System",Font.BOLD,14));
        b6=new JButton("Bal Enquiry");b6.setBackground(Color.black);b6.setForeground(Color.white);b6.setBounds(350,350,200,50);pan.add(b6);b6.setFont(new Font("System",Font.BOLD,14));
        b7=new JButton("Exit");b7.setBackground(Color.black);b7.setForeground(Color.white);b7.setBounds(200,450,200,50);pan.add(b7);b7.setFont(new Font("System",Font.BOLD,14));
b1.addActionListener(this);b2.addActionListener(this);b3.addActionListener(this);b4.addActionListener(this);b5.addActionListener(this);b6.addActionListener(this);b7.addActionListener(this);

        setVisible(true);
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==b1){
    Deposit d=new Deposit();

}
if(e.getSource()==b2){

    Withdraw w=new Withdraw();}
if(e.getSource()==b3){PayBill pb=new PayBill();}
if(e.getSource()==b4){Buisness b=new Buisness();}
if(e.getSource()==b5){
new PinChange();
}
if(e.getSource()==b6){
    new BAL_CHECK();

}
if(e.getSource()==b7){
    setVisible(false);
    new Menu();

}
        }


    public static void main(String[] args) {
        Transaction t=new Transaction();
    }


}
