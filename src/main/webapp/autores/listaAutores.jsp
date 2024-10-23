<%@page import="ProyectoWeb.beans.Autor"%>
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

String url="http://localhost:8180/ProyectoWeb2/";


%>

<a type="button" href="<%=url%>AutoresController?op=nuevo">Nuevo Autor </a>




<table border="1">
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
			List<Autor> listaAutores=(List<Autor>) request.getAttribute("listaAutores");

			if (listaAutores != null) {

				for (Autor autor : listaAutores) {
			%>
			<tr>
				<td><%=autor.getIdAutor()%></td>
				<td><%=autor.getNombre()%></td>
				<td><%=autor.getNacionalidad()%></td>
				<td></td>
			



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

</body>
</html>