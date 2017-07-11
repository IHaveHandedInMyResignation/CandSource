<!DOCTYPE html>
<html lang="en">
<head>
<title>C&Source My Profile</title>
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
<%@ taglib uri="http://cand.com/functions" prefix="f"%>
<style>
/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

#upcmngTsk {
	font-size: 12px;
}

#taskHeader {
	padding-top: 8px;
	font-size: 14px;
}

#taskDescription {
	line-height: 0.9;
	font-size: 11px;
	font-style: italic;
}

#taskDate {
	line-height: 1;
	font-size: 12;
}

.buttonShare {
	margin-top: 2px;
	float: right;
	margin-bottom: 8px;
}

#postLabel {
	float: left;
}

.text-date {
	font-size: 11px;
	font-style: italic;
	font-weight: normal;
}

.text-basic {
	font-family: "Palatino Linotype", "Book Antiqua", Palatino, serif;
	font-size: 14px;
	font-weight: normal;
	font-size: 14px;
}
.text-history {
	font-size: 14px;
	font-style: italic;
	font-size: 14px;
}
}
.table {
	margin-top: 20px;
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
					<li class="active"><a href="#"><span
							class="glyphicon glyphicon-user"></span> My Profile</a></li>
					<li><a href="${pageContext.request.contextPath}/taskmgr/">Tasks</a></li>
					<li><a href="${pageContext.request.contextPath}/forum/">Forum</a></li>
					<li><a href="${pageContext.request.contextPath}/expenses/">Expenses</a></li>
				</ul>
				<form:form id="logoutForm"
					action="${pageContext.request.contextPath}/logout" method="POST">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#"
							onclick="document.getElementById('logoutForm').submit()"><span
								class="glyphicon glyphicon-log-in"></span> Logout</a></li>
					</ul>
				</form:form>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group input-group">
						<input type="text" class="form-control" placeholder="Search..">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</form>

			</div>
		</div>
	</nav>

	<div class="container text-center">
		<div class="row">
			<div class="col-sm-3 well">
				<div class="well">
					<img src="${pageContext.request.contextPath}/img/${profile_login}"
						class="img-circle" height="65" width="65" alt="Avatar">
					<h4>${profile_login}</h4>
				</div>
				<table class="table text-left">
					<thead>
						<tr>
							<th><p class="text-center">Settings</p></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><a
								href="${pageContext.request.contextPath}/account/options/task">Tasks
									options</a></td>
						</tr>
						<tr>
							<td><a
								href="${pageContext.request.contextPath}/account/options/expense">Expenses
									options</a></td>
						</tr>
						<tr>
							<td><a
								href="${pageContext.request.contextPath}/account/options/other">Other
									options</a></td>
						</tr>
						<tr>
							<td><a
								href="${pageContext.request.contextPath}/account/options/password">Change
									Password</a></td>
						</tr>
						<tr>
							<td><a
								href="${pageContext.request.contextPath}/account/options/delete">Delete
									account</a></td>
						</tr>
					</tbody>

				</table>

			</div>
			<div class="col-sm-7">
				<div class="row">
					<div class="col-sm-12">
						<div class="form-group">
							<label id="postLabel">Make quick post:</label>
							<form:form modelAttribute="profilePost"
								action="${pageContext.request.contextPath}/profile/note/new"
								method="POST">
								<form:textarea path="text" class="form-control" rows="5"></form:textarea>
								<button type="submit" class="btn btn-default btn-sm buttonShare">
									<span class="glyphicon glyphicon-share "></span> Share
								</button>

							</form:form>

						</div>

					</div>
				</div>

				<table class="table text-left">
					<tbody>
						<c:forEach items="${profile_posts}" var="post">
							<tr>
								<td class="col-md-1"></td>
								<td class="col-md-11 text-basic">${post.text}</td>
							</tr>
							<tr>
								<td class="col-md-1"></td>
								<td class="col-md-11 text-right text-date">${f:formatLocalDateTime(post.creationDate, 'dd-MM-yyyy hh:mm')}</td>
							</tr>
						</c:forEach>
							<tr>
								<td class="col-md-1"></td>
								<td class="col-md-11 text-right text-history"><a href="${pageContext.request.contextPath}/profile/note/history?page=1">History</a></td>
							</tr>
						
					</tbody>

				</table>
			</div>
			<div class="col-sm-2 well well-sm">
				<p id="upcmngTsk">Adverts</p>
				<ul class="list-group">
					<li class="list-group-item"></li>
					<li class="list-group-item"></li>
					<li class="list-group-item"></li>
				</ul>
			</div>
		</div>
	</div>



</body>
</html>
