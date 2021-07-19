package view;

import control.Manager;
import model.DomesticAnimal;
import model.WateringSystem;
import model.WorkshopList;

import javax.swing.*;
import java.awt.*;

public class Game_window extends JFrame {

    Board board;
    Warehouse_panel warehouse_panel;            //todo
    Workshop_panel_left workshop_panel_left;    //todo
    Workshop_panel_right workshop_panel_right;  //todo
    WateringSystem_panel wateringSystem_panel ; //todo
    Buying_Animals buying_animals;

    ImageIcon background = new ImageIcon("background.jpg");
    JLabel background_label = new JLabel();

    //todo Control_panel

    public Game_window(){
        System.out.println("Game Window");
        //set frame--------------------------------------
        setBounds(0,0,1540,830);
        setLayout(null);
        setVisible(true);
        //set background image-------------------------------
        background_label.setBounds(0,0,1540,860);
        background_label.setIcon(background);
        background_label.setOpaque(false);
        //set board------------------------------------------
        board = new Board(Manager.manager_state.Row, Manager.manager_state.Col);
        board.setBounds(295,205,900,610);
        board.setOpaque(false);
        //set warehouse---------------------------------------
        warehouse_panel = new Warehouse_panel();
        warehouse_panel.setBounds(1195,610,345,250);
        warehouse_panel.setOpaque(false);
        //set workshop_left-----------------------------------
        workshop_panel_left = new Workshop_panel_left();
        workshop_panel_left.setBounds(0,100,295,600);
        workshop_panel_left.setOpaque(false);
        //set workshop_right-------------------------------------
        workshop_panel_right = new Workshop_panel_right();
        workshop_panel_right.setBounds(1300,100,295,600);
        workshop_panel_right.setOpaque(false);
        //Watering System------------------------------------------
        wateringSystem_panel = new WateringSystem_panel();
        wateringSystem_panel.setBounds(745,100,155,150);
        wateringSystem_panel.setOpaque(false);
        //buying Animal---------------------------------------------
        buying_animals = new Buying_Animals();
        buying_animals.setBounds(0,0,100,900);
        buying_animals.setOpaque(false);
        //----------------------------------------------------------



        add(board);
        warehouse_panel.view_button.setBounds(1400,750,70,40);
        add(warehouse_panel.view_button);
        add(workshop_panel_left);
        add(workshop_panel_right);
        add(wateringSystem_panel);
        add(buying_animals);
        add(background_label);

        // todo instantiates panels
        //todo set bound and layout
        // todo set frame size and window listener
    }

    static Game_window instance;

    public static Game_window get_instance(){
        if (instance==null){
            instance = new Game_window();
            return instance;
        }else
            return instance;

    }

    public void update_everything(){
        board.refresh();
        workshop_panel_right.refresh();
        workshop_panel_left.refresh();
        buying_animals.refresh();
        warehouse_panel.refresh();
        wateringSystem_panel.refresh();
        //todo


    }


}
