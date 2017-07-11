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
  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/dateTimePicker.css" />">

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
					
											<!-- ************************************* -->
											<!-- ****** LEFT SIDE UPCOMING TASK ****** -->
											<!-- ************************************* -->
	<div class="container text-center">
		<div class="row">

			<div class="col-sm-9">
				<div class="row">
					<div class="col-sm-12">
						<div class="well well-sm" role="alert">
							<p>
								<strong>Manage your current tasks</strong>
							</p>
						</div>
					</div>
				</div>
				<div class="row">

					<div class="col-sm-5">
						<div class="well well-sm"">
							<a href="${pageContext.request.contextPath}/taskmgr/upcoming?page=1" title="Click to manage your Upcoming Tasks">Upcoming
								Tasks:</a>
							<p></p>
							<ul class="list-group">
							
							<c:forEach items="${upcomingTasks}" var="upcomingTask"> 
							<form:form  method="GET" action="edit">
						        <li class="list-group-item">
						        <input type="hidden" name="id" id="id" value = "${upcomingTask.id}"/>
									<p>
										<span class="glyphicon glyphicon-time"></span><strong>${upcomingTask.title}</strong>
									</p>
									<p id="taskDate">
										<span class="label label-info">${f:formatLocalDateTime(upcomingTask.startDate, 'hh:mm')}</span>
									</p>
									<p id="taskDate">
										<span class="label label-info">${f:formatLocalDateTime(upcomingTask.startDate, 'dd-MM-yyyy')}</span> 
									</p>
									
									<p id="taskDescription">${upcomingTask.description}</p>

									<div class="btn-group-sm" role="group"
										aria-label="Basic example">
										<button type="submit" class="btn btn-secondary">Edit</button>
										<button type="button" class="btn btn-secondary">Delete</button>
									</div>

								</li>
								</form:form>
								</c:forEach>
							</ul>
						</div>
					</div>
					
											<!-- ************************************* -->
											<!-- ********* ADD NEW TASK FORM ********* -->
											<!-- ************************************* -->
											
					
									
					<form:form modelAttribute="personalTask" method="POST" action="${pageContext.request.contextPath}/taskmgr/add">					
					
					<div class="col-sm-7">
					<c:if test="${not empty validError}">
						<div class="alert alert-danger">
					 		${validError}
						</div>	
					</c:if>
						<div class="well well-sm">
								<strong>Add Task:</strong>
							<div class="form-group">
								<div class="text-left">
									<label>Header:</label> 
									<form:input path="title" type="text" class="form-control" maxlength="10"></form:input>
									<label>Short Description:</label>
									<form:textarea path="description" rows="3" class="form-control" maxlength ="65"></form:textarea>
									<label>Full Description:</label>
									<form:textarea path="fullText" rows="6" class="form-control" maxlength ="1000"></form:textarea>

									<p></p>
								</div>
								<div class="row" id="dateHeader">
									<div class="col-sm-11">
										<span class="label label-info"></span><label>Start Date&Time:</label>
									</div>
								</div>
								<div class="row">
								<div class="col-sm-1"></div>
									<div class="col-sm-10">
										<div class="input-group">
										    <form:input path="startDate" type="datetime-local" id="startDateTimePicker" name="search_message[displayDateFrom]" placeholder="YYYY-MM-DD hh:mm:ss" class="input-sm form-control"></form:input>
										    <div class="input-group-addon">
										        <span class="glyphicon glyphicon-calendar"></span>
											</div>
										</div>									
									</div>
									<div class="col-sm-1"></div>
								</div>
								
								<div class="row" id="dateHeader">
									<div class="col-sm-11">
										<span id="optionaLabel" class="label label-info">(Optional)</span><label> Reminder Date&Time:</label>
									</div>
								</div>
								<div class="row">
								<div class="col-sm-1"></div>
									<div class="col-sm-10">
										<div class="input-group">
										    <form:input path="reminderDate" type="datetime" id="reminderDateTimePicker" name="search_message[displayDateFrom]" placeholder="YYYY-MM-DD hh:mm:ss" class="input-sm form-control"></form:input>
										    <div class="input-group-addon">
										        <span class="glyphicon glyphicon-calendar"></span>
											</div>
										</div>									
									</div>
								<div class="col-sm-1"></div>
								</div>
								<div class="row" id="dateHeader">
									<div class="col-sm-11">
										<span id="optionaLabel" class="label label-info">(Optional)</span><label> Finish Date&Time:</label>
									</div>
								</div>
								<div class="row">
								<div class="col-sm-1"></div>
									<div class="col-sm-10">
										<div class="input-group">
										    <form:input path="finishDate" type="datetime" id="finishDateTimePicker" name="search_message[displayDateFrom]" placeholder="YYYY-MM-DD hh:mm:ss" class="input-sm form-control"></form:input>
										    <div class="input-group-addon">
										        <span class="glyphicon glyphicon-calendar"></span>
											</div>
										</div>									
									</div>
								<div class="col-sm-1"></div>
								</div>
								<div class="checkbox">
									<label><form:checkbox path="active" value="" checked="checked" ></form:checkbox>Activated</label>
								</div>

								<div id="buttonAdd"  class="text-right">
									<button type="submit" class="btn btn-success">
										<span class="glyphicon glyphicon-ok"></span> Add Task
									</button>
								</div>
							</div>
						</div>
					</div>
					</form:form>	
				</div>
				<div class="row">
					<div class="col-sm-2"></div>

					<div class="col-sm-2"></div>
				</div>
											<!-- ************************************* -->
											<!-- ******* RIGHT SIDE PAST TASK ******** -->
											<!-- ************************************* -->
			</div>
			<div class="col-sm-3 well well-sm">
				<div class="well">
					<p>
						<a href="${pageContext.request.contextPath}/taskmgr/past?page=1" title="Click to manage your past tasks">Your past
							tasks:</a>
					</p>
					<ul class="list-group">
					<c:forEach items="${pastTasks}" var="pastTask">
						<li class="list-group-item">
							<p>
								<span class="glyphicon glyphicon-time"></span><strong>${pastTask.title}</strong>
							</p>
							<p id="taskDate">
								<span class="label label-info">${f:formatLocalDateTime(pastTask.startDate, 'hh:mm')}</span>
							</p>
							<p id="taskDate">
								<span class="label label-info">${f:formatLocalDateTime(pastTask.startDate, 'dd-MM-yyyy')}</span> 
							</p>
							<p id="taskDescription">${pastTask.description}</p>
						</li>
					</c:forEach>
						

					</ul>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
