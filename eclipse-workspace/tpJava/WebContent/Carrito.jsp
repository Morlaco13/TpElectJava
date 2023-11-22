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
		<% Venta v = (Venta) request.getSession().getAttribute("venta");
		   List<LineaVenta> lineaVenta = v.getLineas();
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
			</p>

         <% } %>

         	<p><strong>Subtotal de carrito: </strong></p><%=subtotal %>
         	</form>
        	<form action="NuevaCompra" method="POST"> 
            <button type="submit" > SeguirComprando </button>
            </form>
			</form>
        	<form action="FinalizarCompra" method="POST"> 
            <button type="submit" > Confirmar </button>
            </form>
            </form>
        	<form action="EliminarLineaVenta" method="POST"> 
            <button type="submit" > Eliminar producto </button>
            </form>
	</body>
</html>