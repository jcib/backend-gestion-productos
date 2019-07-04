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
	<h1>Página 4</h1>
	<p>Ficha de Camarero</p>
	<table>
		<tr>
			<th>Id</th>
			<td>${erCamarero.id}</td>
		</tr>
		<tr>
			<th>Nombre</th>
			<td>${erCamarero.nombre}</td>
			
		</tr>
	</table> 
</body>
</html>