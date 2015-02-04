<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="open4job.web.vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mostrar recurso por id</title>
</head>
<body>

<%
//Recogemos el objeto recurso
RecursosVO recurso = (RecursosVO) request.getAttribute("RecursosVO");

//Lo mostramos
out.println(recurso.getId()); 
out.println(recurso.getTitulo());
out.println(recurso.getLatitud());
out.println(recurso.getLongitud());

%>
</body>
</html>