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
        <link href="css/login.css" rel="stylesheet">
        <title>Contact edit SupSMS</title>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="container">
            <h2 class="sub-header">Contact Edit</h2>
            <form class="form-signin" role="form" method="post" action="ContactEditServlet?id=${contact.id}">
                <h2 class="form-signin-heading">Edit ${contact.firstName}</h2>
                 <input type="text" name="firstName" class="form-control" placeholder="${contact.firstName}" required >
                 <input type="text" name="lastName" class="form-control" placeholder="${contact.lastName}" required >
                 <input type="text" name="email" class="form-control" placeholder="${contact.email}" required >
                 <input type="text" name="number" class="form-control" placeholder="${contact.phoneNumber.number}" required >
                 <input type="text" name="address1" class="form-control" placeholder="${contact.address.address1}" >
                 <input type="text" name="address2" class="form-control" placeholder="${contact.address.address2}" >
                 <input type="text" name="postalCode" class="form-control" placeholder="${contact.address.postalCode}" >
                 <input type="text" name="city" class="form-control" placeholder="${contact.address.city}" >
                 <input type="text" name="country" class="form-control" placeholder="${contact.address.country}" >
                 <div class="btn-group btn-group-lg btn-group-justified" role="group">
                    <div class="btn-group">
                        <button class="btn btn-primary " type="submit">Confirm change</button>
                    </div>
                    <div class="btn-group">
                        <button class="btn btn-danger" onclick="ContactServlet">Abort</button>
                    </div>
                 </div>
            </form>
        </div>
    <jsp:include page="footer.jsp" />
    </body>
</html>
