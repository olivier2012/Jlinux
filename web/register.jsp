<%@ page errorPage="error.jsp" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    </head>
    <%@include file="header.html" %> 
    <%
        session.getAttribute("User_name");
        session.getAttribute("Passwd");
        session.invalidate();
    %>


    <form action="RegisterServlet" method="post" id="register-box">
        <h3>User Registration Form</h3>
        <div class="form-inline">

            <div class="form-group ">
                <label class="control-label col-sm-4" for="fn" >First Name</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control input-md " id="fname" name="Fname" maxlength="30"/>
                </div>
            </div>
                            
            <div class="form-group">
                <label class="control-label col-sm-4" >Middle Name</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control input-md" id="mname" name="Mname" maxlength="30"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-4" >Last Name</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control input-md" id="lname" name="Lname" maxlength="30"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-4" >Email</label>
                <div class="col-sm-2">
                    <input type="email" class="form-control input-md" id="email" name="email" maxlength="30"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-4" >User Name</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control input-md" id="User_name" name="User_name" maxlength="30"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-4" >Password</label>
                <div class="col-sm-2">
                    <input type="password" class="form-control input-md" id="Passwd" name="Passwd" maxlength="30"/>
                </div>
            </div>
            
            <div class="form-group" >
                <span class="col-sm-2 col-sm-offset-2">
                    <input class="btn btn-primary" type="submit" value="Submit"></span>
                <span class="col-sm-2 col-sm-offset-5">
                    <input class="btn btn-info" type="reset" value="Reset">
                </span>
            </div>
    </form>
    <%@include file="footer.html" %> 
</body>
</html>
