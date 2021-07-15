package model;
import  model.Farm;

import java.util.Random;

public class Domestics extends Animal {

    public DomesticAnimal AnimalName;
    int timer;
    public int health;
    final int hungerLimit=50;
    boolean hungry=false;

    public Domestics(DomesticAnimal animalName) {
        AnimalName = animalName;
        health =100;
        timer =0;
        x_position=1;
        y_position=1;
    }

    @Override
    public void move(int[][]grass,int maxrow, int maxcol) {

        if (!hungry){
            Random rand = new Random();
            boolean valid_move = false;
            int vertical=0,horizontal=0,destination_x,destination_y;

            while (!valid_move){
                switch (rand.nextInt(4)){
                    case 0:
                        vertical =1;
                        horizontal =0;
                        break;
                    case 1:
                        vertical =-1;
                        horizontal =0;
                        break;
                    case 2:
                        vertical =0;
                        horizontal =1;
                        break;
                    case 3:
                        vertical =0;
                        horizontal =-1;
                        break;

                }
                destination_x= x_position+horizontal;
                destination_y = y_position + vertical;
                // checking if destination is valid

                if ((destination_x<1)||(destination_y<1)||(destination_x> maxcol)||(destination_y> maxrow))
                    valid_move = false;
                else {
                    valid_move = true;
                    x_position =destination_x;
                    y_position =destination_y;
                }


            }


        }else {

            int minimumDistance = 100;
            int distance;
            int targetRow = 1, targetCol = 1;
            for (int i = 1; i < maxcol +1; i++) {
                for (int j = 1; j < maxrow+1; j++) {
                    if (grass[i][j] > 0) {
                        distance = Math.abs(x_position - j) + Math.abs(y_position - i);
                        if (distance < minimumDistance) {
                            minimumDistance = distance;
                            targetCol = i;
                            targetRow = j;
                        }
                    }
                }
            }
            if (y_position > targetRow) {
                    y_position--;
            } else if (y_position < targetRow){
                    y_position++;
            }
            else if (x_position > targetCol) {
                    x_position--;
            } else if(x_position < targetCol){
                    x_position++;
            }
        }


    }
    public void eating(int [][] grass){
        if (hungry) {
            if (grass[x_position][y_position] > 0) {
                grass[x_position][y_position]--;
                this.health = 100;
                hungry = false;
            }
        }
    }

    public boolean decreasingLife_isalive(){
        this.health-=10;
        if (health<=0)
            return false;
        if(health<=hungerLimit)
            hungry=true;
        return true;
    }

    public void turn (Farm farm){
        timer++;
        if (timer >= AnimalName.timeTodo){
            farm.product_map[x_position][y_position].add(new Product(x_position,y_position,AnimalName.product));
            timer = 0;
        }
    }

}





//
//enum DomesticAnimal {
//    chicken(100,2,ProductList.egg),
//    turkey(200,3,ProductList.fabric),
//    buffalo(400,5,ProductList.milk);
//    int cost;
//    int timeTodo;
//    ProductList product;
//
//    DomesticAnimal(int cost, int timeTodo, ProductList product) {
//        this.cost = cost;
//        this.timeTodo = timeTodo;
//        this.product = product;
//    }
//}

