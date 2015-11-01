<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="es.uc3m.tiw.web.Leccion"%>
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

  <title>Lecciones</title>
  <meta name="Alex" content="Grupo de practicas TIW" lang="es">
  <link rel="icon" type="image/png" href="./images/icono.jpg"> 


  <link rel="stylesheet" type="text/css" href="./style/styleHome.css">
  <link rel="stylesheet" type="text/css" href="./style/styleFondoBlanco.css">
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <script type="text/javascript" src="./script/scriptHome.js"></script>

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
	
	<div id="fondoBlanco" >
			<ul>
				<%
					if (request.getAttribute("Listalecciones") != null) {
						ArrayList<Leccion> ListaLecciones = (ArrayList<Leccion>) request
								.getAttribute("Listalecciones");
						int contador = 0;
						for (Leccion leccion : ListaLecciones) {
				%>
				<li><%=leccion.getDescripcion()%> 
				<a href="Imagenes?foto=<%=leccion.getMaterial() %>">Material</a><br><br>
				</li>
				<a href="ServletLecciones?action=delete&id=<%=contador%>" >Eliminar leccion </a></li>
				</li>

				<%
					contador++;
				%>
				<%
					}
					}
				%>

			</ul>
	</div>
			
		<!--Pie de página-->
	<%@include file="Footer.jsp"%>
</body>
</html>