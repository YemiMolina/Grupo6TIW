<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="es.uc3m.tiw.model.Curso"%>
    <%@ page import="es.uc3m.tiw.model.Vale"%>
    <%@ page import="es.uc3m.tiw.model.Usuario"%>
    <%@ page import="es.uc3m.tiw.web.ServletPago"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pago Final</title>
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
	El precio final del curso con el descuento apliaco es :
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
    
    
</body>
</html>