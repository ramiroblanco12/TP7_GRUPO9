<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AGREGAR</title>
</head>
<body>
<a href="Inicio">INICIO</a>
<a href="AgregarSeguro">AGREGAR SEGURO</a>
<a href="ListarSeguro">LISTAR SEGURO</a>

<form action="AgregarSeguro.jsp" method="get">

<h1>Agregar seguros</h1>

<table>
<tr>
	<td>Id Seguro</td>
	<td><%
	int IDSeguro=2;
	%>
	<%= IDSeguro %></td>
</tr>
<tr>
	<td>Descripción</td>
	<td><input type="text" name="txtDescripcion"></td>
</tr>
<tr>
	<td>Tipo de seguro:</td>
	<td><select name="tipoSeguro">
		<option>Seguro de casa</option>
		<option>Seguro de auto</option>
		<option>Seguro de vida</option>
		</select></td>            
</tr>
<tr>
	<td>Costo contratación:</td>
	<td><input type="text" name="txtCostocontratacion"></td>
</tr>
<tr>
	<td>Costo máximo asegurado:</td>
	<td><input type="text" name="txtCostomaximo"></td>
</tr>
<tr>
	<td></td>
	<td><input type="submit" value="Aceptar" name="btnAceptar"></td>
</tr>
</table>

</form>
</body>
</html>