<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Ajout d'un produit</title>
</head>
<body>
   <h1 id="title">Formulaire d'ajout Produit</h1>
   <form id="formulaireInscription"  action="ajoutProduit">
   <h3> Veuillez Remplir les champs suivants</h3>
      <label for="name">Nom</label><br/>
      <input type="text" name="nom"/><br/>
      <label for="name">Prix</label><br/>
      <input type="text" name="Prix"/><br/>
      <label for="name">Quantité</label><br/>
      <input type="text" name="Quantite"/><br/>
         <input type="submit" value="Ajouter"/>
   </form>
</body>
</html>