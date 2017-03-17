package com.tutorialspoint.struts2;

import java.sql.Connection;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tutorialspoint.dataTransfertObject.ProduitDTO;
import com.tutorialspoint.factory.MyFactory;
import com.tutorialspoint.services.IPanierServices;
import com.tutorialspoint.services.IProduitServices;
import com.tutorialspoint.utils.ConnexionBDD;

public class AjouterProduitPanierAction extends ActionSupport {
  /**
   * 
   */
  private static final long serialVersionUID = -8890746630457075718L;
  private String nomProduit;
  final String ATTR_ARTICLE= "Article";
  final String ATTR_PANIER= "Panier";
  final String ATTR_CATALOGUE="Catalogue";
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
 
  public String execute() throws Exception {
    String ret=ERROR;

    final Connection conn=ConnexionBDD.getConnection();
      try{
        Map<String, Object> session=ActionContext.getContext().getSession();
        Map <String,Integer> panier=(Map<String, Integer>) session.get("Panier");
        int article=(int) session.get(ATTR_ARTICLE);
        final IPanierServices panierServices=(IPanierServices)MyFactory.getInstance(IPanierServices.class);
        final IProduitServices produitService=(IProduitServices)MyFactory.getInstance(IProduitServices.class);
        ProduitDTO produit=produitService.recupererProduit(nomProduit);
        if(produit.getQuantite()>1){
        panier=panierServices.ajouterPanier(panier, nomProduit);
        session.put(ATTR_CATALOGUE, produitService.consulter());
        session.put(ATTR_PANIER,panier);
        session.put(ATTR_ARTICLE,article +1);
        ret = SUCCESS;
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

}
