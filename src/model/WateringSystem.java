package model;

public class WateringSystem {
    final int  timeTodo=3;
    //final int price=0;
    final int maxAmount=5;
    public int timer=0;
    well_state state = well_state.READY_TO_USE;
    public int waterAmount= maxAmount;
    public int filling(){
        if (state==well_state.FILLING_IN_PROGRESS)
            return 1;
        if (state==well_state.READY_TO_USE)
            return 0;
        timer = 0;
        state = well_state.FILLING_IN_PROGRESS;
            return 2;
    }

    public void turn() {

        if (state == well_state.FILLING_IN_PROGRESS){
            timer++;
            if (timer==timeTodo){
                waterAmount = maxAmount;
                state = well_state.READY_TO_USE;
                timer =0;
            }

        }

    }

    public boolean using (){
        if (state== well_state.READY_TO_USE){
            waterAmount --;
            if (waterAmount<=0)
                state = well_state.EMPTY;
            return true;
        }else
            return false;

    }


}

enum well_state{
    EMPTY,
    READY_TO_USE,
    FILLING_IN_PROGRESS
}
