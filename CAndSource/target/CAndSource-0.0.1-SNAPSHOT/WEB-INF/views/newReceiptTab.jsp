<!DOCTYPE html>
<html lang="en">
<head>
<title>My expenses</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/moment.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap-datetimepicker.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/dateTimePicker.js" />"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/dateTimePicker.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/tiles.css" />">
<style>
a {
	color: black
}
</style>

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>

				</button>
				<a class="navbar-brand" href="#">C&S</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="${pageContext.request.contextPath}/">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/profile/">My Profile</a></li>
					<li><a href="${pageContext.request.contextPath}/taskmgr/">Tasks</a></li>
					<li><a href="${pageContext.request.contextPath}/forum/">Forum</a></li>
					<li class="active"><a><span
							class="glyphicon glyphicon-usd"></span>Expenses</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							Sign Up</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
							Login</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<h3>Expenses</h3>
		<ul class="nav nav-tabs">
			<li class="active"><a href="#">New Receipt</a></li>
			<li><a href="${pageContext.request.contextPath}/expenses/view/">Expenses view</a></li>
		</ul>
		<br>
		<div class="container">
			<div class="row custom-pad">
				<div class="col-md-4">
					<a href="price?type=food">
						<div class="tile">
							<h3 class="title">Food</h3>
							<p>Food, chemistry, health, etc.</p>

						</div>
					</a>
				</div>
				<div class="col-md-4">
					<a href="price?type=clothes">
						<div class="tile">
							<h3 class="title">Clothes</h3>
						</div>
					</a>
				</div>
				<div class="col-md-4">
					<a href="price?type=transport">
						<div class="tile">
							<h3 class="title">Transport</h3>
							<p>Car, tickets, fuel, etc.</p>
						</div>
					</a>
				</div>
			</div>
			<div class="row custom-pad">
				<div class="col-md-4">
					<a href="price?type=accomodation">
						<div class="tile green">
							<h3 class="title">Accomodation</h3>
							<p>Rent, bills, etc.</p>
						</div>
					</a>
				</div>
				<div class="col-md-4">
					<a href="price?type=relax">
						<div class="tile blue">
							<h3 class="title">Relax</h3>
						</div>
					</a>
				</div>
				<div class="col-md-4">
					<a href="price?type=other">
						<div class="tile">
							<h3>Other</h3>
						</div>
					</a>
				</div>
			</div>
		</div>
		
	</div>




</body>
</html>
