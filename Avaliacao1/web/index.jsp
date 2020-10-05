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
<%
    ArrayList<Disciplina> disciplinaList = (ArrayList) application.getAttribute("disciplinaList");
        if(disciplinaList == null){
            disciplinaList = new ArrayList();
            disciplinaList.add(new Disciplina("Programação Orientada a Objetos", "POO", 4));
            disciplinaList.add(new Disciplina("Engenharia de Software 3", "ES3", 4));
            disciplinaList.add(new Disciplina("Engenharia de Software 3", "ES3", 4));
            disciplinaList.add(new Disciplina("Sistemas Operacionais 2", "SO2", 4));
            disciplinaList.add(new Disciplina("Linguagem de Programação 4", "LP4", 4));
            disciplinaList.add(new Disciplina("Metodologia", "MET", 4));
            disciplinaList.add(new Disciplina("Banco de Dados", "BD", 4));
            disciplinaList.add(new Disciplina("Segurança da Informação", "Seg. I", 5));
            application.setAttribute("disciplinaList", disciplinaList);
        }

%>
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
        <h2>Disciplinas cursadas: <%= Disciplina.getList(disciplinaList).size() %></h2>
    </body>
</html>
