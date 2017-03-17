package com.tutorialspoint.dataAccessObject;

import java.util.ArrayList;

import com.tutorialspoint.dataObject.ProduitDO;

public interface IProduitDAO {
  ArrayList<ProduitDO> consulter ();
  void ajouterProduit(ProduitDO produit);
  void supprimerProduit(ProduitDO produit);
  ProduitDO recupererProduit(String nom);
  void majQuantite(String nom,String operateur);

}
