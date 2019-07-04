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
			<h2>Listado de Camareros</h2>
			<table class="table">
				<tr>
					<th>Código</th>
					<th>Nombre</th>
					<th>Ejemplo visual</th>
				</tr>
				<c:forEach var="camarero" items="${camareros}">
				<tr>
					<td>${camarero.id}</td>
					<td>${camarero.nombre}</td>
					<td><img src="https://img.stockfresh.com/files/r/robuart/x/53/8017321_66476613.jpg"/></td>
				</tr>	
				</c:forEach>
			</table>
		</div>
	</body>
</html>