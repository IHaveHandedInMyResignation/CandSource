<!DOCTYPE html>
<html lang="en">
<head>
  <title>C&Source Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
	#descriptionText{
		font-size: 15px;
	}
	.col-sm-10{
		background-color: #afafaf;
	}
	#askForLogin{
    	line-height: 0.9;
    	font-size: 11px;
    	font-style: italic;
    	margin-top: 5px;
    	margin-bottom: 8px;
    }
	}
	#loginAlert{
		font-size: 8px;
	}
	#passwordMargins{
		margin-top: 5px;
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
       <li><a href="${pageContext.request.contextPath}/">Home</a></li>
      	<li><a href="${pageContext.request.contextPath}/profile/">My Profile</a></li>
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
        <div class="col-md-offset-5 col-md-3">
        	
        	<form name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST'>
        	
					
				  <table>
				  <tr><td><h2><strong>C&Source</strong></h1></td></tr>
				  <tr><td><p>Welcome back</p></td></tr>
				  <tr><td><c:if test="${param.error eq 'loginFailure'}"><div class="alert alert-danger">Incorrect Username or Password</div> </c:if></td></tr>
					<tr>
						<td><input type='text' name='username' value='' placeholder="Username" class="form-control"></td>
					</tr>
					<tr>
						<td><input type='password' name='password' placeholder="Password" class="form-control" id="passwordMargins"/></td>
					</tr>
					<tr>
					<td><p id="askForLogin">Please login yourself</p>
					</td>
					</tr>
					<tr>
						<td colspan='2'><input name="submit" type="submit" value="Login"  class="btn btn-primary" /></td>
					</tr>
				  </table>
				  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
        </div>
    </div>
</div>
</div>

</body>
</html>
