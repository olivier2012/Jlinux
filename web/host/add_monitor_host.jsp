<%@ page errorPage="error.jsp" %>  
<%@page import="jl.service.LoginService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="Hiber.DB.hw.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="../css/main.css" rel="stylesheet" type="text/css" /> 
        <title>Add the New Host to Monitor</title>
    </head>
    <%@include file="host_header.html" %> 
    <center>
        <div id="container">
            <h1>Hardware Page</h1>
            <b>You from Host name : <%= request.getRemoteHost() + "   IP Address : " + request.getRemoteAddr() + "------ Port: " + request.getRemotePort()%></b>   
            <br/>
            <%=new Date()%></br>
            <%
                User user = (User) session.getAttribute("user");
            %>     
            <b>Welcome <%= user.getFname() + " " + user.getLname() + "------ UserID: " + user.getUserId()%></b>     
            <br/>
            <a class="btn btn-info" href="../logout.jsp">Logout</a> <a class="btn btn-info" href="../logout.jsp">Add the New host</a> <a class="btn btn-info" href="../logout.jsp">Update the host information </a>
        </div>
        <form action="add_monitor_host_servlet" method="post" id="host-register-box">
            <h3>Host add Form</h3>
            <div class="form-inline">

                <div class="form-group ">
                    <label class="control-label col-sm-4" for="fn" >Host_name</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control input-md " id="host_name_ssh" name="host_name_ssh" maxlength="30"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-4" >User_name</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control input-md" id="User_name_ssh" name="User_name_ssh" maxlength="30"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-4" >Ssh Password</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control input-md" id="passwd_ssh" name="passwd_ssh" maxlength="30"/>
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
    </center>
    <%@include file="host_footer.html" %> 
</html>