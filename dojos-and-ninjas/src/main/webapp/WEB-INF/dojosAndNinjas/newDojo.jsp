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
<h1>New Dojo</h1>
<form:form action="/dojo/new" method="post" modelAttribute="dojo">
	<div>
		<form:label path="name">Name: </form:label>
		<form:input path="name" type="text"/>
		<form:errors path="name"/>
	</div>
	<button class="btn btn-primary" type="submit">Create</button>
</form:form>
</body>
</html>