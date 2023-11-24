<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Alta de producto</title>
	</head>
	<body>
		<h1>Nuevo producto</h1>
		
		<form action="altaProducto" method="post">
			<p><label> ID: </label> <input type="text" name="id"></p>
			<p><label> Descripcion: </label> <input type="text" name="descripcion"></p>
			<p><label> Nombre: </label> <input type="text" name="nombre"></p>
			<p><label> precio: </label> <input type="text" name="precio"></p>
			<p><label> stock: </label> <input type="text" name="stock"></p>
			<p><label> categoria: </label> <input type="text" name="categoria"></p>
			<p><label> marca: </label> <input type="text" name="marca"></p>	
		</form>

	</body>
</html>