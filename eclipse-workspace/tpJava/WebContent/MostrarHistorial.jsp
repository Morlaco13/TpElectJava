<%@ page import="entidades.Venta" %>
<%@ page import="entidades.LineaVenta" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title> Historial </title>
	</head>
	<body>
		<% ArrayList<Venta> historialVenta = (ArrayList) request.getSession().getAttribute("historialVenta"); %>
		<% for ( Venta v : historialVenta) { %>
			<p>ID Venta: <%=v.getIdVenta() %></p> |
			<p>Fecha: <%=v.getFechaVenta() %></p> |
			
			<% List<LineaVenta> lineaVentas = v.getLineas(); %>
			<% for ( LineaVenta lv : lineaVentas ) { %>	
					<p></p> FALTA TERMINAR
			<% } %>
		<% } %>
		
		<a href="index.jsp">Volver a Inicio</a>
	</body>
</html>