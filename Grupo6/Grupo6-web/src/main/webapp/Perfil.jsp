<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Perfil de usuario</title>

 <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

  <!-- Jquery para cargar los scripts de bootstrap --> 
  <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

  <title>LearnIt | Home</title>
  <meta name="Author" content="Grupo de practicas TIW" lang="es">
  <link rel="icon" type="image/png" href="./images/icono.jpg"> 


  <link rel="stylesheet" type="text/css" href="./style/styleHome.css">
  <link rel="stylesheet" type="text/css" href="./style/stylePerfil.css">
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <script type="text/javascript" src="./script/scriptHome.js"></script>
  <%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="es.uc3m.tiw.web.Usuario"%>
<%@ page import="es.uc3m.tiw.web.ServletRegistroUsuario"%>
  <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Raleway:100' rel='stylesheet' type='text/css'>
  <META HTTP-EQUIV="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<%@include file="HeaderLog.jsp"%>

  <div class="row">
    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
      <div id="imagen">
        <figure>
            <img src="./images/user.png" alt="imagen de perfil" width="150" height="150">
        </figure>
          <button type="button" id="botonSubmit" onclick="editar()" style="color:black">Editar perfil</button>
      </div>
    </div>

    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
      <div class="enlace5">
        <p>Usuario:<%=request.getAttribute("usuario") %></p>
        <p>Nombre:<%=request.getAttribute("nombre") %></p>
        <p>Apellidos: <%=request.getAttribute("apellidos") %></p>
        <p>Edad: <%=request.getAttribute("edad") %></p>
        <p>E-mail: <%=request.getAttribute("email") %></p>
        <p>Tel&eacute;fono: <%=request.getAttribute("telefono") %></p>
        <p>Direcci&oacute;n:<%=request.getAttribute("direccion") %> </p>
        <p>Descripci&oacute;n: <%=request.getAttribute("descripcion") %></p>
        <p>Intereses: <%=request.getAttribute("intereses") %></p>
        	
				
        
      </div>
    </div>     
  </div>

  <div id="CursosInscritos">
      <p>Mis Cursos</p>
      <ul class="enlacesPerfil">
        <li><a class="enlacePerfil" href="../src/error.html">Html5 avanzado</a></li>
        <li><a class="enlacePerfil" href="../src/error.html">Curso de fotografia</a></li>
        <li><a class="enlacePerfil" href="../src/error.html">Curso de ingles</a></li>
        <li><a class="enlacePerfil" href="../src/error.html">Curso de piragua</a></li>
      
      </ul>
        
  </div>

<%@include file="Footer.jsp"%>

</body>
</html>