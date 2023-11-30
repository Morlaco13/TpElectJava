<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1> Baja producto </h1>
		<h1> Ingrese ID del producto </h1>
		<form action="BuscarProductoPorId" method="GET">
		<p><label> ID: </label> <input type="text" name="id"></p>
		<button type="submit" > Buscar producto</button>
		
		<a href="index.jsp">Volver a Inicio</a>
	</body>
</html>