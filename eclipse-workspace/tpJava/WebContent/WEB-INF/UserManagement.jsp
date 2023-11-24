<%@page import="java.util.LinkedList"%>
<%@page import="entidades.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" " http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device.width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" hred="http://getbootsrap.com/favicom.ico">
	<title>E-SHOP UserManagement</title>

	<!-- Bootstrap Core CSS -->
	<link href="style/bootstrap.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="style/start.css" rel="stylesheet">
	<!-- Arriba lo necesario para que funcione -->
	<%
		Persona p = (Persona) session.getAttribute("usuario");
		LinkedList<Persona> lp = (LinkedList<Persona>) request.getAttribute("listaPersonas");
	%>
	<!--  OUTPUT DE CONTENIDO SI ES NECESARIO -->
</head>
<body>
	<div class="container">
		<div class="row">
			<h4>Personas</h4>
				<div class="col-12 col-sm-12 col-lg-12">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>id</th>
									<th>nombre</th>
									<th>apellido</th>
									<th>dni</th>
									<th>telefono</th>
									<th>direccion</th>
									<th>email</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							<% for (Persona per : lp) { %>
								<tr>
									<th><%=p.getIdPersona()%></th>
									<td><%=p.getNombre()%></td>
									<td><%=p.getApellido()%></td>
									<td><%=p.getDni()%></td>
									<td><%=p.getTelefono()%></td>
									<td><%=p.getDireccion()%></td>
									<td><%=p.getEmail()%></td>
									<td>
										<div class="custom-control custom-checkbox">
											<input type="checkbox" class="custom-control-input" id="defaultDisabled" <%=p.isEsAdmin()?"checked":""%> disabled>
											<label class="custom-control-label" for="defaultDisabled"><%=p.isEsAdmin()?"Si":"No"%></label>										
										</div>
									</td>
									<td></td><!-- Columna para editar -->
									<td></td><!-- Columna para borrar -->
								</tr>
							<% } %>
							</tbody>
	</div><!-- /container -->
</body>
</html>