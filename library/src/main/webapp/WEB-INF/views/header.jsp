<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<% 
String user_id = (String)request.getSession().getAttribute("user_id");
String user_name = (String)request.getSession().getAttribute("user_name");
String user_type = (String)request.getSession().getAttribute("user_type");
%>

<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
		<meta name="generator" content="Jekyll v3.8.5">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="/library/resources/js/main.js"></script>
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
						<a id="myBooks" class="nav-link" href="">MyBooks</a>
					</li>
					<c:if test="${user_type == '1'}">
					<li class="nav-item">
						<a id="googleAPI" class="nav-link" href="/library/google_books_api">Google API</a>
					</li>
					</c:if>
				</ul>
				<div class="navbar-nav">
					<c:if test="${user_id != null}"><div class="nav-item"><a class="nav-link" href="/library/update_user">${user_name}</a></div></c:if>
					<c:if test="${user_id == null}"><div class="nav-item"><a class="nav-link" href="/library/sign_up">Sign up</a></div></c:if>
				</div>
				<div class="navbar-nav">
					<c:if test="${user_id != null}"><div class="nav-item"><a class="nav-link" href="/library/sign_out">Sign out</a></div></c:if>
					<c:if test="${user_id == null}"><div class="nav-item"><a class="nav-link" href="/library/sign_in">Sign in</a></div></c:if>
				</div>
				<form id="formSearchBook" class="form-inline my-2 my-lg-0">
					<input id="searchBook" name="searchBook" class="form-control mr-sm-2" type="text" placeholder="Search Book" aria-label="Search">
					<button id="btnSearchBook" class="btn btn-outline-success my-2 my-sm-0">Search</button>
				</form>
			</div>
		</nav>
		<input type="hidden" id="user_id" name="user_id" value="${user_id}" />