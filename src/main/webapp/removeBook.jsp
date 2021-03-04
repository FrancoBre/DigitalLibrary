<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Digital Library</title>
</head>
<body>
	<p>Enter a book's ISBN to remove it from the library</p>
	<form action="/removeBook">
		<input type="text" name="ISBN"> ISBN<br>
		<input type="submit" name="Submit"><br>
	</form>
	${result}<br>
	Go back to <a href="home.jsp">home page</a>
</body>
</html>