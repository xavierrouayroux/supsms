<%-- 
    Document   : index
    Created on : 16 déc. 2014, 12:47:59
    Author     : xavierrouayroux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="com.supsms.entity.UserEntity" %>
<% UserEntity u = (UserEntity)request.getSession().getAttribute("UtilisateurConnecte"); %>
<% if(u != null) { %> <% response.sendRedirect("main"); %> <% } %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/footer.css" rel="stylesheet">
        <title>SUP SMS</title>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="container">

      <!-- START THE FEATURETTES -->
       <div class="jumbotron">

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">Discover SupSMS <span class="text-muted">Create conversation with your friends</span></h2>
          <p class="lead">With SupSMS you can now speak with all your contacts directly from our site !See our offer :<a href="offer.jsp">Offer page</a></p>
        </div>
        </br>
       
	 </div>

    </div><!-- /.container -->
    
       <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-6">
          <h2>Simplicity</h2>
          <p>With SupSMS you can easily manage your contacts and your your converations.</p>
        </div>
        <div class="col-md-6">
          <h2>Accesibility</h2>
          <p>You can sent all your contacts directly from your smartphone by web service.</p>
        </div>
      </div>
       </div>
    
    <jsp:include page="footer.jsp" />
    </body>
</html>
