<%@page import="dominio.TipoSeguros"%>
<%@page import="java.util.ArrayList"%>
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

<form action="AgregarSeguro.jsp" method="post">

<h1>Agregar seguros</h1>

<table>
<tr>
	<td>Id Seguro</td>
	<td>
	<%= request.getAttribute("siguienteId") %></td>
</tr>
<tr>
	<td>Descripción</td>
	<td><input type="text" name="txtDescripcion"></td>
</tr>
                   
	
<% 
ArrayList<TipoSeguros> listaTipoSeguros = null;
if (request.getAttribute("listaTipoSeguros") != null) {
    listaTipoSeguros = (ArrayList<TipoSeguros>) request.getAttribute("listaTipoSeguros");
}
%>

<tr>
    <td>Tipo de seguro:</td>
    <td>
        <select name="tipoSeguro">
            <% 
            if (listaTipoSeguros != null) {
                for (TipoSeguros tipoSeguro : listaTipoSeguros) {
            %>
            <option value="<%= tipoSeguro.getIdTipo() %>">
                <%= tipoSeguro.getDescripcion() %>
            </option>
            <% 
                }
            } 
            %>
        </select>
    </td>
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

<% if (request.getAttribute("error") != null) { %>
    <p style="color: red;"><%= request.getAttribute("error") %></p>
<% } %>

</table>

</form>
</body>
</html>