package view;

import model.WorkshopList;

import javax.swing.*;
import java.awt.*;

public class Workshop_panel_left extends JPanel {//counting from top to bottom
    Single_workshop_panel mill_panel ;
    Single_workshop_panel textTile_panel;
    Single_workshop_panel milk_panel ;


    Workshop_panel_left(){
        mill_panel = new Single_workshop_panel(WorkshopList.mill);
        textTile_panel = new Single_workshop_panel(WorkshopList.textTile);
        milk_panel = new Single_workshop_panel(WorkshopList.MilkProcessing);

        mill_panel.setPreferredSize(new Dimension(155,200));
        mill_panel.setOpaque(false);

        textTile_panel.setPreferredSize(new Dimension(155,200));
        textTile_panel.setOpaque(false);

        milk_panel.setPreferredSize(new Dimension(155,200));
        milk_panel.setOpaque(false);


        //todo set size and location

        add(mill_panel);
        add(textTile_panel);
        add(milk_panel);
        refresh();
    }

    void refresh (){
        mill_panel.refresh();
        textTile_panel.refresh();
        milk_panel.refresh();
    }

}
