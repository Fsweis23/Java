<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<h1>One Donation Page</h1>
	<a class="btn btn-success btn-outline-dark d-flex justify-content-end" href="/dashboard">Back to Dashboard</a>
	<h2>Donation : <c:out value="${donation.donationName}"/></h2>
	<h3>Quantity : <c:out value="${donation.quantity}"/></h3>
	<h3>Donor : <c:out value="${donation.donor.userName}"/></h3>
	<form action="/donation/delete/${donation.id}" method="post">
		<input type="hidden" name="_method" value="delete"/>
		<input class="btn btn-danger btn-outline-dark d-flex justify-content-end" type="submit" value="Delete"/>
	</form>
</body>
</html>