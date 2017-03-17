package com.tutorialspoint.dataObject;


public class UtilisateurDO {

  private int id;
  private String nom;
  private String prenom;
  private String user;
  private String password;
  
  public UtilisateurDO(){
    
  }
  public UtilisateurDO (final int id, final String nom, final String prenom, String user,String password){
    this.id=id;
    this.nom=nom;
    this.prenom=prenom;
    this.user=user;
    this.password=password;
  }

  /**
   * retourne la valeur de la variable 
   * id
   */
  public final int getId() {
    return id;
  }

  /**
   * @param id 
   * la variable id est définit
   */
  public final void setId(int id) {
    this.id = id;
  }

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
 
  


}
