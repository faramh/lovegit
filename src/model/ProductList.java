package model;

public enum ProductList {
    egg(15,1,4),
    feather(20,1,4),
    milk(25,1,4),
    flour(40,2,5),
    fabric(50,2,5),
    packedMilk(60,2,5),
    bread(80,4,6),
    cloth(100,4,6),
    iceCream(120,4,6),
    lion(300,15,5),
    bear(400,15,5),
    tiger(500,15,5);
    int price;
    int housingSpace;
    public int durability;

    ProductList(int price, int housingSpace,int durability ) {
        this.price = price;
        this.housingSpace = housingSpace;
        this.durability=durability;
    }


}


