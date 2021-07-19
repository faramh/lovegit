package view;

import control.Manager;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WateringSystem_panel extends JPanel implements Animatable {
    JLabel img = new JLabel(); // loading image of well
    JProgressBar amount_bar = new JProgressBar(0,5);
    JProgressBar filling_bar = new JProgressBar(0,3);
    JButton fill = new JButton("Fill");
    Animation animation = new Animation(this);

    int frame_cnt = 1;
    final int max_frame = 7 ;
    @Override
    public void nextFrame() {
        frame_cnt++;
        if (frame_cnt>max_frame)
            frame_cnt=1;
        img.setIcon(Load_assets.well(frame_cnt));
    }

    void refresh (){
        switch (Manager.get_manager_Instatnce().farm.WS.state){
            case EMPTY:
                filling_bar.setValue(0);
                amount_bar.setValue(0);
                fill.setEnabled(true);
                animation.setFlag(false);
                break;
            case READY_TO_USE:
                filling_bar.setValue(0);
                amount_bar.setValue(Manager.get_manager_Instatnce().farm.WS.waterAmount);
                fill.setEnabled(false);
                animation.setFlag(false);
                break;
            case FILLING_IN_PROGRESS:
                filling_bar.setValue(Manager.get_manager_Instatnce().farm.WS.timer);
                amount_bar.setValue(0);
                fill.setEnabled(false);
                animation.setFlag(true);
                break;

        }



    }


    WateringSystem_panel(){
        animation.start();
        //img.setIcon(Load_assets.animal_icon(1,2));
        img.setIcon(Load_assets.well(1));
        fill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manager.get_manager_Instatnce().wateringSystemManage();
            }
        });

        img.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fill.doClick();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        add(img);
        add(amount_bar);
        add(filling_bar);
        add(fill);
        //todo add components and set size and


        refresh();
    }





}
