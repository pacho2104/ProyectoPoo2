<%@page import="org.apache.catalina.ant.jmx.JMXAccessorQueryTask"%>
<%@page import="ProyectoWeb.beans.Autor"%>
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


</head>
<body>



	<div class="container">


		EDITAR AUTOR

		<%
	String url = "http://localhost:8080/ProyectoWeb2/";

	Autor autor;

	if (request.getAttribute("autor") == null) {
		autor = new Autor();
	} else {
		autor = (Autor) request.getAttribute("autor");
	}
	%>


		<h3>Nuevo Autoresss</h3>
		<form role="form" action="<%=url%>AutoresController?op=modificar"
			method="POST">
			
			
			<!--  <input type="hidden" name="op" value="modificar" /> Codigo:<input
				type="hidden" value="<%=autor.getIdAutor()%>" name="codigo"
				id="codigo" /><br> Nombre del Autor:<input type="text"
				value="<%=autor.getNombre()%>" name="nombre" id="nombre" /><br>
			Nacionalidad:<input type="text" value="<%=autor.getNacionalidad()%>"
				name="nacionalidad" id="nacionalidad" /><br>     -->

			


			<div class="mb-3">
				<label class="form-label"></label><input type="hidden"  class="form-control" 
					value="<%=autor.getIdAutor()%>" name="codigo" id="codigo" />
			</div>

			<div class="mb-3">
				<label class="form-label">Nombre del autor</label> <input
					type="text" class="form-control" value="<%=autor.getNombre()%>"
					name="nombre" id="nombre" placeholder="Ingrese nombre">
			</div>

			<div class="mb-3">
				<label class="form-label">Ingrese nacionalidad del autor</label> <input
					type="text" class="form-control"
					value="<%=autor.getNacionalidad()%>" name="nacionalidad"
					id="nacionalidad" placeholder="Ingrese nacionalidad">
			</div>


			<input type="submit" value="Guardar" name="Guardar" /> <a
				href="<%=url%>AutoresController?op=lista">Volver</a>


		</form>







	</div>


</body>
</html>