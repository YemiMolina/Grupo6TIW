<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="es.uc3m.tiw.model.Usuario"%>
    
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
   
<html>
<!--Head contenedor del tÃ­tulo de la pÃ¡gina, enlaces a las stylesheets, tipografÃ­as y charset-->
<head>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

  <!-- Jquery para cargar los scripts de bootstrap -->
  <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
 
  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

  <title>Usuarios en Dokulearning</title>
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
<%-- <%
    List<Usuario> listaUsuarios = (List<Usuario>)request.getAttribute("usuarios");
    //Iterator<Curso> iterador = null;
    
    
    for(Usuario usuario: listaUsuarios) {
        %> --%>
        
    
<c:forEach items="${usuarios }" var="usuario"> <!-- recorremos todos los objetos de la coleccion usuarios y cada objeto devuelto lo asignamos a la variable usuario -->
<div id="fondoBlanco" style="margin: 5px">
<tr>
    
    <td>${usuario.nombre }</td> <!-- Usuario es un POJO por lo que podemos acceder a sus propiedades sin necesidad de get/set -->
    <td>${usuario.apellidos }</td>
    <c:if test="${sessionScope.usuario.idusuarios != null }">
    <c:if test="${usuario.idusuarios != sessionScope.usuario.idusuarios }">
        <td ><a href="escribirMensaje.jsp?idFrom=${sessionScope.usuario.idusuarios }&idTo=${usuario.idusuarios }" class="escribir">Enviar Mensaje</a></td>
    </c:if>
        <c:if test="${usuario.idusuarios == sessionScope.usuario.idusuarios }">
        <!-- <td ><a href="mensajes?accion=leer" class="leer">Leer Mensajes</a></td>
     --></c:if>
    </c:if>
</tr>
</div>
</c:forEach>
        
<%--         <% } %>
    <%}%>  --%>



<%@include file="Footer.jsp"%>    
</body>
</html>