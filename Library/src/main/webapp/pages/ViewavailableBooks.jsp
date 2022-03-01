<%@ page import="java.util.*"%>

<%@page import="com.lms.training.domain.Bookdetails"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>Available Books List</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-1.12.3.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>

<script>
	$(document).ready(function() {
		$('#myTable').dataTable();

	});
</script>

<style>
/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
	margin-top: 330px;
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
					<li><a href="<%=context + "/Viewavailablebook.do"%>">Available
							Books</a></li>

					<li><a href="#">About Us</a></li>
					<li><a href="#">Contact</a></li>

					<li><a href=""><span class="glyphicon glyphicon-log-in"></span>
							Logout</a></li>





				</ul>

			</div>
		</div>
	</nav>
	<div class="table-responsive">
		<table id="myTable" class="display table">
			<thead>
				<tr>
					<th>bookname</th>
					<th>isbn</th>
					<th>author</th>
					<th>publisher</th>
					<th>edition</th>
					<th>price</th>
					<th>quantity</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Bookdetails book : ((ArrayList<Bookdetails>) request.getAttribute("list"))) {
				%>
				<tr>
					<td><%=book.getBookname()%></td>
					<td><%=book.getIsbn()%></td>
					<td><%=book.getAuthor()%></td>
					<td><%=book.getPublisher()%></td>
					<td><%=book.getEdition()%></td>
					<td><%=book.getPrice()%></td>
					<td><%=book.getQuantity()%></td>
					<%
					}
					%>
				</tr>
			</tbody>
		</table>
	</div>

	<footer class="text-center text-white fixed-bottom"
		style="background-color: #0a090a;">
		<!-- Grid container -->
		<div class="container p-2"></div>
		<!-- Grid container -->

		<!-- Copyright -->
		<div class="text-center p-2"
			style="background-color: rgba(36, 2, 2, 0.2); color: #f2f2f2;">
			© 2020 Copyright: <a class="text-white"
				href="https://www.linkedin.com/in/anil-l-b023631b6/">Anil.com</a>
		</div>
		<!-- Copyright -->
	</footer>
</body>
</html>