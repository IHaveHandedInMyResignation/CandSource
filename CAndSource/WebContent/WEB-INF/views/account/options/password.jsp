<!DOCTYPE html>
<html lang="en">
<head>
<title>C&Source Forum</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<style>
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

#inputBasic {
	margin-top: 5px;
}

#error {
	padding-top: 12px;
	font-size: 11px;
	text-align: left;
	color: red;
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
					<li><a href="${pageContext.request.contextPath}/profile/">My
							Profile</a></li>
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
			<div class="col-md-offset-3 col-md-5">
				<div class="well well-sx">
					<form:form modelAttribute="profile"
						action="${pageContext.request.contextPath}/accouunt/options/password"
						method='POST'>
						<div class="row">
							<div class="col-sm-5">
								<form:input path="password" class="form-control" id="inputBasic"
									type="password" placeholder="Password"></form:input>
							</div>
							<div class="col-sm-7">
								<p id="error">${passwordErr}</p>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-5">
								<form:input path="matchingPassword" class="form-control"
									id="inputBasic" type="password" placeholder="Confirm Password"></form:input>
							</div>
							<div class="col-sm-7">
								<p id="error">${matchingPasswordErr}</p>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-5">
								<div class="text-right" id="inputBasic">
									<button type="submit" class="btn btn-success">
										<span class="glyphicon glyphicon-ok"></span> Change Password
									</button>
								</div>
							</div>
							<div class="col-sm-7"></div>
						</div>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form:form>

				</div>
			</div>
		</div>
	</div>

	<footer class="navbar navbar-fixed-bottom">
		<div class="container text-center">
			<p>Footer Text</p>
		</div>
	</footer>

</body>
</html>
