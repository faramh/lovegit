package model;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tasks {
    public HashMap<ProductList, Integer> ProductTask = new HashMap<>();
    //public HashMap<ProductList, Integer> Product_sofar;
    public int CoinTask;
    public int due_time;
    public int reward;
    public int init_coin ;
    public HashMap<DomesticAnimal, Integer> AnimalTask = new HashMap<>();
    //public HashMap<DomesticAnimal, Integer> Animal_sofar;
    public ArrayList <WildList>[] WildTasks = new ArrayList[20];

    public Tasks() {
        for (int i = 0; i < 20; i++) {
            WildTasks[i] = new ArrayList<>();
        }
    }

    //    public Tasks(HashMap<ProductList, Integer> productTask, HashMap<DomesticAnimal,
//            Integer> animalTask, ArrayList<WildList>[] wildTasks) {
//        ProductTask = productTask;
//        AnimalTask = animalTask;
//        WildTasks = wildTasks;
//    }
    public boolean checking(Farm farm){
        boolean done=true;
        for (Map.Entry<ProductList, Integer> pair: ProductTask.entrySet()) {
           // Product_sofar.put(pair.getKey(),farm.farmWarehouse.collectedProduct.get(pair.getKey()));
            if (farm.farmWarehouse.collectedProduct.get(pair.getKey())<pair.getValue())
                done= false;
        }
        int cnt=0;
        for (Map.Entry<DomesticAnimal, Integer> pair: AnimalTask.entrySet()) {
            cnt=0;
            for (Domestics d:farm.AnimalInFarm) {
                if (d.AnimalName==pair.getKey())
                    cnt++;
            }
          //  Animal_sofar.put(pair.getKey(),cnt);
            if (cnt<pair.getValue())
                done =false;
        }

        if (CoinTask>farm.coins)
            done= false;


        return done;

    }
//    public void log(){
//
//    }
    public void addWildAnimal(Farm farm) {
        if (farm.turn_cnt < 18) {
            for (WildList w : WildTasks[farm.turn_cnt]) {
                farm.WildesInFarm.add(new Wilds(w, farm.maxCol, farm.maxRow));
            }
        }
    }
}