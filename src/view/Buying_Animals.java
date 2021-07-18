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
    Buying_Animals(){
        price[0]= DomesticAnimal.chicken.cost;
        price[1]= DomesticAnimal.turkey.cost;
        price[2]= DomesticAnimal.buffalo.cost;
        price[3]= Cat.price;
        price[4]= Dog.price;
        //todo adding labels



        refresh();

        
    }
    
    void refresh(){
        for (int i = 0; i < 5; i++) {

            if (Manager.get_manager_Instatnce().farm.coins>price[i]){
                animal_icons[i].setIcon(Load_assets.animal_icon(i,2));
                int finalI = i;
                animal_icons[i].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        switch (finalI){
                            case 0:
                                Manager.get_manager_Instatnce().buy_domestic_animal(DomesticAnimal.chicken);
                                break;
                            case 1:
                                Manager.get_manager_Instatnce().buy_domestic_animal(DomesticAnimal.turkey);
                                break;
                            case 2:
                                Manager.get_manager_Instatnce().buy_domestic_animal(DomesticAnimal.buffalo);
                                break;
                            case 3:
                                Manager.get_manager_Instatnce().buy_cat();
                                break;
                            case 4:
                                Manager.get_manager_Instatnce().buy_dog();
                                break;
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) { }
                    @Override
                    public void mouseReleased(MouseEvent e) { }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        animal_icons[finalI].setIcon(Load_assets.animal_icon(finalI,3));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        animal_icons[finalI].setIcon(Load_assets.animal_icon(finalI,2));
                    }
                });

            }else{
                animal_icons[i].setIcon(Load_assets.animal_icon(i,0));
                animal_icons[i].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // todo play error sound
                    }

                    @Override
                    public void mousePressed(MouseEvent e) { }
                    @Override
                    public void mouseReleased(MouseEvent e) { }
                    @Override
                    public void mouseEntered(MouseEvent e) { }
                    @Override
                    public void mouseExited(MouseEvent e) { }
                });



            }

        }
        
    } 
    
}
