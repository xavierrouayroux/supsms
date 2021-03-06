<%-- 
    Document   : register
    Created on : 16 déc. 2014, 09:16:12
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
        <title>Register SupSMS</title>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="container">
            <form class="form-signin" role="form" action="RegisterServlet" method="POST">
                <h2 class="form-signin-heading">Please sign up</h2>
                 <p class="form-signin-heading">You have already sign with us ? <a href="login.jsp">Sign In</a></p>
                <input class="form-control" type="text" name="username" placeholder="Username" required/>
                <input class="form-control" type="text" name="phone" placeholder="Phone Number" required/>
                <input class="form-control" type="email" name="mail" placeholder="Email" required/>
                <input class="form-control" type="text" name="first_name" placeholder="First name" required/>
                <input class="form-control" type="text" name="last_name" placeholder="Last name" required/>
                <input class="form-control" type="password" name="pwd" placeholder="Password" required/>
                <input class="btn btn-lg btn-primary btn-block" type="submit" value="Sign Up" />
            </form>
        </div>
    <jsp:include page="footer.jsp" />
    </body>
</html>
