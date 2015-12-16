<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="java.util.*"%>
    <%@ page import="java.io.*"%>
    <%@ page import="es.uc3m.tiw.model.Curso"%>
     <%@ page import="es.uc3m.tiw.model.Vale"%>
    <%@ page import="es.uc3m.tiw.model.Leccion"%>
    <%@ page import="es.uc3m.tiw.web.PersistenceServletCursos"%>
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

  <title>Vales de descuento</title>
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
	
		<hr>
		<fieldset>

			<legend> Creacion de Vales </legend>

		<div class="container">
			<div class="row">
			<!-- You can make it whatever width you want. I'm making it full width
             on <= small devices and 4/12 page width on >= medium devices -->
				<div class="col-xs-14 col-md-6">
					<h4>Informaci&oacute;n sobre los Vales de los cursos </h4>
					
					<body>
							<% List<Vale> listaVales =(List<Vale>)request.getAttribute("ListaVales"); %>
							<%  for (Vale vale : listaVales){%>
							    Nombre <%=vale.getNombre() %> <br>
							    Cantidad <%=vale.getCantidad() %> <br>
							    Fecha de caducidad <%=vale.getDateString() %> <br>
							 	Codigo <%=vale.getCodigo() %> <br>

							 <% }%>
							
						<!-- 	
							<form action="ServletValesDecuento" method="post">
							<div>
							<p> -Nombre del vale:  <input type="text" name="nombre"/></p>
							    <br><br>
							
							<p> -Descuento (en euros):    
							<input type="radio" name="cantidad" value="10"  /> 10 euros
        <br>
        					<input type="radio" name="cantidad" value="20"  /> 20 euros </p>
							    <br>
							    
							    <p> -Fecha de caducidad (dd/mm/yyyy):  <input type="text" name="fecha"/></p>
							    
							    
							    <input type="submit" value="Crear nuevo vale">
							   
							   
							   
							    </div>
							    
							    
							    
							</form> -->
							</body>
				
					
					
										
						
					
								
					<br>
					
					<a href="PersistenceServletCursos">
					Ir al listado de Cursos </a>
					
					
				
				</div>
			
			
			</div>
		</div>
		
	</form>	
			</fieldset>
	</form>
</div>
    <!--Pie de página-->
	<%@include file="Footer.jsp"%>

</body>
</html>