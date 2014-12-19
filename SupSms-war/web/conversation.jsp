<%-- 
    Document   : conversation
    Created on : 16 déc. 2014, 12:57:23
    Author     : fabien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="conversation" class="com.supsms.entity.ConversationEntity" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/footer.css" rel="stylesheet">
        <link href="css/login.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="container col-lg-10 col-lg-offset-1">
            <h2 class="sub-header">Conversation page with ${conversation.contact.firstName}</h2>
             <div class="table-responsive">
            <table class="table table-striped">
               <thead>
                <tr class="info" >
                  <th>Message</th>
                  <th>Date</th>
                </tr>
              </thead>
                <tbody>
                    <c:forEach var="sms" items="${requestScope['smsList']}">
                        <tr>
                            <th class="col-lg-5">${sms.content}</th>
                            <th class="col-lg-5">${sms.dateSend}</th>
                            <th class="col-lg-5">${usrlist.email}</th>
                            <th><input value="Delete" class="btn btn-danger btn-xs"></th>
                        </tr>
                    </c:forEach>
		</tbody>
            </table>
        </div>     
        </div>
        <div class="col-lg-10 col-lg-offset-1">
            <form class="form-inline" action="ConversationServlet" method="post">
        <div class="input-group">
            
            <input type="text" class="form-control" name="content">
                <span class="input-group-btn">
                    <button class="btn btn-success" type="submit">Send !</button>
                </span>
            
              </div><!-- /input-group -->
              </form>
            </div><!-- /.col-lg-6 -->
          </div><!-- /.row -->
        <jsp:include page="footer.jsp" />
    </body>
</html>
