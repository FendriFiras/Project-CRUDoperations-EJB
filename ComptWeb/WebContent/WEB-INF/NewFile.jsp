<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<!-- 
		
	<%
	/*
	List<ProductDao> products = (List<ProductDao>) request.getAttribute("products");
	*/%>
	<h2 id="total">le total=<%=//request.getAttribute("total")%></h2>
	<table class="table table-striped table-hover">
		<tr>
			<th>name</th>
			<th>quantity</th>
			<th>price</th>
			<th>delete</th>
			<th>edit</th>
		</tr>
		<%/*
		if (products != null && !products.isEmpty()) {
			for (ProductDao p : products) {
		*/%>
		<tr id='tr<%=//products.indexOf(p)%>'>
			<th><%=//p.getName()%></th>
			<th><%=//p.getQuantity()%></th>
			<th><%=//p.getPrice()%></th>
			<th><a href="javascript:deleteProduct(<%=//products.indexOf(p)%>)">delete</a></th>
			<th><a href=<%=//"ShopServlet?edit=" + products.indexOf(p)%>>edit</a></th>
		</tr>
}
}
		%>
		
		
	</table>
	
	 -->
</body>
</html>