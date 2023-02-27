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
<h1>All Dojos</h1>
	<table>
		<thead>
			<tr>
				<th> Name </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dojo" items="${allDojos}">
				<tr>
					<td><a href="/dojo/show/${dojo.id}"><c:out value="${dojo.name}"/></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>