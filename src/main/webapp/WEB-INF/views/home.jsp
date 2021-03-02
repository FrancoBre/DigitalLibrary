<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Digital library</title>
</head>
<body>

	<h1>Digital library</h1>
	<p>Welcome! To enter books to be accessed in this digital library, please enter the book's
	ISBN, its name, its category and its width in centimeters. </p>
	<form action="/addBook">
		<input type="text" name="ISBN"> ISBN<br>
		<input type="text" name="name"> Name<br>
		<input type="text" name="category"> Category<br>
		<input type="number" name="width"> Width<br>
		<input type="submit" name="Submit"> ${result}<br>
	</form>
	
</body>
</html>