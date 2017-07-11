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
<%@ taglib uri="http://cand.com/functions" prefix="f"%>
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
#btnDone {
	margin-top: 5px;
}
</style>
<script>
       
       function isNumberKey(evt)
       {
    	   var charCode = (evt.which) ? evt.which : evt.keyCode;
    	   if (charCode == 46 && evt.srcElement.value.split('.').length>1) 
    	   	return false; 
           if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
             return false;

          return true;
       }
       
       </script>
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
			<li class="active"><a href="#">New Receipt</a></li>
			<li><a href="view">Expenses view</a></li>
		</ul>
		<br>
		<c:if test="${not empty validError}">
			<div class="alert alert-danger">${validError}</div>
		</c:if>
		<form:form modelAttribute="expense" method="POST"
			action="${pageContext.request.contextPath}/expenses/price/add/">

			<div class="row">
				<div class="col-sm-3"></div>

				<div class="col-sm-6">
					<div class="well">
						<div class="row">
							<div class="col-sm-6">
								<form:input path="type" type="hidden" class="form-control" value="${param.type}"></form:input>
								<p>Price:</p>
								<form:input path="cost" type="number" step="any" class="form-control" 
									maxlength="10" required ="true" onkeypress="return isNumberKey(event)"></form:input>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<p>Description:</p>
								<form:textarea path="description" rows="6" class="form-control"
									 required ="true" maxlength="1000"></form:textarea>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="text-right">
									<button id="btnDone" type="submit" name="clickBtn"
										value="generateDate" class="btn btn-link">
										<span class="glyphicon glyphicon-time"></span> Select specific
										date
									</button>

									<button id="btnDone" type="submit" name="clickBtn"
										value="addReceipt" class="btn btn-success">
										<span class="glyphicon glyphicon-ok"></span> Add to the current day
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-2"></div>
			</div>

		</form:form>


	</div>




</body>
</html>
