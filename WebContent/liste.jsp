<%@ page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,client.Client,artisan.Artisan"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Annuaire</title>
</head>
<body>

<%
	ArrayList<Client> personnes = (ArrayList<Client>) request.getAttribute("Utilsateurs") ;
	if(personnes == null)
		personnes = new ArrayList<Client>();
%>
Liste des personnes :
</br>
<ul>
	<%
		for ( Client personne : personnes ) {
	%>
		<li> <%= "Name : " + personne.getName() %> 
			</br> <% if (personne.getEmail() != null) { %>
			<%= "Email : " + personne.getEmail() + " - Password : " + personne.getPassword()   %> 
			 <% } %>
		</li>
	<% } %>
</ul>
</br>

<a href="index.html">  <li> Accueil </li> </a>

</body>
</html>