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
<h1> ${oneDojo.name} Location Ninjas</h1>
	<table>
		<thead>
			<tr>
				<th> First Name </th>
				<th> Last Name </th>
				<th> Age </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ninja" items="${allNinjas}">
				<tr>
					<td><a href="/dojo/show/${ninja.id}"><c:out value="${ninja.firstName}"/></a></td>
					<td><c:out value="${ninja.lastName}"/></td>
					<td><c:out value="${ninja.age}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>