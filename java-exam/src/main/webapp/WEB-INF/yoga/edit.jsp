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
<h1>Edit Yoga</h1>
	<form:form action="/yoga/edit/${yoga.id}" method="post" modelAttribute="yoga">
	<input type="hidden" name="_method" value="put"/>
	<form:hidden path="instructor"/>
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
		<label>Description</label>
		<form:input path="description" class="form-control" />
		<form:errors path="description" class="text-danger" />
	</div>
	<input type="submit" value="Edit Class" class="btn btn-primary" />
	</form:form>
		<td>
    	<form action="/yoga/delete/${yoga.id}" method="post">
        	<input type="hidden" name="_method" value="delete"/>
        	<input type="submit" value="Delete" class="btn btn-success btn-outline-light"/>
        </form>
		</td>
</body>
</html>