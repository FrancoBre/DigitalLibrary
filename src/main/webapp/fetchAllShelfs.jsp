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
	<p>Press "Submit Query" to see all shelfs registered in the library</p>
	<form action="/getAllShelfs">
		<input type="submit" name="Submit"><br>
	</form>
 	${shelfs}<br>
	Go back to <a href="home.jsp">home page</a>
</body>
</html>