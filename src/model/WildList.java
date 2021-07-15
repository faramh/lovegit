package model;

public enum WildList {
    lion(3,ProductList.lion),
    bear(4,ProductList.bear),
    tiger(4,ProductList.tiger);
    public int maxCage;
    ProductList caged_form;

    WildList(int maxCage,ProductList caged_name) {
        this.maxCage = maxCage;
        caged_form = caged_name;

    }
}
