<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="es.uc3m.tiw.model.Curso"%>
    <%@ page import="es.uc3m.tiw.model.Vale"%>
    <%@ page import="es.uc3m.tiw.model.Usuario"%>
    <%@ page import="es.uc3m.tiw.web.ServletPago"%>
   	<%@ page import="es.uc3m.tiw.web.ServletSession"%>
    <%@ page import="javax.servlet.ServletException"%>
    <%@ page import="javax.servlet.annotation.WebServlet"%>
    <%@ page import="javax.servlet.http.HttpServlet"%>
    <%@ page import="javax.servlet.http.HttpServletRequest"%>
    <%@ page import="javax.servlet.http.HttpServletResponse"%>
    <%@ page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

<title>Pago del curso para matricularse</title>
</head>
<body>
     
      <!--Header-->
  	<%if (session.getAttribute("usuario") != null) { %>
 	<jsp:include page="HeaderLog.jsp"/>
	<%}else{%>
	<jsp:include page="Header.jsp"/>
	<% } %> 
     <div id="fondoBlanco" style="margin: 5px">
     
   <%int idCursoActual = Integer.parseInt(request.getParameter("id"));%>
   <%double precio =  (Double)request.getAttribute("precio");%>
   <%double precioFinal =  (Double)request.getAttribute("precioFinal");%>
   <%List<Curso> CursosMatriculados = (List<Curso>)request.getAttribute("CursosMatriculados");
    List<Vale> ListaValesFinal = (List<Vale>)request.getAttribute("ListaValesFinal");
  %>
  
   <form action="ServletPago"  method="post"> 
    <% for(Vale vale: ListaValesFinal) {%>
    <li>  <input type="radio" name="vale" value="<%=vale.getCantidad() %>"  />Codigo del decuento<%=vale.getCodigo() %><br>
    Cantidad del descuento<%=vale.getCantidad() %> <br>
    Fecha de caducidad del descuento:<%=vale.getFechaCaducidad() %><br><br>
  
     <input type="hidden" name="precio" value="<%=precio %>"/>
    </li>
   <%  } 
    %>
 <br> <br> <br>
    El precio del curso es :
     <%= precio %> <br> <br>
	El precio final del curso con el descuento es :
	<%= precioFinal %>
    <br>
    
    <br><br>
      <input type="submit" value="Aplicar el descuento">
    </form>
</div>
        <!--Pie de página-->
	<%@include file="Footer.jsp"%> 
</body>
</html>