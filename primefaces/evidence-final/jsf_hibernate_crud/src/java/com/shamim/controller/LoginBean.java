package com.shamim.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Shamim
 */
@ManagedBean
@ViewScoped
public class LoginBean {

    String username;
    String password;

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

    public String validate(){
        if(username.equals("shamim") && password.equals("shamim")){
            return "display";
        }else{
            return "error";
        }
    }
}
