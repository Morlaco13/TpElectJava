<%@ page import="entidades.Marca"%>
<%@ page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title> Marcas </title>
	</head>
	<body>
		<% LinkedList<Marca> marcas = (LinkedList) request.getSession().getAttribute("marcas"); %>
		<% for ( Marca m : marcas) { %>
			<p>id: <%=m.getIdMarca() %></p>
			<p>nombre: <%=m.getNombre() %></p>
		<% } %>
		
		<a href="index.jsp">Volver a Inicio</a>
	</body>
</html>