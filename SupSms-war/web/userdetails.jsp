<%-- 
    Document   : userdetails
    Created on : 18 déc. 2014, 23:46:00
    Author     : fabien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="com.supsms.entity.UserEntity" %>
<jsp:useBean id="usersList" class="com.supsms.entity.UserEntity" scope="session"/>
<% UserEntity u = (UserEntity)request.getSession().getAttribute("UtilisateurConnecte"); %>
<% if(u == null) { %> <% response.sendRedirect("login.jsp"); %> <% } %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/footer.css" rel="stylesheet">
        <link href="css/login.css" rel="stylesheet">
        <title>Main SupSMS</title>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="container col-lg-3 col-lg-offset-1">
            <form class="form-signin" role="form" action="EditServlet" method="POST">
                <h2 class="form-signin-heading">User details</h2>
                <input class="form-control" type="text" name="username" placeholder="${UtilisateurConnecte.userName}" value="" readonly="yes"/>
                <input class="form-control" type="email" name="mail" placeholder="${UtilisateurConnecte.email}"/>
                <input class="form-control" type="text" name="first_name" placeholder="${UtilisateurConnecte.firstName}"/>
                <input class="form-control" type="text" name="last_name" placeholder="${UtilisateurConnecte.lastName}"/>
            </form>
        </div>
        <div class="container col-lg-7">
            <h2 class="sub-header">Invoices of user</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr class="info" >
                            <th>Payement date</th>
                            <th>Date of end</th>
                        </tr>
                    </thead>
                        <tbody>
                            <c:forEach var="user" items="${usersList}">
                                <tr>
                                    <th>${user.userName}</th>
                                    <th>${user.email}</th>
                                </tr>
                            </c:forEach>
                        </tbody>
                </table>
            </div>     <!-- table responsive-->
        </div>
    <jsp:include page="footer.jsp" />
    </body>
</html>
