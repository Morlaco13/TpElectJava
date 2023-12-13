<%@ page import="entidades.Marca" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title> Modificar Marca </title>
	</head>
	<body>
		<h1> MODIFICAR MARCA </h1>
		<% Marca m = (Marca) request.getSession().getAttribute("m"); %>
		
		<p>
		<Strong>ID: </Strong><%=m.getIdMarca() %> |
		<Strong>Nombre: </Strong><%=m.getNombre() %>
		</p>
		<p>
		<strong>Ingrese el nuevo nombre: </strong>
		
		<form action="ModificarMarca" method="POST">
        <input type="hidden" name="idMarca" value="<%= m.getIdMarca() %>">
		<p><label> Nombre: </label> <input type="text" name="nombre"></p>
		<button type="submit" > Confirmar </button>			
		</p>
		
		<a href="index.jsp">Volver a Inicio</a>
	</body>
</html>