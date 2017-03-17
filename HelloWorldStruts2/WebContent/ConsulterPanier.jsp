<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Votre Panier</title>
</head>
<body>
   MR <s:property value="#session.Nom" /><br/>
      
   <p>Nombre d'Article : <s:property value="#session.Article"/></p>
   <table>
<tr>
<td>Nom Produit</td>
<td>Quantité</td>
<td>Prix Unitaire</td>
</tr>
    <s:iterator value="#session.Panier">
   <tr>
   <td><s:property value="key"/></td>
   <td><s:property value="value"/></td>
   
 
   </tr>
   	</s:iterator>
   	
   	
   	
   </table>
  <a href="Accueil.jsp"> <button>Retour</button></a>
</body>
</html>