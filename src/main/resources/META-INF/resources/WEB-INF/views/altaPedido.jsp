<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Página de inicio</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h2>Alta Producto</h2>
	<form action="altaPedido" method="POST">
		<table>
			<tr>
				<td>Fecha de Pedido</td>
				<td><input type="date" name ="fecha"/></td>
			</tr>
			<tr>
				<td>Mesa</td>
				<td><input type="number" step="mesa"/></td>
			</tr>
			<tr>
				<td>Camarero</td>
				<td>
					<select name="idCamarero">
						<c:forEach var="camarero" items="${camareros}">
							<option value="${camarero.id}">${camarero.nombre}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Descatalogado</td>
				<td>
					<input type="checkbox" name="descatalogado" value="true"/>
				</td>
			</tr>
		</table>
		<input type="submit" value="Enviar"/>
	</form>
</body>
</html>