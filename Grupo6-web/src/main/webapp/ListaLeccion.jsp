<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="es.uc3m.tiw.web.Leccion"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Leeciones</title>
</head>
<body>
			<ul>
				<%
					if (request.getAttribute("Listalecciones") != null) {
						ArrayList<Leccion> ListaLecciones = (ArrayList<Leccion>) request
								.getAttribute("Listalecciones");
						int contador = 0;
						for (Leccion leccion : ListaLecciones) {
				%>
				<li><%=leccion.getDescripcion()%> 
				<a href="Imagenes?foto=<%=leccion.getMaterial() %>">Material</a><br><br>
				</li>

				</li>

				<%
					contador++;
				%>
				<%
					}
					}
				%>

			</ul>
</body>
</html>