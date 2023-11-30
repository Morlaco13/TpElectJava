<%@page import="java.util.List"%>
<%@page import="entidades.Categoria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Categorias</title>
	</head>
<body>
		<h1>Categorias</h1>
		<%
			List<Categoria> listaCategorias = (List<Categoria>) request.getSession().getAttribute("cats");
			for(Categoria c : listaCategorias){
		%>
				<p>
            	<strong>ID:</strong> <%=c.getIdCategoria()%> |
            	<strong>Nombre:</strong> <%=c.getNombre()%> |
            	
            	<a href="BuscarTodosPorCategoria?idCategoria=<%=c.getIdCategoria()%>">Mostrar Productos</a>
        		</p>
		<% } %>
		<a href="index.jsp">Volver a Inicio</a>
	</body>