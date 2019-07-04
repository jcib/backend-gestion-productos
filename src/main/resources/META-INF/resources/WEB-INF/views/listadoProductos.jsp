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
			<h2>Listado de Productos</h2>
			<table class="table">
				<tr>
					<th>Código</th>
					<th>Nombre</th>
					<th>Descripción</th>
					<th>Precio</th>
					<th>Categoría</th>
					<th>Fecha de alta</th>
					<th>¿Descatalogado?</th>
					<th>Ejemplo visual</th>
				</tr>
				<c:forEach var="producto" items="${productos}">
				<tr>
					<td>${producto.codigo}</td>
					<td>${producto.nombre}</td>
					<td>${producto.descripcion}</td>
					<td>${producto.precio}</td>
					<td>${producto.categoria}</td>
					<td><fmt:formatDate type = "date" 
        			 value = "${producto.fechaAlta}" /></td>
					<td>${producto.descatalogado}</td>
					<td><img src="https://mi8.rightinthebox.com/images/50x50/201706/vrroxj1498025375968.jpg"/></td>
				</tr>	
				</c:forEach>
			</table>
		</div>
	</body>
</html>