package view;
import model.*;
import control.Manager;

public class InstructionProcessor {
    /*public InstructionProcessor(Manager manager) {
        this.manager = manager;}*/
    //private Manager manager ;
    public InstructionProcessor() {
    }
    // Singleton Design
    // Only one State Instance should exist
    public static InstructionProcessor instruction_state;
    public static InstructionProcessor get_instruction_Instatnce(){
        if (instruction_state==null){
            instruction_state = new InstructionProcessor();
        }
        return instruction_state;
    }

    public void UnderstandInstruction(){

        String instruction = InputProcessor.get_input_Instatnce().scanner.nextLine();
        instruction = instruction.toUpperCase();

        if(instruction.equalsIgnoreCase("WELL")){
            Manager.get_manager_Instatnce().wateringSystemManage();
        }
        else if(instruction.startsWith("PLANT")){
            String[] XY = instruction.split(" ");
            int x = Integer.parseInt(String.valueOf(XY[1]));
            int y = Integer.parseInt(String.valueOf(XY[2]));
            Manager.get_manager_Instatnce().plant_manage(x,y);
        }
        else if(instruction.startsWith("PICKUP")){
            String[] XY = instruction.split(" ");
            int x = Integer.parseInt(String.valueOf(XY[1]));
            int y = Integer.parseInt(String.valueOf(XY[2]));
            Manager.get_manager_Instatnce().pickup_manage(x,y);
        }
        else if(instruction.startsWith("BUY")){
            String[] animal_names = instruction.split(" ");
            String animal_name = animal_names[1];
            switch (animal_name){
                case "BUFFALO":
                    Manager.get_manager_Instatnce().buy_domestic_animal(DomesticAnimal.buffalo);
                    break;
                case "TURKEY":
                    Manager.get_manager_Instatnce().buy_domestic_animal(DomesticAnimal.turkey);
                    break;
                case "CHICKEN":
                    Manager.get_manager_Instatnce().buy_domestic_animal(DomesticAnimal.chicken);
                    break;
                case "CAT" :
                    Manager.get_manager_Instatnce().buy_cat();
                    break;
                case "DOG" :
                    Manager.get_manager_Instatnce().buy_dog();
            }
        }
        else if(instruction.startsWith("WORK")){
            String[] workshop_names = instruction.split(" ");
            String workshop_name = workshop_names[1];
            switch (workshop_name){
                case "MILKPROCESSING":
                    Manager.get_manager_Instatnce().workshop_manager(WorkshopList.MilkProcessing);
                    break;
                case "BAKERY":
                    Manager.get_manager_Instatnce().workshop_manager(WorkshopList.bakery);
                    break;
                case "ICECREAMPROCESSING":
                    Manager.get_manager_Instatnce().workshop_manager(WorkshopList.iceCreamProcessing);
                    break;
                case "MILL":
                    Manager.get_manager_Instatnce().workshop_manager(WorkshopList.mill);
                    break;
                case "TAILORING":
                    Manager.get_manager_Instatnce().workshop_manager(WorkshopList.tailoring);
                    break;
                case "TEXTTILE":
                    Manager.get_manager_Instatnce().workshop_manager(WorkshopList.textTile);
                    break;
            }
        }
        else if(instruction.startsWith("BUILD")){
            String[] workshop_names = instruction.split(" ");
            String workshop_name = workshop_names[1];
            switch (workshop_name){
                case "MILKPROCESSING":
                    Manager.get_manager_Instatnce().workshop_builder(WorkshopList.MilkProcessing);
                    break;
                case "BAKERY":
                    Manager.get_manager_Instatnce().workshop_builder(WorkshopList.bakery);
                    break;
                case "ICECREAMPROCESSING":
                    Manager.get_manager_Instatnce().workshop_builder(WorkshopList.iceCreamProcessing);
                    break;
                case "MILL":
                    Manager.get_manager_Instatnce().workshop_builder(WorkshopList.mill);
                    break;
                case "TAILORING":
                    Manager.get_manager_Instatnce().workshop_builder(WorkshopList.tailoring);
                    break;
                case "TEXTTILE":
                    Manager.get_manager_Instatnce().workshop_builder(WorkshopList.textTile);
                    break;
            }
        }
        else if(instruction.startsWith("UPGRADE")){
            String[] workshop_names = instruction.split(" ");
            String workshop_name = workshop_names[1];
            switch (workshop_name){
                case "MILKPROCESSING":
                    Manager.get_manager_Instatnce().workshop_upgrade(WorkshopList.MilkProcessing);
                    break;
                case "BAKERY":
                    Manager.get_manager_Instatnce().workshop_upgrade(WorkshopList.bakery);
                    break;
                case "ICECREAMPROCESSING":
                    Manager.get_manager_Instatnce().workshop_upgrade(WorkshopList.iceCreamProcessing);
                    break;
                case "MILL":
                    Manager.get_manager_Instatnce().workshop_upgrade(WorkshopList.mill);
                    break;
                case "TAILORING":
                    Manager.get_manager_Instatnce().workshop_upgrade(WorkshopList.tailoring);
                    break;
                case "TEXTTILE":
                    Manager.get_manager_Instatnce().workshop_upgrade(WorkshopList.textTile);
                    break;
            }

        }
        else if(instruction.startsWith("CAGE")){
            String[] XY = instruction.split(" ");
            int x = Integer.parseInt(String.valueOf(XY[1]));
            int y = Integer.parseInt(String.valueOf(XY[2]));
            Manager.get_manager_Instatnce().cage_manage(x,y);
        }
        else if(instruction.startsWith("TURN")){
            String[] time_scale = instruction.split(" ");
            Manager.get_manager_Instatnce().turn_manager(Integer.parseInt(String.valueOf(time_scale[1])));
        }
        else if(instruction.startsWith("TRUCK LOAD")){
            String[] item_names = instruction.split(" ");
            String item_name = item_names[2];
            switch (item_name){
                case "LION" :
                    Manager.get_manager_Instatnce().loading_truck(ProductList.lion);
                    break;
                case "TIGER" :
                    Manager.get_manager_Instatnce().loading_truck(ProductList.tiger);
                    break;
                case "BEAR" :
                    Manager.get_manager_Instatnce().loading_truck(ProductList.bear);
                    break;

                case "EGG" :
                    Manager.get_manager_Instatnce().loading_truck(ProductList.egg);
                    break;
                case "MILK" :
                    Manager.get_manager_Instatnce().loading_truck(ProductList.milk);
                    break;
                case "FEATHER" :
                    Manager.get_manager_Instatnce().loading_truck(ProductList.feather);
                    break;


                case "FABRIC" :
                    Manager.get_manager_Instatnce().loading_truck(ProductList.fabric);
                    break;
                case "FLOUR" :
                    Manager.get_manager_Instatnce().loading_truck(ProductList.flour);
                    break;
                case "PACKEDMILK" :
                    Manager.get_manager_Instatnce().loading_truck(ProductList.packedMilk);
                    break;

                case "BREAD" :
                    Manager.get_manager_Instatnce().loading_truck(ProductList.bread);
                    break;
                case "CLOTH" :
                    Manager.get_manager_Instatnce().loading_truck(ProductList.cloth);
                    break;
                case "ICECREAM" :
                    Manager.get_manager_Instatnce().loading_truck(ProductList.iceCream);
                    break;
            }
        }
        else if(instruction.startsWith("TRUCK UNLOAD")){
            String[] item_names = instruction.split(" ");
            String item_name = item_names[2];
            switch (item_name){
                case "LION" :
                    Manager.get_manager_Instatnce().unloading_truck(ProductList.lion);
                    break;
                case "TIGER" :
                    Manager.get_manager_Instatnce().unloading_truck(ProductList.tiger);
                    break;
                case "BEAR" :
                    Manager.get_manager_Instatnce().unloading_truck(ProductList.bear);
                    break;

                case "EGG" :
                    Manager.get_manager_Instatnce().unloading_truck(ProductList.egg);
                    break;
                case "MILK" :
                    Manager.get_manager_Instatnce().unloading_truck(ProductList.milk);
                    break;
                case "FEATHER" :
                    Manager.get_manager_Instatnce().unloading_truck(ProductList.feather);
                    break;

                case "FABRIC" :
                    Manager.get_manager_Instatnce().unloading_truck(ProductList.fabric);
                    break;
                case "FLOUR" :
                    Manager.get_manager_Instatnce().unloading_truck(ProductList.flour);
                    break;
                case "PACKEDMILK" :
                    Manager.get_manager_Instatnce().unloading_truck(ProductList.packedMilk);
                    break;

                case "BREAD" :
                    Manager.get_manager_Instatnce().unloading_truck(ProductList.bread);
                    break;
                case "CLOTH" :
                    Manager.get_manager_Instatnce().unloading_truck(ProductList.cloth);
                    break;
                case "ICECREAM" :
                    Manager.get_manager_Instatnce().unloading_truck(ProductList.iceCream);
                    break;
            }
        }
        else if(instruction.equalsIgnoreCase("TRUCK GO")){
            Manager.get_manager_Instatnce().go_truck();
        }
        else if(instruction.equalsIgnoreCase("INQUIRY")){
            Manager.get_manager_Instatnce().inquiry_manage();
        }

    }
}

