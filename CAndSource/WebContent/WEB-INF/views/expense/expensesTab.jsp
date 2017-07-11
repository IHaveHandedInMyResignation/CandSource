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
#descriptionText {
	font-size: 15px;
}

a {
	color: black;
}

.col-sm-10 {
	background-color: #afafaf;
}

#description {
	line-height: 0.9;
	font-size: 14px;
	font-style: italic;
	margin-top: 0px;
}

#loginAlert {
	margin-top: 7px;
	font-size: 8px;
}

.tile {
	min-height: 170px;
	min-width: 150px;
}

.tile.week {
	background: #fff3e6;
}

.tile.month {
	background: #e0ebeb;
}

.tile.year {
	background: #f2d9e4;
}

.tile.archive {
	background: #e6ecff;
}

.tile.week:hover {
	background: #ffdab3;
}

.tile.month:hover {
	background: #85adad;
}

.tile.year:hover {
	background: #d98cb1;
}

.tile.archive:hover {
	background: #79a4d2;
}

p{
	font-style:italic;
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
	<div class="container tiles">
		<h3>Expenses</h3>
		<ul class="nav nav-tabs">
			<li><a href="${pageContext.request.contextPath}/expenses/">New Receipt</a></li>
			<li class="active"><a>Expenses view</a></li>
		</ul>
		<br>
		<div class="container">

			<div class="row custom-pad">
				<div class="col-md-3">
					<a href="${pageContext.request.contextPath}/expenses/view/summary?period=week">
						<div class="tile week">
							<h3>This week</h3>
							<p>${expenseWeek}</p>
						</div>
					</a>
				</div>
				<div class="col-md-3">
					<a href="${pageContext.request.contextPath}/expenses/view/summary?period=month">
						<div class="tile month">
							<h3>This Month</h3>
							<p>${expenseMonth}</p>
						</div>
					</a>
				</div>
				<div class="col-md-3">
					<a href="${pageContext.request.contextPath}/expenses/view/summary?period=year">
						<div class="tile year">
							<h3>This Year</h3>
							<p>${expenseYear}</p>
						</div>
					</a>
				</div>
				<div class="col-md-3">
					<a href="${pageContext.request.contextPath}/expenses/view/summary?period=archive">
						<div class="tile archive">
							<h3>Archive</h3>
						</div>
					</a>
				</div>
				

			</div>
		</div>
	</div>




</body>
</html>
