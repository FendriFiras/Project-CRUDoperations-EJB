<%@page import="java.util.ArrayList"%>
<%@page import="tn.enis.entities.Client"%>
<%@page import="tn.enis.entities.Compte"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestion des comptes</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
</head>
<body>
<h1>Ajout d'un compte</h1>

<form action="CompteServlet" method="POST">

<table>
	
	<tr>
		<td>Solde:</td>
		<td><input type="text" name="solde"/></td>
	</tr>
	<tr>
		<td>Client:</td>
		<td><input type="text" name="cin" id="tags"/></td>
	</tr>
	
	<tr>
		<td></td>
		<td><input type="submit" name="add" class="btn btn-primary" value="add"/></td>
	</tr>
</table>
</form>

<h1>Liste des comptes <a href="ClientServlet?viewClients" name="viewClients" class="btn btn-primary">View clients</a></h1>
<% 
	List<Compte> comptes=(List<Compte>)request.getAttribute("comptes");
%>
<table class="table">
	 <thead class="thead-dark">
	<tr>
		<th scope="col">N°</th>
		<th scope="col">Rib</th>
		<th scope="col">Solde</th>
		<th scope="col">Client</th>
		<th scope="col">Delete</th>
		<th scope="col">Edit</th>
		
	</tr>
	</thead>
	
	<%
		if(comptes != null && !comptes.isEmpty()){
			int index=0;
			for(Compte compte : comptes){
				index++;
	%>
		<tr id = "<%=compte.getRib() %>">
			<th scope="col"><%=index %></th>
			<th scope="col"><%=compte.getRib() %></th>
			<th scope="col"><%=compte.getSolde() %></th>
			<th scope="col"><%=compte.getClient().getNom() %></th>
			<th scope="col"><a 
			href="javascript:deleteCompte(<%=compte.getRib()%>)" class="btn btn-danger">Delete</a></th>
			<th scope="col"><form action="CompteServlet" method="POST">	
				<input type="hidden" name="rib" value="<%=compte.getRib()%>"/>
				<button name="edit" class="btn btn-success">Edit</button>
				</form>
			</th>
		</tr>
		
	<%}} %>	
		
	<script src="js/comptes.js"></script>
	<script src="js/sweetalert.min.js"></script>
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script src="js/autoComplete.js"></script>

</body>
</html>