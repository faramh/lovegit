package view;

import model.WorkshopList;

import javax.swing.*;
import java.awt.*;

public class Workshop_panel_right extends JPanel {

    Single_workshop_panel bakery_panel ;
    Single_workshop_panel tailoring_panel ;
    Single_workshop_panel ice_cream_panel ;
    Workshop_panel_right() {
        bakery_panel = new Single_workshop_panel(WorkshopList.bakery);
        tailoring_panel = new Single_workshop_panel(WorkshopList.tailoring);
        ice_cream_panel = new Single_workshop_panel(WorkshopList.iceCreamProcessing);
        bakery_panel.setPreferredSize(new Dimension(250,200));
        bakery_panel.setOpaque(false);
        add(bakery_panel);
        add(tailoring_panel);
        add(ice_cream_panel);
        refresh();
    }

    void refresh (){
        bakery_panel.refresh();
        tailoring_panel.refresh();
        ice_cream_panel.refresh();

    }

}
