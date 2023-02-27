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
	<h1>review form</h1>
	
		${error}
		
	<form action="/review/form" method="post">
		<input type="hidden" name="reviewer" value="Bobby Brown"/>
		<div>
			<label> Movie </label>
			<input type="text" name="movie"/>
		</div>
		<div>
			<label> Comment </label>
			<textarea name="comment"></textarea>
		</div>
		<div>
			<label> Rating </label>
			<input type="number" name="rating"/>
		</div>
			<button type="submit">review movie</button>
	</form>
</body>
</html>