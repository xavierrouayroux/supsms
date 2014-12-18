<%-- 
    Document   : logout
    Created on : 16 déc. 2014, 16:05:55
    Author     : xavierrouayroux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="com.supsms.entity.UserEntity" %>
<% UserEntity u = (UserEntity)request.getSession().getAttribute("UtilisateurConnecte"); %>
<% if(u != null) { %> <% request.getSession().setAttribute("UtilisateurConnecte", null);
                         response.sendRedirect("index.jsp");
 %> <% } %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
