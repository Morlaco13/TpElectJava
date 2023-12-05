<%@page import="entidades.Venta"%>
<%@page import="entidades.LineaVenta"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Mi Carrito</title>
	</head>
	<body>
		<h1>Productos en el carrito: </h1>
		<% Venta v = (Venta) request.getSession().getAttribute("venta"); %>
		<% if (v != null){ %>
		<% List<LineaVenta> lineaVenta = v.getLineas();
		   	int subtotal = 0;
			for(LineaVenta lv : lineaVenta){
				subtotal += (lv.getPrecioUnit()*lv.getCant());
		%>
			<p>
			<strong>Nombre:</strong> <%=lv.getProd().getNombre() %> |
			<strong>Descripcion:</strong> <%=lv.getProd().getDescripcion() %> |
			<strong>Cantidad:</strong> <%=lv.getCant() %>
			<strong>Precio:</strong> <%=lv.getPrecioUnit() %> |
			<strong>SubTotal:</strong> <%=(lv.getPrecioUnit()*lv.getCant())  %>
			
			<form action="EliminarLineaVenta" method="GET">
				<input type="hidden" name="idProducto" value="<%= lv.getProd().getIdProducto() %>">	
            	<button type="submit" > Eliminar </button>
            </form>
			</p>

         <% } %>
			<% if (subtotal != 0) { %>
			<form>
         	<p><strong>Total de carrito: </strong></p><%=subtotal %>
         	</form>
        		<form action="NuevaCompra" method="GET"> 
            		<button type="submit" > Seguir Comprando </button>
            	</form>

        		<form action="FinalizarCompra" method="POST"> 
            		<button type="submit" > Confirmar </button>
            	</form>
            <% } else { %>
            <p> CARRITO VACIO </p>
            <% } %>
            <% } else { %>
            	<p> CARRITO VACIO </p>
            <% } %>
            
            <a href="index.jsp">Volver a Inicio</a>
	</body>
</html>