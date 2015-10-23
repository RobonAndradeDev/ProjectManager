<%@ page import="com.soberuh.Bussiness.Developer" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<% Developer dev = (Developer) request.getSession().getAttribute("login"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Project Manager</title>
    <link rel="stylesheet" type="text/css" href="/ProjectManager/css/main.css">
    <script type="text/javascript" src="/ProjectManager/js/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="/ProjectManager/js/main.js"></script>
</head>
<body>
	<header id="generalHeader">
    	Projects Manager
        <span id="nameUser">Bem vindo, <%= dev.getNome()%></span>
	 </header>
     <section id="conteinerSection">
     	<section id="centerSection">
            <div id="centerDiv">
                <header>
                    Tasks List
                </header>
                <div id="centerContent">
                	aki tem coisa
                </div>
            </div>
            <aside>
            	<div id="myProjects">
                    <header>
                        My Projects <a href="#" id="updateMyProjects"> <img id="imgRefresh" src="/ProjectManager/img/atualizar.png" /> </a>
                    </header>
                    <div id="myProjectContent">
                    	projeto 1
                    </div>
                </div>
            	<div id="allProjects">
                    <header>
                        All Projects <a href="#" id="updateAllProjects"> <img id="imgRefresh" src="/ProjectManager/img/atualizar.png" /> </a>
                    </header>
                    <div id="allProjectContent">
                        projeto 1
                        projeto 2
                    </div>
                </div>
            </aside>
        </section>
     </section>
     <footer>
     	
     </footer>
</body>
</html>