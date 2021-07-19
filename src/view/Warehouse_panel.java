package view;

import control.Manager;
import model.ProductList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Warehouse_panel extends JPanel {//todo adding a preview frame
    ArrayList<JLabel> items = new ArrayList<>();
    JButton view_button = new JButton("View Warehouse");
    //JButton load_truck = new JButton("Load truck");
    Truck_loading_frame tlf;
    JProgressBar truck_bar= new JProgressBar(0,Manager.get_manager_Instatnce().farm.truck.timeTodo);


    Warehouse_panel(){
        add(view_button);
        add(truck_bar);
        tlf = new Truck_loading_frame();
        tlf.exit();
        view_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tlf.show_up();
                tlf.refresh();
            }
        });

     refresh();
    }

    void refresh (){
        items.clear();

        for (HashMap.Entry<ProductList, Integer> entry : Manager.get_manager_Instatnce()
                .farm.farmWarehouse.existingProduct.entrySet()) {
            if (entry.getValue()!=0){
                for (int i = 0; i < entry.getValue(); i++) {
                    JLabel temp =new JLabel( Load_assets.product(entry.getKey()));
                    items.add(temp);
                }
            }

        }

        truck_bar.setValue(Manager.get_manager_Instatnce().farm.truck.timer);
        removeAll();
        revalidate();
        repaint();
        //todo add items to panel and set size and layout




    }


}
