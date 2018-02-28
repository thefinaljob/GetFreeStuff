package com.example.mapwithmarker;

/**
 * Created by operam on 12/16/2017.
 */

public class UserLoginInfo {


    private String username;
    private String password;

    public UserLoginInfo(String username, String password){
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean authenticate(String enterUsername, String enterPassword){
        if(enterPassword.equals(password) && enterUsername.equals(username)){
            return true;
        }
        else{
            return false;
        }

    }

}
