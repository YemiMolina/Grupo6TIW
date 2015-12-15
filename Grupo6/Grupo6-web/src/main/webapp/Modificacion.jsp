<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="es.uc3m.tiw.web.Curso"%>
    <%@ page import="es.uc3m.tiw.web.PersistenceServletCursos"%>
    
    <%@ page import="es.uc3m.tiw.web.ServletSession"%>
    <%@ page import="javax.servlet.ServletException"%>
    <%@ page import="javax.servlet.annotation.WebServlet"%>
    <%@ page import="javax.servlet.http.HttpServlet"%>
    <%@ page import="javax.servlet.http.HttpServletRequest"%>
    <%@ page import="javax.servlet.http.HttpServletResponse"%>
    <%@ page import="javax.servlet.http.HttpSession"%>
    
<!DOCTYPE html >
   
<html>
<!--Head contenedor del título de la página, enlaces a las stylesheets, tipografías y charset-->
<head>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

  <!-- Jquery para cargar los scripts de bootstrap --> 
  <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
  
  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

  <title>Modificacion</title>
  <meta name="Alex" content="Grupo de practicas TIW" lang="es">
  <link rel="icon" type="image/png" href="./images/icono.jpg"> 


  <link rel="stylesheet" type="text/css" href="./style/styleHome.css">
   <link rel="stylesheet" type="text/css" href="./style/styleFondoBlanco.css">
    <link rel="stylesheet" type="text/css" href="./style/styleSimulacion.css">
    
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <script type="text/javascript" src="./script/scriptHome.js"></script>
  <script type="text/javascript" src="./script/scriptSimulacion.js"></script>

  <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Raleway:100' rel='stylesheet' type='text/css'>
  <META HTTP-EQUIV="Content-Type" content="text/html; charset=utf-8"/>
</head>

<body>
  <!--Header-->
  	<%if (session.getAttribute("usuario") != null) { %>
 	<jsp:include page="HeaderLog.jsp"/>
	<%}else{%>
	<jsp:include page="Header.jsp"/>
	<% } %> 
<div id="fondoBlanco" style="margin: 5px">
<form action="PersistenceServletCursos" enctype="multipart/form-data" method="post">
   
    <hr>
    <fieldset>
    <legend> Alta de curso 
    </legend>
    
    <% Curso CursoModificar =(Curso) request.getAttribute("CursoModificar");%>
    <input type="hidden" name="id" value="<%=CursoModificar.getId() %>">
	<p> -Título: <input type="text" name="titulo" value="<%=CursoModificar.getTitulo() %>"/></p>
    <br><br>
	
	<p> -Descripción:
    <input type="text" name="descripcion" value="<%=CursoModificar.getDescripcion() %>" />
   
     </p>
    <br><br>
	
    <p> -Nivel de dificultad:
        <br>
        <input type="radio" name="dificultad" value="<%=CursoModificar.getDificultad() %>"  /> Básico
        <br>
        <input type="radio" name="dificultad" value="<%=CursoModificar.getDificultad() %>"  /> Intermedio
        <br>
        <input type="radio" name="dificultad" value="<%=CursoModificar.getDificultad() %>"  /> Avanzado
        </p>
    <br><br>

    <p> -Número de horas: <input type="number" name="numeroh" value="<%=CursoModificar.getNumeroh() %>"> </p>
    <br>
    
    <p> -Precio: <input type="number" name="precio" value="<%=CursoModificar.getPrecio() %>"></p> <br>
    
    <p> -Cupon Descuento (si se desea): 
     <br>
        <input type="radio" name="descuento" value="fijo"  /> 10 euros
        <br>
        <input type="radio" name="descuento" value="variable"  /> 10% de descuento
        <br>
        <input type="radio" name="descuento" value="ninguno"  /> Ningun descuento
        <br>
    
	
	<p> Subir Imagen</p>
	
		<input type="hidden" name="action" value="upload">
	 <p>
			<input type="file" name="imagenuri">
		</p> 
		
    <input type="submit" value="Dar de alta">
</form>
</div>
<%@include file="Footer.jsp"%>	
</body>
</html>