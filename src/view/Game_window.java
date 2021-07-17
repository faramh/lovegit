package view;

import javax.swing.*;

public class Game_window extends JFrame {

    Board board;
    Warehouse_panel warehouse_panel;
    Workshop_panel workshop_panel;//todo

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
        //todo



    }


}
