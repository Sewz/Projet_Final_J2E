package model;

public class User {
    private String _username;
    private String _pw;
    
    public User (String username, String pw){
        this._username = username;
        this._pw = pw;
    }
    
    public void setUsername(String username){
        this._username = username;
    }
    
    public String getUsername(){
        return this._username;
    }
    
    public void setPassword(String pw){
        this._pw = pw;
    }
    
    public String getPassword(){
        return this._pw;
    }
}
