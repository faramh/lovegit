package view;

import control.Manager;
import model.ProductList;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Warehouse_to_truck_panel extends JPanel {
    ArrayList<Single_product_panel> panels = new ArrayList<>();
    JProgressBar truck_capacity = new JProgressBar(0, Manager.get_manager_Instatnce().farm.farmWarehouse.maxCapacity);
    Warehouse_to_truck_panel(){
        //todo setting size
        refresh();
    }
    void refresh (){
        panels.clear();



        for (HashMap.Entry<ProductList, Integer> entry : Manager.get_manager_Instatnce().farm.farmWarehouse.existingProduct.entrySet()) {
            if (entry.getValue()!=0)
                panels.add(new Single_product_panel(entry.getKey(),entry.getValue(),true));
        }

        removeAll();
        revalidate();
        repaint();

        truck_capacity.setValue(Manager.get_manager_Instatnce().farm.farmWarehouse.capacity);
        add(truck_capacity);
        for (Single_product_panel s:panels) {
            add(s);
        }

    }



}
