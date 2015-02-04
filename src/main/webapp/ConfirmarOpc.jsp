<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Operación con id</title>
</head>
<body>
<%

//Recogemos el objeto sesion
Integer idInteger = (Integer) session.getAttribute("idRecurso");
int id = idInteger.intValue();

%>
Esta usted seguro de realizar la siguiente operación con el id
<%
//Lo mostramos
out.println(id);
%>
?
<a href="http://localhost:8080/aytoMVC/VisualizarOpcServlet"> Ir a operación</a>
</body>
</html>