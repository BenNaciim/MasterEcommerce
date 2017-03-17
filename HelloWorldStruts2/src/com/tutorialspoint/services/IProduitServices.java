package com.tutorialspoint.services;

import java.util.ArrayList;

import com.tutorialspoint.dataTransfertObject.ProduitDTO;

public interface IProduitServices {
  ArrayList<ProduitDTO> consulter ();
  void ajouterProduit (ProduitDTO produit);
  void supprimerProduit(ProduitDTO produit);
  ProduitDTO recupererProduit(String nom);
  void majQuantite(String nom,String operateur);

}
