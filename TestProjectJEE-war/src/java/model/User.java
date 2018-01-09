package model;
public class User {
    
    // properties
    private String id = "";
    private String name = "";
    private String firstname = "";
    private String lastname = "";
    private String password = "";
    private Boolean auth = false; 
    
    public User() {
    }
    
    // getters and setters

    public boolean getAuth(){
        return this.auth;
    }

    public void setAuth(boolean auth){
        this.auth = auth;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public String getFirstname(){
        return this.firstname;
    }
    
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    
    public String getLastname(){
        return this.lastname;
    }
    
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    
    public String getId(){
        return this.id;
    }

    public String getPassword(){
        return this.password;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setPassword(String password){
        this.password = password;
    }



}