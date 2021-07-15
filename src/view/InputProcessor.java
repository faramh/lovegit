package view;

import java.util.Scanner;
import control.Manager;
public class InputProcessor {

    //private Manager manager;
    //private OutputProcessor outputProcessor;
    // private InstructionProcessor instructionProcessor = new InstructionProcessor() ;

    public Scanner scanner = new Scanner(System.in);

    public void login(){
        OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("Login Panel Stated !");
        String choose_state = scanner.nextLine();
        if(choose_state.equalsIgnoreCase("LOG IN")){

            OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("USERNAME :");
            String username_input = scanner.nextLine();

            OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("PASSWORD :");
            String password_input = scanner.nextLine();

            Manager.get_manager_Instatnce().login_Check(username_input,password_input);
        }
        else if(choose_state.equalsIgnoreCase("SIGNUP")){
            OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("USERNAME :");
            String username_input = scanner.nextLine();

            OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("EMAIL : *******@gmail.com ");
            String user_email = scanner.nextLine();

            OutputProcessor.get_output_Instatnce().ShowOutputUserNotice("PASSWORD :");
            String password_input = scanner.nextLine();

            Manager.get_manager_Instatnce().signup_Password_Check(username_input,password_input);
        }
        else{
            OutputProcessor.get_output_Instatnce().ShowOutputError("INCORRECT INPUT ! ");
        }
    }

    public void menu(){
        String menu_input = scanner.nextLine();
        menu_input = menu_input.toUpperCase();

        if(menu_input.startsWith("START")){
            if(Manager.get_manager_Instatnce().level_Check(parsing_String(menu_input))){
                InstructionProcessor.get_instruction_Instatnce().UnderstandInstruction();
            }
            else{
                menu();
            }
        }
        else if(menu_input.equalsIgnoreCase("LOG OUT")){
            login();
        }
        else if(menu_input.equalsIgnoreCase("SETTINGS")){
            OutputProcessor.get_output_Instatnce().ShowOutputError("Completing ...  ");
        }
        else if(menu_input.equalsIgnoreCase("EXIT")){
            System.exit(0);
        }
        else{
            OutputProcessor.get_output_Instatnce().ShowOutputError("INCORRECT INPUT ! ");
        }
    }
       /* public void output_set(OutputProcessor op){
            this.  OutputProcessor.get_output_Instatnce() = op;
        }*/

    private int parsing_String (String menu_input){
        String[] level = menu_input.split(" ");
        return Integer.parseInt(String.valueOf(level[1]));
    }

    // Singleton Design
    // Only one State Instance should exist
    private static InputProcessor input_state;
    public static InputProcessor get_input_Instatnce(){
        if (input_state==null){
            input_state = new InputProcessor();
        }
        return input_state;
    }
}


