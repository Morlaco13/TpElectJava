<%@page import="entidades.Persona"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Mostrar Usuario</title>
	</head>
	<body>
		<%	Persona p = (Persona) request.getSession().getAttribute("p");	%>
	
		<p><strong>id: </strong><%=p.getIdPersona() %></p>
		<p><strong>Nombre: </strong><%=p.getNombre() %></p>
		<p><strong>Apellido: </strong><%=p.getApellido() %></p>
		<p><strong>Dni: </strong><%=p.getDni() %></p>
		<p><strong>Telefono: </strong><%=p.getTelefono() %></p>
		<p><strong>Direccion: </strong><%=p.getDireccion() %></p>
		<p><strong>Email: </strong><%=p.getEmail() %></p>
		<p><strong>EsAdmin: </strong><%=p.isEsAdmin() %></p>
		<p><strong>password: </strong><%=p.getPassword() %></p>
		
		<p>---------------------------------</p>

		<a href="index.jsp">Volver a Inicio</a>
	</body>
</html>