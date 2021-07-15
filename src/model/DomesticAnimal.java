package model;

public enum DomesticAnimal {
    chicken(100,2,ProductList.egg),
    turkey(200,3,ProductList.fabric),
    buffalo(400,5,ProductList.milk);
    int cost;
    int timeTodo;
    ProductList product;

    DomesticAnimal(int cost, int timeTodo, ProductList product) {
        this.cost = cost;
        this.timeTodo = timeTodo;
        this.product = product;
    }
}
