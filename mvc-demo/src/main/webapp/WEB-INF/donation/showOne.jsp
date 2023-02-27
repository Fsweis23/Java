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
	<h1>Donation: <c:out value="${oneDonation.donationName}"/></h1>
	<h4>Quantity: <c:out value="${oneDonation.quantity}"/></h4>
	<h4>Donor: <c:out value="${oneDonation.donor}"/></h4>
	<h4>CreatedAt: <c:out value="${oneDonation.createdAt}"/></h4>
	<form action="/donation/delete/${oneDonation.id}" method="post">
    	<input type="hidden" name="_method" value="delete">
   		<input class="btn btn-danger" type="submit" value="Delete">
	</form>
</body>
</html>