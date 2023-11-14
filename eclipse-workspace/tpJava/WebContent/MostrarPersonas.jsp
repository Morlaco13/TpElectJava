<%@page import="java.util.List"%>
<%@page import="entidades.Persona"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Mostrar personas</title>
	</head>
	<body>
		<h1>Lista de personas</h1>
		<%
			List<Persona> personas = (List<Persona>) request.getSession().getAttribute("pers");
			for(Persona p : personas){
		%>
				<p>id: <%=p.getIdPersona() %></p>
				<p>nombre: <%=p.getNombre() %></p>
				<p>apellido: <%=p.getApellido() %></p>
				<p>dni: <%=p.getDni() %></p>
				<p>telefono: <%=p.getTelefono() %></p>
				<p>direccion: <%=p.getDireccion() %></p>
				<p>email: <%=p.getEmail() %></p>
				<p>esAdmin: <%=p.isEsAdmin() %></p>
				<p>password: <%=p.getPassword() %></p>

				<p>---------------------------------</p>
		<% } %>

	</body>
</html>