<%@page import="entidades.LineaVenta"%>
<%@page import="entidades.Producto"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Producto encontrado</title>
	</head>
	<body>
		<%	Producto p = (Producto) request.getSession().getAttribute("p");
			LineaVenta nuevaLineaVenta = (LineaVenta) request.getSession().getAttribute("nuevaLineaVenta");
			
			if (nuevaLineaVenta != null) {
				p = nuevaLineaVenta.getProd();
			}
		%>
		
			<p>id: <%=p.getIdProducto() %></p>
			<p>descripcion: <%=p.getDescripcion() %></p>
			<p>nombre: <%=p.getNombre() %></p>
			<p>precio: <%=p.getPrecio() %></p>
			<p>stock: <%=p.getStock() %></p>
			<p>categoria: <%=p.getCat() %></p>
			<p>marca: <%=p.getBrand() %></p>
			
			<form action="BajaProducto" method="POST" >
			<button type="submit" > Borrar producto </button>
			</form>
		
			<!-- Si HAY NUEVA LINEAVENTA MUESTRO EL FORMULARIO -->
    		<% if (nuevaLineaVenta != null && nuevaLineaVenta.getProd().getIdProducto() == p.getIdProducto()) { %>
        	<form action="GuardarLineaVenta" method="POST">
        	<input type="hidden" name="idProducto" value="<%= p.getIdProducto() %>">
            <p><label> Cantidad: </label> <input type="text" name="cantidad" value="<%= nuevaLineaVenta.getCant() %>"></p>
            <button type="submit" > Confirmar </button>
        	</form>
        	<form action="ProductosPorCategoria" method="POST"> 
            <button type="submit" > Volver </button>
            </form>
   			<% } %>
			
	</body>
</html>