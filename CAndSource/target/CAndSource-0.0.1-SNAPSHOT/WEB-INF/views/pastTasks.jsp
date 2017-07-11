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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://cand.com/functions" prefix="f" %>
  <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/moment.min.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/bootstrap-datetimepicker.min.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/dateTimePicker.js" />"></script>

<style>
/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}
#footerBtn{
	color: white;
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
#dateHeader{
	margin-bottom:5px;
	margin-top:8px;
}
#optionaLabel{
	margin-right:5px;
}
#postLabel {
	float: left;
}

#buttonEdit {
	float: right;
	margin-bottom: 18px;
}
#buttonAdd {
	margin-top: 18px;
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

			<div class="col-sm-12">
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
					<div class="col-sm-3"></div>
					<div class="col-sm-6">
						<div class="alert alert-danger">
							<h4 title="Click to manage your Past Tasks"><strong>Past
								Tasks:</strong></h4>
							<p></p>
							<ul class="list-group">
								<c:forEach items="${pastTasks}" var="pastTask">
									<li class="list-group-item">
										<p>
											<span class="glyphicon glyphicon-time"></span><strong>${pastTask.title}</strong>
										</p>
										<p id="taskDate">
										<span class="label label-danger">${f:formatLocalDateTime(pastTask.startDate, 'dd-MM-yyyy')}</span> <span
											class="label label-danger">${f:formatLocalDateTime(pastTask.startDate, 'hh:mm')}</span>
										</p>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<div class="col-sm-3"></div>
				</div>
				
			
		</div>
	</div>

	<footer class="navbar navbar-fixed-bottom">
		<div class="container text-center">
			<a href="${pageContext.request.contextPath}/taskmgr/past?page=${pageNum lt 2 ? 1: pageNum-1}" id ="footerBtn" class="btn btn-link"> <span class="glyphicon glyphicon-minus"></span><strong> 5</strong></a>
			<a href="${pageContext.request.contextPath}/taskmgr/past?page=${pageNum +1}" id ="footerBtn" class="btn btn-link"><span class="glyphicon glyphicon glyphicon-plus"></span><strong> 5</strong> </a>
		</div>
	</footer>

</body>
</html>
