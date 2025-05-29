
<%@page import="java.util.ArrayList"%>
<%@page import="dominio.Seguro"%>
<%@page import="dominio.TipoSeguros"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LISTAR</title>
</head>
<body>
<a href="Inicio">INICIO</a>
<a href="AgregarSeguro">AGREGAR SEGURO</a>
<a href="ListarSeguro">LISTAR SEGURO</a>
<br>
<%
ArrayList<TipoSeguros> listaTipos=null;
if(request.getAttribute("listaTipos")!=null)
{
	listaTipos = (ArrayList<TipoSeguros>) request.getAttribute("listaTipos");
}
%>

<br>
<b>"Tipo de seguros de la base de datos"</b>
<br>
<br>
<form action="ListarSeguro" method="get">Busqueda por tipo de Seguros: <select name="tipos">
<% if(listaTipos!=null)
for(TipoSeguros tipo:listaTipos){
	%>
<option value="<%= tipo.getIdTipo()%>"><%=tipo.getDescripcion() %> </option>

<%  } %>
</select>
<input type="submit" name="btnFiltrar" value="Filtrar">
</form>
<br>

<%
	ArrayList<Seguro> listaSeguros = null;
	if(request.getAttribute("listaS") != null)
	{
		listaSeguros = (ArrayList<Seguro>) request.getAttribute("listaS");
	}

%>
<table border="1">
	<tr> 
		<th>ID seguro</th>
		<th>Descripcion seguro</th>  
		<th>Descripcion tipo seguro</th>  
		<th>Costo Contratacion</th> 
		<th>Costo maximo Asegurado</th> 
	</tr>
	
	<%  if(listaSeguros != null)
		for(Seguro seguro : listaSeguros) 
		{
	%>
	<tr>  
	     <form action="ListarSeguro" method="get">
	     <td><%=seguro.getId() %>  </td>    
	     <td><%=seguro.getDescripcion() %></td>   
	     <td><%=seguro.getDescripcionTipo() %></td>
	     <td><%=seguro.getCostoContracion() %></td>
	     <td><%=seguro.getCostoAsegurado() %></td> 
	     </form>  
	</tr>
	<%  } %>

</table>
</body>
</html>