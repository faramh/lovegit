package view;

import control.Manager;
import model.ProductList;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Truck_panel extends JPanel {
    ArrayList<Single_product_panel> panels = new ArrayList<>();
    JProgressBar truck_capacity = new JProgressBar(0, Manager.get_manager_Instatnce().farm.truck.MaxCapacity);

    Truck_panel (){
        setOpaque(false);
        setPreferredSize(new Dimension(350,500));
        refresh();
    }

    void refresh (){
        panels.clear();
        for (HashMap.Entry<ProductList, Integer> entry : Manager.get_manager_Instatnce().farm.truck.load.entrySet()) {
            if (entry.getValue()!=0)
                panels.add(new Single_product_panel(entry.getKey(),entry.getValue(),false));
        }

        removeAll();
        revalidate();
        repaint();

        truck_capacity.setValue(Manager.get_manager_Instatnce().farm.truck.Loaded);
        add(truck_capacity);
        for (Single_product_panel s:panels) {
            add(s);
        }

    }




}
