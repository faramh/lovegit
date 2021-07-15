package model;

import java.util.HashMap; // import the HashMap class


public class warehouse {
   public HashMap<ProductList, Integer> existingProduct = new HashMap<ProductList, Integer>();
    public HashMap<ProductList, Integer> collectedProduct = new HashMap<ProductList, Integer>();

    public int capacity=0;
	public final int maxCapacity=30;

    public warehouse() {
        ProductList [] all_products = new ProductList[12];
        all_products = ProductList.values();
        for (int i = 0; i < 12; i++) {
            existingProduct.put(all_products[i],0);
            collectedProduct.put(all_products[i],0);
        }

    }

    public boolean add(ProductList product ){ // farm->pickup

        if (maxCapacity - capacity > 0) {

            if (existingProduct.get(product) == 0) {
                existingProduct.put(product, 1);
            }
            else {
                existingProduct.put(product, 1 + collectedProduct.get(product));
            }
            if (collectedProduct.get(product) == 0) {
                collectedProduct.put(product, 1);
            }
            else {
                collectedProduct.put(product, 1 + collectedProduct.get(product));
            }
            capacity += product.housingSpace;

            return true;
        }
        else
            return false;

    }
    public boolean remove(ProductList removed){



        //boolean success;
        if(existingProduct.get(removed)==0){
            return false;
        }
        else if(existingProduct.get(removed)==1)
        {
            capacity -= removed.housingSpace;
            existingProduct.put(removed,0);
            return true;
        }
        else
        {
            capacity -= removed.housingSpace;
            existingProduct.put(removed,existingProduct.get(removed)-1);
            return true;
        }
    }

}
