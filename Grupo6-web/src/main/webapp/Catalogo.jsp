<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="es.uc3m.tiw.web.Curso"%>
    <%@ page import="es.uc3m.tiw.web.Leccion"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Catalogo de cursos</title>

</head>
<body>
<p><strong>Cursos disponibles</strong></p>

	<ul>
<%
	ArrayList<Curso> Listacursos = (ArrayList<Curso>) request.getAttribute("Listacursos");
	//Iterator<Curso> iterador = null;
	int contador=0;
	for(Curso curso: Listacursos) {
		%>
		<li><%=curso.getTitulo() %> <br>
		<%=curso.getDescripcion() %> <br>
		<%=curso.getPrecio()%> 
		
		<br><br>

		 <img src="Imagenes?foto=<%=curso.getImagenuri()%>"> <br><br>
		 <a href="ServletLecciones?id=<%=curso.getId()%>" > Ver sus Lecciones </a></li>
		  <a href="CatalogoLecciones.jsp?id=<%=curso.getId()%>" > Añadir Leccion </a></li> <br>
		 <a href="cursos?action=delete&id=<%=contador%>" >Eliminar curso </a></li>
		
		<%contador++; %>
		<%
	}
	
		%>
	</ul>
	


	

		<br>
<a href="FormularioAlta.html" >Dar de alta otro curso </a>		
</body>
</html>