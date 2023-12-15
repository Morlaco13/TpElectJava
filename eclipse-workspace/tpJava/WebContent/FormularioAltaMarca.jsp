<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title> Nueva Marca </title>
	</head>
	<body>
		<h1> Nueva Marca </h1>
		
		<form action="AltaMarca" method="POST">
		<p><label> Nombre: </label> <input type="text" name="nombre"></p>
		<button type="submit" > Confirmar </button>
		</form>
		
		<a href="index.jsp">Volver a Inicio</a>
	</body>
</html>