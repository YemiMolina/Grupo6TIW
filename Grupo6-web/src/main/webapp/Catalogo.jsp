<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="es.uc3m.tiw.web.Curso"%>
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

  <title>Catalogo de cursos</title>
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
<p><strong>Cursos disponibles</strong></p>

	<ul>
<%
	ArrayList<Curso> Listacursos = (ArrayList<Curso>)request.getAttribute("Listacursos");
	//Iterator<Curso> iterador = null;
	int contador=0;
	for(Curso curso: Listacursos) {
		%>
		<li><%=curso.getTitulo() %> <br>
		<%=curso.getDescripcion() %> <br>
		El precio inicial es:<%=curso.getPrecio()%><br>
		El precio final es: <%=curso.getPrecioFinal()%> <br>
		<br><br>

		 <img src="ServletImagenes?foto=<%=curso.getImagenuri()%>"> <br><br>
		 
		 <a href="ServletLecciones?id=<%=curso.getId()%>" > Ver sus Lecciones </a></li><br>
		  <a href="CatalogoLecciones.jsp?id=<%=curso.getId()%>" > Añadir Leccion </a></li> <br>
		  <a href="Matriculacion.jsp?id=<%=curso.getId()%>&precioFinal=<%=curso.getPrecioFinal()%>" > Matricularse en este curso </a></li> <br>
		  <a href="ServletCursos?action=modificar&id=<%=curso.getId()%>" > Modificar Curso </a></li><br>
		 <a href="ServletCursos?action=delete&id=<%=contador%>" >Eliminar curso </a></li>
		
		
		<%contador++; %>
		<%
	}
	
		%>
	</ul>

		<br>
<a href="FormularioAlta.jsp" >Dar de alta otro curso </a>	
</div>



<%@include file="Footer.jsp"%>	
</body>
</html>