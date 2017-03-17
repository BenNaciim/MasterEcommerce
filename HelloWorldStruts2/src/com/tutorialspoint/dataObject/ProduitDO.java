package com.tutorialspoint.dataObject;

public class ProduitDO {
private String nomProduit;
private int quantite;
private int prix;
/**
 * retourne la valeur de la variable 
 * nomProduit
 */
public final String getNomProduit() {
  return nomProduit;
}
/**
 * @param nomProduit 
 * la variable nomProduit est définit
 */
public final void setNomProduit(String nomProduit) {
  this.nomProduit = nomProduit;
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
public ProduitDO(){
  
  
}
public ProduitDO(String nomProduit, int quantite, int prix){
  this.nomProduit=nomProduit;
  this.quantite=quantite;
  this.prix=prix;
  
}
}
