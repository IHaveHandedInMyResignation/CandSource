<!DOCTYPE html>
<html lang="en">
<head>
  <title>C&Source Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/moment.min.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/bootstrap-datetimepicker.min.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/dateTimePicker.js" />"></script>
  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/dateTimePicker.css" />">
<style>
	#descriptionText{
		font-size: 15px;
	}
	.col-sm-10{
		background-color: #afafaf;
	}
	#description{
    	line-height: 0.9;
    	font-size: 14px;
    	font-style: italic;
    	margin-top: 0px;
    }
	}
	#loginAlert{
		margin-top: 7px;
		font-size: 8px;
	}
</style>

</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>  
        
      </button>
      <a class="navbar-brand" href="#">C&S</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
       <li class="active"><a><span class="glyphicon glyphicon-home"></span> Home</a></li>
      	<li><a href="${pageContext.request.contextPath}/profile/">My Profile</a></li>
        <li><a href="${pageContext.request.contextPath}/taskmgr/">Tasks</a></li>
        <li><a href="${pageContext.request.contextPath}/forum/">Forum</a></li>
		<li><a href="${pageContext.request.contextPath}/expenses/">Expenses</a></li>
      </ul>
	     <ul class="nav navbar-nav navbar-right">
	      <li><a href="${pageContext.request.contextPath}/newAccount"><span class="glyphicon glyphicon-user"></span> New Account</a></li>
	      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	     </ul>
    </div>
  </div>
</nav>
<div class="jumbotron text-center">
   <div class="container">
    <div class="row">
        <div class="col-md-offset-5 col-md-3">
        	<h1><strong>C&Source</strong></h1>
        	</br>
        	</br>
        	<p>Welcome back</p>
        	<span id="description" >Select option from navigation menu</span>
			</br>
        	</br>
			</br>
        	</br>
			</br>
			
        	</br>        	        	
        </div>
    </div>
</div>
</div>

</body>
</html>
