<%@ page import="entidades.Marca"%>
<%@ page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<style>
        .form-container {
            display: inline-block;
        }
        
        form {
            display: inline-block;
            margin-right: 10px;
        }
    </style>
	<meta charset="UTF-8">
		<title> Marcas </title>
	</head>
	<body>
		<% LinkedList<Marca> marcas = (LinkedList) request.getSession().getAttribute("marcas"); %>
		<% for ( Marca m : marcas) { %>
			<p>
				<strong> id: </strong><%=m.getIdMarca() %> |
				<strong> Nombre: </strong><%=m.getNombre() %> |
				<div class="form-container" style="display: inline-block;"> <!-- NO SE ALINEAN HORIZONTALMENTE -->
					<form action="FormularioModificarMarca" method="GET" style="display: inline-block;">
					<input type="hidden" name="idMarca" value="<%=m.getIdMarca()%>">
					<button type="submit" > Modificar </button>
					</form>
					<form action="BajaMarca" method="GET" style="display: inline-block;">
					<input type="hidden" name="idMarca" value="<%=m.getIdMarca()%>">
					<button type="submit" > Eliminar </button>
					</form>
				</div>
			</p>
		<% } %>
		
		<a href="index.jsp">Volver a Inicio</a>
	</body>
</html>