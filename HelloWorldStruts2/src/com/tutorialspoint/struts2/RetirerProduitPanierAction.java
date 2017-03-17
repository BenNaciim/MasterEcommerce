package com.tutorialspoint.struts2;

import java.sql.Connection;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tutorialspoint.factory.MyFactory;
import com.tutorialspoint.services.IPanierServices;
import com.tutorialspoint.services.IProduitServices;
import com.tutorialspoint.utils.ConnexionBDD;

public class RetirerProduitPanierAction extends ActionSupport {
  Map<String, Object> session;
  String nomProduit;
  String ATTR_PANIER = "Panier";
  String ATTR_ARTICLE = "Article";
  final String ATTR_CATALOGUE="Catalogue";
  /**
   * retourne la valeur de la variable nomProduit
   */
  public final String getNomProduit() {
    return nomProduit;
  }

  /**
   * @param nomProduit la variable nomProduit est définit
   */
  public final void setNomProduit(String nomProduit) {
    this.nomProduit = nomProduit;
  }

  /**
   * 
   */
  private static final long serialVersionUID = 8577467811652431893L;


  public String execute() throws Exception {
    String ret = ERROR;

    final Connection conn = ConnexionBDD.getConnection();
    try {
      IPanierServices panierServices = (IPanierServices) MyFactory.getInstance(IPanierServices.class);
      final IProduitServices produitService=(IProduitServices)MyFactory.getInstance(IProduitServices.class);
      Map<String, Object> session = ActionContext.getContext().getSession();
      int article = (int) session.get(ATTR_ARTICLE);
      final Map<String, Integer> panier = (Map<String, Integer>) session.get("Panier");
      
      if (article > 0) {
        panierServices.retirerPanier(panier, nomProduit);
        session.put(ATTR_CATALOGUE, produitService.consulter());
        session.put(ATTR_PANIER, panier);
        session.put(ATTR_ARTICLE, article - 1);
        ret = SUCCESS;
      }
      else{
        ret=ERROR;
      }
    } catch (Exception e) {} finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (Exception e) {}
      }
    }
    return ret;
  }
}
