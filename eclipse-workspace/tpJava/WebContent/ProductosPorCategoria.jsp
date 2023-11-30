<%@page import="java.util.List"%>
<%@page import="entidades.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Producto por categoria</title>
	</head>
	<body>
		<h1>Lista de productos de la Categoria</h1>
		<%
			List<Producto> listaProductos = (List<Producto>) request.getSession().getAttribute("prods");
			for(Producto p : listaProductos){
		%>
				<p>
            	<strong>ID:</strong> <%=p.getIdProducto() %> |
            	<strong>Descripción:</strong> <%=p.getDescripcion() %> |
            	<strong>Nombre:</strong> <%=p.getNombre() %> |
            	<strong>Precio:</strong> <%=p.getPrecio() %> |
            	<strong>Stock:</strong> <%=p.getStock() %> |
            	<strong>Categoría:</strong> <%=p.getCat() %> |
            	<strong>Marca:</strong> <%=p.getBrand() %>
            	<form action="NuevaLineaVenta" method="POST">
            	<input type="hidden" name="idProducto" value="<%= p.getIdProducto() %>">
				<p><label> Cantidad: </label> <input type="text" name="cantidad"></p>
				<button type="submit" > Cargar al carrito</button>
				</form>
        						
		
				<p>---------------------------------</p>
		<% } %>
		<a href="index.jsp">Volver a Inicio</a>
	</body>
</html>