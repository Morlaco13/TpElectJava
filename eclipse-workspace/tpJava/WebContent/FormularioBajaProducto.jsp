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
		
		<p><label> descripcion: </label> <input type="text" name="descripcion"></p>
		<p><label> Nombre: </label> <input type="text" name="nombre"></p>
		<p><label> precio: </label> <input type="text" name="precio"></p>
		<p><label> stock: </label> <input type="text" name="stock"></p>
		<p><label> categoria: </label> <input type="text" name="categoria"></p>
		<p><label> marca: </label> <input type="text" name="marca"></p>		
		<form action="BajaProducto" method="POST">
		<button type="submit" > Borrar producto</button>
		</form>
	</body>
</html>