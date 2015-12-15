<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="java.util.*"%>
    <%@ page import="java.io.*"%>
    <%@ page import="es.uc3m.tiw.model.Curso"%>
    <%@ page import="es.uc3m.tiw.model.Vale"%>
    <%@ page import="es.uc3m.tiw.model.Leccion"%>
    <%@ page import="es.uc3m.tiw.web.ServletCursos"%>
    <%@ page import="es.uc3m.tiw.model.Usuario"%>
    <%@ page import="es.uc3m.tiw.web.ServletValesDescuento"%>

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

<title>Fomulario Creacion vales de descuentos</title>
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

<form action="ServletValesDescuento" method="post">
							<div>
							<p> -Nombre del vale:  <input type="text" name="nombre"/></p>
							    <br><br>
							 <p> -Fecha de caducidad (dd/mm/yyyy): <input type="text" name="fechaCaducidad"/></p>
							 
							<p> -Descuento (en euros):    
							<input type="radio" name="cantidad" value="10"  /> 10 euros <br>
        <br>
        					<input type="radio" name="cantidad" value="20"  /> 20 euros </p>
							    <br>
							      
							<p> -Numero de cursos en los que debe haberse inscribirse:  <input type="number" name="numeroCursosinscrito"/></p>
							<p> -Numero minimo del coste de la matricula:  <input type="number" name="numeroMinMatricula"/></p>   
							
							 <input type="submit" value="Crear nuevo vale">
							 </div>
							 
							 </form>
	</div>
<%@include file="Footer.jsp"%>	
</body>
</html>