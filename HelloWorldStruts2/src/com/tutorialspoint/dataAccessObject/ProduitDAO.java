package com.tutorialspoint.dataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tutorialspoint.dataObject.ProduitDO;
import com.tutorialspoint.utils.ConnexionBDD;

public class ProduitDAO implements IProduitDAO {
  
  public static IProduitDAO instance=new ProduitDAO();
  
  private ProduitDAO(){
    
  }
  public static IProduitDAO getInstance(){
    return instance;
  }
  
  @Override
  public ArrayList<ProduitDO> consulter() {
    final Connection connexion=ConnexionBDD.getConnection();
    ArrayList<ProduitDO> produits=new ArrayList<ProduitDO>();
    try{
     connexion.setAutoCommit(false);
     final String request="select * from produits";
     PreparedStatement statement=connexion.prepareStatement(request);
     ResultSet result=statement.executeQuery();  
     while(result.next()){
       ProduitDO produitDo=new ProduitDO(result.getString(2), result.getInt(3), result.getInt(4));
       produits.add(produitDo);
     }
     
    }
    catch (SQLException e){
      throw new RuntimeException("echec de la fermeture de la connexion : "+e.getMessage());
    }
    return produits;
  }
  @Override
  public void ajouterProduit(ProduitDO produit) {
    final Connection connexion=ConnexionBDD.getConnection();
try{
  connexion.setAutoCommit(false);
  final String request="insert into produits (nomProduit,quantite,prix) VALUES(?,?,?)";
  PreparedStatement statement=connexion.prepareStatement(request);
  statement.setString(1, produit.getNomProduit());
  statement.setInt(2, produit.getPrix());
  statement.setInt(3, produit.getQuantite());
  statement.executeUpdate();
  connexion.commit();
}
catch(SQLException e){
  throw new RuntimeException("echec de la fermeture de la connexion : "+e.getMessage());
}
}
  @Override
  public void supprimerProduit(ProduitDO produit) {
    final Connection connexion=ConnexionBDD.getConnection();
try{
  connexion.setAutoCommit(false);
  final String request="Delete from produits where nomProduit= ? and quantite=? and prix=? ";
  PreparedStatement statement=connexion.prepareStatement(request);
  statement.setString(1, produit.getNomProduit());
  statement.setInt(2, produit.getPrix());
  statement.setInt(3, produit.getQuantite());
  statement.executeUpdate();
  connexion.commit();
}
catch(SQLException e){
  throw new RuntimeException("echec de la fermeture de la connexion : "+e.getMessage());
}
}
  @Override
  public ProduitDO recupererProduit(String nom) {
    final Connection connexion=ConnexionBDD.getConnection();
    ProduitDO produitDo = null;
        try{
          connexion.setAutoCommit(false);
          final String request="Select * from produits where nomProduit= ? ";
          PreparedStatement statement=connexion.prepareStatement(request);
          statement.setString(1, nom);
          ResultSet result=statement.executeQuery();  
          while(result.next()){
            produitDo=new ProduitDO(result.getString(2), result.getInt(3), result.getInt(4));
                     }
        }
        catch(SQLException e){
          throw new RuntimeException("echec de la fermeture de la connexion : "+e.getMessage());
        }
    return produitDo;
  }
  @Override
  public void majQuantite(String nom, String operateur) {
    final Connection connexion=ConnexionBDD.getConnection();
    try{
      connexion.setAutoCommit(false);
      final String request="update produits set quantite=quantite"+operateur+"1"+" where nomProduit= ? ";
      PreparedStatement statement=connexion.prepareStatement(request);
      statement.setString(1, nom);
      statement.executeUpdate();
      statement.close();
      connexion.commit();
    }
    catch(SQLException e){
      throw new RuntimeException("echec de la fermeture de la connexion : "+e.getMessage());
    }
  }  
}

