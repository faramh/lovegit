package view;
import javax.swing.*;
import java.awt.*;

public class Loadbar {
    JFrame frame = new JFrame("                                                     Please Wait ...!");
    JLabel label = new JLabel();
    JLabel cow_label =new JLabel();
    JProgressBar bar = new JProgressBar(0,100);
    ImageIcon imageIcon = new ImageIcon("1.png");
    ImageIcon cowIcon = new ImageIcon("cow.png");
    ImageIcon image_icon = new ImageIcon("logo.png");


    public Loadbar(){
        frame.setIconImage(image_icon.getImage());

        bar.setValue(0);
        bar.setBounds(0,590,535,25);
        bar.setStringPainted(true);
        bar.setFont(new Font("MV Boli",Font.BOLD,14));
        bar.setForeground(new Color(92, 189, 22));
        bar.setBackground(Color.black);

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
                Thread.sleep(50);
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
