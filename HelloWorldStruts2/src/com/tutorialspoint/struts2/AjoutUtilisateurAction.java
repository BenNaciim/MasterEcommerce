package com.tutorialspoint.struts2;

import com.opensymphony.xwork2.ActionSupport;
import com.tutorialspoint.dataTransfertObject.UtilisateurDTO;
import com.tutorialspoint.factory.MyFactory;
import com.tutorialspoint.services.IUtilisateurServices;

public class AjoutUtilisateurAction extends ActionSupport {
  
  private String nom;
  private String prenom;
  private String user;
  private String password;

  /**
   * retourne la valeur de la variable 
   * nom
   */
  public final String getNom() {
    return nom;
  }

  /**
   * @param nom 
   * la variable nom est définit
   */
  public final void setNom(String nom) {
    this.nom = nom;
  }

  /**
   * retourne la valeur de la variable 
   * prenom
   */
  public final String getPrenom() {
    return prenom;
  }

  /**
   * @param prenom 
   * la variable prenom est définit
   */
  public final void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  /**
   * retourne la valeur de la variable 
   * user
   */
  public final String getUser() {
    return user;
  }

  /**
   * @param user 
   * la variable user est définit
   */
  public final void setUser(String user) {
    this.user = user;
  }

  /**
   * retourne la valeur de la variable 
   * password
   */
  public final String getPassword() {
    return password;
  }

  /**
   * @param password 
   * la variable password est définit
   */
  public final void setPassword(String password) {
    this.password = password;
  }

  private static final long serialVersionUID = -4670006123037286643L;

public String execute() throws Exception {
  final IUtilisateurServices utilisateurServices=(IUtilisateurServices)MyFactory.getInstance(IUtilisateurServices.class);
  UtilisateurDTO Utilisateur= new UtilisateurDTO(nom, prenom, user, password);
  utilisateurServices.ajouterUtilisateur(Utilisateur);
  return SUCCESS;
  

}
}