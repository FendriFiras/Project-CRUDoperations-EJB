<%@page import="tn.enis.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Ajout un nouveau produit</h1>
		<form action="ShopServlet" method="GET">
			<table>
				<tr>
					<td>name:</td>
					<td><input type="text" name="name" required /></td>
				</tr>
				<tr>
					<td>quantity:</td>
					<td><input type="text" name="quantity" required /></td>
				</tr>
				<tr>
					<td>price:</td>
					<td><input type="text" name="price" required /></td>
				</tr>
			</table>
			<input class="btn btn-success" type="submit" name="action"
				value="add" />
		</form>
		<hr />
		<%
		List<Product> products = (List<Product>) session.getAttribute("Produit");
		float total = 0;
		if (products != null && !products.isEmpty()) {
			for (Product p : products) {
				total= total + p.getPrice();
			}
			}
		%>
		<h2 id="total">le total=<%=total%></h2>
		<table class="table table-striped table-hover">
			<tr>
				<th>name</th>
				<th>quantity</th>
				<th>price</th>
				<th>delete</th>
				<th>edit</th>
			</tr>
			<%
			
			if (products != null && !products.isEmpty()) {
				for (Product p : products) {
			%>
			<tr id='tr<%=p.getId()%>'>
				<th><%=p.getName()%></th>
				<th><%=p.getQuantity()%></th>
				<th><%=p.getPrice()%></th>
				<th><a href=<%="ShopServlet?delete=" + p.getId()%>>delete</a></th>
				<th><a href=<%="ShopServlet?edit=" + p.getId()%>>edit</a></th>
			</tr>
			<%
			}
			}
			%>


		</table>

		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
			crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
		<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>
		<script src="assets/shop.js"></script>
	</div>
</body>
</html>