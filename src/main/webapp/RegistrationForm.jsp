<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link href="static/style1.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Sing up</title>
<style type="text/css">
body {
  margin: 0;
  padding: 0;
  background-color: #17a2b8;
  height: 100vh;
}
#login .container #login-row #login-column #login-box {
  margin-top: 30px;
  max-width: 600px;
  height: 490px;
  border: 1px solid #9C9C9C;
  background-color: #EAEAEA;
}
#login .container #login-row #login-column #login-box #login-form {
  padding: 20px;
}
#login .container #login-row #login-column #login-box #login-form #register-link {
  margin-top: -85px;
}
</style>
</head>
<body>

	
			<form name="myForm" action="registrationServlet" method="post">
	<div id="login">
       
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="registrationServlet" method="post">
                            <h3 class="text-center text-info">sing up</h3>
                            <div class="form-group">
                                <label for="username" class="text-info" >First name:</label><br>
                                <input type="text" name="first_name" id="username" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="username" class="text-info">Last name:</label><br>
                                <input type="text" name="last_name" id="username" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="username" class="text-info">Email</label><br>
                                <input type="text" name="email" id="username" class="form-control" >
                            </div>
                            <div class="form-group">
                                <label for="username" class="text-info">Password:</label><br>
                                <input type="password" name="password" id="password" class="form-control" >
                            </div>
                            <div class="form-group">
                                
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="sing up">
                            </div>
                            
                            
                              <div class="form-group">
                                
                                <a href="loginForm.jsp" class="btn btn-info btn-md"> cancel  </a>
                            </div>
                            
                            
                           
                        </form>
                    </div>
                </div>
            </div>
            </div>
            </div>
            
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	</form>

	
			
</body>
</html>