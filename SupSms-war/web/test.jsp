<%-- 
    Document   : test
    Created on : 14 déc. 2014, 17:52:00
    Author     : fabien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="com.supsms.entity.UserEntity" %>
<% UserEntity u = (UserEntity)request.getSession().getAttribute("UtilisateurConnecte"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Utilisateur connecté : <% if(u != null) { %> <%= u.getFirstName().concat(" ").concat(u.getLastName()).concat(" ").concat(u.getEmail()) %> <% } else { %>
        Aucun utilisateur connecté <% } %>
       
    </body>
</html>
