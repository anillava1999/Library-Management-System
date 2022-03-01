<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/CSS/first.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Error</title>

<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

.text-nowrap {
    white-space: nowrap;
    padding-left: 500px;
    text-align: inherit;
    text-size-adjust: inherit;
    text-shadow: 0 0 black;
    size: landscape;
}
/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
	    margin-bottom: 10px;
    margin-top: 500px;
}

.carousel-inner img {
	width: 100%; /* Set width to 100% */
	margin: auto;
	min-height: 200px;
	width: 640px;
	height: 360px;
}

/* Hide the carousel text when the screen is less than 600 pixels wide */
@media ( max-width : 600px) {
	.carousel-caption {
		display: none;
		margin: top 8px;;
	}
}

.navbar-nav {
	float: right;
	margin: 0;
	margin-top: 30px;
	font-size: large;
	font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
		'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

.container-fluid>.navbar-collapse, .container-fluid>.navbar-header,
	.container>.navbar-collapse, .container>.navbar-header {
	margin-right: 0;
	margin-left: 0;
	margin-bottom: 10px;
}

.headd {
	font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
		'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
	font-size: large;
	top: auto;
	color: #f2f2f2;
}

.img2 {
	display: block;
	max-width: 100%;
	height: 70%;
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse  fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<div class="headd">
				<strong><h1>Library Management System</h1></strong>

			</div>
		</div>
		<div class="collapse navbar-collapse d-flex align-items-center">
			<ul class="nav navbar-nav pt-20 navbar-right">
				<li class="active  "><a href="#">Home</a></li>


				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Book <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="bookregistration.jsp">Add Book</a></li>
						<li><a href="updatebook.jsp">Update Book</a></li>
						<li><a href="deletebook.jsp">Delete Book</a></li>
					</ul></li>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Student <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="studentregistration.jsp">Add Student</a></li>
						<li><a href="updatestudent.jsp">Update Student</a></li>
						<li><a href="deletestudent.jsp">Delete Student</a></li>
					</ul></li>
				<li><a href="#">About Us</a></li>
				<li><a href="#">Contact</a></li>

				<li><a href="../index.jsp"><span
						class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul>

		</div>
	</div>
	</nav>

	<h4>
		<b>Something is Wrong Please Check Again </b>
	</h4>

	<c:choose>
		<c:when test="${requestScope.success!=null}">
			<b><font color="purple">${requestScope.Err1}</font></b>
		</c:when>
		<c:otherwise>
			<b><font color="purple">${requestScope.Err1}</font></b>
		</c:otherwise>

	</c:choose>
	<font color='red'>${requestScope.Err }</font>

	<div class="form-group justify-content-center align-items-center">
		<a href="studenthome.jsp" class="ForgetPwd"><button>Back</button></a>
	</div>


	<footer class="text-center text-white"
		style="background-color: #0a090a;"> <!-- Grid container -->
	<div class="container p-2"></div>
	<!-- Grid container --> <!-- Copyright -->
	<div class="text-center p-2"
		style="background-color: rgba(36, 2, 2, 0.2); color: white;">
		© NTT DATA Copyright: <a class="text-white"
			href="https://www.linkedin.com/in/anil-l-b023631b6/"
			style="color: white;">Anil.com</a>
	</div>
	<!-- Copyright --> </footer>
</body>
</html>