package control;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import view.OutputProcessor;
import model.Product;
import control.User;
import model.*;
import control.FileOperator;
import control.UserDataBase;
import view.*;

public class Manager {
    //private InputProcessor inputProcessor;
    //private OutputProcessor outputProcessor;
    static GsonBuilder builder = new GsonBuilder();
    static Gson gson = builder.create();
    private control.UserDataBase udb = gson.fromJson(FileOperator.reading("data.txt"),UserDataBase.class);
    //private control.UserDataBase udb = new UserDataBase();
    public Tasks [] all_tasks = new Tasks [5];
    //public DomesticAnimal domesticAnimal;
    //public Domestics domestics = new Domestics(domesticAnimal);
    public Farm farm ;//TODO:user coin;
    //public WildList wildList;
    //public Wilds wilds = new Wilds(wildList,farm.maxCol,farm.maxRow);
    //public Product product = new Product();
    private User loged_in_user ;

    // Singleton Design
    // Only one State Instance should exist
    public static Manager manager_state;
    public static Manager get_manager_Instatnce(){
        if (manager_state==null){
            manager_state = new Manager();
            for (int i = 1; i < 6; i++) {
                manager_state.all_tasks[i-1]= gson.fromJson(FileOperator.reading("level"+i+".txt"),Tasks.class);
            }

           // manager_state.udb = FileOperator.getUserData();//todo
        }
        return manager_state;
    }

    public boolean login_Check(String  username_input , String password_input){
        switch (udb.log_in_check(username_input,password_input)){
            case SUCCESS:
                loged_in_user = udb.current_user;
                OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("wellcome "+ loged_in_user.username);
                return true;
            case USERNAME_DOSENT_EXIST:
                OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("Username doesn't exist");
                return false;
            case INCORRECT_PASSWORD:
                OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("Incorrect password");
                return false;
        }
        return false;
    }

    public boolean signup_Password_Check(String  username_input , String password_input){
        switch (udb.sing_up_check(username_input,password_input)){
            case SUCCESS:
                FileOperator.Writing(gson.toJson(udb,UserDataBase.class),"data.txt");
                OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("Signed up successfully");
                loged_in_user = udb.current_user;
                return true;
            case ALREADY_EXIST:
                OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("This username already exist ");
                return false;
            case WEAK_PASSWORD:
                OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("The password is too weak"); // todo
                InputProcessor.get_input_Instatnce().login();
                break;
            case INVALID_USERNAME:
                OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("Invalid username"); //todo
                InputProcessor.get_input_Instatnce().login();
                break;
        }

        return false;
    }

    public void workshop_upgrade (WorkshopList label){
        switch (farm.upgrade(label)){
            case 1:
                OutputProcessor.get_output_Instatnce().ShowOutputError("not enough coin");
                break;
            case 2:
                OutputProcessor.get_output_Instatnce().ShowOutputError("doesnt exist");
                break;
            case 0:
                break;

        }


    }

    public boolean level_Check(int level){
        if (loged_in_user.level>=level){
            OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("starting level "+ level);
            farm = new Farm(all_tasks[level-1],loged_in_user.reward_coin);//todo
            return true;
        }
        else{
            return false;
        }
    }

    /*public void Manager_set(InputProcessor inputProcessor, OutputProcessor outputProcessor) {
        this.inputProcessor = inputProcessor;
        this.outputProcessor = outputProcessor;
    }*/

    public void wateringSystemManage(){
        int result = farm.well();
        if(result==0){
            OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("Your bucket is ready to use ... ! ");
        }
        else if(result==1) {
            OutputProcessor.get_output_Instatnce().ShowOutputError("Your bucket is filling ... ! ");
            OutputProcessor.get_output_Instatnce().ShowOutputError("Please wait ... ! ");
        }
        else
            OutputProcessor.get_output_Instatnce().ShowOutputError("Your bucket is empty ... ! ");

    }

    public void plant_manage(int x,int y) {
        if (!farm.plant(x, y)) {

            OutputProcessor.get_output_Instatnce().ShowOutputError("Your watering system is not ready to use ... !");
        }
    }

    public void pickup_manage(int x,int y){
        switch (farm.pick_up(x,y)) {
            case 0:

                break;
            case 1:
                OutputProcessor.get_output_Instatnce().ShowOutputError("This Coordinates is empty ... !");

                break;
            case 2:
                OutputProcessor.get_output_Instatnce().ShowOutputError("No SPACE ... !");

                break; }
    }

    public void cage_manage(int x,int y){
        farm.cage(x,y);
    }

    public void buy_domestic_animal(DomesticAnimal domesticName){
        if(farm.buy(domesticName)){
        }
        else{
            OutputProcessor.get_output_Instatnce().ShowOutputError("You need more coins ... !");
        }
    }
    public void buy_cat(){
        if(farm.buy_cat()){
            
        }
        else{
            OutputProcessor.get_output_Instatnce().ShowOutputError("You don`t have enough coin :(");
            
        }
    }

    public void buy_dog(){
        if(!farm.buy_dog()){
            OutputProcessor.get_output_Instatnce().ShowOutputError("You don`t have enough coin :(");
        }
    }

    public void workshop_manager(WorkshopList workshopName) {
        switch (farm.work(workshopName)) {
            case 1 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("Workshop is busy ... !");

                break;
            case 2 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("You don`t have enough product ... !");

                break;
            case 0:

                break;
            case 3:
                OutputProcessor.get_output_Instatnce().ShowOutputError("not such a workshop");

                break;
        }
    }
    public void workshop_builder(WorkshopList workshopNameToBuild){
        switch (farm.build(workshopNameToBuild)){
            case 0 :

                break;
            case 1 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("You need more coin ...!");

                break;
            case 2 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("This workshop is already exist  ...!");

                break;
        }
    }
    public void turn_manager(int time_scale){
        for (int i = 0; i < time_scale; i++) {
            if (farm.turn()){
                OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("level completed");
                loged_in_user.level++;
                FileOperator.Writing(gson.toJson(udb,UserDataBase.class),"data.txt");
                InputProcessor.get_input_Instatnce().menu();
            }
        }
        inquiry_manage();

    }

    public void loading_truck(ProductList productName){
        switch (farm.truck_load(productName)){
            case 0 :

                break;
            case 1 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("Your truck is on the way ...");

                break;
            case 2 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("Storage is not enough ... !");

                break;
            case 3 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("This product does not exist ...");

                break;
            case 4 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("bug :(");

                break;
        }
    }
    public void unloading_truck(ProductList productName){
        switch (farm.truck_unload(productName)){
            case 0 :

                break;
            case 1 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("Your truck is on the way ...");

                break;
            case 2 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("This product does not exist...");

                break;
            case 3 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("The warehouse is full");

                break;
            case 4 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("bug :(");

                break;
        }
    }
    public void go_truck(){
        if(farm.truck_go()){
            OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("Truck leaves farm successfully :) ");
            
        }
        else {
            OutputProcessor.get_output_Instatnce().ShowOutputError("Truck is on the way ... ");
            
        }
    }

    public void inquiry_manage(){

        OutputProcessor.get_output_Instatnce().ShowOutputOfTurn_Inquiry(farm);
        
    }
//    public void Turn_Time() {
//        int Time = farm.turn_cnt;
//        OutputProcessor.get_output_Instatnce().ShowOutputOfTurn_Inquiry(Time);
//    }
//    public void Show_grass(){
//        for (int i = 0; i < farm.maxCol; i++) {
//            for (int j = 0; j < farm.maxRow; j++) {
//                if(farm.grass[i][j]>0) {
//                    System.out.print("["+i+"/t"+j+"]");
//                }
//                else{
//                    System.out.print("_");
//                }
//            }
//        }
//        Domestic_info();
//    }
//    public void Domestic_info(){
//        //TODO : NAME;
//        DomesticAnimal domestic_name = domestics.AnimalName;
//        int Health = domestics.health;
//        int X_position_dom = domestics.x_position;
//        int Y_position_dom = domestics.y_position;
//        //TODO : NAME;
//        WildList wild_name = wilds.name;
//        int Maxcage = wilds.name.maxCage ;
//        int X_position_wild =wilds.x_position;
//        int Y_position_wild =wilds.y_position;
//        //TODO:dog;
//
//    }
//    public void Uncollected_product_info(){
//
//        //name
//        //map-->ok
//        for (int i = 1; i <farm.maxCol+1; i++) {
//            for (int j = 1; j < farm.maxRow+1; j++) {
//                if (!farm.product_map[i][j].isEmpty()){
//                    System.out.print("["+i+"/t"+j+"]");
//                    farm.product_map[i][j].get(0).product.ProductName;
//                }
//            }
//        }
//    }
}
    /*public Manager() {
    }*/

