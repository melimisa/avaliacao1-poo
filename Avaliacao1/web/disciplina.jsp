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

    
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>P1 - Disciplinas</title>
    </head>
    <body>
        <h1> Disciplinas</h1>
        <table border='1'>
            <tr>
                <th>Índice</th>
                <th>Nome</th>
                <th>Ementa</th>
                <th>Ciclo</th>
                <th>Nota</th>
                <th colspan="2">Alterar Nota</th>
            </tr>
            
            <%for( Disciplina disciplina: Disciplina.getList()){%>
                    <tr>
                        <td> <%= disciplina.getId() %> </td>
                        <td> <%= disciplina.getNome() %> </td>
                        <td> <%= disciplina.getEmenta()  %> </td>
                        <td> <%= disciplina.getCiclo()  %> </td>
                        <td> <%= disciplina.getNota()  %> </td>
                        <td>
                            <form method="post">
                                <input type="number" name="nota">
                                <input type="submit" name="altera" value="Alterar">
                                <input type="hidden" name="i" value="<%= disciplina.getId() %>">
                            </form>
                        </td>
                    </tr>
                    
            <% } %>
        </table>    
        
    </body>
</html>
