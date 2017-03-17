<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>E-commerce Inscription</title>
</head>
<body>
   <h1 id="title">Inscription</h1>
   <form id="formulaireInscription"  action="ajout">
   <h3> Veuillez Remplir les champs suivants</h3>
      <label for="name">Nom</label><br/>
      <input type="text" name="nom"/><br/>
      <label for="name">Prenom</label><br/>
      <input type="text" name="prenom"/><br/>
      <label for="name">Nom Utilisateur</label><br/>
      <input type="text" name="user"/><br/>
      <label for="name">Mot de passe</label><br/>
      <input type="password" name="password"/><br/><br/>
      <input type="submit" value="Confirmer"/>
   </form>
</body>
</html>