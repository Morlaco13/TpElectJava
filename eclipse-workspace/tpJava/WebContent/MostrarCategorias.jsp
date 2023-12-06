<%@ page import="entidades.Categoria"%>
<%@ page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title> Categorias </title>
	</head>
	<body>
		<% LinkedList<Categoria> categorias = (LinkedList) request.getSession().getAttribute("categorias"); %>
		<% for ( Categoria c : categorias ) { %>
			<p>id: <%=c.getIdCategoria() %></p>
			<p>nombre: <%=c.getNombre() %></p>
		<% } %>
		
		<a href="index.jsp">Volver a Inicio</a>
	</body>
</html>