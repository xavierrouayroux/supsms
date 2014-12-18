<%-- 
    Document   : main
    Created on : 18 déc. 2014, 17:16:08
    Author     : xavierrouayroux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="com.supsms.entity.UserEntity" %>
<jsp:useBean id="UtilisateurConnecte" class="com.supsms.entity.UserEntity" scope="session"/>
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
        <title>Home, welcome to SupSMS ${UtilisateurConnecte.userName}</title>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="container">
            
            <h2 class="sub-header">Conversations history</h2>
             <div class="table-responsive">
            <table class="table table-striped">
               <thead>
                <tr class="info" >
                  <th>last sms</th>
                  <th>phone number</th>
                  <th>contact name</th>
                </tr>
              </thead>
                <tbody>
                    <c:forEach var="conversations">
                        <tr>
                          <th>${conversations.lastSms}</th>
                          <th>${conversations.sms.iterator().next().numberSend}</th>
                          <th>${conversations.contact.firstName}</th>
                        </tr>
                    </c:forEach>
		</tbody>
            </table>
        </div>     <!-- table respinsive-->
        <input class="btn btn-block btn-primary btn-lg" value="New conversation">
        </div>
    <jsp:include page="footer.jsp" />
    </body>
</html>
