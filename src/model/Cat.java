package model;

import java.util.ArrayList;

public class Cat extends Animal{
    static final int price = 150;

    public Cat() {
        x_position =1;
        y_position =1;
    }

    public void move(ArrayList<Product>[][]productMap, int maxcol, int maxrow) {
        int minimumDistance=100;
        int distance;
        int targetRow=maxrow,targetCol=maxcol;
        for (int i = 1; i <maxcol+1; i++) {
            for (int j = 1; j < maxrow+1; j++) {//todo bug
                if (!productMap[i][j].isEmpty()){

                    distance=Math.abs(x_position-j)+Math.abs(y_position-i);
                    if(distance<minimumDistance){
                        minimumDistance=distance;
                        targetCol=i;
                        targetRow=j;
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
        } else if (x_position < targetCol) {
            x_position++;
        }


    }

    public void collect (Farm farm){
        if (!farm.product_map[x_position][y_position].isEmpty()){
            farm.pick_up(x_position,y_position);
        }

    }

}
