<%@ page import="entidades.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Modificar producto</title>
	</head>
	<body>
		<%	Producto p = (Producto) request.getSession().getAttribute("prod");	%>
		
			<p>id: <%=p.getIdProducto() %></p>
			<p>descripcion: <%=p.getDescripcion() %></p>
			<p>nombre: <%=p.getNombre() %></p>
			<p>precio: <%=p.getPrecio() %></p>
			<p>stock: <%=p.getStock() %></p>
			<p>categoria: <%=p.getCat().getNombre() %></p>
			<p>marca: <%=p.getBrand().getNombre() %></p>
			
			<p>----------------------------------------</p>
			
			<p>Elementos a modificar</p>
			
			<form action="ConfirmarModificacion" method="POST">
			<input type="hidden" name="idProducto" value="<%= p.getIdProducto() %>">
			<p><label> Descripcion: </label> <input type="text" name="descripcion"></p>
			<p><label> Nombre: </label> <input type="text" name="nombre"></p>
			<p><label> precio: </label> <input type="number" name="precio"></p>
			<p><label> stock: </label> <input type="number" name="stock"></p>
			<p><label> categoria: </label> <input type="text" name="categoria"></p>
			<p><label> marca: </label> <input type="text" name="marca"></p>		
			<button type="submit" > Modificar producto </button>
			</form>
			
			<a href="index.jsp">Volver a Inicio</a>

	</body>
</html>