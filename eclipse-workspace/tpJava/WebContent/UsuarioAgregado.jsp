<%@page import="entidades.Persona" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title> REGISTRO </title>
	</head>
	<body>
		<h1> REGISTRO </h1>
		<% Persona p = (Persona) request.getSession().getAttribute("p"); %>
		<% if (p != null){ %>
			<p>Bienvenido <%=p.getNombre() %> <%=p.getApellido() %></p>
			<p><strong> Email de inicio de sesion: </strong><%=p.getEmail() %></p>
		<% } else { %>
			<p> CUENTA EXISTENTE ( DNI en uso )</p>
		<% } %>
		
		<a href="index.jsp">Volver a Inicio</a>
	</body>
</html>