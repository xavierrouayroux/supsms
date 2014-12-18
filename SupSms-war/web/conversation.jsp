<%-- 
    Document   : conversation
    Created on : 16 déc. 2014, 12:57:23
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
        <form action="ConversationServlet" method="POST">
            <h1>Conversation Page !</h1>
            <textarea rows="20" cols="250"></textarea><br>
            <input type="text" name="msgSend" size="125">
            <input type="submit" value="Send">
        </form>
    </body>
</html>
