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
	<h1>JSTL Demo</h1>
	<h2><c:out value="${jspName}"/></h2>
	<p>${jspAge}</p>
	<p>${jspIsHungry}</p>
<%-- 	<p><c:out value="${test}"/></p> --%>
	<p>${test}</p>
	<p>${dateFromJsp}</p>

	
	<h1>if-statement</h1>
	<c:if test="${jspIsHungry}">
		<p><c:out value="${jspName}"/> is hungry</p>
	</c:if>
	
	<h1>if-else statement</h1>
	<c:choose>
		
		<c:when test="${jspAge < 21}">
			<p><c:out value="${jspName}"/> is under 21 and can't buy drinks</p>
		</c:when>
		
		<c:otherwise>
			<p><c:out value="${jspName}"/> is over 21 drink up</p>
		</c:otherwise>
		
	</c:choose>
	
	<h1>for each</h1>
	<c:forEach var="user" items="${jspUsers}">
			<p><c:out value="${user}"/></p>
	</c:forEach>
</body>
</html>