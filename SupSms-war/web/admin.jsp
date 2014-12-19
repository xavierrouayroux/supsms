<%-- 
    Document   : admin
    Created on : 18 déc. 2014, 15:43:06
    Author     : fabien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="com.supsms.entity.UserEntity" %>
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
        <title>Administration SupSMS</title>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="container col-lg-10 col-lg-offset-1">
            <h2 class="sub-header">Users administration</h2>
             <div class="table-responsive">
            <table class="table table-striped">
               <thead>
                <tr class="info" >
                  <th>Username</th>
                  <th>Mail</th>
                </tr>
              </thead>
                <tbody>
                    <c:forEach var="usrlist" items="${requestScope['UsersList']}">
                        <tr>
                            <th class="col-lg-5">${usrlist.userName}</th>
                            <th class="col-lg-5">${usrlist.email}</th>
                            <th><input value="Invoice(s)" class="btn btn-info btn-xs"></th>
                            <th><input value="Delete" class="btn btn-danger btn-xs"></th>
                        </tr>
                    </c:forEach>
		</tbody>
            </table>
        </div>     <!-- table responsive-->
        </div>
    <jsp:include page="footer.jsp" />
    </body>
</html>
