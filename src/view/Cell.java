package view;

import control.Manager;
import model.Domestics;
import model.Product;
import model.Wilds;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Cell extends JPanel{

    ArrayList<JLabel> animals = new ArrayList<>();
    ArrayList <JLabel> products = new ArrayList<>();
    ArrayList<JLabel> wilds =  new ArrayList<>();
    int row , col;
    int x,y,h,w;

    Cell(int c,int r){//todo
        row = r;
        col= c;

    }


    void listener(){
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton()==1){
                    Manager.get_manager_Instatnce().pickup_manage(col,row);

                }else if (e.getButton()==3){
                    Manager.get_manager_Instatnce().cage_manage(col,row);

                }

                Game_window.get_instance().update_everything();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //todo
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


    }

    void refresh(){
        refresh_animals();
        refresh_products();
        refresh_wilds();
        add_everything();
    }

    private void refresh_animals (){
        animals.clear();

        for (Domestics d:Manager.get_manager_Instatnce().farm.AnimalInFarm) {
            if ((d.x_position==col)&&(d.y_position==row)){
                JLabel temp = new JLabel(Load_assets.domestic(d.AnimalName,d.health));
                animals.add(temp);
            }
        }
    }

    private void refresh_products (){
        products.clear();
        for (Product p:Manager.get_manager_Instatnce().farm.product_map[col][row]) {
            JLabel temp = new JLabel(Load_assets.product(p.ProductName));
            products.add(temp);
        }
    }

    private void refresh_wilds(){
        wilds.clear();
        for (Wilds d:Manager.get_manager_Instatnce().farm.WildesInFarm) {
            if ((d.x_position==col)&&(d.y_position==row)){
                JLabel temp = new JLabel(Load_assets.wild(d.name,d.cageCounter));
                animals.add(temp);
            }
        }
    }

    private void add_everything(){

        //todo

    }
}
