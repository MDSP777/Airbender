<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>SECURDE</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />" />
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
    rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
	<script src="<c:url value="/resources/js/login.js" />" type="text/javascript"></script>
</head>
<body>

	<div class="navbar" id="navbar">
      <div class="container" id="container">
        <div class="navbar-header" id="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="patatas.htmlxxx" class="navbar-brand" style = "margin-top:10px;"><span style="font-size: 200%;">SECURDE</span></a>
        </div>
<!--         <div id="icons" data-toggle="collapse" data-target="#navbar-ex-collapse"> -->
<!--             <ul id="icons-nav"> -->
<!-- 			      <div class="col-sm-10"> -->
<!-- 			        <input type="search" class="form-control" id="search" placeholder="Search Item"> -->
<!-- 			      </div> -->
<!--             </ul> -->
<!--         </div> -->
          <ul id="rightnav">
			<c:choose>
			  <c:when test="${user==null }">
				<li>
					<a id="login-button">Login</a>
				</li>
				<li>
					<a href="signup" id="signup-button">Sign Up</a>
				</li>
			  </c:when>
			  <c:otherwise>
			  	<li>
			  		<a>Hi, ${user.firstName }!</a>
			  	</li>
			  	
			<c:if test="${user.userType == 'PM'}">
				<li>
					<a href="categories?type=productManager" id="pm-button">Manage Products</a>
				</li>
			</c:if>
			
			<c:if test="${user.userType == 'admin'}">
				<li>
					<a href="ad" id="ad-button">Manage Accounts</a>
				</li>
			</c:if>
			
			<c:if test="${user.userType == 'AM'}">
				<li>
					<a href="view_sales_reports?total" id="am-button">View Sales Reports</a>
				</li>
			</c:if>
			  	
			  	<li>
					<a href="logout" id="signup-button">Logout</a>
			  	</li>
			  </c:otherwise>
			</c:choose>
		</ul>
      </div>
    </div>
    
    
	<div id="login" >
		<div class="loginBox">
		<form action="login" method="post">
			<div class="form-text" >Username</div>
			<input type="text" name="username"/>
			<div class="form-text" >Password</div>
			<input type="password" name="password"/>
			<div class="loginButtons">
				<div class = "row">
					<button type="button" class="cancel">Cancel</button>
					<button type="submit" class="submit-user">Login</button>
				</div>
			</div>
		</form>
		</div>
	</div>