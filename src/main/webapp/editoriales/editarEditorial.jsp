<%@page import="ProyectoWeb.beans.Editorial"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

Editar Editoriales

<%
String url="http://localhost:8080/ProyectoWeb2/";

Editorial editorial;

if(request.getAttribute("editorial")==null){
	editorial=new Editorial();
	
}else{
	
	editorial=(Editorial)request.getAttribute("editorial");
}


%>

<form role="form" action="<%=url%>EditorialController?op=modificar" method="POST" >

<input type="hidden" name="op" value="modificar" />
<input type =hidden value="<%=editorial.getIdLibro() %>" name="codigo" id="codigo" >
Nombre Editorial:<input type =text value="<%=editorial.getNombre() %>" name="nombre" id="nombre"/><br>
Contacto Editorial:<input type =text value="<%=editorial.getContacto() %>" name="contacto" id="contacto"/><br>
Telefono Editorial:<input type =text value="<%=editorial.getTelefono() %>" name="telefono" id="telefono"/><br>
<input type="submit" value="Guardar" name="Guardar" />
<a href="<%=url%>EditorialController?op=listar" >Volver</a>






</form>


</body>
</html>