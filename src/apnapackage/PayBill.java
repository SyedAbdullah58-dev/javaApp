package apnapackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class PayBill extends JFrame implements ActionListener {
    JTextField Sender;
    JTextField Bill_NO;
    JTextField Balance;
    JButton b1, b2, b3;
    JPanel pan;
    JLabel top, from, to, Amount;

    String label;
    JComboBox category;

    public PayBill() {
        category = new JComboBox();
        category.addItem("PTCL");
        category.addItem("SUI_GAS");
        category.addItem("WAPDA");
        category.setBounds(500, 80, 100, 30);


        setLayout(null);
        setBounds(200, 20, 700, 700);
        setBackground(Color.black);
        pan = new JPanel();
        pan.setLayout(null);
        pan.setBounds(30, 30, 600, 600);
        pan.setBackground(Color.lightGray);
        add(pan);
        pan.add(category);
        Amount = new JLabel("Amount");
        Amount.setBounds(80, 260, 90, 60);
        pan.add(Amount);
        setFont(new Font("System", Font.BOLD, 22));
        top = new JLabel("                                      PAY BILL ");
        top.setFont(new Font("System", Font.BOLD, 20));
        pan.add(top);
        top.setBounds(50, 40, 400, 100);
        b1 = new JButton("Send");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(200, 450, 100, 30);
        pan.add(b1);
        b1.setFont(new Font("System", Font.BOLD, 14));
        b2 = new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(320, 450, 100, 30);
        pan.add(b2);
        b2.setFont(new Font("System", Font.BOLD, 14));
        b3 = new JButton("Exit");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(260, 500, 100, 30);
        pan.add(b3);
        b3.setFont(new Font("System", Font.BOLD, 14));
        Sender = new JTextField();
        Sender.setBounds(200, 200, 230, 30);
        pan.add(Sender);
        Balance = new JTextField();
        Balance.setBounds(200, 280, 230, 30);
        pan.add(Balance);
        Bill_NO = new JTextField();
        Bill_NO.setBounds(200, 380, 230, 30);
        pan.add(Bill_NO);
        from = new JLabel("  ACC ID");
        from.setBounds(80, 185, 90, 60);
        pan.add(from);
        from.setFont(new Font("System", Font.BOLD, 16));
        Amount.setFont(new Font("System", Font.BOLD, 16));
        to = new JLabel("    BILL NO");
        to.setBounds(60, 365, 120, 60);
        pan.add(to);
        to.setFont(new Font("System", Font.BOLD, 16));
        setVisible(true);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String code=null;
        Conn c=new Conn();
        CallableStatement st;
        if (e.getSource() == b3) {
            setVisible(false);
        }

        if (e.getSource() == b1) {
if(category.getSelectedItem().equals("PTCL")){
    code="1133";
}
if(category.getSelectedItem().equals("WAPDA")){code="2222";}
if(category.getSelectedItem().equals("SUI_GAS")){code="4411";}


            if (!Sender.getText().equals("") && !Balance.getText().equals("") && !Bill_NO.getText().equals("")) {

                try {
                    st=c.con2.prepareCall("{call BILL_PROC(?,?,?,?)}");
                    st.setString(1,Bill_NO.getText());
                    st.setString(2,code);
                    st.setString(3,Balance.getText());
                    st.setString(4,Sender.getText());
                    st.execute();
                    String ms="Bill No : "+Bill_NO.getText()+" is payed now";
                    JOptionPane.showMessageDialog(null,ms);
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null,e1);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Fill up the fields");
            }

        }
        if(e.getSource()==b2){

            Sender.setText("") ;
            Balance.setText("");Bill_NO.setText("");

        }

    }



    public static void main(String[] args) {
        PayBill b=new PayBill();
    }

}
