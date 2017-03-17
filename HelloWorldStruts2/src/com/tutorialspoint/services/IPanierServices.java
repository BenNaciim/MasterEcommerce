package com.tutorialspoint.services;

import java.util.Map;

public interface IPanierServices {
   Map<String,Integer> initPanier();
   Map<String,Integer> ajouterPanier(final Map <String,Integer> panier, String nomProduit);
   Map<String,Integer> retirerPanier(final Map <String,Integer> panier, String nomProduit);
   
   
}
