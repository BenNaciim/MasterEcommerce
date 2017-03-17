package com.tutorialspoint.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBDD {

  public static Connection getConnection(){
    Connection connexion=null;
    try{
      String url="jdbc:mysql://localhost/ecommerce_db";
      
      Class.forName("com.mysql.jdbc.Driver");
      connexion = DriverManager.getConnection(url, "root","root");
    }
    catch (final ClassNotFoundException e) {
      throw new RuntimeException("Drivers MySQL indisponibles." + e.getMessage());
  } catch (final SQLException e) {
      throw new RuntimeException("Connexion à base de données impossible." + e.getMessage());
  }
    return connexion;
  }
  
  public static void fermetureConnexion(final Connection connexion) {
    if (connexion != null) {
        try {
            connexion.close();
        } catch (final SQLException e) {
            throw new RuntimeException("echec de la fermeture de la connexion : "+e.getMessage());
            
        }
    }

}

}
