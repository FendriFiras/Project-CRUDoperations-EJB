<%@page import="tn.enis.entities.Compte"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit compte</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

	<%
		Compte compte = (Compte) request.getAttribute("compte");
	%>
		<h1>Edit d'un compte dont le rib est <%=compte.getRib()%></h1>
	<form action="CompteServlet" method="POST">
	<td><input type="hidden" name="rib" value="<%=compte.getRib()%>"></td>
			
		<table>
	<!--  	<tr>
				<th scope="col">Rib :</th>
			</tr> -->
			<tr>
				<th scope="col">Solde :</th>
				<th scope="col"><input type="text" name="solde" value="<%=compte.getSolde()%>"></th>
			</tr>
			<tr>
				<th scope="col">Client :</th>
				<th scope="col"><input type="text" name="cin" value="<%=compte.getClient().getCin()%>"></th>
				
			</tr>
			<tr>
				<th></th>
				<th scope="col"><input type="submit" name="update" value="update"></th>
			</tr>
		</table>
	</form>

</body>
</html>