<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World</h1>
	<p><c:out value='${"<h1> something hanis </h1>"}'/></p>
<%-- 	<h2><c:out value="${2+2}"/></h2> --%>
	<p><c:out value="${name}"/></p>
	<p>${number}</p>
	
	
	<% for(int i = 0; i < 5 ; i++) {%>
		<h1><%= i %></h1>
	<% } %>
	<p>The time is: <%= new Date() %></p>
</body>
</html>