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
	<form action="/review/form" method="post">
		<input type="hidden" name="friend" value="Bob Dylan"/>
		<div>
			<label> Pick any number from 5 to 25 </label>
			<input type="number" min="5" max="25" name="number"/>
		</div>
		<div>
			<label> Enter the name of any city. </label>
			<input type="text" name="city"/>
		</div>
		<div>
			<label> Enter the name of any real person </label>
			<input type="text" name="city"/>
		</div>
		<div>
			<label> Enter professional endeavor or hobby: </label>
			<input type="text" name="hobby"/>
		</div>
		<div>
			<label> Enter any type of living thing. </label>
			<input type="text" name="thing"/>
		</div>
		<div>
			<label> Say something nice to someone: </label>
			<textarea name="nice"></textarea>
		</div>
		<p>Send and show a friend</p>
		<button type="submit">Send</button>
	</form>
</body>
</html>