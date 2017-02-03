<%-- 
    Document   : NieuwBoek
    Created on : 1-feb-2017, 21:47:05
    Author     : Johna
--%>

<%@page import="DAL.Boek"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nieuw boek</h1>        
            <table>
                <form action="/Web_BoekenMarkt/FilteredBoekList" method="POST" id="richting">
                    <tr>
                        <td>Titel:</td>
                        <td><input type="text" name="titel" value=""></td>
                    </tr>
                    <tr>
                    <td>Kies de richting:</td>
                    <td><select name="isRichting" form="richting">
                        <option value="empty"></option>
                        <% 
                            List<String> allRichting = (List<String>)session.getAttribute("richting");
                            for (String richting : allRichting) {
                                %><option value="<%= richting%>"><%= richting%></option>
                                <%
                            }
                        %>
                        </select></td>
                    </tr>
                    <tr>
                        <td>Isbn:</td>
                        <td><input type="text" name="isbn" value=""></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="registreer"></td>
                    </tr>
                </form> 
            </table>        
    </body>
</html>
