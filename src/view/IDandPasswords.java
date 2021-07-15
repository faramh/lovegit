package view;

import java.util.HashMap;

public class IDandPasswords {
    HashMap<String,String> logininfo = new HashMap<String,String>();

    public IDandPasswords(){

        logininfo.put("Matin","Ahmadi");
        logininfo.put("Daniel","Rasti");

    }

    public HashMap getLoginInfo(){
        return logininfo;
    }
}
