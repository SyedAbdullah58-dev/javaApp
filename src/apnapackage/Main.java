package apnapackage;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import javax.swing.plaf.FileChooserUI;
import javax.swing.plaf.basic.BasicFileChooserUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main extends JFrame implements ActionListener {
    private JComboBox B;
    private JButton bt,sign_in,sign_up;
    private JLabel welcome;
    private JLabel cateogry;
    private JProgressBar pb;

    public Main() {
        Color cc1= new Color(156,132,33);
        Color cc2=new Color(115, 112, 223);
        setLayout(new BorderLayout());
        ImageIcon im = new ImageIcon("E:\\Imp data\\BMSF\\bank_management.jpg");
        JLabel hevy = new JLabel(im);
        hevy.setBounds(100, 0, 720, 200);
        add(hevy);
        setBounds(90, 40, 1000, 500);
        sign_up=new JButton("SIGN UP");sign_up.setBounds(200,340,120,50);add(sign_up,BorderLayout.CENTER);sign_up.setForeground(Color.black);sign_up.setFont(new Font("Times New Roman",Font.BOLD,14));
        sign_in=new JButton("SIGN IN");sign_in.setBounds(400,340,120,50);add(sign_in,BorderLayout.CENTER);sign_in.setForeground(Color.black);sign_in.setFont(new Font("Times New Roman",Font.BOLD,14));

        sign_up.setBackground(cc2);
        sign_in.setBackground(cc2);
        sign_up.addActionListener(this);
sign_in.addActionListener(this);



        getContentPane().setBackground(Color.LIGHT_GRAY);

        setLayout(new BorderLayout());
        setVisible(true);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sign_in) {
            setVisible(false);
            new Login();
        }
    if(e.getSource()==sign_up){
        new Employee();

    }
    }

    public static void main(String[] args)  {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run()  {
new Main();
//                Loader b=new Loader();
//                Thread t=new Thread(b);
//
//                t.start();



            }
        });
    }

}

class Music {
    public void playmusic(String filepath) {
        InputStream music;
        try {
            music = new FileInputStream(new File((filepath)));
            AudioStream audio = new AudioStream(music);
            AudioPlayer.player.start(audio);


        } catch (Exception eoo) {
            System.out.println("error in playing");
        }


    }


}
