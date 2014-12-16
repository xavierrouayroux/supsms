<%-- 
    Document   : register
    Created on : 16 déc. 2014, 09:16:12
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
        <h1>Sign up !</h1>
        <form action="RegisterServlet" method="POST">            
            <input type="text" name="username" placeholder="Username"/><br>
            <input type="email" name="mail" placeholder="Email"/><br>
            <input type="text" name="first_name" placeholder="First name"/><br>
            <input type="text" name="last_name" placeholder="Last name"/><br>
            <input type="password" name="pwd" placeholder="Password"/><br>
            <input type="submit" value="Register" />
        </form>
    </body>
</html>
