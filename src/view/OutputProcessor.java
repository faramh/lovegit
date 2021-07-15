package view;

import control.Manager;
import model.*;
import model.Farm;

import java.util.Map;

public class OutputProcessor {
    // Singleton Design
    // Only one State Instance should exist
    public static OutputProcessor outputProcessor_state;
    public static OutputProcessor get_output_Instatnce(){
        if (outputProcessor_state==null){
            outputProcessor_state = new OutputProcessor();
        }
        return outputProcessor_state;
    }
// private Manager mg ;

   /* public OutputProcessor(Manager manager) {
        this.mg = manager;
    }*/
    public void ShowOutputError(String Error){
        System.err.println(Error);
    }
    public void ShowOutputUserNotice(String Notice){
        System.out.print(Notice);
    }



    public void ShowOutputOfTurn_Inquiry(Farm farm){
        System.out.println("-------------------------------------------");
        System.out.println("your coins = "+ farm.coins);
        System.out.println("warehouse capacity =" + farm.farmWarehouse.capacity );
        System.out.println("truck timer =" + farm.truck.timer);
        System.out.println("truck capacity = "+ farm.truck.Loaded);
        System.out.println("truck price = "+ farm.truck.price);
        System.out.println("water amount = "+farm.WS.waterAmount);
        System.out.println("watering system timer " + farm.WS.timer);
        System.out.println("passed time ="+ farm.turn_cnt);

        for (int i = 1; i < farm.maxCol+1; i++) {
            for (int j = 1; j < farm.maxRow+1; j++) {
                if(farm.grass[i][j]>0) {
                    System.out.print(" ");
                    System.out.print(farm.grass[i][j]);
                    System.out.print(" ");;
                }
                else{
                    System.out.print("__ ");
                }
            }
            System.out.println("");
        }

        //========================================
        System.out.println("Domestic animals:");
        for (Domestics d:farm.AnimalInFarm) {
            System.out.println(d.AnimalName+" " +d.health+"%"+ "["+d.x_position + "  " +d.y_position +"]" );
        }
        System.out.println("Wild animals:");
        for (Wilds w: farm.WildesInFarm) {
            System.out.println(w.name +""+ (w.name.maxCage-w.cageCounter)+ "["+w.x_position + "  " +w.y_position +"]"   );
        }
        System.out.println("all cats:");
        for (Cat c:farm.cats) {
            System.out.println("["+c.x_position + "  " +c.y_position +"]" );
        }
        System.out.println("all dogs:");
        for (Cat c:farm.cats) {
            System.out.println("["+c.x_position + "  " +c.y_position +"]" );
        }
        System.out.println("Products:");
        for (int i = 1; i < farm.maxCol; i++) {
            for (int j = 1; j <farm.maxRow ; j++) {
                for (Product p: farm.product_map[i][j]) {
                    System.out.println(p.ProductName +" "+(p.ProductName.durability-p.timer)+ "["+p.xPosition + "  " +p.YPosition +"]"  );
                }
            }
        }

        if (farm.coins<farm.tasks.CoinTask){
            System.out.println(" coin task");
            System.out.println( farm.coins + "/ "+farm.tasks.CoinTask);
        }

        System.out.println("Animal task:");
        int cnt;
        for (Map.Entry<DomesticAnimal, Integer> pair: farm.tasks.AnimalTask.entrySet()) {
            cnt=0;
            for (Domestics d:farm.AnimalInFarm) {
                if (d.AnimalName==pair.getKey())
                    cnt++;
            }
            System.out.println(pair.getKey()+"  "+cnt+"/" +pair.getValue());
        }
        System.out.println("Product task:");
        for (Map.Entry<ProductList, Integer> pair: farm.tasks.ProductTask.entrySet()) {
            System.out.println(pair.getKey()+ "  "+ farm.farmWarehouse.collectedProduct.get(pair.getKey())+"/"+pair.getValue());
        }

    }

}
