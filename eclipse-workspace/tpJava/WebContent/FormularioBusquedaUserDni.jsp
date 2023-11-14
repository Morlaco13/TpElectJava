<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1> Buscar usuario por Dni </h1>
		<form action="BuscarUsuarioDni" method="POST">
		<p><label> Dni: </label> <input type="text" name="dni"></p>
		<button type="submit" > Buscar usuario</button>
		</form>
	</body>
</html>