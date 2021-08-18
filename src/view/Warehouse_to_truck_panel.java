package view;

import control.Manager;
import model.ProductList;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Warehouse_to_truck_panel extends JPanel {
    ArrayList<Single_product_panel> panels = new ArrayList<>();
    JTextArea data = new JTextArea(40,40);
    JProgressBar truck_capacity = new JProgressBar(0, Manager.get_manager_Instatnce().farm.farmWarehouse.maxCapacity);
    Warehouse_to_truck_panel(){
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        flowLayout.setVgap(0);
        setLayout(flowLayout);
        setOpaque(false);
        setPreferredSize(new Dimension(350,500));
        refresh();
    }
    void refresh (){
        panels.clear();
        String result = "";

        for (HashMap.Entry<ProductList, Integer> entry : Manager.get_manager_Instatnce().farm.farmWarehouse.existingProduct.entrySet()) {
            if (entry.getValue()!=0){
                result+=entry.getKey()+String.valueOf(entry.getValue())+"\n";

                panels.add(new Single_product_panel(entry.getKey(),entry.getValue(),true));}
        }

        data.setText(result);
        add(data);

        removeAll();
        revalidate();
        repaint();

        truck_capacity.setValue(Manager.get_manager_Instatnce().farm.farmWarehouse.capacity);
        //add(truck_capacity);
        for (Single_product_panel s:panels) {
            add(s);
        }

    }



}
