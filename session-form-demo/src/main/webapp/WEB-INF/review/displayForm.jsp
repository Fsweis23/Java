<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Review info </h1>
	<h3>Reviewer: <c:out value="${reviewer}"/></h3>
	<h3>Movie: <c:out value="${movie}"/></h3>
	<h3>comment: <c:out value="${comment}"/></h3>
	<h3>rating: ${rating}</h3>
</body>
</html>