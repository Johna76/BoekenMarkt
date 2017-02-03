<%-- 
    Document   : Overview
    Created on : 1-feb-2017, 19:27:06
    Author     : Johna
--%>

<%@page import="DAL.Boek"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAL.AangebodenBoek"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="/Web_BoekenMarkt/NewBoekServlet" method="POST">
        <table>
            <tr>
                <th>Omschrijving</th>
                <th>ISBN</th>
                <th>Richting</th>
            </tr>
                <%
                    List<Boek> lijstBoeken = (List<Boek>)session.getAttribute("filteredList");
                for (Boek boek : lijstBoeken) {
                        %> <tr>
                            <td>
                                <a href="/Web_BoekenMarkt/NewBoekServlet?BoekID=<%= boek.getId()%>"><%= boek.getTitel()%></a>      
                            </td>
                            <td>
                                <%= boek.getIsbn()%>
                            </td>
                            <td>
                                <%= boek.getRichting()%>
                            </td>
                        </tr>
                            <%
                    }
                %>
                
        </table>
        </form>
    </body>
</html>
