<%@page import="tn.enis.entity.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Product p = (Product) request.getAttribute("editItem");
	%>
	<form action="ShopServlet" method="POST">
		<table>
			<tr>
				<td>name:</td>
				<td><input type="text" value="<%=p.getName()%>" name="name" /></td>
			</tr>
			<tr>
				<td>quantity:</td>
				<td><input type="text" value="<%=p.getQuantity()%>"
					name="quantity" /></td>
			</tr>
			<tr>
				<td>price:</td>
				<td><input type="text" value="<%=p.getPrice()%>" name="price" /></td>
			</tr>
		</table>
		<input type="hidden" name="action" value="<%=p.getId()%>" />
		<input type="submit"  value="Edit" />
	</form>

</body>
</html>