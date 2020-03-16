package apnapackage;

import javafx.scene.layout.GridPane;
import sun.security.util.Password;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class Login extends JFrame implements ActionListener {
    JLabel l1, l2, l3;
    JTextField tf;
    JPasswordField pass;
    JButton log, Cancel;
    JFrame fraam;
    JLabel state;
JComboBox category;

    Login() {
        setFont(new Font("System", Font.BOLD, 23));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("WELCOME TO SYED BANK");
category=new JComboBox();
category.addItem("Manager");
category.addItem("Supervisor");
category.addItem("Staff");
category.setBounds(400,350,100,30);
        fraam = new JFrame();
        int y = fm.stringWidth(" ");
        int z = getWidth() - x;
        int w = z / y;
        String pad = "";
        pad = String.format("%" + w + "s", pad);
        String.format(pad, BOTTOM_ALIGNMENT);
        fraam.setTitle(pad + "               \t\tWELOCME TO Bank");
       // l1 = new JLabel("WELCOME TO BANK");
       // l1.setFont(new Font("Osward", Font.BOLD, 20));
        l2 = new JLabel("EMP ID");
        l2.setFont(new Font("Raleway", Font.BOLD, 14));
        l3 = new JLabel("Password");
        l3.setFont(new Font("Raleway", Font.BOLD, 14));
        tf = new JTextField();
        pass = new JPasswordField();
        ImageIcon im=new ImageIcon("E:\\statebank.png");
state=new JLabel(im);state.setBounds(20,0,500,200);
fraam.add(state);

fraam.add(category);
        log = new JButton("login");
        log.setForeground(Color.black);
        Cancel = new JButton("Cancel");
        Cancel.setForeground(Color.BLACK);
        Cancel.setBounds(280,400,80,30);
        fraam.setLayout(null);
        fraam.setBounds(150,40,560,500);
      //  l1.setBounds(175, 50, 450, 200);
        //fraam.add(l1);

        l2.setBounds(80, 200, 200, 200);
        l3.setBounds(80, 260, 200, 200);
        fraam.add(l3);
        tf.setBounds(160, 290, 200, 20);
        pass.setBounds(160, 355, 200, 20);
        fraam.add(pass);
        fraam.add(tf);
        log.setBounds(160, 400, 80, 30);
        fraam.add(log);fraam.add(Cancel);

        log.addActionListener(this);Cancel.addActionListener(this);
        fraam.setVisible(true);
        fraam.add(l2);
        fraam.getContentPane().setBackground(Color.LIGHT_GRAY);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
String note=null;
        if(e.getSource()==log) {
            int flag=0;
            try {
                Conn c=new Conn();
                Statement st=c.con2.createStatement();ResultSet rs=null;
                if(category.getSelectedItem().equals("Manager")) {
                     rs = st.executeQuery("select E_id,E_password from Manager");
                     note="Manager";
                }
                 if(category.getSelectedItem().equals("Supervisor")){
                    rs = st.executeQuery("select E_id,E_password from Supervisor");
                    note="Supervisor";
                }
                if(category.getSelectedItem().equals("Staff")){
                    rs = st.executeQuery("select E_id,E_password from staff");
                    note="Staff";
                }

                while (rs.next())
                    {
                        if(tf.getText().equals(rs.getString(1))&&(pass.getText().equals(rs.getString(2))))
                        {
                            String text="Validation Successful"+"\n Welcome "+note;
                            JOptionPane.showMessageDialog(null,text
                            );
                            flag=1;
                            setVisible(false);

                            setVisible(false);
                            Menu b = new Menu();
                            Loader n = new Loader();
                            Thread dd = new Thread(n);
                            dd.start();


                            ;
                        }
                    }
                    if (flag==0) {
                        JOptionPane.showMessageDialog(null, "ID or Password not correct");
                        tf.setText("");
                        pass.setText("");
                        //con=false; }
                    }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
if(e.getSource()==Cancel){
    setVisible(false);
    new Main();

}


        }

    public static void main(String[] args) {
        Login l=new Login();

    }
    }



