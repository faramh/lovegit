package view;

import model.WateringSystem;

import javax.swing.*;

public class Game_window extends JFrame {

    Board board;
    Warehouse_panel warehouse_panel;//todo
    Workshop_panel_left workshop_panel_left;//todo
    Workshop_panel_right workshop_panel_right;//todo
    WateringSystem_panel wateringSystem_panel ; // todo
    //todo Control_panel



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
        //todo



    }


}
