<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
	<title>Carousel Template for Bootstrap</title>
</head>

<body>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">Shopping Website</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li><a href="<c:url value="/"/>">Home</a></li>
	      <li><a href="<c:url value="/product/list"/>">Products</a></li>
	      <li><a href="#">About</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
					<li><a href="<c:url value="/customer/cart" />"> Cart</a></li>
				</c:if>
				<c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
					<li><a href="<c:url value="/admin" />"> Admin</a></li>
				</c:if>
				<li><a href="<c:url value="/logout"/>"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</c:if>
			<c:if test="${pageContext.request.userPrincipal.name == null}">
				<li><a href="<c:url value="/register"/>"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</c:if>
	    </ul>
	  </div>
	</nav>
	

  
