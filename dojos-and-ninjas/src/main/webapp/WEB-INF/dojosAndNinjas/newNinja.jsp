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
<h1>New Ninja</h1>
<form:form action="/ninja/new" method="post" modelAttribute="ninja">
	<div>
		<form:label path="id">Dojo: </form:label>
		<select name="DojoId" >
		    <c:forEach var="dojo" items="${allDojos}">
		        <option value="${dojo.id}">${dojo.name}</option>
		    </c:forEach>
		</select>
		<form:errors path="id"/>
	</div>
	<div>
		<form:label path="firstName">First Name: </form:label>
		<form:input path="firstName" type="text"/>
		<form:errors path="firstName"/>
	</div>
	<div>
		<form:label path="lastName">Last Name: </form:label>
		<form:input path="lastName" type="text"/>
		<form:errors path="lastName"/>
	</div>
	<div>
		<form:label path="age">Age: </form:label>
		<form:input path="age" type="text"/>
		<form:errors path="age"/>
	</div>
	<button class="btn btn-primary" type="submit">Create</button>
</form:form>
</body>
</html>