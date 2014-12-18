<%-- 
    Document   : offer
    Created on : 16 déc. 2014, 15:44:56
    Author     : xavierrouayroux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/footer.css" rel="stylesheet">
        <link href="css/login.css" rel="stylesheet">
        <title>Offer SupSMS</title>
    </head>
    <body>
    <jsp:include page="menu.jsp" />
        <div class="col-md-10 col-md-offset-1">
            <div class="jumbotron text-center">
                <h2>NEW OFFER</h2>
                <p>Only for 10€ by month</p>
                <img src="img/premium.png" class="img-responsive center-block" alt="Responsive image"><br/>
           <p>You just have to create an account and you can start !Premium user have no sms limitation and much more !</p>
            <p><a class="btn btn-primary btn-lg btn-block" href="register.jsp" role="button">Sign up </a></p>         
            </div>
        </div>
    <jsp:include page="footer.jsp" />
    </body>
</html>
