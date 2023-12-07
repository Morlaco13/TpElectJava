<%@ page import="entidades.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Modificar USUARIO</title>
	</head>
	<body>
		<h1>MODIFICAR USUARIO</h1>
		<%	Persona p = (Persona) request.getSession().getAttribute("p");	%>
		
			<p>id: <%=p.getIdPersona() %></p>
			<p>Apellido: <%=p.getApellido() %></p>
			<p>Nombre: <%=p.getNombre() %></p>
			<p>DNI: <%=p.getDni() %></p>
			<p>Telefono: <%=p.getTelefono() %></p>
			<p>Direccion: <%=p.getDireccion() %></p>
			<p>Email: <%=p.getEmail() %></p>		
			<p>Es Admin: <%=p.isEsAdmin() %></p>
			<p>Password: <%=p.getPassword() %></p>
			
			<h2>Elementos a modificar</h2>
			
			<form action="ConfirmarModificacionUser" method="POST">
			<input type="hidden" name="id" value="<%= p.getIdPersona() %>">
			<p><label> Apellido: </label> <input type="text" name="apellido" required></p>
			<p><label> Nombre: </label> <input type="text" name="nombre" required></p>
			<p><label> DNI: </label> <input type="text" name="dni" required></p>
			<p><label> Telefono: </label> <input type="text" name="telefono" required></p>
			<p><label> Direccion: </label> <input type="text" name="direccion" required></p>
			<p><label> Email: </label> <input type="text" name="email" required></p>	
			<p>---------------ALERTA----------------</p>
			
			<p> 1: Admin --- 0: Usuario</p>
			<p><label> Es Admin: </label> <input type="text" name="admin" required></p>
			<p><label> Password: </label> <input type="text" name="password" required></p>	
			<button type="submit" > Modificar Usuario </button>
			</form>
			
			<a href="index.jsp">Volver a Inicio</a>

	</body>
</html>