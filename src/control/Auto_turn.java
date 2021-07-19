package control;

import view.Game_window;

public class Auto_turn extends Thread {

    int state=0;
    int time_duration_ms = 3000;
    int timer_ms;
    @Override
    public void run() {
        while(true){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timer_ms+=100;
            if (timer_ms>=time_duration_ms){
                timer_ms = 0;
                if (state ==1){
                    Manager.get_manager_Instatnce().turn_manager(1);
                    Game_window.get_instance().update_everything();
                }
            }

        }
    }


    void play (){
        timer_ms =0;
        state=1;
    }

    void pause (){
        state =0;
    }

    void reset (){
        timer_ms=0;
    }

    void setTime_duration_ms(int a){
        time_duration_ms = a;
    }

}
