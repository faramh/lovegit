package view;

import model.DomesticAnimal;
import model.ProductList;
import model.WildList;
import model.WorkshopList;

import javax.swing.*;

public class Load_assets {
    static ImageIcon chicken = new ImageIcon();
    static ImageIcon turkey = new ImageIcon();
    static ImageIcon buffalo = new ImageIcon();

    static  ImageIcon cat = new ImageIcon();
    static ImageIcon dog = new ImageIcon();
    //todo change to array

    static ImageIcon egg = new  ImageIcon();
    static ImageIcon milk = new  ImageIcon();
    static ImageIcon flour = new  ImageIcon();
    static ImageIcon fabric = new  ImageIcon();
    static ImageIcon packedmilk = new  ImageIcon();
    static ImageIcon bread = new  ImageIcon();
    static ImageIcon cloth = new  ImageIcon();
    static ImageIcon ice_cream = new  ImageIcon();
    static ImageIcon caged_lion = new  ImageIcon();
    static ImageIcon caged_bear = new  ImageIcon();
    static ImageIcon caged_tiger = new  ImageIcon();


    //todo moving wild animals
    //todo workshop frames
    //todo well


    static ImageIcon cat_img (){
        //todo
        return null;
    }

    static ImageIcon dog_img(){
        //todo
        return null;
    }

    static ImageIcon domestic (DomesticAnimal name,int health){
        //todo
        return null;
    }

    static ImageIcon product (ProductList name){
        //todo
        return null;

    }

    static ImageIcon wild (WildList name,int cage){
        //todo
        return null;
    }

    static ImageIcon workshop_img (WorkshopList name,int frame,int leve){

        //todo
        return null;

    }

    static ImageIcon well (int frame){
        //todo
        return null;
    }

    static ImageIcon animal_icon(int code, int mode){
        // code : 0 = chicken   1 = turkey    2 = buffalo    3 = cat      4 = dog
        // mode : 0 =unavailable    2= normal     3 = hover
        //todo
        return null;

    }



}
