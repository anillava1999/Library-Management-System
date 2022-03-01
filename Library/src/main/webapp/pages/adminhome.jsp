<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/CSS/first.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
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

	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators img4">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>

		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner img2" role="listbox">
			<div class="item active img2">
				<img src="../images/13.jpg" alt="Image" class="img-fluid img2">
				<div class="carousel-caption">
					<h3>Learn Well Earn Well</h3>
					<p>Study Study....</p>
				</div>
			</div>

			<div class="item img-fluid">
				<img src="../images/14.jpg" alt="Image"">
				<div class="carousel-caption">
					<h3>Learn Well Earn Well</h3>
					<p>Study Study....</p>
				</div>
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>

	<div class="container text-center">
		<h3>Informations</h3>
		<br>
		<div class="row">
			<div class="col-sm-4">
				<img src="../images/20.jpg" class="img-responsive"
					style="width: 100%" alt="Image">
				<p>Science Section</p>
			</div>
			<div class="col-sm-4">
				<img src="../images/18.jpg" class="img-responsive"
					style="width: 100%" alt="Image">
				<p>Computer Section</p>
			</div>
			<div class="col-sm-4">
				<div class="well">
					<p>Admin Details</p>

				</div>
				<div class="well">
					<p>
						Admin ID : --> <b><font color="Black">${requestScope.Name}</font></b>
				</div>
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
			style="background-color: rgba(36, 2, 2, 0.2); color: white;">
			© NTT DATA Copyright: <a class="text-white"
				href="https://www.linkedin.com/in/anil-l-b023631b6/"
				style="color: white;">Anil.com</a>
		</div>
		<!-- Copyright -->
	</footer>

</body>
</html>
