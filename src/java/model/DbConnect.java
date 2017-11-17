package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
  private Connection connection = null;
    
  public DbConnect () {      
    try {
      Class.forName("com.mysql.jdbc.Driver");

      String url = "jdbc:derby://localhost:1527/BASESTAG";
      String user = "adm";
      String passwd = "adm";

      connection = DriverManager.getConnection(url, user, passwd);
      System.out.println("Connexion effective !");         
         
    } catch (Exception e) {
      e.printStackTrace();
    }      
  }
  
  public Connection getConnection (){
      return connection;
  }
  
  public void disconnect () throws SQLException{
      if (connection != null)
        connection.close();
  }
}