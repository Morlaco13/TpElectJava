<%@ page import="entidades.Categoria" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title> Modificar Categoria </title>
	</head>
	<body>
		<h1> Modificar Categoria </h1>
		<% Categoria c = (Categoria) request.getSession().getAttribute("c"); %>
		
		<p>
		<Strong>ID: </Strong><%=c.getIdCategoria() %> |
		<Strong>Nombre: </Strong><%=c.getNombre() %>
		</p>
		<p>
		<strong>Ingrese el nuevo nombre: </strong>
		
		<form action="ModificarCategoria" method="POST">
        <input type="hidden" name="idCategoria" value="<%= c.getIdCategoria() %>">
		<p><label> Nombre: </label> <input type="text" name="nombre"></p>
		<button type="submit" > Confirmar </button>			
		</p>
		
		<a href="index.jsp">Volver a Inicio</a>
	</body>
</html>