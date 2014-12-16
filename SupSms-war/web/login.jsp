<%-- 
    Document   : login
    Created on : 14 déc. 2014, 15:43:58
    Author     : fabien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Veuillez vous identifier</h1>
        <form action="ProcessSignIn" method="POST">
            <input type="Text" name="login" />
            <input type="password" name="mdp" />
            <input type="submit" value="Connexion" />
        </form>
    </body>
</html>
