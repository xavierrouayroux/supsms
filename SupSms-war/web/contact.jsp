<%-- 
    Document   : contact
    Created on : 18 déc. 2014, 14:25:15
    Author     : xavierrouayroux
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Contact SupSMS</title>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="container col-lg-3 col-lg-offset-1">
            <form class="form-signin" role="form" method="post" action="ContactServlet">
                <h2 class="form-signin-heading">Create a new contact</h2>
                 <input type="text" name="firstName" class="form-control" placeholder="First Name" required >
                 <input type="text" name="lastName" class="form-control" placeholder="Last Name" required >
                 <input type="text" name="email" class="form-control" placeholder="Mail" required >
                 <input type="text" name="number" class="form-control" placeholder="Phone Number" required >
                 <input type="text" name="address1" class="form-control" placeholder="Address" >
                 <input type="text" name="address2" class="form-control" placeholder="Address 2" >
                 <input type="text" name="postalCode" class="form-control" placeholder="Zip Code" >
                 <input type="text" name="city" class="form-control" placeholder="City" >
                 <input type="text" name="country" class="form-control" placeholder="Country" >
                <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
            </form> 
        </div>
        <div class="container col-lg-7">
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
                    <c:forEach var="contact" items="${requestScope['contacts']}">
                        <tr>
                            <th class="col-lg-4">${contact.firstName}</th>
                            <th class="col-lg-4">${contact.lastName}</th>
                            <th class="col-lg-4">${contact.phoneNumber.number}</th>
                            <th class="col-lg-4">${contact.email}</th>
                            <th class="col-lg-1"><a href="ContactEditServlet?id=${contact.id}" ><input value="Details" class="btn btn-info btn-xs"></a></th>
                            <th class="col-lg-1"><input value="Delete" class="btn btn-danger btn-xs"></th>
                        </tr>
                    </c:forEach>
		</tbody>
            </table>
        </div>

        
   <jsp:include page="footer.jsp" />
    </body>
</html>
