package model;
import model.WorkshopList;

import java.util.Random;


public class Workshop {
    WorkshopList name;
    int timer ;
    boolean working = false;
    int timeTodo;
    int amount;
    int level=1;
    public Workshop(WorkshopList name) {
        this.name = name;
    }

    public int work (warehouse WH ){ // 1= working
        if (working)
            return 1 ;
        if (WH.existingProduct.get(name.input)<=0) //2 = not enough
            return 2;

        working = true;
        timer = 0;
        timeTodo = name.time;
        if (level > WH.existingProduct.get(name.input))
            amount = WH.existingProduct.get(name.input);
        else
            amount = level;

        for (int i = 0; i < amount; i++) {
            if(!WH.remove(name.input))
                System.err.println("ریدیم");
        }
        return 0;
    }

    public void turn (Farm farm){
        if (working){
            timer++;
            if (timer>=timeTodo){
                farm.product_map[1][1].add(new Product(1,1,name.output));
                timer =0;
                working =false;

            }

        }
    }
    public boolean upgrade (Farm farm){
        if (name.cost[1]>farm.coins)
            return false;

        if (level+1>name.maxlevel)
            return false;

        farm.coins-=name.cost[level];
        level++;
        return true;

    }
}
