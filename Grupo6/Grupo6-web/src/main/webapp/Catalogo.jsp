<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="es.uc3m.tiw.model.Curso"%>
    <%@ page import="es.uc3m.tiw.model.Leccion"%>
    <%@ page import="es.uc3m.tiw.model.daos.ILeccion"%>
    <%@ page import="es.uc3m.tiw.model.daos.LeccionDao"%>
    <%@ page import="es.uc3m.tiw.model.daos.ICurso"%>
    <%@ page import="es.uc3m.tiw.model.daos.CursoDao"%>
    <%@ page import="es.uc3m.tiw.model.Usuario"%>
     
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

  <title>Catalogo de cursos</title>
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
	
<div id="busqueda">
    <br><p>Se han encontrado los siguientes resultados</p>
  <div class="row">
    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
    <div id="parametros">
      <br><h3 class="titulosPar">Configuración</h3>
      <h4 class="titulosPar">Tipo de dificultad</h4>
      <p class="datosPar">Basico</p>
      <input class="check" type="checkbox" id="basico" name="Basico" value="Basico" onchange="check()" checked>
      <p class="datosPar">Avanzado</p>
      <input class="check" type="checkbox" id="avanzado" name="Avanzado" value="Avanzado" onchange="check()" checked><br>
      <h4 class="titulosPar">Duracion</h4>
      <p class="datosPar">Corta</p>
      <input class="check" type="checkbox" id="corta" name="Corta" value="Corta" onchange="check()" checked>
      <p class="datosPar">Larga</p>
      <input class="check" type="checkbox" id="larga" name="Larga" value="Larga" onchange="check()" checked><br>
    </div>
    </div>
    
    <div class="col-lg-9 col-md-9 col-sm-8 col-xs-12">

<%
	List<Curso> Listacursos = (List<Curso>) request.getAttribute("Listacursos");
	//Iterator<Curso> iterador = null;
	int contador=0;
	for(Curso curso: Listacursos) {
		
		%>
		<div id="fondoBlanco" style="margin: 5px">
		
		<li>Nombre del curso: <%=curso.getTitulo() %> <br>
		Descripcion: <%=curso.getDescripcion() %> <br>
		
		El precio inicial es:<%=curso.getPrecio()%><br>
		El precio final es: <%=curso.getPrecioFinal()%> <br>
		<br><br>

		 <img src="ServletImagenes?foto=<%=curso.getImagenuri()%>"> <br><br>
		 
		
		 <a href="ServletLecciones?action=mostrar&id=<%=curso.getIdcursos()%>" > Ver sus Lecciones </a></li><br>
		 <a href="ServletPago?id=<%=curso.getIdcursos()%>" > Matricularse en este curso </a></li> <br>
			<%//if (session.getAttribute("usuario") != null) { 
			//Usuario log = (Usuario)session.getAttribute("usuario");	
			//if( log.getRol() != 1 ){ %>
				<a href="CatalogoLecciones.jsp?id=<%=curso.getIdcursos()%>" > Añadir Leccion </a></li> <br>
		  		<a href="PersistenceServletCursos?action=modificar&id=<%=curso.getIdcursos()%>" > Modificar Curso </a></li><br>
		 		<a href="PersistenceServletCursos?action=delete&id=<%=curso.getIdcursos()%>" >Eliminar curso </a></li>	
			<%//} %>
		<%//} %>
			  	
		</div>
		<%contador++; %>
	<%} %>
	</div>
	</div>

		<br>
		
		<%//if (session.getAttribute("usuario") != null) { 
			//Usuario log = (Usuario)session.getAttribute("usuario");	
			//if( log.getRol() != 1 ){ %>
				<a href="FormularioAlta.jsp" ><input id="" type="submit" value="Dar de alta otro curso"></a>
				<br>
				<a href="FomularioValesAlta.jsp" ><input id="" type="submit" value="Crear vale descuento"></a>	
			<%//} %>
		<%//} %>

</div>
<%@include file="Footer.jsp"%>	
</body>
</html>