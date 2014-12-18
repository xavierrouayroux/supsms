<%-- 
    Document   : admin
    Created on : 18 déc. 2014, 15:43:06
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
        <div class="container">
            <h2 class="sub-header">Users administration</h2>
             <div class="table-responsive">
            <table class="table table-striped">
               <thead>
                <tr class="info" >
                  <th>Username</th>
                  <th>Mail</th>
                  <th>Delete</th>
                </tr>
              </thead>
                <tbody>
                    <c:forEach var="user" items="${usersList}">
                        <tr>
                            <th>${user.userName}</th>
                            <th>${user.email}</th>
                            <th><a href="${user.id}">X</a></th>
                        </tr>
                    </c:forEach>
		</tbody>
            </table>
        </div>     <!-- table respinsive-->
        </div>
    <jsp:include page="footer.jsp" />
    </body>
</html>
