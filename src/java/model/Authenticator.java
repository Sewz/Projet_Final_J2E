package model;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Authenticator {
    public String authenticate(String username, String password) throws SQLException {
        DbConnect dbConnec = new DbConnect();
        Connection connection = dbConnec.getConnection();
        
        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM USERS");
        
        // Check si l'user existe
        boolean usernameFound = false;
        boolean passwordGood = false;
        while (result.next() && !usernameFound){
            String myUsername = result.getString("username");
            String myPassword = result.getString("password");
            if (username.equals(myUsername)){
                usernameFound = true;
                if (password.equals(myPassword)){
                    passwordGood = true;
                }
            }
        }
       
        dbConnec.disconnect();
        
        if (passwordGood) {
            return "success";
        } else {
            return "failure";
        }
    }
}