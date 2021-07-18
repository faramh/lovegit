package view;

import control.Manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control_panel extends JPanel {
    JButton turn = new JButton("Turn");
    //JProgressBar turn_timer = new JProgressBar();
    JButton menu = new JButton("Menu");
    JLabel coins = new JLabel();
    Task_panel task_panel = new Task_panel();



    Control_panel(){
        //todo adding
        turn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manager.get_manager_Instatnce().turn_manager(1);
            }
        });

        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo
            }
        });

    }

    void refresh (){
        task_panel.refresh();
        coins.setText(String.valueOf(Manager.get_manager_Instatnce().farm.coins)+"$");



    }


}
