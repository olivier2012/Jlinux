<html>
<head>
<title>Registration Form</title>
      <meta  charset="utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css" /> 
</head>
<body>
<div id ="register-box">
<h3>User Registration Form</h3>
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
</body>
</html>
