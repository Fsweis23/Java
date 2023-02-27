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
	<h1>Welcome to the dashboard ${user.userName}</h1>
	<div>
		<a class="btn btn-outline-danger btn-warning" href="/game/new">add a game to your collection</a>
		<a href="/logout">Logout</a>
	</div>
	<h2>Here are all the games in the database</h2>
	<table class="table table-striped">
	<thead>
	<tr>
		<th scope="col">id</th>
		<th scope="col">Title</th>
		<th scope="col">Rating</th>
		<th scope="col">Owner</th>
		<th scope="col">Genre</th>
		<th scope="col">Actions</th>

	</tr>
	</thead>
	<tbody>
	<c:forEach items="${allGames}" var="game">
	<tr>
		<td>${game.id}</td>
		<td><a href="/game/display/${game.id}">${game.title}</a></td>
		<td>${game.rating}</td>
		<td>${game.owner.userName}</td>
        <td>${game.genre}</td>
		<td><a class="btn btn-warning btn-outline-primary" href="/game/edit/${game.id}">Edit</a>
    	<form action="/game/delete/${game.id}" method="post">
        	<input type="hidden" name="_method" value="delete"/>
        	<input type="submit" value="Delete" class="btn btn-danger btn-outline-dark"/>
        </form>
		</td>
	</tr>
	</c:forEach>
	</tbody>
	</table>

</body>
</html>