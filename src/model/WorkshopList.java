package model;

//import model.ProductList;

public enum WorkshopList {
    mill(4,ProductList.egg,ProductList.flour,150,300),

    textTile(5,ProductList.feather,ProductList.fabric ,250,500),

    MilkProcessing(6,ProductList.milk,ProductList.packedMilk,400,800),

    bakery(5,ProductList.flour,ProductList.bread,250,500),

    tailoring(6,ProductList.fabric,ProductList.cloth,400,800),

    iceCreamProcessing(7,ProductList.packedMilk,ProductList.iceCream,550,1100);

    int [] cost;
    ProductList output,input;
    int time ;
    int maxlevel = 2;

    WorkshopList( int time ,ProductList input,ProductList output , int ... cost ) {
        this.cost = cost;
        this.output = output;
        this.input= input;
        this.time=time;
    }
}
