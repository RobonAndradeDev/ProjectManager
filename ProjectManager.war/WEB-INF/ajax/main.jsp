<%@page import="com.soberuh.Util.StringConstants"%>
<%@page import="com.soberuh.Bussiness.Project"%>
<%@page import="java.util.ArrayList"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<ul>

<c:forEach items="${projetos}" var="projeto">
    <a href=${projeto.id}><li> ${projeto.nome} </li></a>
</c:forEach>

</ul>