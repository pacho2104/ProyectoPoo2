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

<script>


function validarFormulario(){
	
	const nombre= document.getElementById("nombre").value.trim();
	const nacionalidad=document.getElementById("nacionalidad").value.trim();
	
	if(nombre === ''){
		
		alert('Ingrese el nombre del autor');
		document.getElementById("nombre").value.trim();
		return false;
		
		
	}
	return true;
	
}

</script>


</head>
<body>

	hola a todos

	<%
String url = "http://localhost:8088/ProyectoWeb2/";
%>

	<div class="container">

		<h3>Nuevo Autor</h3>
		<form role="form" action="<%=url%>AutoresController?op=insertar"
			method="POST" onsubmit="return validarFormulario()"  >
			
			<!-- <input type="hidden" name="op" value="insertar" /> Nombre del Autor:
			<input type="text" name="nombre" id="nombre" /><br>
			Nacionalidad: <input type="text" name="nacionalidad"
				id="nacionalidad" /><br>     -->

			


			<div class="mb-3">
				<label  class="form-label">Nombre
					del autor</label> <input type="text" class="form-control" name="nombre"
					id="nombre" placeholder="Ingrese nombre">
			</div>
			
			<div class="mb-3">
				<label  class="form-label">Ingrese nacionalidad
					del autor</label> <input type="text" class="form-control" name="nacionalidad"
					id="nacionalidad" placeholder="Ingrese nacionalidad">
			</div>
			
			
			<input type="submit" value="Guardar" name="Guardar" /> <a
				href="<%=url%>AutoresController?op=lista">Volver</a>

		</form>


	</div>

<%

 if(request.getAttribute("respuesta")!=null){
	 
	 boolean res=(boolean)request.getAttribute("respuesta");
	 
	 
	 if(res){
		 List<String> listaError=(List<String>)request.getAttribute("listaError");
		 for(String error:listaError){
	
%>

<span><%=error%></span>
<br>

<%
		 }
	 }
	 
 }

%>




</body>
</html>