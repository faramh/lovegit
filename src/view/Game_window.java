package view;

import control.Manager;
import model.DomesticAnimal;
import model.WateringSystem;
import model.WorkshopList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Game_window extends JFrame {


    JLabel coin = new JLabel();
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
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) { }
            @Override
            public void windowClosing(WindowEvent e) {
                Sound_Effect.get_Sound_Effect_Instatnce().exit();
                if (JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?  your progress wont be saved","",JOptionPane.YES_NO_OPTION)==0)
                    System.exit(0);
            }
            @Override
            public void windowClosed(WindowEvent e) { }
            @Override
            public void windowIconified(WindowEvent e) { }
            @Override
            public void windowDeiconified(WindowEvent e) { }
            @Override
            public void windowActivated(WindowEvent e) { }
            @Override
            public void windowDeactivated(WindowEvent e) { }
        });
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
        wateringSystem_panel.setBounds(745,60,155,150);
        wateringSystem_panel.setOpaque(false);
        //buying Animal---------------------------------------------
        buying_animals = new Buying_Animals();
        buying_animals.setBounds(0,0,100,900);
        buying_animals.setOpaque(false);
        //----------------------------------------------------------

        coin.setBounds(1400,100,120,40);
        coin.setText(String.valueOf(Manager.get_manager_Instatnce().farm.coins));
        coin.setFont(new Font(null,Font.BOLD,28));
        coin.setForeground(new Color(0x6F6FFF));
        add(coin);
        add(board);
        warehouse_panel.view_button.setBounds(1400,750,130,40);
        add(warehouse_panel.view_button);
        warehouse_panel.truck_bar.setBounds(1400,700,80,40);
        add(warehouse_panel.truck_bar);
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
        coin.setText(String.valueOf(Manager.get_manager_Instatnce().farm.coins));
        board.refresh();
        workshop_panel_right.refresh();
        workshop_panel_left.refresh();
        buying_animals.refresh();
        warehouse_panel.refresh();
        wateringSystem_panel.refresh();
        //todo


    }


}
