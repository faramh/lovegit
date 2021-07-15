package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Dog extends Animal{
        static final int price =100 ;
    public void move (int maxcol, int maxrow){

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

    }


    public boolean KillingWild(ArrayList<Wilds> all_wilds){ // true means that it has killed a wild animal
        Iterator<Wilds> wild_itr  = all_wilds.iterator();
        Wilds temporary_wild ;
        while (wild_itr.hasNext()){
            temporary_wild = wild_itr.next();
            if ((temporary_wild.x_position==x_position)&&(temporary_wild.y_position==y_position)){
                wild_itr.remove();
                return true;
            }
        }
        return false;
    }
}
