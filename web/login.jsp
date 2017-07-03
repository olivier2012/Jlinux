<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;  />
<title>Login Page</title>
      <meta conten="width=device-width,inital-scal=1.0 " name="viewport">
      <meta  charset="utf-8">
       <script
       src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
       integrity="sha256-k2WSCIexGzOj3Euiig+TlR8gA0EmPjuc79OEeY5L45g="
       crossorigin="anonymous"></script>      
       <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
       <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
       <script src="/js/libs.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" /> 
</head>
<body>
<form method="post" action="LoginServlet">
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
     New User  ?    <a href="register.jsp?User_name=value&Passwd=value" style="margin-left:20px;">Register Here</a>
</span>
<br />
<br />
<input style="margin-left:100px; color: #1e4f8a" type="submit" value="Login" />
</div>
</div>
</form>
</body>
</html>