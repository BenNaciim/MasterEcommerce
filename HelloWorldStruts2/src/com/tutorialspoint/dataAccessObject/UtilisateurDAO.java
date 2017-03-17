package com.tutorialspoint.dataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tutorialspoint.dataObject.UtilisateurDO;
import com.tutorialspoint.utils.ConnexionBDD;

public class UtilisateurDAO implements IUtilisateurDAO {
  
  private static final IUtilisateurDAO instance = new UtilisateurDAO();

  private UtilisateurDAO(){
    
  }
  public static IUtilisateurDAO getInstance() {
    return instance;
}
  @Override
  public void ajouterUtilisateur(UtilisateurDO utilisateur) {
    final Connection connection=ConnexionBDD.getConnection();
    try{
      connection.setAutoCommit(false);
      final String request ="insert into utilisateurs (nom,prenom,user,password) Values (?,?,?,?)";
      final PreparedStatement statement=connection.prepareStatement(request);
      statement.setString(1,utilisateur.getNom());
      statement.setString(2,utilisateur.getPrenom());
      statement.setString(3, utilisateur.getUser());
      statement.setString(4, utilisateur.getPassword());
      statement.executeUpdate();
      connection.commit();
      
      
    }
    catch(SQLException e){
      throw new RuntimeException("echec de la fermeture de la connexion : "+e.getMessage());
    }
    
  }
  @Override
  public UtilisateurDO recupererInformation(int id) {
    final Connection connection=ConnexionBDD.getConnection();
    UtilisateurDO utilisateurDo=new UtilisateurDO();
    try{
      connection.setAutoCommit(false);
      final String request ="select * from utilisateurs where id= ?";
      final PreparedStatement statement=connection.prepareStatement(request);
      statement.setInt(1,id);
      ResultSet rs = statement.executeQuery();
      while(rs.next()){
         utilisateurDo=new UtilisateurDO(rs.getInt(1), rs.getString(2),  rs.getString(3),  rs.getString(4),  rs.getString(5)); 
      }
      return utilisateurDo;
      
    }
    catch(SQLException e){
      throw new RuntimeException("echec de la fermeture de la connexion : "+e.getMessage());
    }
  }
  @Override
  public void supprimerUtilisateur(int id) {
   final Connection connection=ConnexionBDD.getConnection();
   try{
     connection.setAutoCommit(false);
     final String request ="DELETE into utilisateurs Values (?)";
     final PreparedStatement statement=connection.prepareStatement(request);
     statement.setInt(1,id);
     statement.executeUpdate();
     connection.commit();
     
     
   }
   catch(SQLException e){
     throw new RuntimeException("echec de la fermeture de la connexion : "+e.getMessage());
   }
    
  }
}
