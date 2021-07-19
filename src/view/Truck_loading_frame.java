package view;

import control.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Truck_loading_frame extends JFrame {
    Truck_panel truck_panel;
    Warehouse_to_truck_panel warehouse_to_truck_panel;
    JButton go = new JButton("Go");
    JButton cancel = new JButton("Cancel");
    Truck_loading_frame(){
        //todo adding panels
        //todo setting size
        setSize(700,600);
        setLayout(new FlowLayout());
        truck_panel = new Truck_panel();
        truck_panel.setPreferredSize(new Dimension(350,400));
        warehouse_to_truck_panel = new Warehouse_to_truck_panel();
        warehouse_to_truck_panel.setPreferredSize(new Dimension(350,400));
        add(truck_panel);
        add(warehouse_to_truck_panel);
        add(go);
        add(cancel);

        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manager.get_manager_Instatnce().go_truck();//todo should it return boolean ?
                Game_window.get_instance().update_everything();
                exit();
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
        refresh();
    }

    void show_up (){
        this.setVisible(true);
    }

    void exit (){
        this.setVisible(false);
    }

    void refresh (){
        go.setEnabled((!Manager.get_manager_Instatnce().farm.truck.load.isEmpty())
                && ((Manager.get_manager_Instatnce().farm.truck.present)));


        truck_panel.refresh();
        warehouse_to_truck_panel.refresh();

    }



}
