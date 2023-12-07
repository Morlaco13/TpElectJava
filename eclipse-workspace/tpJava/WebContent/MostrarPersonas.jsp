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
		<p>Para Eliminar un usuario completa el campo</p>
		<form action="EliminarUsuario" method="POST">
		<p><label> ID: </label> <input type="text" name="id"></p>
        <button type="submit" > Eliminar Usuario </button></form>
        
        <p>---------------------------------</p>
        
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
        	<form action="ModificarUsuario" method="POST">
        	<input type="hidden" name="id" value="<%= p.getIdPersona() %>">
        	<button type="submit" > Modificar Usuario </button></form><!-- MANDAMOS ID PARA MAYOR SEGURIDAD -->

			<p>---------------------------------</p>
		<% } %>
    	
    	<a href="index.jsp">Volver a Inicio</a>
	</body>
</html>