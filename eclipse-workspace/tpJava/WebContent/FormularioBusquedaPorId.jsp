<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1> Buscar por ID producto </h1>
		<form action="BuscarProductoPorId" method="POST">
		<p><label> ID: </label> <input type="text" name="id"></p>
		<button type="submit" > Buscar producto</button>
		</form>
		
		<a href="index.jsp">Volver a Inicio</a>
	</body>
</html>