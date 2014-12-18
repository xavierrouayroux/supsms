<%-- 
    Document   : ContactEdit
    Created on : 18 déc. 2014, 15:47:01
    Author     : xavierrouayroux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="com.supsms.entity.ContactEntity" %>
<%@page  import="com.supsms.entity.UserEntity" %>
<% UserEntity u = (UserEntity)request.getSession().getAttribute("UtilisateurConnecte"); %>
<% if(u == null) { %> <% response.sendRedirect("login.jsp"); %> <% } %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/footer.css" rel="stylesheet">
        <title>Contact edit SupSMS</title>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="container">
            <h2 class="sub-header">CONTACT EDIT</h2>
            <form class="form" role="form" method="post" action="/contact-edit/?id=${contact.id}">
            <h2 class="form-signin-heading">Edit ${contact.firstName}</h2>
             <input type="text" name="firstName" class="form-control" value="${contact.firstName}" required >
             <input type="text" name="lastName" class="form-control" value="${contact.lastName}" required >
             <input type="text" name="email" class="form-control" value="${contact.email}" required >
             <input type="text" name="number" class="form-control" value="${contact.phoneNumber.number}" required >
             <input type="text" name="address1" class="form-control" value="${contact.address.address1}" >
             <input type="text" name="address2" class="form-control" value="${contact.address.address2}" >
             <input type="text" name="postalCode" class="form-control" value="${contact.address.postalCode}" >
             <input type="text" name="city" class="form-control" value="${contact.address.city}" >
             <input type="text" name="country" class="form-control" value="${contact.address.country}" >
            <button class="btn btn-lg btn-primary btn-block" type="submit">EDIT</button>
        </form>
        </div>
    <jsp:include page="footer.jsp" />
    </body>
</html>
