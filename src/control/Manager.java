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

    public void login_Check(String  username_input , String password_input){
        switch (udb.log_in_check(username_input,password_input)){
            case SUCCESS:
                OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("Success");
                loged_in_user = udb.current_user;
                OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("wellcome "+ loged_in_user.username);
                //InputProcessor.get_input_Instatnce().menu();
                new Menu_frame();
                break;
            case USERNAME_DOSENT_EXIST:
                OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("Username doesn't exist");
                InputProcessor.get_input_Instatnce().login();
                break;
            case INCORRECT_PASSWORD:
                OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("Incorrect password");
                InputProcessor.get_input_Instatnce().login();
                break;
        }
    }

    public void signup_Password_Check(String  username_input , String password_input){
        switch (udb.sing_up_check(username_input,password_input)){
            case SUCCESS:
                FileOperator.Writing(gson.toJson(udb,UserDataBase.class),"data.txt");
                OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("Signed up successfully");
                loged_in_user = udb.current_user;
                //InputProcessor.get_input_Instatnce().menu();
                //login_Panel.get_login_Panel_Instatnce().music(false);
                new Menu_frame();
                break;
            case ALREADY_EXIST:
                OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("This username already exist ");
                login_Panel.get_login_Panel_Instatnce().frame.setVisible(false);
               // login_Panel.get_login_Panel_Instatnce().music(1);
                login_Panel.get_login_Panel_Instatnce().reset_key();
                new Menu_frame();

                break;
            case WEAK_PASSWORD:
                OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("The password is too weak"); // todo
                InputProcessor.get_input_Instatnce().login();
                break;
            case INVALID_USERNAME:
                OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("Invalid username"); //todo
                InputProcessor.get_input_Instatnce().login();
                break;
        }
    }

    public void workshop_upgrade (WorkshopList label){
        switch (farm.upgrade(label)){
            case 1:
                OutputProcessor.get_output_Instatnce().ShowOutputError("not enough coin");
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;
            case 2:
                OutputProcessor.get_output_Instatnce().ShowOutputError("doesnt exist");
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;
            case 0:
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;

        }


    }

    public boolean level_Check(int level){
        if (loged_in_user.level>=level){
            OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("starting level "+ level);
            farm = new Farm(all_tasks[level-1],loged_in_user.reward_coin);
            return true;
        }
        else{
            OutputProcessor.get_output_Instatnce().ShowOutputError("you haven't unlocked this level yet");
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

        InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
    }

    public void plant_manage(int x,int y) {
        if (farm.plant(x, y)) {
            InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
        }
        else {
            OutputProcessor.get_output_Instatnce().ShowOutputError("Your watering system is not ready to use ... !");
            InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
        }
    }

    public void pickup_manage(int x,int y){
        switch (farm.pick_up(x,y)) {
            case 0:
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;
            case 1:
                OutputProcessor.get_output_Instatnce().ShowOutputError("This Coordinates is empty ... !");
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;
            case 2:
                OutputProcessor.get_output_Instatnce().ShowOutputError("No SPACE ... !");
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break; }
    }

    public void cage_manage(int x,int y){
        farm.cage(x,y);
        InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
    }

    public void buy_domestic_animal(DomesticAnimal domesticName){
        if(farm.buy(domesticName)){
            InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
        }
        else{
            OutputProcessor.get_output_Instatnce().ShowOutputError("You need more coins ... !");
            InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
        }
    }
    public void buy_cat(){
        if(farm.buy_cat()){
            InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
        }
        else{
            OutputProcessor.get_output_Instatnce().ShowOutputError("You don`t have enough coin :(");
            InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
        }
    }

    public void buy_dog(){
        if(farm.buy_dog()){
            InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
        }
        else{
            OutputProcessor.get_output_Instatnce().ShowOutputError("You don`t have enough coin :(");
            InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
        }
    }

    public void workshop_manager(WorkshopList workshopName) {
        switch (farm.work(workshopName)) {
            case 1 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("Workshop is busy ... !");
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;
            case 2 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("You don`t have enough product ... !");
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;
            case 0:
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;
            case 3:
                OutputProcessor.get_output_Instatnce().ShowOutputError("not such a workshop");
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;
        }
    }
    public void workshop_builder(WorkshopList workshopNameToBuild){
        switch (farm.build(workshopNameToBuild)){
            case 0 :
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;
            case 1 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("You need more coin ...!");
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;
            case 2 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("This workshop is already exist  ...!");
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
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
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;
            case 1 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("Your truck is on the way ...");
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;
            case 2 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("Storage is not enough ... !");
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;
            case 3 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("This product does not exist ...");
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;
            case 4 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("bug :(");
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;
        }
    }
    public void unloading_truck(ProductList productName){
        switch (farm.truck_unload(productName)){
            case 0 :
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;
            case 1 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("Your truck is on the way ...");
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;
            case 2 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("This product does not exist...");
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;
            case 3 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("The warehouse is full");
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;
            case 4 :
                OutputProcessor.get_output_Instatnce().ShowOutputError("bug :(");
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
                break;
        }
    }
    public void go_truck(){
        if(farm.truck_go()){
            OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("Truck leaves farm successfully :) ");
            InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
        }
        else {
            OutputProcessor.get_output_Instatnce().ShowOutputError("Truck is on the way ... ");
            InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
        }
    }

    public void inquiry_manage(){

        OutputProcessor.get_output_Instatnce().ShowOutputOfTurn_Inquiry(farm);
        InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
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

