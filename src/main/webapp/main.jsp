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
	<p>Welcome! To get started, let's create a library</p>
	<p>Enter how many shelfs will this library have, and their width in centimeters</p><br>
	<form action="/addLibrary">
		<input type="text" name="name"> Name<br>
		<input type="number" name="shelfNumber"> Shelf Number<br>
		<input type="number" name="shelfWidth"> Shelf Width<br>
		<input type="submit" name="Submit"><br>
	</form>
</body>
</html>