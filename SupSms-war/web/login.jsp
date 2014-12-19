<%-- 
    Document   : login
    Created on : 14 déc. 2014, 15:43:58
    Author     : fabien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="com.supsms.entity.UserEntity" %>
<% UserEntity u = (UserEntity)request.getSession().getAttribute("UtilisateurConnecte"); %>
<% if(u != null) { %> <% response.sendRedirect("main.jsp"); %> <% } %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/footer.css" rel="stylesheet">
        <link href="css/login.css" rel="stylesheet">
        <title>Login SUPSMS</title>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
         <div class="container">
             <c:if test="${not empty message}">
                <p> ${message}</p>
             </c:if>
             
            <form class="form-signin" role="form" action="ProcessSignIn" method="POST">
                <h2 class="form-signin-heading">Enter your information</h2>
                <p class="form-signin-heading">New user ? <a href="register.jsp">Sign Up</a></p>
                <input type="Text" name="login" class="form-control" placeholder="UserName"  required autofocus />
                <input type="password" name="mdp" class="form-control" placeholder="Password" required/>
                <input class="btn btn-lg btn-primary btn-block" type="submit" value="Sign In" />
            </form>
         </div>
    <jsp:include page="footer.jsp" />
    </body>
</html>
