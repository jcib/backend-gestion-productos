<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Página JSP</title>
		
    	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>	
	<body>
		<jsp:include page="header.jsp"/>
		<div class="container">
			<h2>Listado de Pedidos</h2>
			<table class="table">
				<tr>
					<th>Id</th>
					<th>Fecha</th>
					<th>Mesa</th>
					<th>Camarero</th>
					<th>Líneas de pedido</th>
				</tr>
				<c:forEach var="pedido" items="${pedidos}">
				<tr>
					<td>${pedido.id}</td>
					<td>${pedido.fecha}</td>
					<td>${pedido.mesa}</td>
					<td>${pedido.camarero.nombre}</td>
					<td>
					<ol>
					<c:forEach var="linea" items="${pedido.lineasPedido}">
						<li>${linea.id} ${linea.producto.nombre} ${linea.precio}</li>
					</c:forEach>
					</ol>
					</td>
				</tr>	
				</c:forEach>
			</table>
		</div>
	</body>
</html>