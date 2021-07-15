package control;

public class User {
    String username ;
    String password;
    String email ;
    int level ;
    int reward_coin;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        level = 1;
        reward_coin =0;
    }
}
