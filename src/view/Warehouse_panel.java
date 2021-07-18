package view;

import control.Manager;
import model.ProductList;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Warehouse_panel extends JPanel {//todo adding a preview frame
    ArrayList<JLabel> items = new ArrayList<>();

    Warehouse_panel(){

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
        removeAll();
        revalidate();
        repaint();
        //todo add items to panel and set size and layout




    }


}
