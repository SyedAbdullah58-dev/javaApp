package apnapackage;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class Deposit extends JFrame implements ActionListener {
    JLabel top, ID, AMOUNT;
    JButton b1, b2, b3;
    JPanel pan;
    Double  Amount;
    JTextField AccountField, AmountField;
    String AccountNO;

    static double Balance = 1000;

    public Deposit() {

        setLayout(null);
        setBounds(200, 20, 700, 700);
        setBackground(Color.black);
        pan = new JPanel();
        pan.setLayout(null);
        pan.setBounds(30, 30, 600, 600);
        pan.setBackground(Color.white);
        add(pan);
        setFont(new Font("System", Font.BOLD, 22));
        top = new JLabel("                      Enter Amount to Deposit ");
        top.setFont(new Font("System", Font.BOLD, 20));
        pan.add(top);
        top.setBounds(50, 60, 400, 100);

        b1 = new JButton("Deposit");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(180, 370, 100, 30);
        pan.add(b1);
        b1.setFont(new Font("System", Font.BOLD, 14));
        b2 = new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(300, 370, 100, 30);
        pan.add(b2);
        b2.setFont(new Font("System", Font.BOLD, 14));
        b3 = new JButton("Exit");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(240, 440, 100, 30);
        pan.add(b3);
        b3.setFont(new Font("System", Font.BOLD, 14));
        AccountField = new JTextField();
        AccountField.setBounds(180, 200, 230, 50);
        pan.add(AccountField);
        AmountField = new JTextField();
        AmountField.setBounds(180, 280, 230, 50);
        pan.add(AmountField);
        ID = new JLabel("Accout ID");
        ID.setFont(new Font("System", Font.BOLD, 16));
        ID.setBounds(60, 170, 200, 100);
        pan.add(ID);
        AMOUNT = new JLabel("Amount");
        AMOUNT.setFont(new Font("System", Font.BOLD, 16));
        AMOUNT.setBounds(70, 260, 200, 100);
        pan.add(AMOUNT);
        b1.addActionListener(this);
        b3.addActionListener(this);
        b2.addActionListener(this);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        AccountNO = AccountField.getText();
        Amount = Double.parseDouble(AmountField.getText());
        if (AccountNO.equals("") || Amount.equals(null)) {

            ExceptionCase();

        }

        if (e.getSource() == b1) {
            System.out.println("Button pressed");
            if (AccountNO.equals("1144")) {
                DepositDone();
            }
            else {
                JOptionPane.showMessageDialog(new Frame(),"ID not valid");
            }
        }



        if (e.getSource() == b1) {

            if (e.getSource() == b2) {
                AccountField.setText("");
                AmountField.setText("");
            }
            if (e.getSource() == b3) {
                setVisible(false);

            }

        }
        }
        public boolean DepositDone () {


            Balance = Balance + Amount;
            System.out.println("New Amount : " + Balance);
            JOptionPane.showMessageDialog(new Frame(),"Deposit Done \n Current Balance : "+Balance);
            return true;

        }

        private void ExceptionCase () {
            throw new NullPointerException();
        }

        public static void main (String[]args){

            {
                Result result = JUnitCore.runClasses(DepositTest.class);
                for (Failure failure : result.getFailures()) {
                    System.out.println(failure.toString());
                }
                System.out.println(result.wasSuccessful());
            }


        }
public void Database(){
    Conn c = new Conn();
    CallableStatement st = null;

    if(!AccountField.getText().equals("")     &&! AmountField.getText().equals("")){
        try {
            st=c.con2.prepareCall("{call DEP_TRAN(?,?)}");
            st.setDouble(1, Amount);
            st.setString(2, AccountNO);

            st.execute();
            JOptionPane.showMessageDialog(null,"Deposit successful");
        } catch (SQLException e1) {
            System.out.println(e1.toString());
        }
    }
}

}


