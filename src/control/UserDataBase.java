package control;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;


public class UserDataBase {
    private ArrayList<User> dataBase = new ArrayList<>();
    private FileOperator fo;
    public User current_user;

    public ErrorLabel log_in_check (String username , String password){
        boolean username_existance = false;
        boolean correct_password = false;
        for (User u :dataBase) {
            if (u.username.equals(username)){
                username_existance = true;
                if (u.password.equals(password)){
                    correct_password = true;
                    current_user = u;
                }
                break;
            }
        }
        if (!username_existance)
            return ErrorLabel.USERNAME_DOSENT_EXIST;
        if (correct_password) {
            return ErrorLabel.SUCCESS;
        }
        else
            return ErrorLabel.INCORRECT_PASSWORD;

    }

    public ErrorLabel sing_up_check (String username , String password){
        boolean exist = false ;
        for (User u:dataBase) {
            if (u.username.equals(username) ){
                exist = true;
                break;
            }
        }
        if (exist){
            return ErrorLabel.ALREADY_EXIST;
        }

        if (!username_check(username)){
            return ErrorLabel.INVALID_USERNAME;
        }
        if (!password_check(password)){
            return ErrorLabel.WEAK_PASSWORD;
        }
        current_user = new User(username,password);
        dataBase.add(current_user);
        return ErrorLabel.SUCCESS;


    }
    public boolean username_check (String un){
        //todo
        return true;
    }
    public boolean password_check (String pw){
        //todo
        return true;
    }


}

enum ErrorLabel{
    SUCCESS,
    USERNAME_DOSENT_EXIST,
    INCORRECT_PASSWORD,
    WEAK_PASSWORD,
    ALREADY_EXIST,
    INVALID_USERNAME;
}
