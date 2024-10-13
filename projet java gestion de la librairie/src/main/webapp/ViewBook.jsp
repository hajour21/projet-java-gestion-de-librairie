<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book</title>

<link href="style/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp">log-out</a>
		</div>
	</nav>
	<ul class="nav nav-tabs">
		
		<c:if test="${role != null}">
			<li class="nav-item"><a class="nav-link" aria-current="page"
				href="AddBook">Add Books</a></li>
			<li class="nav-item"><a class="nav-link" aria-current="page"
				href="ListUsers">Users</a></li>
		</c:if>
		<c:if test="${role = null}">
			<li class="nav-item"><a class="nav-link" aria-current="page"
				href="mark.jsp">My Books</a></li>
		</c:if>
		<li class="nav-item"><a class="nav-link active"
			href="ListerBooks">All Books</a></li>
	</ul>
	<br>
	<br>
	<table
		class="table table-success table-light table table-hover table-bordered">
		
			<tr>
				<td scope="col">Title</td>
				<td scope="col">${book1.title}</td>
			</tr>
			<tr>
				<td scope="col">ISBN</td>
				<td scope="col">${book1.ISBN}</td>
			</tr>
			<tr>
				<td scope="col">Authors</td>
				<td scope="col">${book1.author}</td>
			</tr>
			<tr>
				<td scope="col">Language</td>
				<td scope="col">${book1.language}</td>
			</tr>
			<tr>
				<td scope="col">Year</td>
				<td scope="col">${book1.year}</td>
			</tr>
			<tr>
				<td scope="col">Abstract</td>
				<td scope="col"></td>
			</tr>
			
	</table>
</body>
</html>