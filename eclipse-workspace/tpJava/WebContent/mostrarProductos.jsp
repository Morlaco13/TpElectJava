<%@page import="java.util.List"%>
<%@page import="entidades.Producto"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    <title>Mostrar productos</title>
    <style>
        .form-container {
            display: inline-block;
        }
        
        form {
            display: inline-block;
            margin-right: 10px;
        }
    </style>
	</head>
	<body>
		<h1>Lista de productos</h1>
		
		<div class="form-container">
			<form action="OrdenarProductoA" method="GET">
			<button type="submit" > Orden precio ascendente </button>
			</form>
			<form action="OrdenarProductoD" method="GET">
			<button type="submit" > Comprar precio descendente </button>
			</form>
		</div>
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
            	<strong>Categoría:</strong> <%=p.getCat().getNombre() %> |
            	<strong>Marca:</strong> <%=p.getBrand().getNombre() %>
        		</p>
				<% if (p.getStock() == 0) { %>
				<p> Producto no disponible </p>
				<% } %>
				<p>---------------------------------</p>
		<% } %>
		<a href="index.jsp">Volver a Inicio</a>
	</body>
</html>