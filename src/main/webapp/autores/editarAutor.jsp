<%@page import="org.apache.catalina.ant.jmx.JMXAccessorQueryTask"%>
<%@page import="ProyectoWeb.beans.Autor"%>
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

String url="http://localhost:8090/ProyectoWeb2/";

Autor autor;

if(request.getAttribute("autor")==null){
	autor=new Autor();
}else{
   autor=(Autor)request.getAttribute("autor");
}


%>


<h3>Nuevo Autor</h3>
<form role="form" action="<%=url%>AutoresController?op=insertar" method="POST">

<input type="hidden" name ="op" value="modificar"/>

Nombre del Autor:<input type="text" value="<%=autor.getNombre() %>" name="nombre" id="nombre"/><br>
Nacionalidad:<input type="text" value="<%=autor.getNacionalidad() %>" name="nacionalidad" id="nacionalidad"/><br>
<input type="submit" value="Guardar" name="Guardar"/>
<a href="<%=url%>AutoresController?op=lista">Volver</a>

</form>

</body>
</html>