package apnapackage;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PinChange extends JFrame implements ActionListener {


    JTextField Accoun_ID;
    JTextField newpin;
    JTextField Old;
    JButton b1, b2, b3;
    JPanel pan;
    JLabel top, from, to , Amount;

    String label;

    public PinChange() {


        setLayout(null);
        setBounds(200, 20, 700, 700);
        setBackground(Color.black);
        pan = new JPanel();
        pan.setLayout(null);
        pan.setBounds(30, 30, 600, 600);
        pan.setBackground(Color.lightGray);
        add(pan);
        Amount=new JLabel("Old Pin");Amount.setBounds(80, 260, 90, 60);pan.add(Amount);
        setFont(new Font("System", Font.BOLD, 22));
        top = new JLabel("                               Change PIN ");
        top.setFont(new Font("System", Font.BOLD, 20));
        pan.add(top);
        top.setBounds(50, 40, 400, 100);
        b1 = new JButton("Change");
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
        Accoun_ID = new JTextField();
        Accoun_ID.setBounds(200, 200, 230, 30);
        pan.add(Accoun_ID);
        Old = new JTextField();
        Old.setBounds(200, 280, 230, 30);
        pan.add(Old);
        newpin = new JTextField();
        newpin.setBounds(200, 380, 230, 30);
        pan.add(newpin);
        from = new JLabel("  ID");
        from.setBounds(80, 185, 90, 60);
        pan.add(from);
        from.setFont(new Font("System", Font.BOLD, 16));
        Amount.setFont(new Font("System", Font.BOLD, 16));
        to = new JLabel("  New Pin   ");
        to.setBounds(60, 365, 120, 60);
        pan.add(to);
        to.setFont(new Font("System", Font.BOLD, 16));
        setVisible(true);b1.addActionListener(this);b2.addActionListener(this);b3.addActionListener(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String old= Old.getText();
        String acc=Accoun_ID.getText();
        String newpas= newpin.getText();

        Conn c=new Conn();
      ;
        CallableStatement st;

        if(e.getSource()==b2){
            Accoun_ID.setText("");
            newpin.setText("");

        }
        if(e.getSource()==b1){
            if(!Accoun_ID.getText().equals("")&&!newpin.getText().equals("")&&!Old.getText().equals("")){
                try {
                    st=c.con2.prepareCall("{call PINCHANGE(?,?,?)}");
                    st.setString(1,acc);
                    st.setString(2,old);
                    st.setString(3,newpas);
                    st.execute();
                    JOptionPane.showMessageDialog(null,"Pin Changed");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }


            }
            else {
                JOptionPane.showMessageDialog(null,"Fill all fields");
            }

        }

        if(e.getSource()==b3){
            setVisible(false);

        }
    }


    public static void main(String[] args) {
        PinChange p=new PinChange();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}

