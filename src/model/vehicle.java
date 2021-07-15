package model;

import java.util.HashMap;

public class vehicle {
    final int MaxCapacity=15;
    public int Loaded=0;
    final int timeTodo=10;
    public int timer;
    public int price=0;
    boolean present = true;
    HashMap<ProductList, Integer> load = new HashMap<>() ;

    public vehicle() {
        ProductList [] all_products = new ProductList[12];
        all_products = ProductList.values();
        for (int i = 0; i < 12; i++) {
            load.put(all_products[i],0);
        }

    }

    public int loading(ProductList cargo) {  //1=not available  2=storage error

        if (!present)
            return  1;
        if (MaxCapacity - Loaded > 0) {

            if (load.get(cargo) == 0) {
                load.put(cargo, 1);
            }
            else {
                load.put(cargo, 1 + load.get(cargo));
            }
            Loaded += cargo.housingSpace;
            price += cargo.price;

            return 0;
        }
        else
            return 2;
    }
    public int remove(ProductList removed){
        if (!present)
            return 1;
        if(load.get(removed)==0){
            return 2;
        }
        else if(load.get(removed)==1)
        {
            load.put(removed,0);
            price-=removed.price;
            Loaded-= removed.housingSpace;
            return 0;
        }
        else
        {
            load.put(removed,load.get(removed)-1);
            price-=removed.price;
            Loaded-= removed.housingSpace;
            return 0;
        }

    }
    public boolean go(){
        if (present){
            present=false;
            timer=0;
            return  true;
        }
        return  false;
    }

    public int move(){ // -1= is present   -2= on way   else = coin
        int coin;
        if(present) {
            return -1;
        }
        timer++;
         if(timer==timeTodo)
        {
            present=true;
            coin=price;
            price=0;
            timer=0;
            return coin;
        }
         return -2;
    }
}
