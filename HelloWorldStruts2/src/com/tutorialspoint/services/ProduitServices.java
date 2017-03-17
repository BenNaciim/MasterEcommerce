package com.tutorialspoint.services;

import java.util.ArrayList;

import com.tutorialspoint.dataAccessObject.IProduitDAO;
import com.tutorialspoint.dataObject.ProduitDO;
import com.tutorialspoint.dataTransfertObject.ProduitDTO;
import com.tutorialspoint.factory.MyFactory;

public class ProduitServices implements IProduitServices{
  
  public static IProduitServices instance= new ProduitServices();
  
  private ProduitServices(){
    
  }
  public static IProduitServices getInstance(){
    return instance;
  }
  
  @Override
  public ArrayList<ProduitDTO> consulter() {
    ArrayList<ProduitDTO> Produits=new ArrayList<ProduitDTO>();
    IProduitDAO produitServicesDao = (IProduitDAO)MyFactory.getInstance(IProduitDAO.class);
    ArrayList<ProduitDO> produitDo=produitServicesDao.consulter();
    for (ProduitDO produit : produitDo) {
      ProduitDTO produitDto=convertDoDto(produit);
      Produits.add(produitDto);
    }
    return Produits;
  }
  @Override
  public void ajouterProduit(ProduitDTO produit) {
    IProduitDAO produitServicesDao = (IProduitDAO)MyFactory.getInstance(IProduitDAO.class);
    ProduitDO produitDo = convertDtoDo(produit);
    produitServicesDao.ajouterProduit(produitDo);
    
  }
  
  @Override
  public void supprimerProduit(ProduitDTO produit) {
    IProduitDAO produitServicesDao = (IProduitDAO)MyFactory.getInstance(IProduitDAO.class);
    ProduitDO produitDo = convertDtoDo(produit);
    produitServicesDao.supprimerProduit(produitDo);
    
  }
  
  @Override
  public void majQuantite(String nom, String operateur) {
  IProduitDAO produitServicesDao =(IProduitDAO)MyFactory.getInstance(IProduitDAO.class);
  produitServicesDao.majQuantite(nom,operateur);
    
    
  }
  private ProduitDO convertDtoDo(ProduitDTO produit) {
    ProduitDO produitDo=new ProduitDO(produit.getNomProduit(),produit.getQuantite(),produit.getPrix());
    return produitDo;
  }
  
  private ProduitDTO convertDoDto (ProduitDO produit){
    ProduitDTO produitDto =new ProduitDTO(produit.getNomProduit(), produit.getQuantite(), produit.getPrix());
    return produitDto;
  }
  @Override
  public ProduitDTO recupererProduit(String nom) {
    IProduitDAO produitServicesDao= (IProduitDAO)MyFactory.getInstance(IProduitDAO.class);
    ProduitDO produitDo=produitServicesDao.recupererProduit(nom);
    ProduitDTO produitDto=convertDoDto(produitDo);
    return produitDto;
  }

  
  
  

}
