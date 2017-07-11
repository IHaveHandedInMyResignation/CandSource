<!DOCTYPE html>
<html lang="en">
<head>
<title>My expenses</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://cand.com/functions" prefix="f"%>
<style>
.col-sm-10 {
	background-color: #afafaf;
}

#description {
	line-height: 0.9;
	font-size: 14px;
	font-style: italic;
	margin-top: 0px;
}

}
#loginAlert {
	margin-top: 7px;
	font-size: 8px;
}

.tile {
	min-height: 150px;
	min-width: 150px;
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
			<li><a href="${pageContext.request.contextPath}/expenses/">New Receipt</a></li>
			<li class="active"><a href="${pageContext.request.contextPath}/expenses/view/">Expenses view</a></li>
		</ul>
		<br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Date</th>
					<th>Type</th>
					<th>Cost</th>
					<th>Description</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${expenses}" var="expense">
					<tr>
						<td>${f:formatLocalDateTime(expense.date, 'dd-MM-yyyy hh:mm')}</td>
						<td>${expense.type}</td>
						<td>${expense.cost} PLN</td>
						<td>${expense.description}</td>
						<td><a href="edit?id=${expense.id}">Edit</a></td>
						<td><a href="show?id=${expense.id}">Show</a></td>
					</tr>
				</c:forEach>
			</tbody>
			<thead>
				<tr>
					<th>Summary</th>
					<th> </th>
					<th>${expensesSummary} PLN</th>
					<th> </th>
					<th> </th>
				</tr>
			</thead>
		</table>

	</div>
	




</body>
</html>
