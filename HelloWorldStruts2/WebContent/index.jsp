<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Hello World</title>
</head>
<body>
   <h1 id="title">Site Web E-commerce</h1>
   <p id="registration"><a href="AjoutUtilisateur.jsp">Inscription</a></p>
<s:if test="hasActionErrors()">
	<div class="errorDiv">
		<s:actionerror/>
		<ul class="errorMessage">
            <li><span>User name is not valid</span></li>
            <li><span>Password is wrong</span></li>
</ul>
	</div>
</s:if>   
   <form id="loginForm" action="login">
   <h3>Entrez vos identiants</h3>
      <label for="name">Nom Utilisateur</label><br/>
      <input type="text" name="user"/><br/>
      <label for="name">Mot de passe</label><br/>
      <input type="password" name="password"/><br/><br/>
      <input type="submit" value="Connexion"/>
   </form>
</body>
</html>