<!DOCTYPE html>
<html lang="en">
<head>
  <title>C&Source My Profile</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  <style>    
    /* Set black background color, white text and some padding */
  footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    #upcmngTsk{
    	font-size: 12px;
    }
    #taskHeader{
    	padding-top: 8px;
    	font-size: 14px;
    }
    #taskDescription{
    	line-height: 0.9;
    	font-size: 11px;
    	font-style: italic;
    }
    #taskDate{
    	line-height: 1;
    	font-size: 12;
    }
    #buttonShare{
    	margin-top: 2px;
    	float: right;
    	margin-bottom: 8px;
    }
    #postLabel {
  		float:left;
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
        <li class="active"><a href="#"><span class="glyphicon glyphicon-user"></span> My Profile</a></li>
        <li><a href="${pageContext.request.contextPath}/taskmgr/">Tasks</a></li>
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
  
<div class="container text-center" >    
  <div class="row">
    <div class="col-sm-3 well">
      <div class="well">
        <p><a href="#">My Profile</a></p>
        <img src="bird.jpg" class="img-circle" height="65" width="65" alt="Avatar">
      </div>
      <div class="well">
        <p><a href="#" title="Click to show your all posts">Your last posts:</a></p>
        <p>
        <div class="row">
          <span class="label label-default">Post_1..2blablablab</span>
         </div>
         <div class="row">
          <span class="label label-primary">Post_2..blablalab</span>
          </div>
          <div class="row">
          <span class="label label-success">Post_3..blablablab</span>
          </div>
          <div class="row">
          <span class="label label-info">Post_4..blablablab</span>
          </div>
          <div class="row">
          <span class="label label-warning">Post_5..blablablab</span>
          </div>
          <div class="row">
          <span class="label label-danger">Post_6..blablablab</span>
          </div>
        </p>
      </div>
      <div class="alert alert-success fade in">
        <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
        <p><strong>Ey!</strong></p>
        People are looking at your profile. Find out who.
      </div>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
    </div>
    <div class="col-sm-7">
      <div class="row">
        <div class="col-sm-12">
            <div class="form-group">
		  		<label id="postLabel" for="comment" >Lets talk about something:</label>
		  		<textarea class="form-control" rows="5" id="post"></textarea>
		  		<button id="buttonShare" type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-share"></span> Share</button>
			</div>
          
        </div>
      </div>
      
      <div class="row">
        <div class="col-sm-3">
          <div class="well well-sm">
           <p>John</p>
           <img src="bird.jpg" class="img-circle" height="55" width="55" alt="Avatar">
          </div>
        </div>
        <div class="col-sm-9">
          <div class="well">
            <p>Just Forgot that I had to mention something about someone to someone about how I forgot something, but now I forgot it. Ahh, forget it! Or wait. I remember.... no I don't.</p>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-3">
          <div class="well well-sm">
           <p>Bo</p>
           <img src="bandmember.jpg" class="img-circle" height="55" width="55" alt="Avatar">
          </div>
        </div>
        <div class="col-sm-9">
          <div class="well">
            <p>Just Forgot that I had to mention something about someone to someone about how I forgot something, but now I forgot it. Ahh, forget it! Or wait. I remember.... no I don't.</p>
          </div>
        </div>
      </div>

    </div>
    <div class="col-sm-2 well well-sm">
        <p id= "upcmngTsk">Upcoming Tasks:</p>
        <ul class="list-group">
        <li class ="list-group-item">
	        <p><span class="glyphicon glyphicon-time"></span><strong>Task_nr_one</strong></p>
	        <p id="taskDate"><span class="label label-info">20:00</span></p>
	        <p id="taskDate"><span class="label label-info">2017-05-03</span> </p>
	        <p id="taskDescription">task secr t Forgot that I had to mention something about someone to someone abou</p>
	        <button class="btn btn-default btn-xs"><span class = "glyphicon glyphicon-triangle-right"></span> More</button>
        </li>
        <li class ="list-group-item">        
        <p id="taskHeader"><span class="glyphicon glyphicon-time"></span><strong>Paris</strong></p>
	         <p id="taskDate"><span class="label label-info">20:00</span></p>
	        <p id="taskDate"><span class="label label-info">2017-05-03</span> </p>
	        <p id="taskDescription">sorgot something, but now I forgorgot something, but now I forgorgot something, but now I forgomeone to someone about how I forgot something, but now I forgot it. Ahh, forget it</p>
	        <button class="btn btn-default btn-xs"><span class = "glyphicon glyphicon-triangle-right"></span> More</button>
		</li>
        <li class ="list-group-item">
	        <p id="taskHeader"><span class="glyphicon glyphicon-time"></span><strong>Paris</strong></p>
	         <p id="taskDate"><span class="label label-info">20:00</span></p>
	        <p id="taskDate"><span class="label label-info">2017-05-03</span> </p>
	        <p id="taskDescription">someone to someone about how I forgot something, but now I forgot it. Ahh, forget it</p>
	        <button class="btn btn-default btn-xs"><span class = "glyphicon glyphicon-triangle-right"></span> More</button>
        </li>
        </ul>
            

    </div>
  </div>
</div>



</body>
</html>
