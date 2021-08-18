package view;

import model.DomesticAnimal;
import model.ProductList;
import model.WildList;
import model.WorkshopList;

import javax.swing.*;

public class Load_assets {
    static ImageIcon []chicken = new ImageIcon[3];
    static ImageIcon []turkey = new ImageIcon[3];
    static ImageIcon[] buffalo = new ImageIcon[3];
    static ImageIcon []buyDog = new ImageIcon[3];
    static ImageIcon []buyCat = new ImageIcon[3];
    static ImageIcon []well = new ImageIcon[7];

    static  ImageIcon cat = new ImageIcon("resources\\cat.png");
    static ImageIcon dog = new ImageIcon("resources\\dog.png");


    static ImageIcon [] l1_CakeBakery = new ImageIcon[16];
    static ImageIcon [] l2_CakeBakery = new ImageIcon[16];
    static ImageIcon [] l1_CookieBakery = new ImageIcon[16];
    static ImageIcon [] l2_CookieBakery = new ImageIcon[16];
    static ImageIcon [] l1_EggPowderPlant = new ImageIcon[16];
    static ImageIcon [] l2_EggPowderPlant = new ImageIcon[16];
    static ImageIcon [] l1_SewingFactory = new ImageIcon[16];
    static ImageIcon [] l2_SewingFactory = new ImageIcon[16];
    static ImageIcon [] l1_Spinnery = new ImageIcon[16];
    static ImageIcon [] l2_Spinnery = new ImageIcon[16];
    static ImageIcon [] l1_WeavingFactory = new ImageIcon[16];
    static ImageIcon [] l2_WeavingFactory= new ImageIcon[16];
    static ImageIcon [] Hen = new ImageIcon[10];
    static ImageIcon [] Turkey = new ImageIcon[10];
    static ImageIcon [] Lion = new ImageIcon[3];
    static ImageIcon [] Bear = new ImageIcon[4];
    static ImageIcon [] Tiger = new ImageIcon[4];
    static ImageIcon [] Bufalo = new ImageIcon[10];




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

    static ImageIcon iceCream = new ImageIcon();
    static ImageIcon milkProcess = new ImageIcon();

    static  ImageIcon grass1 = new ImageIcon();
    static  ImageIcon grass2 = new ImageIcon();
    static  ImageIcon grass3 = new ImageIcon();
    static  ImageIcon grass4 = new ImageIcon();




    //todo moving wild animals
    //todo workshop frames
    //todo well
    public static void initialize(){
        egg = new ImageIcon("resources\\Products\\Egg\\normal.png");
        milk = new ImageIcon("resources\\Products\\Milk.png");
        flour = new ImageIcon("resources\\Products\\Flour.png");
        fabric = new ImageIcon("resources\\Products\\Fabric.png");
        packedmilk = new ImageIcon("resources\\Products\\packed.png");
        bread = new ImageIcon("resources\\Products\\Cake.png");
        cloth = new ImageIcon("resources\\Products\\CarnivalDress.png");
        ice_cream = new ImageIcon("resources\\Products\\FlouryCake.png");
        caged_lion = new ImageIcon("resources\\Products\\CagedLion.png");
        caged_bear = new ImageIcon("resources\\Products\\CagedBrownBear.png");
        caged_tiger = new ImageIcon("resources\\Products\\tigercaged.png");
        cat = new ImageIcon("resources\\cat.png");
        dog = new ImageIcon("resources\\dog.png");

        grass1 = new ImageIcon("resources\\grass\\grass1.png");
        grass2 = new ImageIcon("resources\\grass\\grass2.png");
        grass3 = new ImageIcon("resources\\grass\\grass3.png");
        grass4 = new ImageIcon("resources\\grass\\grass4.png");



        milkProcess = new ImageIcon("resources\\milkpacking1.png");
        iceCream = new ImageIcon("resources\\icecreamfactory1.png");


        for (int i = 0; i < 3; i++) {
            buffalo[i]= new ImageIcon("resources\\icons\\B"+String.valueOf(i+1)+".png");
        }
        for (int i = 0; i < 3; i++) {
            buyCat[i]= new ImageIcon("resources\\icons\\C"+String.valueOf(i+1)+".png");
        }
        for (int i = 0; i < 3; i++) {
            buyDog[i]= new ImageIcon("resources\\icons\\D"+String.valueOf(i+1)+".png");
        }
        for (int i = 0; i < 3; i++) {
            chicken[i]= new ImageIcon("resources\\icons\\H"+String.valueOf(i+1)+".png");
        }
        for (int i = 0; i < 3; i++) {
            turkey[i]= new ImageIcon("resources\\icons\\T"+String.valueOf(i+1)+".png");
        }





        for (int i = 0; i < 16; i++) {
            l1_CakeBakery[i]= new ImageIcon("resources\\CakeBakery\\Level1\\"+String.valueOf(i+1)+"H.png");
        }
        for (int i = 0; i < 16; i++) {
            l2_CakeBakery[i]= new ImageIcon("resources\\CakeBakery\\Level2\\"+String.valueOf(i+1)+"H.png");
        }
        for (int i = 0; i < 16; i++) {
            l1_CookieBakery[i]= new ImageIcon("resources\\CookieBakery\\Level1\\"+String.valueOf(i+1)+"C.png");
        }
        for (int i = 0; i < 16; i++) {
            l2_CookieBakery[i]= new ImageIcon("resources\\CookieBakery\\Level2\\"+String.valueOf(i+1)+"C.png");
        }
        for (int i = 0; i < 16; i++) {
            l1_EggPowderPlant[i]= new ImageIcon("resources\\EggPowderPlant\\Level1\\"+String.valueOf(i+1)+"E.png");
        }
        for (int i = 0; i < 16; i++) {
            l2_EggPowderPlant[i]= new ImageIcon("resources\\EggPowderPlant\\Level2\\"+String.valueOf(i+1)+"E.png");
        }
        for (int i = 0; i < 16; i++) {
            l1_SewingFactory[i]= new ImageIcon("resources\\SewingFactory\\Level1\\"+String.valueOf(i+1)+"S.png");
        }
        for (int i = 0; i < 16; i++) {
            l2_SewingFactory[i]= new ImageIcon("resources\\SewingFactory\\Level2\\"+String.valueOf(i+1)+"S.png");
        }
        for (int i = 0; i < 16; i++) {
            l1_Spinnery[i]= new ImageIcon("resources\\Spinnery\\Level1\\"+String.valueOf(i+1)+"R.png");
        }
        for (int i = 0; i < 16; i++) {
            l2_Spinnery[i]= new ImageIcon("resources\\Spinnery\\Level2\\"+String.valueOf(i+1)+"R.png");
        }
        for (int i = 0; i < 16; i++) {
            l1_WeavingFactory[i]= new ImageIcon("resources\\WeavingFactory\\Level1\\"+String.valueOf(i+1)+"W.png");
        }
        for (int i = 0; i < 16; i++) {
            l2_WeavingFactory[i]= new ImageIcon("resources\\WeavingFactory\\Level2\\"+String.valueOf(i+1)+"W.png");
        }
        for (int i = 0; i < 10; i++) {
            Hen[i]= new ImageIcon("resources\\Hen\\"+String.valueOf(i+1)+"H.png");
        }
        for (int i = 0; i < 3; i++) {
            Lion[i]= new ImageIcon("resources\\Lion\\"+String.valueOf(i+1)+"L.png");
        }
        for (int i = 0; i < 4; i++) {
            Bear[i]= new ImageIcon("resources\\Bear\\"+String.valueOf(i+1)+"B.png");
        }
        for (int i = 0; i < 4; i++) {
            Tiger[i]= new ImageIcon("resources\\Tiger\\"+String.valueOf(i+1)+"E.png");
        }
        for (int i = 0; i < 10; i++) {
            Turkey[i]= new ImageIcon("resources\\Turkey\\"+String.valueOf(i+1)+"T.png");
        }
        for (int i = 0; i < 10; i++) {
            Bufalo[i]= new ImageIcon("resources\\Bufalo\\"+String.valueOf(i+1)+"B.png");
        }
        for (int i = 0; i < 7; i++) {
            well[i]= new ImageIcon("resources\\well\\"+String.valueOf(i+1)+".png");// todo
        }


    }


    static ImageIcon cat_img (){

        return cat;
        //return null;
    }

    static ImageIcon dog_img(){

        return dog;
    }

    static ImageIcon domestic (DomesticAnimal name,int health){
        health/=10;
        switch (name){
            case turkey:
                return Turkey[health-1];
            case chicken:
                return Hen[health-1];

            case buffalo:
                return Bufalo[health-1];
            default:
                return null;




        }
        //return null;
    }

    static ImageIcon product (ProductList name){


        switch (name){
            case egg:
                return egg;

            case bread:
                return bread;

            case cloth:
                return cloth;

            case iceCream:
                return ice_cream;

            case packedMilk:
                return  packedmilk;

            case milk:
                return milk;

            case fabric:
                return fabric;

            case lion:
                return caged_lion;

            case tiger:
                return caged_tiger;

            case bear:
                return caged_bear;


        }

        return null;

    }


    static  ImageIcon getGrass (int count){
        switch (count){
            case 1:
                return grass1;
            case 2:
                return grass2;
            case 3:
                return grass3;
            default:
                return grass4;
        }

    }

    static ImageIcon wild (WildList name,int cage){

        switch (name){
            case lion:
                return Lion[cage];

            case bear:
                return Bear[cage];

            case tiger:
                return Tiger[cage];

            default:
                return null;
        }
        //return null;
    }

    static ImageIcon workshop_img (WorkshopList name,int frame,int level){

        //todo
        switch (name){
            case mill:
                if(level==1)
                    return l1_EggPowderPlant[frame-1];
                else
                    return l2_EggPowderPlant[frame-1];

            case bakery:
                if(level==1)
                    return l1_CookieBakery[frame-1];
                else
                    return l2_CookieBakery[frame-1];
            case tailoring:
                if(level==1)
                    return l1_SewingFactory[frame-1];
                else
                    return l2_SewingFactory[frame-1];


            case textTile:
                if(level==1)
                    return l1_Spinnery[frame-1];
                else
                    return l2_Spinnery[frame-1];

            case MilkProcessing:
                return milkProcess;

            case iceCreamProcessing:
                return iceCream;
        }
        return null;

    }

    static ImageIcon well (int frame){

        return well[frame-1];

    }

    static ImageIcon animal_icon(int code, int mode){
        // code : 0 = chicken   1 = turkey    2 = buffalo    3 = cat      4 = dog
        // mode : 0 =unavailable    2= normal     3 = hover

        switch (code)
        {
            case 0:
                if(mode==0)
                    return chicken[1];
                else if(mode==2)
                    return chicken[0];
                else
                    return chicken[2];

            case 1:
                if(mode==0)
                    return turkey[1];
                else if(mode==2)
                    return turkey[0];
                else
                    return turkey[2];


            case 2:
                if(mode==0)
                    return buffalo[1];
                else if(mode==2)
                    return buffalo[0];
                else
                    return buffalo[2];



            case 3:
                if(mode==0)
                    return buyCat[1];
                else if(mode==2)
                    return buyCat[0];
                else
                    return buyCat[2];




            case 4:
                if(mode==0)
                    return buyDog[1];
                else if(mode==2)
                    return buyDog[0];
                else
                    return buyDog[2];




        }

        return null;

    }



}
