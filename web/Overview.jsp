<%-- 
    Document   : Overview
    Created on : 1-feb-2017, 19:27:06
    Author     : Johna
--%>

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
        
        <table>
            <tr>
                <th>Omschrijving</th>
                <th>ISBN</th>
                <th>Prijs</th>
            </tr>
                <%
                    List<AangebodenBoek> lijstAangebodenBoeken = (List<AangebodenBoek>)session.getAttribute("list");
                for (AangebodenBoek boek : lijstAangebodenBoeken) {
                        %> <tr>
                            <td>
                                <%= boek.getBoekID().getTitel()%>      
                            </td>
                            <td>
                                <%= boek.getBoekID().getIsbn()%>
                            </td>
                            <td>
                                <%= boek.getPrijs()%>
                            </td>
                        </tr>
                            <%
                    }
                %>
                
            
            
            
            
        </table>
        
    </body>
</html>
