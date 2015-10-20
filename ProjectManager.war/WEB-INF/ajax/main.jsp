<%@page import="Util.StringConstants"%>
<%@page import="Bussiness.Project"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<ul>
<%
	ArrayList<Project> projetos = (ArrayList<Project>)request.getAttribute(StringConstants.ATTR_PROJETOS);
	for(Project project : projetos){
%>
  		<a href=<%=project.getId() %>><li> <%=project.getNome() %> </li></a>
<%		
	}
%>
</ul>