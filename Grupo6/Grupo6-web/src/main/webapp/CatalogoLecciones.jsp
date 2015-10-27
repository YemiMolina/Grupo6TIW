<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="es.uc3m.tiw.web.Leccion"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Catalogo de lecciones</title>
</head>
<body>
	<form action="ServletLecciones" enctype="multipart/form-data"
		method="post">
		<hr>
		<fieldset>
			<%
				String id = request.getParameter("id");
			%>
			<input type="hidden" name="id" value="<%=id%>" />

			<legend> Contenido de lecciones </legend>

			<p>
				Descripcion: <input type="text" name="descripcion" />
			</p>
			<br>
			<br>

			<h1> Subir Material</h1>
	
		<input type="hidden" name="action" value="upload">

	 <p>
			<input type="file" name="material">
		</p> 

			<input type="submit" value="Dar de alta" />
			<ul>
				<%
					if (request.getAttribute("Listalecciones") != null) {
						ArrayList<Leccion> ListaLecciones = (ArrayList<Leccion>) request.getAttribute("Listalecciones");
						int contador = 0;
						for (Leccion leccion : ListaLecciones) {
				%>
				<li><%=leccion.getDescripcion()%> 
				<a href="Imagenes?foto=<%=leccion.getMaterial() %>">Material</a><br><br>
				</li>

				

				<%
					contador++;
				%>
				<%
					}
					}
				%>
				<a href="CatalogoLecciones.jsp?id=<%=request.getParameter("id")%>">
					Añadir Leccion </a>

			</ul>

	
	</form>


</body>
</html>