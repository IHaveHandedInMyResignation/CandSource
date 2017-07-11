<!DOCTYPE html>
<html lang="en">
<head>
<title>C&Source Task Manager</title>
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
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
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

#postLabel {
	float: left;
}

#buttonEdit {
	float: right;
	margin-bottom: 18px;
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
					<li class="active"><a href="#"><span
							class="glyphicon glyphicon-time"></span> Tasks</a></li>
					<li><a href="${pageContext.request.contextPath}/forum/">Forum</a></li>
					<li><a href="${pageContext.request.contextPath}/expenses/">Expenses</a></li>
				</ul>
		<form:form id="logoutForm" action="${pageContext.request.contextPath}/logout" method="POST">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#" onclick="document.getElementById('logoutForm').submit()"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>	    
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

			<div class="col-sm-9">
				<div class="row">
					<div class="col-sm-12">
							
							<div class="alert alert-success" role="alert">
								<p>
									<strong>Manage your tasks</strong>
								</p>
							</div>
							
					</div>
				</div>
				<div class="row">

					<div class="col-sm-5">
						<div class="alert alert-info">
							<a href="#" title="Click to manage your Upcoming Tasks">Upcoming Tasks:</a>
							<p></p>
							<ul class="list-group">
								<li class="list-group-item">
									<p>
										<span class="glyphicon glyphicon-time"></span><strong>Task_nr_one</strong>
									</p>
									<p id="taskDate">
										<span class="label label-info">20:00</span> <span
											class="label label-info">2017-05-03</span>
									</p>
									<p id="taskDescription">task secr t Forgot that I had to
										mention something about someone to someone abou</p>
										
								<div class="btn-group-sm" role="group" aria-label="Basic example">
								  <button type="button" class="btn btn-secondary">Edit</button>
								  <button type="button" class="btn btn-secondary">Delete</button>
								</div>
									
								</li>
								<li class="list-group-item">
									<p id="taskHeader">
										<span class="glyphicon glyphicon-time"></span><strong>Paris</strong>
									</p>
									<p id="taskDate">
										<span class="label label-info">20:00</span> <span
											class="label label-info">2017-05-03</span>
									</p>
									<p id="taskDescription">task secr t Forgot that I had to
										mention something about someone to someone abou</p>

								<div class="btn-group-sm" role="group" aria-label="Basic example">
								  <button type="button" class="btn btn-secondary">Edit</button>
								  <button type="button" class="btn btn-secondary">Delete</button>
								</div>
								</li>
								<li class="list-group-item">
									<p id="taskHeader">
										<span class="glyphicon glyphicon-time"></span><strong>Paris</strong>
									</p>
									<p id="taskDate">
										<span class="label label-info">20:00</span> <span
											class="label label-info">2017-05-03</span>
									</p>
									<p id="taskDescription">task secr t Forgot that I had to
										mention something about someone to someone abou</p>
								<div class="btn-group-sm" role="group" aria-label="Basic example">
								  <button type="button" class="btn btn-secondary">Edit</button>
								  <button type="button" class="btn btn-secondary">Delete</button>
								</div>
								</li>
							</ul>
						</div>
					</div>
					<div class="col-sm-7">
						<div class="well well-sm">
							<p>
								<strong>Add Task:</strong>
							</p>
							<div class="form-group">
							<div class="text-left">
								<label for="usr">Header:</label> 
								<input type="text" class="form-control"> 
							
							<label for="usr">Description:</label>
								<textarea rows ="6" class="form-control"></textarea>
								
								<p>
									<strong>Date:</strong> <input type="text" class="form-control"
										id="datepicker">
								</p>
							</div>
								<label for="usr">Time:</label>
								<div class="row">
									<div class="col-sm-3"></div>
									<div class="col-sm-3">
										<input placeholder="hh" maxlength="2" min ="0" max="23" type="number" class="form-control" />
									</div>
									<div class="col-sm-3">
										<input placeholder="mm" maxlength="2" min ="0" max="60" type="number" class="form-control">
									</div>
									<div class="col-sm-3"></div>
								</div>
							</div>

							<div class="text-right">
								<button type="button" class="btn btn-success">
									<span class="glyphicon glyphicon-ok"></span> Add Task
								</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-2"></div>

					<div class="col-sm-2"></div>
				</div>

			</div>
			<div class="col-sm-3 well well-sm">
				<div class="well">
					<p>
						<a href="#" title="Click to manage your past tasks">Your past
							tasks:</a>
					</p>
					<ul class="list-group">
						<li class="list-group-item">
							<p>
								<span class="glyphicon glyphicon-time"></span><strong>Paris</strong>
							</p>
							<p id="taskDate">
								<span class="label label-info">20:00</span>
							</p>
							<p id="taskDate">
								<span class="label label-info">2017-05-03</span>
							</p>
							<p id="taskDescription">task secr t Forgot that I had to
								mention something about someone to someone abou</p>
						</li>
						<li class="list-group-item">
							<p id="taskHeader">
								<span class="glyphicon glyphicon-time"></span><strong>Paris</strong>
							</p>
							<p id="taskDate">
								<span class="label label-info">20:00</span>
							</p>
							<p id="taskDate">
								<span class="label label-info">2017-05-03</span>
							</p>
							<p id="taskDescription">task secr t Forgot that I had to
								mention something about someone to someone abou</p>

						</li>
						<li class="list-group-item">
							<p id="taskHeader">
								<span class="glyphicon glyphicon-time"></span><strong>Paris</strong>
							</p>
							<p id="taskDate">
								<span class="label label-info">20:00</span>
							</p>
							<p id="taskDate">
								<span class="label label-info">2017-05-03</span>
							</p>
							<p id="taskDescription">task secr t Forgot that I had to
								mention something about someone to someone abou</p>

						</li>

					</ul>
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
