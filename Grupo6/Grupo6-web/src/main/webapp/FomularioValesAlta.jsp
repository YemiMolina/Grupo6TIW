<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="java.util.*"%>
    <%@ page import="java.io.*"%>
    <%@ page import="es.uc3m.tiw.model.Curso"%>
     <%@ page import="es.uc3m.tiw.model.Vale"%>
    <%@ page import="es.uc3m.tiw.model.Leccion"%>
    <%@ page import="es.uc3m.tiw.web.ServletCursos"%>
    <%@ page import="es.uc3m.tiw.model.Usuario"%>
    <%@ page import="es.uc3m.tiw.web.ServletValesDescuento"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fomulario Creacion vales de descuentos</title>
</head>
<body>
<form action="ServletValesDescuento" method="post">
							<div>
							<p> -Nombre del vale:  <input type="text" name="nombre"/></p>
							    <br><br>
							 <p> -Fecha de caducidad (dd/mm/yyyy): <input type="text" name="fechaCaducidad"/></p>
							 
							<p> -Descuento (en euros):    
							<input type="radio" name="cantidad" value="10"  /> 10 euros <br>
        <br>
        					<input type="radio" name="cantidad" value="20"  /> 20 euros </p>
							    <br>
							      
							<p> -Numero de cursos en los que debe haberse inscribirse:  <input type="number" name="numeroCursosinscrito"/></p>
							<p> -Numero minimo del coste de la matricula:  <input type="number" name="numeroMinMatricula"/></p>   
							 <p> -Fecha maxima de vigencia (dd/mm/yyyy): <input type="text" name="FechaMaxima"/></p>  
							 <input type="submit" value="Crear nuevo vale">
							 </div>
							 
							 </form>
</body>
</html>