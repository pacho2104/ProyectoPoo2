<%@page import="ProyectoWeb.beans.Editorial"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
	String url = "http://localhost:8080/ProyectoWeb2/";
	%>

	<a type="button" href="<%=url%>EditorialController?op=nuevo">Nuevo
		Editorial</a>

	<table border=1>

		<thead>
			<tr>
				<th>Codigo de Editorial</th>
				<th>Nombre de Editorial</th>
				<th>Contacto de Editorial</th>
				<th>Telefono de Editorial</th>
				<th>Operaciones</th>

			</tr>
		</thead>

		<%
		       
		       List<Editorial>listaEditorial=(List<Editorial>) request.getAttribute("listaEditorial");
		       
		       if(listaEditorial !=null){
		    	   
		              for(Editorial editorial: listaEditorial){
		       
		       %>
		<tr>
			<td><%=editorial.getIdLibro()%></td>
			<td><%=editorial.getNombre()%></td>
			<td><%=editorial.getContacto() %></td>
			<td><%=editorial.getTelefono()%></td>
			<td>
			<a href="<%=url%>EditorialController?op=eliminar&id=<%=editorial.getIdLibro()%>">Eliminar</a>
			<a href="<%=url%>EditorialController?op=obtener&id=<%=editorial.getIdLibro()%>">Modificar</a>
			
			
			</td>

		</tr>

		<%
		              }
		
		      }else{
		       
		       
		       %>

		<tr>
			<td>No hay datos</td>
			<td>No hay datos</td>
			<td>No hay datos</td>
			<td>No hay datos</td>



		</tr>
		
		<%
		      }
		%>








	</table>



</body>
</html>