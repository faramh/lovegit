package view;

import control.Manager;
import model.ProductList;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;

public class Task_panel extends JPanel {
    ArrayList<JPanel> tasks_list = new ArrayList<>();

    Task_panel(){

        refresh();
    }


    void refresh (){
        tasks_list.clear();
        for (Map.Entry<ProductList, Integer> pair: Manager.get_manager_Instatnce().farm.tasks.ProductTask.entrySet()) {
            JLabel temp_label = new JLabel(Load_assets.product( pair.getKey()));
            JProgressBar temp_bar = new JProgressBar(0,pair.getValue());
            temp_bar.setValue(Manager.get_manager_Instatnce().farm.farmWarehouse.collectedProduct.get(pair.getKey()));
        }

        this.removeAll();
        this.revalidate();
        this.repaint();
        for (JPanel p:tasks_list) {
            this.add(p);
        }

    }



}
