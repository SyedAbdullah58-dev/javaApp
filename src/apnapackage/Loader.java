package apnapackage;

import javax.swing.*;
import java.awt.*;

public class Loader  extends JFrame implements  Runnable {

    JProgressBar jb;

    public Loader() {

        jb = new JProgressBar(0, 2000);jb.setBackground(Color.orange);setTitle("Loading...");
        jb.setBounds(200, 100, 160, 30);
        jb.setValue(0);jb.setString("LOADING...");jb.setFont(new Font("Arial",Font.BOLD,20));
        jb.setStringPainted(true);setFont(new Font("Arial",Font.BOLD,20));
setBounds(200,200,500,100);
        add(jb);jb.setForeground(Color.green);
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

setVisible(true);
        setLayout(null);
    }

    public void iterate() {
        int i = 0;
        while (i <= 2000) {
            jb.setValue(i);
            i = i + 20;
            try {
                Thread.sleep(150);
            } catch (Exception e) {
            }
        }
        setVisible(false);
    }

    @Override
    public void run() {
        iterate();
    }



}