package model;
import model.ProductList;
public class Product {
    public int xPosition;
    public int YPosition;
    public ProductList ProductName;
    public int timer;
    boolean collected;
    boolean expired = false;

    public Product(int xPosition, int YPosition, ProductList productName) {
        this.xPosition = xPosition;
        this.YPosition = YPosition;
        this.ProductName = productName;
    }

    public void  collect(){collected = true;}

    public  boolean  turn_and_is_expired (){
        timer++;
        if(timer >= ProductName.durability){
            expired = true ;
            return true;
        }
        else
            return false;

    }

}
