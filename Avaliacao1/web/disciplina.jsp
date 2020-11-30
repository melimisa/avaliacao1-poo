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
    String errorMessage = null;
    if(request.getParameter("insert")!=null){
        try{
        String nome = request.getParameter("nome");
        String ementa = request.getParameter("ementa");
        int ciclo = Integer.parseInt(request.getParameter("ciclo"));
        double nota = Double.parseDouble(request.getParameter("nota"));
        Disciplina.insert(nome, ementa, ciclo, nota);
        response.sendRedirect(request.getRequestURI());
        }
        catch(Exception ex){
            errorMessage = "Erro ao inserir disciplina: " + ex.getMessage();
        }
    }
    
    if(request.getParameter("delete")!=null){
        try{
        int id = Integer.parseInt(request.getParameter("id"));
        Disciplina.delete(id);
        response.sendRedirect(request.getRequestURI());
        }
        catch(Exception ex){
            errorMessage = "Erro ao deletar disciplina: " + ex.getMessage();
        }
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
        <form>
            <input type="text" name="nome">
            <input type="text" name="ementa">
            <input type="text" name="ciclo">
            <input type="text" name="nota">
            <input type="submit" name="insert" value="enviar">
        </form>
        <br>
        <hr>
        <table border='1'>
            <tr>
                <th>Índice</th>
                <th>Nome</th>
                <th>Ementa</th>
                <th>Ciclo</th>
                <th>Nota</th>
                <th colspan="2">Excluir disciplina</th>
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
                                <input type="submit" name="excluir" value="Excluir">
                                <input type="hidden" name="id" value="<%= disciplina.getId() %>">
                            </form>
                        </td>
                    </tr>
                    
            <% } %>
        </table>    
        
    </body>
</html>
