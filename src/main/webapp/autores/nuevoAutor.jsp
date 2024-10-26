<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

hola a todos

<%

String url="http://localhost:8090/ProyectoWeb2/";


%>


<h3>Nuevo Autor</h3>
<form role="form" action="<%=url%>AutoresController?op=insertar" method="POST">

<input type="hidden" name ="op" value="insertar"/>

Nombre del Autor:<input type="text" name="nombre" id="nombre"/><br>
Nacionalidad:<input type="text" name="nacionalidad" id="nacionalidad"/><br>
<input type="submit" value="Guardar" name="Guardar"/>
<a href="<%=url%>AutoresController?op=lista">Volver</a>

</form>


</body>
</html>