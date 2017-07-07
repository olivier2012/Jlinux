<%@page import="Hiber.DB.hw.Jlinux_User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="index.html" %>  
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Jlinux System Information</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="shortcut icon" type="image/png" href="img/favicon.png"/>
        <link rel="stylesheet" type="text/css" href="../css/main.css"/>
    </head>
    <%@include file="header.html" %> 
     <%
             Object User_name = session.getAttribute("User_name");
             
            Object Passwd = session.getAttribute("Passwd");
            Object b_result = session.getAttribute("session_result");
            Jlinux_User b_user = (Jlinux_User) session.getAttribute("user");
            /*customer have login , then second time click the Login menu , they will go home page directly*/
            if (Integer.parseInt("b_result")==1 && User_name.toString() == b_user.getUser_name() && Passwd.toString() == b_user.getPasswd()) {
                response.sendRedirect("home.jsp");
            } 
                   %>
    <form method="get" action="LoginServlet">
        <div style="padding: 100px 0 0 250px;">
            <div id="login-box">
                <h2>Login Page</h2>
                Please provide your credential to use this website
                <br>
                </br>
                <div id="login-box-name" style="margin-top:20px;">User Name:</div>
                <div id="login-box-field" style="margin-top:20px;">
                    <input name="User_name" class="form-login" title="Username" value="" size="30" maxlength="50" />
                </div>
                <div id="login-box-name">Password:</div>
                <div id="login-box-field">
                    <input name="Passwd" type="password" class="form-login" title="Password" value="" size="30" maxlength="48" />
                </div>
                <br />
                <span class="login-box-options">
                    New User  ?    <a href="register.jsp" style="margin-left:20px;">Register Here</a>
                </span>
                <br />
                <br />
                <input style="margin-left:100px; color: #1e4f8a" type="submit" value="Login" />
            </div>
        </div>
    </form>
    <%@include file="footer.html" %> 
</body>
</html>