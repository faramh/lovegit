package view;

import control.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Truck_loading_frame extends JFrame {

    ImageIcon background = new ImageIcon("resources//shipment.jpg");
    JLabel background_label = new JLabel();
    Truck_panel truck_panel;
    Warehouse_to_truck_panel warehouse_to_truck_panel;
    JButton go = new JButton("Go");
    JButton cancel = new JButton("Cancel");
    Truck_loading_frame(){
        setSize(735,800);
        setLayout(null);
        background_label.setBounds(0,0,735,800);
        background_label.setIcon(background);
        background_label.setOpaque(false);
        truck_panel = new Truck_panel();
        truck_panel.setBounds(390,140,314,560);
        warehouse_to_truck_panel = new Warehouse_to_truck_panel();
        warehouse_to_truck_panel.setBounds(33,136,330,566);
        go.setBounds(77,735,40,30);
        cancel.setBounds(120,735,60,30);
        add(truck_panel);
        add(warehouse_to_truck_panel);
        add(go);
        add(cancel);
        add(background_label);
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
