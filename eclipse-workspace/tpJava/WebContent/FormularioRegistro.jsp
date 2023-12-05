<%@page import="entidades.Persona" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title> Nueva cuenta </title>
	</head>
	<body>
		<h1> REGISTRO </h1>

		<h1> Datos del Usuario </h1>
		<% Persona p = (Persona) request.getSession().getAttribute("p"); %>
		<% if (p != null ) { %>
			<p> DNI en uso </p>
		<% } %>
		<form action="AltaUsuario" method="POST">
		<p><label> Nombre: </label> <input type="text" name="nombre"></p>
		<p><label> Apellido: </label> <input type="text" name="apellido"></p>
		<p><label> DNI: </label> <input type="text" name="dni"></p>
		<p><label> Telefono: </label> <input type="text" name="telefono"></p>
		<p><label> Direccion: </label> <input type="text" name="direccion"></p>
		<p><label> Email: </label> <input type="text" name="email"></p>
		<p><label> Contraseña: </label> <input type="text" name="password"></p>		
		<button type="submit" > Confirmar registro </button>
		</form>
		
		<a href="index.jsp">Volver a Inicio</a>
	</body>
</html>