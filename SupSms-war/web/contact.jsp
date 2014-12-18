<%-- 
    Document   : contact
    Created on : 18 déc. 2014, 14:25:15
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
        <title>Contact SupSMS</title>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="container">
             <h2 class="sub-header">MANAGE YOUR CONTACTS</h2>
             <div class="table-responsive">
            <table class="table table-striped">
               <thead>
                <tr class="info" >
                  <th>First name</th>
                  <th>Last name</th>
                  <th>Phone number</th>
                  <th>Email</th>
                </tr>
              </thead>
                <tbody>
                    <c:forEach var="contacts">
                        <tr>
                          <th><a href="/contact-edit/?id=${contacts.id}">${contacts.firstName}</a></th>
                          <th>${contacts.lastName}</th>
                          <th>${contacts.phoneNumber.number}</th>
                          <th>${contacts.email}</th>
                        </tr>
                    </c:forEach>
		</tbody>
            </table>
        </div>     <!-- table respinsive-->
        </br></br>

        <form class="form" role="form" method="post" action="/Contact">
            <h2 class="form-signin-heading">Create a new contact</h2>
             <input type="text" name="firstName" class="form-control" placeholder="first name" required >
             <input type="text" name="lastName" class="form-control" placeholder="last name" required >
             <input type="text" name="email" class="form-control" placeholder="email" required >
             <input type="text" name="number" class="form-control" placeholder="phone number" required >
             <input type="text" name="address1" class="form-control" placeholder="address" >
             <input type="text" name="address2" class="form-control" placeholder="address2" >
             <input type="text" name="postalCode" class="form-control" placeholder="postal code" >
             <input type="text" name="city" class="form-control" placeholder="city" >
             <input type="text" name="country" class="form-control" placeholder="country" >
            <button class="btn btn-lg btn-primary btn-block" type="submit">Create</button>
        </form>
        
        </div>
    <jsp:include page="footer.jsp" />
    </body>
</html>
