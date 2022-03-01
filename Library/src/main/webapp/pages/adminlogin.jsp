<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    
<!DOCTYPE html>

<html>
	<title>Login Page</title>
<head>
	<link href="../CSS/first.css" rel="stylesheet">

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style>
.login-container8 {
margin-top: 10%;
margin-bottom: 5%;
margin-left:30%;
}
</style>
</head>
<body>
<div class="center fixed-top" style="color: rgb(15, 1, 1);">
<header><strong><h1 style="font-weight: bold;">Library Management System</h1></strong></header>
</div>
<div class="container login-container8">
            <div class="row">
             
                <div class="col-md-6 login-form-1">
                    <h3>Admin Login Form </h3>
                    <form action="adminlogin.do"  method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Enter Admin ID" name="adminid" />
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Enter Password" name="adminpassword" />
                        </div>
                        <div class="form-group d-flex justify-content-center align-items-center container">
                            <input type="submit" class="btnSubmit" value="Login" />
                        </div>
                         <div class="form-group justify-content-center align-items-center">
                            <a href="adminregistration.jsp" class="ForgetPwd">Do Want to Register</a>
                        </div>
				<div
						class="form-group d-flex justify-content-center align-items-center container">
						<c:choose>
							<c:when test="${requestScope.success!=null}">
							<b><font color="green">${requestScope.success}</font></b>
							</c:when>
							<c:otherwise>
							<b><font color="red">${requestScope.Err}</font></b>
							</c:otherwise>
							
						</c:choose>
					
					</div>
                    </form>
                </div>
            </div>
        </div>

		<footer class="text-center text-white fixed-bottom" style="background-color: #0a090a;">
			<!-- Grid container -->
			<div class="container p-2"></div>
			<!-- Grid container -->
		  
			<!-- Copyright -->
			<div class="text-center p-2" style="background-color: rgba(36, 2, 2, 0.2);">
			  © NTT DATA Copyright:
      <a class="text-white" href="https://www.linkedin.com/in/anil-l-b023631b6/">Anil.com</a>
			</div>
			<!-- Copyright -->
		  </footer>
		</body>

		</html>