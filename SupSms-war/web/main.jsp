<%-- 
    Document   : main
    Created on : 18 déc. 2014, 17:16:08
    Author     : xavierrouayroux
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                  <th>Last Sms</th>
                  <th>Contact Name</th>
                  <th>Phone Number</th>
                </tr>
              </thead>
                <tbody>
                    <c:forEach var="conversation" items="${requestScope['conversations']}">
                        <tr>
                            <th class="col-lg-3">${conversation.lastSms}</th>
                            <th class="col-lg-3">${conversation.contact.firstName.concat(" ").concat(conversation.contact.lastName)}</th>
                            <th class="col-lg-3">${conversation.contact.phoneNumber.number}</th>
                            <th><input class="btn btn-info btn-xs" value="See"></th>
                            <th><a href="main?id=${conversation.id}"><input class="btn btn-danger btn-xs" value="Delete"></a></th>  
                        </tr>
                    </c:forEach>
		</tbody>
            </table>
        </div>     <!-- table respinsive-->
        
        <div class="container">
            <form class="form-signin" role="form" method="post" action="main">
                <select name="contactSelect" class="form-control">
                    <option selected="true" value="none">Contact(s) list</option>
                    <c:forEach var="contact" items="${requestScope['contacts']}">
                        <option value="${contact.id}">${contact.firstName.concat(" ").concat(contact.lastName)}</option>
                    </c:forEach>
                </select>
                <input type="tel" class="form-control" placeholder="or Phone Number" name="phone">
                <input class="btn btn-block btn-primary btn-lg" value="New conversation" type="submit">
            </form>
        </div>
        </div>
    <jsp:include page="footer.jsp" />
    </body>
</html>
