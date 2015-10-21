<%@page import="com.soberuh.Util.StringConstants"%>
<%@page import="com.soberuh.Bussiness.Developer"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:out value="${sessionScope.login}"/>
<%
Developer dev = (Developer) request.getSession().getAttribute(StringConstants.ATTR_LOGIN);
boolean warm = true;
boolean firstTime = request.getAttribute(StringConstants.ATTR_FIRST_TIME)==null?false:true;
if(dev != null){
	warm = false;
}
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
<title>Projects Manegement</title>
</head>
<body>
<div id="conteinner" data-warm="<%=warm%>" data-firsttime="<%=firstTime%>" >
  <h2 id="header">Login</h2>
  <div id="content">
	<form id="loginForm" action="controller.jsp" method="post">
		<input type="hidden"name="classe" value="DeveloperDAO" />
		<input type="hidden" name="command" value="List" />	
		<input type="email" name="email" id="email" placeholder="mail@adress.com" class="text" required="required"/>
		<input type="password" name="senha" id="senha" placeholder="password" class="text" required="required"/>
	 	<input type="submit" id="login" value="Entrar" />
	 </form>
	</div>
</div>
</body>
</html>