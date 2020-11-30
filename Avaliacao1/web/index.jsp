<%-- 
    Document   : index
    Created on : 5 de out de 2020, 00:05:42
    Author     : isame
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="avaliacao1.Disciplina" %>
<%@include file="WEB-INF/menu.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>P1 - Início</title>
    </head>
    <body>
        <h1>Início</h1>
        <a href="sobre.jsp">Sobre</a>
        <a href="disciplina.jsp">Disciplinas</a>
        <h2>Isabela Pereira Melim</h2>
        <h2>RA: 1290481913020</h2>
        <h2>Disciplinas cursadas: <%= Disciplina.getDisciplinasCount() %></h2>
    </body>
</html>
