<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
    <%@ page import="es.uc3m.tiw.web.ServletSession"%>
    <%@ page import="javax.servlet.ServletException"%>
    <%@ page import="javax.servlet.annotation.WebServlet"%>
    <%@ page import="javax.servlet.http.HttpServlet"%>
    <%@ page import="javax.servlet.http.HttpServletRequest"%>
    <%@ page import="javax.servlet.http.HttpServletResponse"%>
    <%@ page import="javax.servlet.http.HttpSession"%>
    
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

  <title>Dokulearning | Home</title>
  <meta name="Alex" content="Grupo de practicas TIW" lang="es">
  <link rel="icon" type="image/png" href="./images/icono.jpg">


  <link rel="stylesheet" type="text/css" href="./style/styleHome.css">
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <script type="text/javascript" src="./script/scriptHome.js"></script>

  <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Raleway:100' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" type="text/css" href="./style/styleFondoBlanco.css">
 
  <META HTTP-EQUIV="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
    <jsp:include page="HeaderLog.jsp"></jsp:include>
<div id="fondoBlanco" >
    <h1>Lista de mensajes</h1>
    <table>
        <thead>

            <tr>
                <th>De</th>
                <th>Mensaje</th>
            </tr>

        </thead>
        <tbody>
            <c:forEach items="${listaMensajes }" var="mensaje">
                <tr>
                    <td>${mensaje.from.nombre }:        </td>
                    <td>${mensaje.mensaje }</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p>
        <a href="javascript:history.go(-1)">Volver</a>
    </p>
    </div>
    
        <!--Pie de página-->
    <%@include file="Footer.jsp"%>
</body>
</html>