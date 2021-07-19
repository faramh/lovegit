package view;

import control.Manager;
import model.Cat;
import model.Dog;
import model.DomesticAnimal;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Buying_Animals extends JPanel {
    // index : 0 = chicken   1 = turkey    2 = buffalo    3 = cat      4 = dog
    JLabel[] animal_icons = new JLabel[5];
    int [] price = new int[5];

    boolean [] flags = new boolean[5];

    MouseListener m0 = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (flags[0]) {
                Manager.get_manager_Instatnce().buy_domestic_animal(DomesticAnimal.chicken);
                Game_window.get_instance().update_everything();
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (flags[0])
                animal_icons[0].setIcon(Load_assets.animal_icon(0,3));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (flags[0])
                animal_icons[0].setIcon(Load_assets.animal_icon(0,2));

        }
    };

    MouseListener m1 = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (flags[1]) {
                Manager.get_manager_Instatnce().buy_domestic_animal(DomesticAnimal.turkey);
                Game_window.get_instance().update_everything();
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (flags[1])
                animal_icons[1].setIcon(Load_assets.animal_icon(1,3));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (flags[1])
                animal_icons[1].setIcon(Load_assets.animal_icon(1,2));
        }
    };

    MouseListener m2 = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (flags[2]) {
                Manager.get_manager_Instatnce().buy_domestic_animal(DomesticAnimal.buffalo);
                Game_window.get_instance().update_everything();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (flags[2])
                animal_icons[2].setIcon(Load_assets.animal_icon(2,3));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(flags[2])
                animal_icons[2].setIcon(Load_assets.animal_icon(2,2));
        }
    };

    MouseListener m3 = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (flags[3]) {
                Manager.get_manager_Instatnce().buy_cat();
                Game_window.get_instance().update_everything();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (flags[3])
                animal_icons[3].setIcon(Load_assets.animal_icon(3,3));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (flags[3])
                animal_icons[3].setIcon(Load_assets.animal_icon(3,2));
        }
    };

    MouseListener m4 = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (flags[4]) {
                Manager.get_manager_Instatnce().buy_dog();
                Game_window.get_instance().update_everything();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (flags[4])
                animal_icons[4].setIcon(Load_assets.animal_icon(4,3));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (flags[4])
                animal_icons[4].setIcon(Load_assets.animal_icon(4,2));
        }
    };

    Buying_Animals(){
        price[0]= DomesticAnimal.chicken.cost;
        price[1]= DomesticAnimal.turkey.cost;
        price[2]= DomesticAnimal.buffalo.cost;
        price[3]= Cat.price;
        price[4]= Dog.price;



        for (int i = 0; i < 5; i++) {
            animal_icons [i] = new JLabel();
        }
        animal_icons[0].addMouseListener(m0);
        animal_icons[1].addMouseListener(m1);
        animal_icons[2].addMouseListener(m2);
        animal_icons[3].addMouseListener(m3);
        animal_icons[4].addMouseListener(m4);

        refresh();
        for (int i = 0; i < 5; i++) {
            add(animal_icons[i]);
        }
    }

    void refresh(){
        for (int i = 0; i < 5; i++) {
            if (Manager.get_manager_Instatnce().farm.coins>price[i]){
                animal_icons[i].setIcon(Load_assets.animal_icon(i,2));
                //animal_icons[i].setIcon(new ImageIcon("resources\\icons\\B3.png"));
                flags[i]= true;
            }else{
                animal_icons[i].setIcon(Load_assets.animal_icon(i,0));
                flags[i]= false;
            }
        }
    }
}
