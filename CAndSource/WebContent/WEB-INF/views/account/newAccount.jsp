<!DOCTYPE html>
<html lang="en">
<head>
<title>C&Source New Account</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>

#inputBasic {
	margin-top: 5px;
}
#error{
	padding-top:12px;
	font-size:11px;
	text-align:left;
	color:red;
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

			</div>
		</div>
	</nav>
	<div class="jumbotron text-center">
		<div class="container">
			<div class="row">
				<div class="col-md-offset-5 col-md-7">
					<div class="row">
						<div class="col-sm-5"><h4><strong>Create new Account</strong></h4></div>
						<div class="col-sm-7"></div>
					</div>
  					
					<form:form modelAttribute="profile" action="${pageContext.request.contextPath}/account/new" method='POST'>
						<div class="row">
							<div class="col-sm-5"><form:input path="login" class="form-control" id="inputBasic" type="text" placeholder="Username"></form:input></div>
							<div class="col-sm-6"><p id="error">${loginErr}</p></div>
						</div>
						<div class="row">
							<div class="col-sm-5">
								<div class="row">
									<div class="col-xs-6">
										<form:input path="firstName" class="form-control" id="inputBasic" type="text" placeholder="First Name"></form:input>
									</div>
									<div class="col-xs-6">
										<form:input path="lastName" class="form-control" id="inputBasic" type="text" placeholder="Last Name"></form:input>
									</div>
								</div>
							</div>
							<div class="col-sm-7"><p id="error">${firstNameErr} ${lastNameErr}</p></div>
						</div>
						<div class="row">
							<div class="col-sm-5"><form:input path="email" class="form-control" id="inputBasic" type="text" placeholder="Email"></form:input></div>
							<div class="col-sm-7"><p id="error">${emailErr}</p></div>
						</div>
						<div class="row">
							<div class="col-sm-5"><form:input path="password" class="form-control" id="inputBasic" type="password" placeholder="Password"></form:input></div>
							<div class="col-sm-7"><p id="error">${passwordErr}</p></div>
						</div>
						<div class="row">
							<div class="col-sm-5"><form:input path="matchingPassword" class="form-control" id="inputBasic" type="password" placeholder="Confirm Password"></form:input></div>
							<div class="col-sm-7"><p id="error">${matchingPasswordErr}</p></div>
						</div>
						<div class="row">
							<div class="col-sm-5">
								<div class="text-right" id="inputBasic">
									<button type="submit" class="btn btn-success">
										<span class="glyphicon glyphicon-ok"></span> Create Account
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

</body>
</html>
