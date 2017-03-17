<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Accueil</title>
</head>
<body>
   Bienvenue, MR <s:property value="#session.Nom" /><br/>
      
   <p>Nombre d'Article : <s:property value="#session.Article"/></p>
   <p><a href="<s:url action="ConsulterPanierAction">
   <s:param name="Panier" value="#session.Panier"/>
   </s:url>">Consulter votre panier</a></p>
   <p><a href="AjoutProduit.jsp">Ajouter un produit</a></p>
   <table>
<tr>
<td>Nom Produit</td>
<td>Prix</td>
<td>Quantité</td>
<td>Ajouter au panier</td>
<td>Supprimer du panier</td>
</tr>
   <s:iterator value="#session.Catalogue">
   <tr>
   <td><s:property value="nomProduit"/></td>
   <td><s:property value="prix"/></td>
   <td><s:property value="quantite"/></td>
   <td>
   <a href="<s:url action="ajoutProduitPanier">
   <s:param name="nomProduit" value="nomProduit"/>
   </s:url>">
   <button>+</button>
   </a>
   </td>
   <td>
   <a href="<s:url action="RetirerProduitPanier">
   <s:param name="nomProduit" value="nomProduit"/>
   </s:url>">
   <button>-</button>
   </a>
</td>
   </tr>
   	</s:iterator>
   </table>
</body>
</html>