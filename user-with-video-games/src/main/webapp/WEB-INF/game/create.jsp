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
<title>Insert title here</title>
</head>
<body>
	<h1>Add a game to your collection</h1>
	<form:form action="/game/new" method="post" modelAttribute="game">
	<form:hidden path="owner" value="${user_id}"/>
	<div class="form-group">
		<label>Title</label>
		<form:input path="title" class="form-control" />
		<form:errors path="title" class="text-danger" />
	</div>	
	<div class="form-group">
		<label>Rating</label>
		<form:input path="rating" class="form-control" />
		<form:errors path="rating" class="text-danger" />
	</div>
	<div class="form-group">
		<label>Genre</label>
		<form:input path="genre" class="form-control" />
		<form:errors path="genre" class="text-danger" />
	</div>
	<div class="form-group">
		<label>Description</label>
		<form:input path="description" class="form-control" />
		<form:errors path="description" class="text-danger" />
	</div>
	<input type="submit" value="Add Game" class="btn btn-primary" />
	</form:form>
</body>
</html>