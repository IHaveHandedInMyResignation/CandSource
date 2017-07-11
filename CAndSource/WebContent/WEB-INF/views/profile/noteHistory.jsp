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
<%@ taglib uri="http://cand.com/functions" prefix="f"%>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/moment.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap-datetimepicker.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/dateTimePicker.js" />"></script>

<style>
/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

#footerBtn {
	color: white;
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
					<li><a href="${pageContext.request.contextPath}/profile/">My
							Profile</a></li>
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
								<strong>Notes History</strong>
							</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3"></div>
					<div class="col-sm-6">
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
							</tbody>
						</table>
					</div>
					<div class="col-sm-3"></div>
				</div>
			</div>
		</div>
	</div>

	<footer class="navbar navbar-fixed-bottom">
		<div class="container text-center">
			<a
				href="${pageContext.request.contextPath}/profile/note/history?page=${pageNum lt 2 ? 1: pageNum-1}"
				id="footerBtn" class="btn btn-link"> <span
				class="glyphicon glyphicon-minus"></span><strong> 5</strong></a> <a
				href="${pageContext.request.contextPath}/profile/note/history?page=${pageNum +1}"
				id="footerBtn" class="btn btn-link"><span
				class="glyphicon glyphicon glyphicon-plus"></span><strong>
					5</strong> </a>
		</div>
	</footer>

</body>
</html>
