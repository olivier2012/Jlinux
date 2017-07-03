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
<div id ="register-box">
<h3>User Registration Form</h3>
    <%     
         session.getAttribute("User_name");
         session.getAttribute("Passwd");
         session.invalidate();
     %>
<form action="RegisterServlet" method="post">
<table  align="center" cellpadding = "10">
<tr>
<td>First Name</td>
<td><input type="text" name="Fname" maxlength="30"/>
</td>
</tr>
<tr>
<td>Middle Name</td>
<td><input type="text" name="Mname" maxlength="30"/>
</td>
</tr>
<tr>
<td>Last Name</td>
<td><input type="text" name="Lname" maxlength="30"/>
</td>
</tr>
<tr>
<td>Email</td>
<td><input type="text" name="Email" maxlength="100" /></td>
</tr>
<tr>
<td>User Name</td>
<td><input type="text" name="User_name" maxlength="100" /></td>
</tr>
<tr>
<td>Password</td>
<td><input type="text" name="Passwd" maxlength="100" /></td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="Submit">
<input type="reset" value="Reset">
</td>
</tr>
</table>
</form>
</div>
 <%@include file="footer.html" %> 
</body>
</html>
