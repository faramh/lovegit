package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class Loadbar {
    JFrame frame = new JFrame("                                                        Please Wait ...!");
    JLabel label = new JLabel();
    JLabel cow_label =new JLabel();
    JProgressBar bar = new JProgressBar(0,100);
    ImageIcon imageIcon = new ImageIcon("1.png");
    ImageIcon cowIcon = new ImageIcon("cow.png");
    ImageIcon image_icon = new ImageIcon("logo.png");


    public Loadbar(){
        //Ask close frame
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) { }
            @Override
            public void windowClosing(WindowEvent e) {
                Sound_Effect.get_Sound_Effect_Instatnce().exit();
                if (JOptionPane.showConfirmDialog(null,"Are you sure you want to exit","",JOptionPane.YES_NO_OPTION)==0)
                    System.exit(0);
            }
            @Override
            public void windowClosed(WindowEvent e) { }
            @Override
            public void windowIconified(WindowEvent e) { }
            @Override
            public void windowDeiconified(WindowEvent e) { }
            @Override
            public void windowActivated(WindowEvent e) { }
            @Override
            public void windowDeactivated(WindowEvent e) { }
        });
        //

        frame.setLocation(515,125);//Located frame in center of screen;

        frame.setIconImage(image_icon.getImage());

        bar.setValue(0);
        bar.setBounds(0,590,535,25);
        bar.setStringPainted(true);
        bar.setFont(new Font("MV Boli",Font.BOLD,14));
        bar.setForeground(new Color(92, 189, 22));
        bar.setBackground(Color.white);

        frame.getContentPane().setBackground(new Color(135,206,235));

        label.setBounds(0,0,550,650);
        label.setIcon(imageIcon);

        cow_label.setBounds(0,0,150,150);
        cow_label.setIcon(cowIcon);


        frame.add(bar);
        frame.add(label);
        frame.add(cow_label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 650);
        frame.setLayout(null);
        frame.setVisible(true);
        fill();
    }
    public void fill() {
        int counter =0;
        while(counter<=100) {
            bar.setValue(counter);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter +=1;
        }
        bar.setString("Done! :)");
        frame.dispose();
        new login_Panel();
    }
}
