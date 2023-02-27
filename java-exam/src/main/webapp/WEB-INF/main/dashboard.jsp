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
<title>Dashboard Page</title>
</head>
<body>
	<h1>Namaste, ${user.userName}.</h1>
<div>
		<a href="/logout">Logout</a>
	</div>
	<h2>Course Schedule</h2>
	<table class="table table-striped">
	<thead>
	<tr>
		<th scope="col">id</th>
		<th scope="col">Class Name</th>
		<th scope="col">Instructor</th>
		<th scope="col">Weekday</th>
		<th scope="col">Price</th>
		<th scope="col">Actions</th>

	</tr>
	</thead>
	<tbody>
	<c:forEach items="${allYoga}" var="yoga">
	<tr>
		<td>${yoga.id}</td>
		<td><a href="/yoga/display/${yoga.id}">${yoga.className}</a></td>
		<td>${yoga.instructor.userName}</td>
		<td>${yoga.weekday}</td>
		<td>${yoga.price}</td>
		<td><a class="btn btn-warning btn-outline-dark" href="/yoga/edit/${yoga.id}">Edit</a></td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	<a class="btn btn-outline-light btn-primary" href="/yoga/new">New Course</a>
</body>
</html>