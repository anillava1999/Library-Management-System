<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<title>Login Page</title>
<head>
	<link href="../CSS/first.css" rel="stylesheet">

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
</head>
<body>
<div class="center" style="background-color: #ffffff">
<header><strong><h1 style="font-weight: bold;">Library Management System</h1></strong></header>
</div>
<div class="container  login-container2 offset-1">
            <div class="row justify-content-center ">
                <div class="col-md-6 login-form-1 col-mb-1 col-mt-1">
                    <h3>Request Book Form</h3>
                    <form action="requestbook.do">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Enter Student ID" name="studentid" />
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Enter Book ISBN " name="isbn" />
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Enter Request Book Name" name="requestbook" />
                        </div>
                        <div class="form-group">
                            <input type="date" class="form-control" placeholder="Enter Request Book Date" name="requestdate" />
                        </div>
                    
                        <div class="form-group d-flex justify-content-center align-items-center container">
                            <input type="submit" class="btnSubmit " value="Request Book" />
                        </div>
                
                    <div class="form-group d-flex justify-content-center align-items-center container ">
                        <a href="studenthome.jsp" class="ForgetPwd ">Back</a>
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
                    	<span><a href="Adminerror.jsp"> </a></span>
                    
                </div>
            </div>
            </div>
            <div>
               
            </div>
        <footer class="text-center text-white fixed-bottom" style="background-color: #0a090a;">
    <!-- Grid container -->
    <div class="container p-2"></div>
    <!-- Grid container -->
  
    <!-- Copyright -->
    <div class="text-center p-2" style="background-color: rgba(36, 2, 2, 0.2); color:#f2f2f2;">
      ?? NTT DATA Copyright:
      <a class="text-white" href="https://www.linkedin.com/in/anil-l-b023631b6/">Anil.com</a>
    </div>
    <!-- Copyright -->
  </footer>
		</body>

		</html>