<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
		<meta name="generator" content="Jekyll v3.8.5">
		<link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/jumbotron/">
		<link rel="stylesheet" type="text/css" href="/library/resources/css/main.css">
	  	<!-- Bootstrap core CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<title>Library</title>
	</head>
  	<body>
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
			<a class="navbar-brand" href="/library">PUBLIC<br>LIBRARY</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			
			<div class="collapse navbar-collapse" id="navbarsExampleDefault">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item">
						<a class="nav-link" href="/library/books">Books</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/library/subjects">Subjects</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/library/rental">Rental</a>
					</li>
				</ul>
				<div class="navbar-nav">
					<div class="nav-item"><a class="nav-link" href="/library/sign_in">Sign in</a></div>
				</div>
				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</nav>
		
		<main role="main">
			<!-- Main jumbotron for a primary marketing message or call to action -->
			<div class="jumbotron top_image">
				<div class="container">
					<h1 class="display-3">Beliveau Library</h1>
				</div>
			</div>
			<!--
			<div class="container">
				<div class="row">
					<c:forEach var="item" items="${list}">
						<div class="col-2">
							<a href="bookInfo?book_id=${item.book_id}"><img src="${item.image}" alt="" class="book_image" /></a>
							<h3>${item.title}</h3>
						</div>
					</c:forEach>
				</div>
			</div>
			-->
			
			<div class="container main_container">
				<div class="row">
					<h3>Just add</h3>
				</div>
				<div class="card-deck">
					<c:forEach var="item" items="${list}">
		                <div class="card text-center">
		                    <div class="card-block">
		                    	<a href="bookInfo?book_id=${item.book_id}"><img src="${item.image}" alt="" class="card-img-top" /></a>
		                        <h5 class="card-title">${item.title}</h5>
		                        <h6 class="card-title">by ${item.author}</h6>
		                    </div>
		                </div>
					</c:forEach>
				</div>
			</div>
			<div class="container main_container">
				<div class="row">
					<h3>Your next great read</h3>
				</div>
				<div class="card-deck">
					<c:forEach var="item" items="${list}">
		                <div class="card text-center">
		                    <div class="card-block">
		                    	<a href="bookInfo?book_id=${item.book_id}"><img src="${item.image}" alt="" class="card-img-top" /></a>
		                        <h5 class="card-title">${item.title}</h5>
		                        <h6 class="card-title">by ${item.author}</h6>
		                    </div>
		                </div>
					</c:forEach>
				</div>
			</div>
			
		</main>

		<footer>
			<hr>
			<div class="container">
				<p>Public library Copyright &copy; 2020</p>
			</div>
		</footer>
		
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')</script><script src="/docs/4.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
	</body>
</html>
