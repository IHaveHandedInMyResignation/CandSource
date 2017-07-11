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
        <li><a>Home</a></li>
      	<li><a href="/CAndSource/profile/">My Profile</a></li>
        <li><a href="/CAndSource/taskmgr/">Tasks</a></li>
        <li><a href="/CAndSource/forum/">Forum</a></li>
      </ul>
		<form:form id="logoutForm" action="${pageContext.request.contextPath}/logout" method="POST">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#" onclick="document.getElementById('logoutForm').submit()"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>	    
			</ul>
		</form:form>
    </div>
  </div>
</nav>
<div class="jumbotron text-center">
   <div class="container">
    <div class="row">
        <div class="col-md-offset-5 col-md-3">
        	</br>
        	</br>
        	<div class="alert alert-danger">
	        		<strong><h2>Access denied</h2></strong>
	        		<span id="description" >You do not have permission to access this page</span>
	        	</br>	
        	</div>
        	
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
