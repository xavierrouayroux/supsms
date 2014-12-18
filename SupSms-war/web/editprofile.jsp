<%-- 
    Document   : editprofile
    Created on : 18 déc. 2014, 14:29:10
    Author     : fabien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="com.supsms.entity.UserEntity" %>
<% UserEntity u = (UserEntity)request.getSession().getAttribute("UtilisateurConnecte"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/footer.css" rel="stylesheet">
        <link href="css/login.css" rel="stylesheet">
        <title>Edit profile SupSMS</title>
    </head>
    <body>
    <jsp:include page="menu.jsp" />
        <div class="container">
            <form class="form-signin" role="form" action="EditServlet" method="POST">
                <h2 class="form-signin-heading">Edit profile</h2>
                <input class="form-control" type="text" name="username" placeholder="<%= u.getUserName()%>" value="" readonly="yes"/>
                <input class="form-control" type="email" name="mail" placeholder="<%= u.getEmail() %>"/>
                <input class="form-control" type="text" name="first_name" placeholder="<%= u.getFirstName() %>"/>
                <input class="form-control" type="text" name="last_name" placeholder="<%= u.getLastName() %>"/>
                <input class="form-control" type="password" name="pwd" placeholder="New password"/>
                <input class="btn btn-lg btn-primary btn-block" type="submit" value="Confirm change" />
            </form>
        </div>
    <jsp:include page="footer.jsp" />
    </body>
</html>
