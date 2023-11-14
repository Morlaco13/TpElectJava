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
	
		<p>id: <%=p.getIdPersona() %></p>
		<p>Nombre: <%=p.getNombre() %></p>
		<p>Apellido: <%=p.getApellido() %></p>
		<p>Dni: <%=p.getDni() %></p>
		<p>Telefono: <%=p.getTelefono() %></p>
		<p>Direccion: <%=p.getDireccion() %></p>
		<p>Email: <%=p.getEmail() %></p>
		<p>EsAdmin: <%=p.isEsAdmin() %></p>
		<p>password: <%=p.getPassword() %></p>
		
		<p>---------------------------------</p>

	</body>
</html>