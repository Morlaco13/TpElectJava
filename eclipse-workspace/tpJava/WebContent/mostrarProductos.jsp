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
				<p>
            	<strong>ID:</strong> <%=p.getIdProducto() %> |
            	<strong>Descripción:</strong> <%=p.getDescripcion() %> |
            	<strong>Nombre:</strong> <%=p.getNombre() %> |
            	<strong>Precio:</strong> <%=p.getPrecio() %> |
            	<strong>Stock:</strong> <%=p.getStock() %> |
            	<strong>Categoría:</strong> <%=p.getCat() %> |
            	<strong>Marca:</strong> <%=p.getBrand() %>
        		</p>
		
				<p>---------------------------------</p>
		<% } %>

	</body>
</html>