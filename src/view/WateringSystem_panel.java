package view;

import control.Manager;
import javax.swing.*;

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


        //todo add components and set size and


        refresh();
    }





}
