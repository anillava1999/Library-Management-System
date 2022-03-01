<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.lms.training.domain.Student"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}

.carousel-inner img {
	width: 100%; /* Set width to 100% */
	min-height: 200px;
}

/* Hide the carousel text when the screen is less than 600 pixels wide */
@media ( max-width : 600px) {
	.carousel-caption {
		display: none;
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
</style>
</style>
</head>
<body>
	<%
	String context = (String) request.getContextPath();
	%>

	<nav class="navbar navbar-inverse ">
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
							<li><a href="requestbook.jsp">Request Book</a></li>
							<li><a href="returnbook.jsp">Return Book</a></li>
							<li><a href="cancelbook.jsp">Cancel Book</a></li>
						</ul></li>
					<li><a href="<%=context + "/Viewavailablebook.do"%>">View
							Books</a></li>

					<li><a href="#">About Us</a></li>
					<li><a href="#">Contact</a></li>

					<li><a href="../index.jsp"><span
							class="glyphicon glyphicon-log-in"></span> Logout</a></li>




				</ul>

			</div>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-sm-8">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="../images/1.jpg" alt="Image">
							<div class="carousel-caption">
								<h3>Study Well</h3>
								<p>Earn Well</p>
							</div>
						</div>

						<div class="item">
							<img src="../images/4.jpg" alt="Image">
							<div class="carousel-caption">
								<h3>Study Well</h3>
								<p>Earn Well</p>
							</div>
						</div>
					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel" role="button"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel" role="button"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="well">
					<p>
						Student ID : --> <b><font color="Black">${requestScope.Name}</font></b>
					</p>
				</div>
				<div class="well">
					<p>Lecturers</p>
				</div>
				<div class="well">
					<p>Result</p>
				</div>
			</div>

		</div>
		<hr>
	</div>

	<div class="container text-center">
		<h3>New Book Sections</h3>
		<br>
		<div class="row">
			<div class="col-sm-3">
				<img src="../images/13.jpg" class="img-responsive"
					style="width: 100%" alt="Image">
				<p>Book Offer</p>
			</div>
			<div class="col-sm-3">
				<img src="../images/14.jpg" class="img-responsive"
					style="width: 100%" alt="Image">
				<p>Project Book</p>
			</div>
			<div class="col-sm-3">
				<div class="well">
					<p>Python New Book Available</p>
				</div>
				<div class="well">
					<p>Data Science New Book Available.</p>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="well">
					<p>Machine Learning New Book Available</p>
				</div>
				<div class="well">
					<p>Mathematics New Book Available</p>
				</div>
			</div>
		</div>
		<hr>
	</div>

	<div class="container text-center">
		<h3>Sections</h3>
		<br>
		<div class="row">
			<div class="col-sm-2">
				<img src="../images/7.jpg" class="img-responsive"
					style="width: 100%" alt="Image">
				<p>Section 1</p>
			</div>
			<div class="col-sm-2">
				<img src="../images/8.jpg" class="img-responsive"
					style="width: 100%" alt="Image">
				<p>Section 2</p>
			</div>
			<div class="col-sm-2">
				<img src="../images/9.jpg" class="img-responsive"
					style="width: 100%" alt="Image">
				<p>Section 3</p>
			</div>
			<div class="col-sm-2">
				<img src="../images/13.jpg" class="img-responsive"
					style="width: 100%" alt="Image">
				<p>Section 4</p>
			</div>
			<div class="col-sm-2">
				<img src="../images/6.jpg" class="img-responsive"
					style="width: 100%" alt="Image">
				<p>Section 5</p>
			</div>
			<div class="col-sm-2">
				<img src="../images/20.jpg" class="img-responsive"
					style="width: 100%" alt="Image">
				<p>Section 6</p>
			</div>
		</div>
	</div>
	<br>

	<footer class="text-center text-white fixed-bottom"
		style="background-color: #0a090a;">
		<!-- Grid container -->
		<div class="container p-2"></div>
		<!-- Grid container -->

		<!-- Copyright -->
		<div class="text-center p-2"
			style="background-color: rgba(36, 2, 2, 0.2); color: #f2f2f2;">
			© NTT DATA Copyright: <a class="text-white"
				href="https://www.linkedin.com/in/anil-l-b023631b6/">Anil.com</a>
		</div>
		<!-- Copyright -->
	</footer>
</body>
</html>
