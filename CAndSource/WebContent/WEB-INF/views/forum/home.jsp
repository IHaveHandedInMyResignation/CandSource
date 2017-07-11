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

#postHeader {
	padding-top: 8px;
	font-size: 14px;
}

#postDescription {
	line-height: 0.9;
	font-size: 11px;
	font-style: italic;
}

#postDate {
	margin-top: 12px;
	line-height: 1.4;
	font-size: 12;
}
#author {
	font-style: italic;
	font-size: 10;
	color:gray;
}
#postLabel {
	float: left;
}

#postIcon {
	
	margin-left: 10px;
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
					<li class="active"><a href="#"><span
							class=" glyphicon glyphicon-th-list"></span> Forum</a></li>
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

			<div class="col-sm-12">
				<div class="row">
						<div class="col-sm-12">
							<div class="well well-sm">
							<a href="">
								<div class="row">
									<div class ="text-left">
									<div class="col-sm-1">
									<br/>
										<span class="glyphicon glyphicon-align-left" id="postIcon"></span>
									</div>
										<div class="col-sm-9">
										<div class="row">
										
											<strong> 
														Long Title thing about someone to someone abothing about
														someone to someone about
											</strong>
										
										</div>
										<div class="row">
											<p id="author">
												Autor
											</p>
										</div>
										</div>
										<div class="col-sm-2">
											<p id="postDate">
												<span class="label label-info">20:00</span> 
												<br /> 
												<span class="label label-info">2017-05-03</span>
											</p>
										</div>
									</div>
								</div>
								</a>
							</div>
							<div class="well well-sm">
							<a href="">
								<div class="row">
									<div class ="text-left">
									<div class="col-sm-1">
									<br/>
										<span class="glyphicon glyphicon-align-left" id="postIcon"></span>
									</div>
										<div class="col-sm-9">
										<div class="row">
										
											<strong> 
														Long Title thing about someone to someone abothing about
														someone to someone about
											</strong>
										
										</div>
										<div class="row">
											<p id="author">
												Autor
											</p>
										</div>
										</div>
										<div class="col-sm-2">
											<p id="postDate">
												<span class="label label-info">20:00</span> 
												<br /> 
												<span class="label label-info">2017-05-03</span>
											</p>
										</div>
									</div>
								</div>
								</a>
							</div>
							<div class="well well-sm">
							<a href="">
								<div class="row">
									<div class ="text-left">
									<div class="col-sm-1">
									<br/>
										<span class="glyphicon glyphicon-align-left" id="postIcon"></span>
									</div>
										<div class="col-sm-9">
										<div class="row">
										
											<strong> 
														Long Title thing about someone to someone abothing about
														someone to someone about
											</strong>
										
										</div>
										<div class="row">
											<p id="author">
												Autor
											</p>
										</div>
										</div>
										<div class="col-sm-2">
											<p id="postDate">
												<span class="label label-info">20:00</span> 
												<br /> 
												<span class="label label-info">2017-05-03</span>
											</p>
										</div>
									</div>
								</div>
								</a>
							</div>
							<div class="well well-sm">
							<a href="">
								<div class="row">
									<div class ="text-left">
									<div class="col-sm-1">
									<br/>
										<span class="glyphicon glyphicon-align-left" id="postIcon"></span>
									</div>
										<div class="col-sm-9">
										<div class="row">
										
											<strong> 
														Long Title thing about someone to someone abothing about
														someone to someone about
											</strong>
										
										</div>
										<div class="row">
											<p id="author">
												Autor
											</p>
										</div>
										</div>
										<div class="col-sm-2">
											<p id="postDate">
												<span class="label label-info">20:00</span> 
												<br /> 
												<span class="label label-info">2017-05-03</span>
											</p>
										</div>
									</div>
								</div>
								</a>
							</div>
							<div class="well well-sm">
							<a href="">
								<div class="row">
									<div class ="text-left">
									<div class="col-sm-1">
									<br/>
										<span class="glyphicon glyphicon-align-left" id="postIcon"></span>
									</div>
										<div class="col-sm-9">
										<div class="row">
										
											<strong> 
														Long Title thing about someone to someone abothing about
														someone to someone about
											</strong>
										
										</div>
										<div class="row">
											<p id="author">
												Autor
											</p>
										</div>
										</div>
										<div class="col-sm-2">
											<p id="postDate">
												<span class="label label-info">20:00</span> 
												<br /> 
												<span class="label label-info">2017-05-03</span>
											</p>
										</div>
									</div>
								</div>
								</a>
							</div>
						</div>
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
