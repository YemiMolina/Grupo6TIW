<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="es.uc3m.tiw.model.Curso"%>
    <%@ page import="es.uc3m.tiw.model.Vale"%>
    <%@ page import="es.uc3m.tiw.model.Usuario"%>
    <%@ page import="es.uc3m.tiw.web.ServletPago"%>
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

  <title>Pago final</title>
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
    

	<%double precio =  (Double)request.getAttribute("precio");%>
    <%double precioFinal= (Double)request.getAttribute("precioFinal");%>
  
   
    El precio inicial del curso era :
     <%= precio %> <br> <br>
	El precio final del curso con el descuento aplicado es :
	<%= precioFinal %>
    <br>
    
    <br><br>
    
  <form action="ServletPago"  method="post">
      
<!-- Metodo de pago-->
<input  type="hidden" name="precioFinal" value="<%= precioFinal %>"/> <br>
Numero de la tarjeta:
<input type="text" name="codigoTarjeta" pattern="[A-B][0-9]{19}" /><br>
<input type="hidden" name="action" value="pagar"/><br>
<input type="submit" value="Pagar">
</form>
     <%-- <a href="ServletPago?action=pagar&id=<%=request.getParameter("id")%>">Finalizar pago </a> --%>
   <!--  <a href="Perfil.jsp">  Finalizar pago </a><br> -->
    
</div>
<%@include file="Footer.jsp"%>	    
</body>
</html>