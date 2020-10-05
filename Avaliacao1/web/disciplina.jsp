<%-- 
    Document   : disciplina
    Created on : 5 de out de 2020, 00:27:33
    Author     : isame
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="avaliacao1.Disciplina" %>
<%@include file="WEB-INF/menu.jspf" %>
<%
    ArrayList<Disciplina> disciplinaList = (ArrayList)application.getAttribute("disciplinaList");
    try{
        if(request.getParameter("altera") != null){
        int i = Integer.parseInt(request.getParameter("i"));
        double nota = Double.parseDouble(request.getParameter("nota"));
        if(nota >= 0 && nota <= 10){
            disciplinaList.get(i).setNota(nota);
            response.sendRedirect(request.getRequestURI());
        }
        else{
            out.print("<script> alert('Nota inválida')</script>");
        }
    }
    }catch(Exception e){
        
    }
    
    
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>P1 - Disciplinas</title>
    </head>
    <body>
        <h1> Disciplinas</h1>
        <table border="1">
            <tr>
                <th>Índice</th>
                <th>Nome</th>
                <th>Ementa</th>
                <th>Ciclo</th>
                <th>Nota</th>
                <th colspan="2">Alterar Nota</th>
            </tr>
            
            <%for(int i = 0; i < Disciplina.getList(disciplinaList).size(); i++){%>
                    <% Disciplina disciplina = Disciplina.getList(disciplinaList).get(i); %>
                    <tr>
                        <td> <%=i%> </td>
                        <td> <%= disciplina.getNome() %> </td>
                        <td> <%= disciplina.getEmenta()  %> </td>
                        <td> <%= disciplina.getCiclo()  %> </td>
                        <td> <%= disciplina.getNota()  %> </td>
                        <td>
                            <form>
                                <input type="number" name="nota">
                                <input type="submit" name="altera" value="Alterar">
                                <input type="hidden" name="i" value="<%=i%>">
                            </form>
                        </td>
                    </tr>
                    
            <% } %>
            
        </table>
    </body>
</html>
