<%-- 
    Document   : menu
    Created on : 16 déc. 2014, 13:01:16
    Author     : xavierrouayroux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="com.supsms.entity.UserEntity" %>
<% UserEntity u = (UserEntity)request.getSession().getAttribute("UtilisateurConnecte"); %>
<div class="navbar-wrapper">
      <div class="container">

        <div class="navbar navbar-inverse navbar-static-top" role="navigation">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
                <a class="navbar-brand" href="index.jsp">SUP SMS</a>
            </div>
                <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                <li ><a href="index.jsp">Home</a></li>
              
                <li><a href="offer.jsp">Offer</a></li>
                <li><a href="login.jsp">Log in</a></li>
                <li><a href="register.jsp">Register</a></li>
                <%
                  if (u != null) {
                      out.print("<li><a href=\"EditServlet\">Profile</a></li>");
                      out.print("<li><a href=\"ContactServlet\">Contacts</a></li>");
                      if (u.isIsAdmin() == true) {
                          out.print("<li><a href=\"AdminServlet\">Admin</a></li>");
                      }
                  }
                %>
                <li><a href="#contact">About</a></li>
             </ul>
            </div>
          </div>
        </div>

      </div>
    </div>
