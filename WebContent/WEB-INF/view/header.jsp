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
          <a href="index.jsp" class="navbar-brand"><span style="font-size: 200%;">Securde</span></a>
        </div>
        <div id="icons" data-toggle="collapse" data-target="#navbar-ex-collapse">
            <ul id="icons-nav">
              <li>
                  <a href=""><div id="flood"></div></a>
              </li>
              <li>
                <a href=""><div id="storm"></div></a>
              </li>
              <li>
                <a href=""><div id="earthquake"></div></a>
              </li>
            </ul>
        </div>
          <ul id="rightnav">
			
			<li>
				<a id="login-button">Login</a>
			</li>
			<li>
				<a id="signup-button">Sign Up</a>
			</li>
		</ul>
      </div>
    </div>
    
    <div id="signup" >
		<h1 class = "boxheader">Sign Up</h1>
		<div class="loginBox">
		<form action="signup" method="post">
			<div class="form-text" >Username</div>
			<input type="text" name="username"/>
			<div class="form-text" >Password</div>
			<input type="password" name="password"/>
			<div class="loginButtons">
				<div class = "row">
					<button type="button" class="cancel">Cancel</button>
					<button type="submit" class="submit-user">Sign Up</button>
				</div>
			</div>
		</form>
		</div>
	</div>
	<div id="login" >
		<h1 class = "boxHeader">Login</h1>
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