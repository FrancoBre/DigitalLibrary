<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Digital Library</title>
</head>
<body>
	<h1>Digital library</h1>
	<p>Enter a shelf's id number and a category to label it</p>
	<form action="/labelShelf">
		<input type="number" name="id"> Shelf id<br>
		<input type="text" name="category"> Category<br>
		<input type="submit" name="Submit"><br>
	</form>
	${result}<br>
	Go back to <a href="home.jsp">home page</a>
</body>
</html>