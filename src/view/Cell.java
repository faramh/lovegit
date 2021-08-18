package view;

import control.Manager;
import model.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Cell extends JPanel{

    
    JPanel background = new JPanel();
    JPanel foreground = new JPanel();
    
    ArrayList<JLabel> animals = new ArrayList<>();
    ArrayList <JLabel> products = new ArrayList<>();
    ArrayList<JLabel> wilds =  new ArrayList<>();
    ArrayList<JLabel> cats = new ArrayList<>();
    ArrayList<JLabel> dogs = new ArrayList<>();
    JLabel grassLabel = new JLabel();
    Border border;

    int grass =0;
    int row , col;
    int x,y,h,w;

    Cell(int c,int r){//todo
        row = r;
        col= c;
        listener();
        refresh();
    setOpaque(false);

    }


    void listener(){
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton()==1){
                    Manager.get_manager_Instatnce().pickup_manage(col,row);

                }else if (e.getButton()==3){
                    Manager.get_manager_Instatnce().cage_manage(col,row);

                }else  if (e.getButton()==2){
                    Manager.get_manager_Instatnce().plant_manage(col,row);
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


        grass = Manager.get_manager_Instatnce().farm.grass[col][row];
        refresh_animals();
        refresh_products();
        refresh_wilds();
        refresh_cats();
        refresh_dogs();
        refresh_grass();
        add_everything();
    }

    private void refresh_grass (){
        grass = Manager.get_manager_Instatnce().farm.grass[col][row];

    }

    private void refresh_animals (){
        animals.clear();

        for (Domestics d:Manager.get_manager_Instatnce().farm.AnimalInFarm) {
            if ((d.x_position==col)&&(d.y_position==row)){
                JLabel temp = new JLabel(Load_assets.domestic(d.AnimalName,d.health));
                //JLabel temp = new JLabel(new ImageIcon("resources\\Hen\\5H.png"));
                animals.add(temp);
            }
        }
    }

    private void refresh_cats (){
        cats.clear();

        for (Cat d:Manager.get_manager_Instatnce().farm.cats) {
            if ((d.x_position==col)&&(d.y_position==row)){
                JLabel temp = new JLabel(Load_assets.cat_img());
                cats.add(temp);
            }
        }
    }

    private void refresh_dogs (){
        dogs.clear();

        for (Dog d:Manager.get_manager_Instatnce().farm.dogs) {
            if ((d.x_position==col)&&(d.y_position==row)){
                JLabel temp = new JLabel(Load_assets.cat_img());
                dogs.add(temp);
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
                wilds.add(temp);
            }
        }
    }

    private void add_everything() {
        removeAll();
        revalidate();
        repaint();
        
        foreground.removeAll();
        foreground.revalidate();
        foreground.repaint();

        background.removeAll();
        background.revalidate();
        background.repaint();
//        if (grass==0)
//            border = new LineBorder(new Color(0xC4B304),1);
//        else
//            border = new LineBorder(new Color(0x39D900),grass+1);



//        this.setBorder(border);
        for (JLabel x:wilds) {
            foreground.add(x);
        }

        for (JLabel x:products) {
            foreground.add(x);
        }

        for (JLabel x:animals) {
            foreground.add(x);
        }

        for (JLabel x:cats) {
            foreground.add(x);
        }

        for (JLabel x:dogs) {
            foreground.add(x);
        }

        //setLayout(null);
        if (grass!=0){
            grassLabel = new JLabel(Load_assets.getGrass(grass));
            grassLabel.setBounds(0,0,100,100);
            grassLabel.setOpaque(false);
            background.add(new JLabel(Load_assets.getGrass(grass)));
        }

        setLayout(null);
        foreground.setBounds(0,0,getWidth(),getWidth());
        background.setBounds(0,0,getWidth(),getWidth());
        foreground.setOpaque(false);
        background.setOpaque(false);
        add(foreground);
        add(background);




    }
}
