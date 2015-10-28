<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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

  <title>LearnIt | Home</title>
  <meta name="Author" content="Grupo de practicas TIW" lang="es">
  <link rel="icon" type="image/png" href="./images/icono.jpg"> 


  <link rel="stylesheet" type="text/css" href="./style/styleHome.css">
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <script type="text/javascript" src="./script/scriptHome.js"></script>

  <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Raleway:100' rel='stylesheet' type='text/css'>
  <META HTTP-EQUIV="Content-Type" content="text/html; charset=utf-8"/>

  <!--Header-->


  <body id="body" onload="" >

    <header id="header">
      <div class="row">
        <div class="col-lg-8 col-md-8 col-sm-7 col-xs-12">
          <figure>
            <a href="./Index.html"><img id="imagenTitulo" src="./images/logo.png" alt="Logo tiw"></a>
          </figure>
          <h1 id="titulo">Dokulearning</h1>
        </div>
        <div class="col-lg-4 col-md-4 col-sm-5 hidden-xs" style="float=right">
          <div id="registroUsuario">
            <form name="formularioUsuario"  method="post" action="ServletLogin">
              <div><p id="usuario"> <span style="color:white">Usuario </span></p> <input class="cuadro"  id="cuadro" type="text" name="user"></input></div>
              <div style="clear: both; float: left"><p id="pas"><span style="color:white"> Contraseña </span></p> <input class="cuadro" id="cuadro"  type="password" name="pasw"></input></div>
            	<div id="registroUsuario">
              		<input id="botonSubmit" type="submit" value="Iniciar Sesión">
             		<a class="enlaceUsuario" href="./RegistroUsuario.jsp" style="font-size:20px;" >¿Aún no te has registrado?</a>
            	</div>
            </form>
          </div>
        </div>
      </div>
    </header>

    <!--Menú con lista de enlaces-->

<div class="menu">
  <nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Menu</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Cursos</a></li>
      </ul>
     <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Busca Cursos">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Sesion <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <input type="text" class="form-control" placeholder="Usuario">
            <input type="text" class="form-control" placeholder="Contraseña">
            <li><a href="#">Iniciar Sesion</a></li>
            
            <li><a href="#">Resgistrarse</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Informacion</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
  </nav>
</div>

    <nav id="menud">
      <a class="enlace5" href="#">Home</a>    
    </nav>

    </body>
    </html>