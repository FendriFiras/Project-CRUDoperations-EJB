<%@page import="tn.enis.dto.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%ProductDto p = (ProductDto) request.getAttribute("editItem"); %>
	<form action="ShopServlet" method="POST">
		<table>
			<tr>
				<td>name:</td>
				<td><input type="text" value="<%=p.getName() %>" name="name" /></td>
			</tr>
			<tr>
				<td>quantity:</td>
				<td><input type="text" value="<%=p.getQuantity() %>" name="quantity" /></td>
			</tr>
			<tr>
				<td>price:</td>
				<td><input type="text" value="<%=p.getPrice() %>" name="price" /></td>
				<td><input type="hidden" name='objItem' value="<%=request.getAttribute("indexItem") %>" name="price" /></td>
			</tr>
		</table>
		<input type="submit" name="action" value="edit" />
	</form>

</body>
</html>