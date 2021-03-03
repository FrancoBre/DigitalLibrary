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
	<p>Enter a book's ISBN to get a book from the library</p>
	<form action="/getBook">
		<input type="text" name="ISBN"> ISBN<br>
		<input type="submit" name="Submit"><br>
	</form>
	${book}<br>
	Go back to <a href="http://localhost:8080/">home page</a>
</body>
</html>