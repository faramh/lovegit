package model;

import java.util.Iterator;
import java.util.Random;

public class Wilds extends Animal{

    public int cageCounter=0;
    public WildList name;


    public Wilds(WildList name,int maxcol , int maxrow) {
        this.name = name;
        Random rand = new Random();
        x_position = rand.nextInt(maxcol)+1;
        y_position = rand.nextInt(maxrow)+1;
    }

    public boolean cage (){ // returns true if caged completely
        cageCounter ++;
        if (cageCounter>=name.maxCage)
            return true;
        return false;
    }// the project instruction says (if player don't cage in a turn , the cage counter decreases  )
    // todo, this is not implemented yet

    public void move(Farm farm){ // move and eliminate animals and products

        Random rand = new Random();
        boolean valid_move = false;
        int vertical=0,horizontal=0,destination_x,destination_y,middle_x=0,middle_y=0;
        if (name==WildList.tiger){
            while (!valid_move){
                switch (rand.nextInt(4)){
                    case 0:
                        vertical =2;
                        horizontal =0;
                        break;
                    case 1:
                        vertical =-2;
                        horizontal =0;
                        break;
                    case 2:
                        vertical =0;
                        horizontal =2;
                        break;
                    case 3:
                        vertical =0;
                        horizontal =-2;
                        break;

                }
                destination_x= x_position+horizontal;
                middle_x = x_position + (horizontal/2);
                destination_y = y_position + vertical;
                middle_y = y_position + (vertical/2);
                // checking if destination is valid

                if ((destination_x<1)||(destination_y<1)||(destination_x> farm.maxCol)||(destination_y> farm.maxCol))
                    valid_move = false;
                else {
                    valid_move = true;
                    x_position =destination_x;
                    y_position =destination_y;
                }


            }

            // elimination
            farm.product_map[x_position][y_position].clear();
            farm.product_map[middle_x][middle_y].clear();
            Iterator<Domestics> domestic_itr  = farm.AnimalInFarm.iterator();
            Domestics temporary_dom ;
            while (domestic_itr.hasNext()){
                temporary_dom = domestic_itr.next();
                if (((temporary_dom.y_position==y_position)&&(temporary_dom.x_position==x_position))||((temporary_dom.y_position==middle_y)&&(temporary_dom.x_position==middle_x)))
                    domestic_itr.remove();

            }

            Iterator<Cat> cat_itr  = farm.cats.iterator();
            Cat temporary_cat ;
            while (cat_itr.hasNext()){
                temporary_cat = cat_itr.next();
                if ((temporary_cat.y_position==y_position)&&(temporary_cat.x_position==x_position))
                    cat_itr.remove();

            }

        }else{
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

                if ((destination_x<1)||(destination_y<1)||(destination_x> farm.maxCol)||(destination_y> farm.maxCol))
                    valid_move = false;
                else {
                    valid_move = true;
                    x_position =destination_x;
                    y_position =destination_y;
                }


            }
            // elimination
            if(!farm.product_map[x_position][y_position].isEmpty())
                farm.product_map[x_position][y_position].clear();
            Iterator<Domestics> domestic_itr  = farm.AnimalInFarm.iterator();
            Domestics temporary_dom ;
            while (domestic_itr.hasNext()){
                temporary_dom = domestic_itr.next();
                if ((temporary_dom.y_position==y_position)&&(temporary_dom.x_position==x_position))
                    domestic_itr.remove();

            }

            Iterator<Cat> cat_itr  = farm.cats.iterator();
            Cat temporary_cat ;
            while (cat_itr.hasNext()){
                temporary_cat = cat_itr.next();
                if ((temporary_cat.y_position==y_position)&&(temporary_cat.x_position==x_position))
                    cat_itr.remove();

            }

        }

    }
}

