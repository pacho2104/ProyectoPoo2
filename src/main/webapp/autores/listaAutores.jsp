<%@page import="ProyectoWeb.model.AutoresModel"%>
<%@page import="ProyectoWeb.beans.Autor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">





<title>Insert title here</title>

<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<script src="assets/js/bootstrap.min.js">
	
</script>


<script ">

function eliminar(id){
	
	if(confirm("¿Desea elimnar el registro?")){
		
		location.href="AutoresController?op=eliminar&id="+id;
	}
}

</script>




</head>
<body>

	<%
	String url = "http://localhost:8080/ProyectoWeb2/";
	%>

	<div class="container">


		<a type="button" href="<%=url%>AutoresController?op=nuevo">Nuevo
			Autor </a>




		<table class="table">
			<thead>

				<tr>
					<th>Codigo del autor</th>
					<th>Nombre del autor</th>
					<th>Nacionalidad</th>
					<th>Operacionesr</th>
				</tr>
			</thead>
			<tbody>

				<%
				List<Autor> listaAutores = (List<Autor>) request.getAttribute("listaAutores");

				if (listaAutores != null) {

					for (Autor autor : listaAutores) {
				%>
				<tr>
					<td><%=autor.getIdAutor()%></td>
					<td><%=autor.getNombre()%></td>
					<td><%=autor.getNacionalidad()%></td>
					<td>
						<!--<input type="button" value="ELIMINAR" name="eliminar">
				<input type="button" value="MODIFICAR" name="modificar">  --> 
				
				<!-- <a
						href="<%=url%>AutoresController?op=eliminar&id=<%=autor.getIdAutor()%>">Eliminar</a>       -->
				
				
						<a
						href="<%=url%>AutoresController?op=obtener&id=<%=autor.getIdAutor()%> " class="btn btn-warning" >Modificar</a>
						
						<a href="javascript:eliminar('<%=autor.getIdAutor()%>')" class="btn btn-danger"  >Eliminar </a>

					</td>





				</tr>


				<%
				}

				} else {
				%>
				<tr>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td>No hay datos</td>
				</tr>


				<%
				}
				%>





			</tbody>



		</table>
		<%
		AutoresModel model = new AutoresModel();
		%>
		<br> Total Autores:
		<td><%=model.totalAutores()%></td>









	</div>





</body>
</html>