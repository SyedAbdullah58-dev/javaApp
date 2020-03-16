package apnapackage;

import jdk.nashorn.internal.codegen.CompilerConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class Withdraw extends JFrame implements ActionListener {

    JLabel top,ID,AMOUNT;
    JButton b1,b2,b3;
    JPanel pan;
    JTextField d1,id;
    public Withdraw(){

        setLayout(null);setBounds(200,20,700,700);setBackground(Color.black);
        pan=new JPanel();pan.setLayout(null);pan.setBounds(30,30,600,600);pan.setBackground(Color.white);add(pan);
        setFont(new Font("System",Font.BOLD,22));
        top=new JLabel("                     Enter Amount to Withdraw ");top.setFont(new Font("System",Font.BOLD,20));pan.add(top);top.setBounds(50,60,400,100);

        b1=new JButton("Draw");b1.setBackground(Color.black);b1.setForeground(Color.white);b1.setBounds(180,370,100,30);pan.add(b1);b1.setFont(new Font("System",Font.BOLD,14));
        b2=new JButton("Cancel");b2.setBackground(Color.black);b2.setForeground(Color.white);b2.setBounds(300,370,100,30);pan.add(b2);b2.setFont(new Font("System",Font.BOLD,14));
        b3=new JButton("Exit");b3.setBackground(Color.black);b3.setForeground(Color.white);b3.setBounds(240,440,100,30);pan.add(b3);b3.setFont(new Font("System",Font.BOLD,14));
        d1=new JTextField();d1.setBounds(180,200,230,50);pan.add(d1);
        id=new JTextField();id.setBounds(180,280,230,50);pan.add(id);
ID=new JLabel("Accout ID");ID.setFont(new Font("System",Font.BOLD,16));ID.setBounds(60,170,200,100);pan.add(ID);
        AMOUNT=new JLabel("Amount");AMOUNT.setFont(new Font("System",Font.BOLD,16));AMOUNT.setBounds(70,260,200,100);pan.add(AMOUNT);
        b1.addActionListener(this); b3.addActionListener(this); b2.addActionListener(this);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String ac=d1.getText();
        String am=id.getText();
        Conn c=new Conn();
        CallableStatement st=null;

        if(e.getSource()==b1){
            if(!d1.getText().equals("")     &&! id.getText().equals("")){
                try {
                    st=c.con2.prepareCall("{call WITHD_TRAN(?,?)}");
                    st.setString(1,am);
                    st.setString(2,ac);

                    st.execute();
                    JOptionPane.showMessageDialog(null,"Withdraw successful");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        if(e.getSource()==b2){
            d1.setText("");id.setText("");
        }
        if(e.getSource()==b3){
            setVisible(false);

        }


    }

    public static void main(String[] args) {
        Withdraw b=new Withdraw();
    }



}
