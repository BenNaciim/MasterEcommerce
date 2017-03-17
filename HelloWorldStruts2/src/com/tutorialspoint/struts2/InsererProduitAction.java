package com.tutorialspoint.struts2;

import com.opensymphony.xwork2.ActionSupport;
import com.tutorialspoint.dataTransfertObject.ProduitDTO;
import com.tutorialspoint.factory.MyFactory;
import com.tutorialspoint.services.IProduitServices;

public class InsererProduitAction extends ActionSupport {
  
  /**
   * 
   */
  private static final long serialVersionUID = 6664996985413808066L;
  private String nom;
  private int quantite;
  private int prix;
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
   * quantite
   */
  public final int getQuantite() {
    return quantite;
  }
  /**
   * @param quantite 
   * la variable quantite est définit
   */
  public final void setQuantite(int quantite) {
    this.quantite = quantite;
  }
  /**
   * retourne la valeur de la variable 
   * prix
   */
  public final int getPrix() {
    return prix;
  }
  /**
   * @param prix 
   * la variable prix est définit
   */
  public final void setPrix(int prix) {
    this.prix = prix;
  }
  public String execute() throws Exception {
    try{
    final IProduitServices produitservice =(IProduitServices)MyFactory.getInstance(IProduitServices.class);
    ProduitDTO produitDto = new ProduitDTO(nom, quantite, prix);
    produitservice.ajouterProduit(produitDto);
    return SUCCESS;
    }
    catch (NumberFormatException e){
    return ERROR;
    }
  }

}
