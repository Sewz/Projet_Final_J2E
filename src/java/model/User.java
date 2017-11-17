package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hugo
 */
public class User {
    private String login;
    private String pw;
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public String getLogin(){
        return this.login;
    }
    
    public void setPw(String pw){
        this.pw = pw;
    }
    
    public String getPw(){
        return this.pw;
    }
}
