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
			<p>
            	<strong>ID:</strong> <%=p.getIdPersona() %> |
            	<strong>Nombre:</strong> <%=p.getNombre() %> |
            	<strong>Apellido:</strong> <%=p.getApellido() %> |
            	<strong>dni:</strong> <%=p.getDni() %> |
            	<strong>Telefono:</strong> <%=p.getTelefono() %> |
            	<strong>direccion:</strong> <%=p.getDireccion() %> |
            	<strong>email:</strong> <%=p.getEmail() %> |
            	<strong>esAdmin:</strong> <%=p.isEsAdmin() %> |
            	<strong>password:</strong> <%=p.getPassword() %> |
        	</p>

			<p>---------------------------------</p>
		<% } %>
		<a href="index.jsp">Volver a Inicio</a>
	</body>
</html>