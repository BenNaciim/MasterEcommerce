package com.tutorialspoint.services;

import java.util.HashMap;
import java.util.Map;

import com.tutorialspoint.dataTransfertObject.ProduitDTO;
import com.tutorialspoint.factory.MyFactory;

public class PanierServices implements IPanierServices {
  
  public static IPanierServices instance=new PanierServices();
  
  private PanierServices() {
  }

  public static IPanierServices getInstance() {
    return instance;
}
  
    public Map<String, Integer> initPanier() {
    HashMap<String,Integer> panier=new HashMap<String, Integer>();
    
    return panier;
  }

  public Map<String, Integer> ajouterPanier(Map<String, Integer> panier, String nomProduit) {
    IProduitServices produitServices=(IProduitServices)MyFactory.getInstance(IProduitServices.class);
    ProduitDTO produit=produitServices.recupererProduit(nomProduit);
    if(null!=produit){
      if(panier.containsKey(nomProduit)){
        panier.replace(nomProduit, panier.get(nomProduit)+1);
        produitServices.majQuantite(nomProduit,"-");
      }
      else{
        panier.put(nomProduit,1);
        produitServices.majQuantite(nomProduit,"-");
      } 
    } 
    return panier;
  }

   public Map<String, Integer> retirerPanier(Map<String, Integer> panier, String nomProduit) {
    IProduitServices produitServices=(IProduitServices)MyFactory.getInstance(IProduitServices.class);
    ProduitDTO produit=produitServices.recupererProduit(nomProduit);
    if(!panier.isEmpty()){
    if(null!=produit){
      if(panier.containsKey(nomProduit) && panier.get(nomProduit)==1){
      panier.remove(nomProduit);
      produitServices.majQuantite(nomProduit,"+");
      }
      else{
        panier.replace(nomProduit, panier.get(nomProduit)-1);
        produitServices.majQuantite(nomProduit,"+");
      }
    }
  }
    return panier;
  }

}


