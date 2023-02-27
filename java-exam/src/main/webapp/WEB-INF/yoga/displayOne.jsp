<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Display Page</title>
</head>
<body>
	<a href="/dashboard"> Back Home</a>
	<h1>${yoga.className} with Jax</h1>
	<h3>Day: ${yoga.weekday}</h3>
	<h3>Cost: ${yoga.price}</h3>
	<h3>${yoga.description}</h3>
</body>
</html>