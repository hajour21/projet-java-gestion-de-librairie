<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="addition.Book"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<link href="style/css/bootstrap.min.css" rel="stylesheet">

<meta charset="ISO-8859-1">
<title>AddBook</title>
</head>
<body>
	<nav class="navbar navbar-light" style="background-color: #a2f2fd;">
		<div class="container-fluid">
			<h1>
			<p class="navbar-brand">Book's App</p></h1>
			<h3><a class="navbar-brand" href="index.jsp">LogOut</a></h3>
		</div>
	</nav>
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link" aria-current="page"
			href="AddBook">Add Books</a></li>
		<li class="nav-item"><a class="nav-link "
			href="./Bibliotheque.jsp">All Books</a></li>
	</ul>
	<br>
	<h3>Books Form</h3>
	<br>
		<form action="Addbook" method="post">
            		<h2>Add New book</h2>	
	<fieldset class="form-group">
		<label>Title : </label> <input type="text"
			name="title" value="<c:out value='${book.title}'/>" required="required">
	</fieldset>

	<fieldset class="form-group">
		<label>ISBN</label> <input type="text" value="<c:out value='${book.ISBN}'/>"
			name="ISBN">
	</fieldset>

	<fieldset class="form-group">
		<label>Author</label> <input type="text" value="<c:out value='${book.author}'/>"
			name="Author">
	</fieldset>

	<fieldset class="form-group">
		<label>language</label> <input type="text" value="<c:out value='${book.language}'/>" 
			name="language" required="required">
	</fieldset>

	<fieldset class="form-group">
		<label>year</label> <input type="text" value="<c:out value='${book.year}'/>"
			name="Year" required="required">
	</fieldset>

	<fieldset class="form-group">
		<label>abstract</label> <input type="text"  
			name="Abstract" required="required">
	</fieldset>

	<button type="submit" class="btn btn-success">ADD</button>
	</form>


</body>
</html>