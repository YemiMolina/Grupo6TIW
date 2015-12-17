<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>


<head>
<title> Registro Dokulearning</title>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">

<!-- Latest compiled and minified CSS-->
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- CSS Validator-->
<link
    href="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"
    rel="stylesheet"></link>


<!-- Optional theme-->
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<link rel="stylesheet"
    href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="./style/styleHome.css">
<link rel="stylesheet" type="text/css" href="./style/styleFondoBlanco.css">

<!-- <!-- JavaScript
<script type="text/javascript" src="./script/validator.js"></script>
 -->
</head>
<body>
<jsp:include page="HeaderLog.jsp"/>

<div id="fondoBlanco" >
<form action="mensajes" method="post">
    <fieldset>
        <legend>Esribir mensaje </legend>
        <textarea name="mensaje" id="mensaje" cols="30" rows="10"></textarea>
        <br />
        <input type="submit" value="enviar" />
        <input type="hidden" name="to" value="${param.idTo }" />
        <input type="hidden"  name="from" value="${param.idFrom }"/>
    </fieldset>
</form>
</div>
        <!--Pie de página-->
    <%@include file="Footer.jsp"%>

</body>

</html>