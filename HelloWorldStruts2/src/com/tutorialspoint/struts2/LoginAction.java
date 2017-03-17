package com.tutorialspoint.struts2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.tutorialspoint.factory.MyFactory;
import com.tutorialspoint.services.IPanierServices;
import com.tutorialspoint.services.IProduitServices;
import com.tutorialspoint.utils.ConnexionBDD;

public class LoginAction extends ActionSupport implements SessionAware  {
  
  
  private Map<String, Object> session;
  private static final long serialVersionUID = 6819181275155784772L;
  private String user;
  private String password;
  final String ATTR_NOM = "Nom";
  final String ATTR_PANIER = "Panier";
  final String ATTR_CATALOGUE = "Catalogue";
  final String ATTR_ARTICLE= "Article";
  final String MSG_ERREUR = "Nom Utilisateur ou mot de passe incorrecte";
  /**
   * retourne la valeur de la variable user
   */
  public final String getUser() {
    return user;
  }

  /**
   * @param user la variable user est définit
   */
  public final void setUser(String user) {
    this.user = user;
  }

  /**
   * retourne la valeur de la variable password
   */
  public final String getPassword() {
    return password;
  }

  /**
   * @param password la variable password est définit
   */
  public final void setPassword(String password) {
    this.password = password;
  }
  public String execute() throws Exception {
String ret=INPUT;

final Connection conn=ConnexionBDD.getConnection();
  try{
 
    String request="select * from utilisateurs where user = ? and password = ?";
    PreparedStatement ps = conn.prepareStatement(request);
    ps.setString(1, user);
    ps.setString(2, password);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
      if(user.equals(rs.getString(2)) && password.equals(rs.getString(3))){
        
        session.put(ATTR_NOM, rs.getString(4));
        final IPanierServices panierService=(IPanierServices)MyFactory.getInstance(IPanierServices.class);
        session.put(ATTR_PANIER,panierService.initPanier());
        final IProduitServices produitService=(IProduitServices)MyFactory.getInstance(IProduitServices.class);
        session.put(ATTR_CATALOGUE, produitService.consulter());
        session.put(ATTR_ARTICLE, 0);
      ret = SUCCESS;
      }
      else{
        addActionError(MSG_ERREUR);
      }
    }
       
  }
  catch (Exception e) {
 } finally {
    if (conn != null) {
       try {
          conn.close();
       } catch (Exception e) {
       }
    }
 }
 return ret;
 }
public void validate() {
  
  
};
  @Override
  public void setSession(Map<String, Object> map) {
   session=map;
    
  }
  public final Map<String, Object> getSession() {
    return session;
  }


}
