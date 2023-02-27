<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<h1>Dashboard Welcome <c:out value="${loggedInUser.userName}"/></h1>
	<a class="btn btn-outline-danger btn-warning" href="/user/logout">Logout</a>
	<a href="/donation/new">Donate!</a>
	<table class="table table-dark">
	<thead>
	<tr>
		<th scope="col">id</th>
		<th scope="col">Donation Name</th>
		<th scope="col">Quantity</th>
		<th scope="col">Donor</th>
		<th scope="col">Actions</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="donation" items="${allDonations}">
	<tr>
			<td>${donation.id}</td>
			<td><a href="donation/display/${donation.id}">${donation.donationName}</a></td>
			<td>${donation.donationName}</td>
			<td>${donation.quantity}</td>
			<td>${donation.donor.userName}</td>
			<td>
			<a class="btn btn-warning btn-outline-primary" href="/donation/edit/${donation.id}">Edit</a>
			</td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
</body>
</html>