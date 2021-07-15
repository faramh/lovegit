package view;

import javax.swing.*;
import java.awt.*;

public class Game_frame {
    JFrame Game_frame = new JFrame("Farm Frenzy");
    public Game_frame(){

        JPanel p11 = new JPanel();
        JPanel p12 = new JPanel();
        JPanel p13 = new JPanel();
        JPanel p14 = new JPanel();
        JPanel p15 = new JPanel();
        JPanel p16 = new JPanel();

        JPanel p21 = new JPanel();
        JPanel p22 = new JPanel();
        JPanel p23 = new JPanel();
        JPanel p24 = new JPanel();
        JPanel p25 = new JPanel();
        JPanel p26 = new JPanel();

        JPanel p31 = new JPanel();
        JPanel p32 = new JPanel();
        JPanel p33 = new JPanel();
        JPanel p34 = new JPanel();
        JPanel p35 = new JPanel();
        JPanel p36 = new JPanel();

        JPanel p41 = new JPanel();
        JPanel p42 = new JPanel();
        JPanel p43 = new JPanel();
        JPanel p44 = new JPanel();
        JPanel p45 = new JPanel();
        JPanel p46 = new JPanel();

        JPanel p51 = new JPanel();
        JPanel p52 = new JPanel();
        JPanel p53 = new JPanel();
        JPanel p54 = new JPanel();
        JPanel p55 = new JPanel();
        JPanel p56 = new JPanel();

        JPanel p61 = new JPanel();
        JPanel p62 = new JPanel();
        JPanel p63 = new JPanel();
        JPanel p64 = new JPanel();
        JPanel p65 = new JPanel();
        JPanel p66 = new JPanel();

        p11.setBounds(0,0,200,100);
        p12.setBounds(200,0,200,100);
        p13.setBounds(400,0,200,100);
        p14.setBounds(600,0,200,100);
        p15.setBounds(800,0,200,100);
        p16.setBounds(1000,0,200,100);

        Game_frame.setContentPane(p11);
        Game_frame.setContentPane(p12);
        Game_frame.setContentPane(p13);
        Game_frame.setContentPane(p14);
        Game_frame.setContentPane(p15);
        Game_frame.setContentPane(p16);

        Game_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game_frame.setSize(1200,600);
        Game_frame.setLayout(null);
        Game_frame.setVisible(true);
        Game_frame.setResizable(false);
    }
}
