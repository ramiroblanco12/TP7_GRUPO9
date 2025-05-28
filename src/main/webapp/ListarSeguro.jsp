
<%@page import="java.util.ArrayList"%>
<%@page import="dominio.Seguro"%>
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

<form method="get" action= "ListarSeguro">
	<a href="ListarSeguro">LISTAR SEGURO</a>
</form>
<h1>SOY LA PAGINA DE LISTAR SEGURO</h1>

<%
	ArrayList<Seguro> listaSeguros = null;
	if(request.getAttribute("listaS") != null)
	{
		listaSeguros = (ArrayList<Seguro>) request.getAttribute("listaS");
	}

%>
<table border="1">
	<tr> 
		<th>ID</th>
		<th>Descripcion</th>  
		<th>Id Tipo</th>  
		<th>Costo Contratacion</th> 
		<th>Costo Asegurado</th> 
	</tr>
	
	<%  if(listaSeguros != null)
		for(Seguro seguro : listaSeguros) 
		{
	%>
	<tr>  
	     <form action="ListarSeguro" method="get">
	     <td><%=seguro.getId() %>  </td>    
	     <td><%=seguro.getDescripcion() %></td>   
	     <td><%=seguro.getIdtipo() %></td>
	     <td><%=seguro.getCostoContracion() %></td>
	     <td><%=seguro.getCostoAsegurado() %></td> 
	     </form>  
	</tr>
	<%  } %>

</table>
</body>
</html>