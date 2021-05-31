<%@page import="tn.enis.entities.Client"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clients</title>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestion des clients</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<h1>Ajout d'un client</h1>
<form action="ClientServlet" method="POST">

<table>
	<tr>
		<td>cin:</td>
		<td><input type="text" name="cin"/></td>
	</tr>
	<tr>
		<td>Nom:</td>
		<td><input type="text" name="nom"/></td>
	</tr>
	<tr>
		<td>Prénom:</td>
		<td><input type="text" name="prenom"/></td>
	</tr>
	<tr>
		<td>Adresse:</td>
		<td><input type="text" name="adresse"/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" name="add" class="btn btn-primary" value="Add client"/></td>
	</tr>
</table>
</form>

<h1>Liste des clients <a href="CompteServlet?addAccount" name="addAccount" class="btn btn-primary">Add account</a></h1>
<% 
	List<Client> clients=(List<Client>)request.getAttribute("clients");
%>
<table class="table">
	 <thead class="thead-dark">
	<tr>
		<th scope="col">N°</th>
		<th scope="col">Cin</th>
		<th scope="col">Nom</th>
		<th scope="col">Prénom</th>
		<th scope="col">Adresse</th>
		<th scope="col">Delete</th>
		<th scope="col">Edit</th>
		
		
	</tr>
	</thead>
	
	<%
		if(clients != null && !clients.isEmpty()){
			int index=0;
			for(Client client : clients){
				index++;
	%>
		<tr id = "<%=client.getCin() %>">
			<th scope="col"><%=index %></th>
			<th scope="col"><%=client.getCin() %></th>
			<th scope="col"><%=client.getNom() %></th>
			<th scope="col"><%=client.getPrenom() %></th>
			<th scope="col"><%=client.getAdresse() %></th>
			<th scope="col"><a 
			href="javascript:deleteClient(<%=client.getCin()%>)" class="btn btn-danger">Delete</a></th>
			<th scope="col"><form action="ClientServlet" method="POST">	
				<input type="hidden" name="cin" value="<%=client.getCin()%>"/>
				<button name="edit" class="btn btn-success">Edit</button>
				</form>
			</th>
		</tr>
		
		<%}} %>	
		
	<script src="js/clients.js"></script>
	<script src="js/sweetalert.min.js"></script>
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>