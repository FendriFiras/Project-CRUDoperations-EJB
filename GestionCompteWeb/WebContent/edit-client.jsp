<%@page import="tn.enis.entities.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit client</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

	<%
		Client client = (Client) request.getAttribute("client");
	%>
		<h1>Edit client dont le cin est <%=client.getCin()%></h1>
	<form action="ClientServlet" method="POST">
	<td><input type="hidden" name="cin" value="<%=client.getCin()%>"></td>
			
		<table>
	<!--  	<tr>
				<th scope="col">Rib :</th>
			</tr> -->
			<tr>
				<th scope="col">Nom:</th>
				<th scope="col"><input type="text" name="nom" value="<%=client.getNom()%>"></th>
			</tr>
			<tr>
				<th scope="col">Prénom :</th>
				<th scope="col"><input type="text" name="prenom" value="<%=client.getPrenom()%>"></th>
				
			</tr>
			<tr>
				<th scope="col">Adresse :</th>
				<th scope="col"><input type="text" name="adresse" value="<%=client.getAdresse()%>"></th>
				
			</tr>
			<tr>
				<th></th>
				<th scope="col"><input type="submit" name="update" value="update" class="btn btn-primary"></th>
			</tr>
		</table>
	</form>
	
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>