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
<title>Create Page</title>
</head>
<body>
	<h1>Create a Course</h1>
	<form:form action="/yoga/new" method="post" modelAttribute="yoga">
		<form:hidden path="instructor" value="${user_id}"/>
		<div class="form-group">
			<label>Name: </label>
			<form:input path="className" class="form-control" />
			<form:errors path="className" class="text-danger" />
		</div>
		<div class="form-group">
			<label>Day of Week: </label>
			<form:input path="weekday" class="form-control" />
			<form:errors path="weekday" class="text-danger" />
		</div>
		<div>
			<form:label path="price">Drop-in Price</form:label>
			<form:input path="price" type="number"/>
			<form:errors path="price"/>
		</div>
		<div class="form-group">
			<label>Description: </label>
			<form:input path="description" class="form-control" />
			<form:errors path="description" class="text-danger" />
		</div>
		<input type="submit" value="Submit" class="btn btn-primary" />
	</form:form>
</body>
</html>