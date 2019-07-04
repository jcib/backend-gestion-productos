<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h2>Alta Camarero</h2>
	<form action="altaCamarero" method="POST">
		<table>
			<tr>
				<td>Código</td>
				<td><input type="number" name ="codigo"/></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><input type="text" name ="nombre"/></td>
			</tr>
		</table>
		<input type="submit" value="Enviar"/>
	</form>
</body>
</html>