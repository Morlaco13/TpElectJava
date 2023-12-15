<%@page import="entidades.Venta"%>
<%@page import="entidades.LineaVenta"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Compra Realizada </title>
	</head>
	<body>
		<h1>Compra realizada</h1>		
			<% Venta v = (Venta) request.getSession().getAttribute("venta");
			   int subtotal = 0;
			   List<LineaVenta> lineaVenta = v.getLineas();
			%>
		<h2>Detalles de la compra:</h2>
		<p>
		<strong>Numero de compra:</strong><%=v.getIdVenta() %>
		<strong>Fecha: </strong><%=v.getFechaVenta() %></p>
		<p> </p>
		<p>
		<strong>A nombre de:</strong><%=v.getPer().getNombre() + " " + v.getPer().getApellido() %>
		<strong>Direccion: </strong><%=v.getPer().getDireccion() %>
		</p>
		<p><strong>PRODUCTOS: </strong></p>
			
		<%	
			for(LineaVenta lv : lineaVenta) {
				subtotal += (lv.getPrecioUnit()*lv.getCant());
		%>
			<p>
			<strong>Nombre:</strong> <%=lv.getProd().getNombre() %> |
			<strong>Descripcion:</strong> <%=lv.getProd().getDescripcion() %> |
			<strong>Cantidad:</strong> <%=lv.getCant() %>
			<strong>Precio:</strong> <%=lv.getPrecioUnit() %> |
			<strong>SubTotal:</strong> <%=(lv.getPrecioUnit()*lv.getCant())  %>
			</p>

         <% } %>
			
			<p><strong>TOTAL de compra: </strong></p><%=subtotal %>
			
			<% HttpSession misession = request.getSession();
			v = null;
				misession.setAttribute("venta", v);
			%> <!-- UNICA FORMA DE LIMPIAR EL CARRITO QUE CONSEGUIMOS -->
			
			<form action="NuevaCompra" method="GET">
            <button type="submit" > Seguir Comprando </button>
            </form>	

            <a href="index.jsp">Volver a Inicio</a>
	</body>
</html>