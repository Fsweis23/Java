<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Dog Adoption</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <!-- NAV-BAR -->
    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Dog Adoption</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-success" type="submit">Logout</button>
            </form>
        </div>
        </div>
    </nav>
    
     	<img alt="" src="${dogImgUrl}">

<!-- JUMBOTRON -->
<div class="jumbotron bg-info text-light my-4 p-4">
<div class="card">
    <img class="card-img-top mb-lg-2" src="" alt="Card image cap">
<div class="card-body">
<h1 class="display-3">Text</h1>
<p class="lead">Text</p>
<hr class="my-2">
<p>Text</p>
<p class="lead">
    <!-- <a class="btn btn-primary btn-lg mt-3" href="#!" id="btn-action" role="button">Click Here</a> -->
</p>
</div>

<!-- CONTAINERS LINKS -->
<div class="row">

<div class="col-sm-4">
    <div class="card">
        <img class="card-img-top" src="" alt="Card image cap">
        <div class="card-body">
            <h4 class="card-title">Title</h4>
            <p class="card-text">
                Text
            </p>
            <a href="#!" class="btn btn-light">Text</a>
        </div>
    </div>
</div>
<div class="col-sm-4">
    <div class="card">
        <img class="card-img-top" src="" alt="Card image cap">
        <div class="card-body">
            <h4 class="card-title">Title</h4>
            <p class="card-text">
                Text
            </p>
            <a href="#!" class="btn btn-light">Text</a>
        </div>
    </div>
</div>
<div class="col-sm-4">
    <div class="card">
        <img class="card-img-top" src="" alt="Card image cap">
        <div class="card-body">
            <h4 class="card-title">Title</h4>
            <p class="card-text">
                Title
            </p>
            <a href="#!" class="btn btn-light">Text</a>
        </div>
    </div>
</div>
</div>
</div>
</div>
</body>
<script src="script.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>