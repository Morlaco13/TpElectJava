<%@page import="java.util.List"%>
<%@page import="entidades.Producto"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Mostrar productos</title>
	</head>
	<body>
		<h1>Lista de productos</h1>
		<%
			List<Producto> listaProductos = (List<Producto>) request.getSession().getAttribute("prods");
			for(Producto p : listaProductos){
		%>
				<p>id: <%=p.getIdProducto() %></p>
				<p>descripcion: <%=p.getDescripcion() %></p>
				<p>nombre: <%=p.getNombre() %></p>
				<p>precio: <%=p.getPrecio() %></p>
				<p>stock: <%=p.getStock() %></p>
				<p>categoria: <%=p.getCat() %></p>
				<p>marca: <%=p.getBrand() %></p>
		
				<p>---------------------------------</p>
		<% } %>

	</body>
</html>