<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h1>P�gina 3</h1>
	<p>Ficha de Producto</p>
	<table>
		<tr>
			<th>C�digo</th>
			<td>${erProducto.codigo}</td>
		</tr>
		<tr>
			<th>Precio</th>
			<td>${erProducto.precio}</td>
		</tr>
		<tr>
			<th>Descripci�n</th>
			<td>${erProducto.descripcion}</td>
		</tr>
		<tr>
			<th>Fecha de alta</th>
			<td>${erProducto.fechaAlta}</td>
		</tr>
		<tr>
			<th>Descatalogado</th>
			<td>${erProducto.descatalogado}</td>
		</tr>
		<tr>
			<th>Categor�a</th>
			<td>${erProducto.categoria}</td>
		</tr>
	</table> 
</body>
</html>