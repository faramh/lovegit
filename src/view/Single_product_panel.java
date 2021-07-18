package view;

import control.Manager;
import model.Product;
import model.ProductList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Single_product_panel extends JPanel {
    JButton add_to_truck = new JButton("Add to truck");
    JButton remove_from_truck = new JButton("Remove from truck");
    JLabel label ;
    ProductList enum_name;

    Single_product_panel(ProductList name,int amount,boolean warehouse){
        enum_name = name;
        label.setIcon(Load_assets.product(enum_name));
        label.setText(String.valueOf(amount));
        remove_from_truck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manager.get_manager_Instatnce().unloading_truck(enum_name);
            }
        });

        add_to_truck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manager.get_manager_Instatnce().loading_truck(enum_name);
            }
        });
        add(label);

        if (warehouse)
            add(add_to_truck);
        else
            add(remove_from_truck);



    }

}
