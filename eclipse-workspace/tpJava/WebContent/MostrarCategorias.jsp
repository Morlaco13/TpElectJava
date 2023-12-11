<%@ page import="entidades.Categoria"%>
<%@ page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title> Categorias </title>
	</head>
	<body>
		<% LinkedList<Categoria> categorias = (LinkedList) request.getSession().getAttribute("categorias"); %>
		<% for ( Categoria c : categorias) { %>
			<p>
				<strong> id: </strong><%=c.getIdCategoria() %> |
				<strong> Nombre: </strong><%=c.getNombre() %> |
				<div class="form-container" style="display: inline-block;"> <!-- NO SE ALINEAN HORIZONTALMENTE -->
					<form action="ModificarCategoria" method="GET" style="display: inline-block;">
					<input type="hidden" name="idCategoria" value="<%=c.getIdCategoria()%>">
					<button type="submit" > Modificar </button>
					</form>
					<form action="BajaCategoria" method="GET" style="display: inline-block;">
					<input type="hidden" name="idCategoria" value="<%=c.getIdCategoria()%>">
					<button type="submit" > Eliminar </button>
					</form>
				</div>
			</p>
		<% } %>
		
		<a href="index.jsp">Volver a Inicio</a>
	</body>
</html>