<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> E-shop </title>º
	</head>
	<body>
		
		<h1> COMPRA </h1>
		<form action="NuevaCompra" method="GET">
		<button type="submit" > Comprar productos</button>
		</form>
		
		<h1> PRODUCTOS </h1>
		<h1> </h1>
		<form action="BuscarTodosProducto" method="GET">
		<button type="submit" > Mostrar productos</button>
		</form>

		<form action="FormularioBusquedaPorIdServlet" method="POST">
		<button type="submit" > Buscar producto por ID</button>
		</form>
		
		<form action="FormularioAltaProductoServlet" method="POST">
		<button type="submit" > alta producto</button>
		</form>
		
		<form action="FormularioBajaProductoServlet" method="POST">
		<button type="submit" > baja producto</button>
		</form>
		
		<form action="FormularioModificarProductoServlet" method="POST">
		<button type="submit" > Modificar producto</button>
		</form>
		
		<h1> USUARIOS </h1>
		<h1> </h1>
		
		<form action="BuscarTodosUsuarios" method="POST">
		<button type="submit" >Listar usuarios</button>
		</form>
		
		<form action="FormularioBusquedaUserPorIdServlet" method="POST">
		<button type="submit" > Buscar Usuario por ID</button>
		</form>

		<form action="FormularioBusquedaPorDniServlet" method="POST">
		<button type="submit" > Buscar usuario por DNI</button>
		</form>
		
	</body>
</html>