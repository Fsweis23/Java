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
	<h1>edit a donation</h1>
	<form:form action="/donation/edit/${donation.id}" modelAttribute="donation" method="post">
	<input type="hidden" name="_method" value="put"/>
		<form:input type="hidden" path="donor" value="${donation.donor.id}"/>
		<div>
			<form:label path="donationName"> Donation Name</form:label>
			<form:input type="text" path="donationName"/>
			<form:errors path="donationName"/>
		</div>
		<div>
			<form:label path="quantity"> Quantity</form:label>
			<form:input type="text" path="quantity"/>
			<form:errors path="quantity"/>
		</div>
		<input type="submit" value="Edit Donation"/>
		</form:form>
</body>
</html>