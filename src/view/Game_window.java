package view;

import model.WateringSystem;

import javax.swing.*;

public class Game_window extends JFrame {

    Board board;
    Warehouse_panel warehouse_panel;            //todo
    Workshop_panel_left workshop_panel_left;    //todo
    Workshop_panel_right workshop_panel_right;  //todo
    WateringSystem_panel wateringSystem_panel ; //todo
    Buying_Animals buying_animals;
    //todo Control_panel

    Game_window(){
        // todo instantiates panels
        //todo set bound and layout
        // todo set frame size and window listener










    }

    static Game_window instance;

    static Game_window get_instance(){
        if (instance==null){
            instance = new Game_window();
            return instance;
        }else
            return instance;

    }

    void update_everything(){
        board.refresh();
        workshop_panel_right.refresh();
        workshop_panel_left.refresh();
        buying_animals.refresh();
        warehouse_panel.refresh();
        wateringSystem_panel.refresh();
        //todo



    }


}
