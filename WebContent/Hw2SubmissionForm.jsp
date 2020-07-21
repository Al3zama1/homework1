<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Submission</title>
</head>
<body>
	<a href="http://localhost:8080/homework2/Hw2CoursesServlet">Course Management</a>
	<br>
	<a href="http://localhost:8080/homework2/Hw2CourseAssignments?course=${param.course}">${param.course}</a>	
	<br>
	<a href="http://localhost:8080/homework2/Hw2Submissions?course=${param.course}&assignment=${param.assignment}">${param.assignment}</a>
	<h3>Create Submission</h3>
	
	<form action="http://localhost:8080/homework2/Hw2Submissions?course=${param.course}&assignment=${param.assignment}" method="post">
		<label for="student-name">Student Name</label>
		<input type="text" id="student-name" name="student-name">
		<br>
		<br>
		<label for="answer">Answer</label>
		<textarea name="answer" id="answer"></textarea>
		<br>
		<br>
		<input type="submit" value="Create">
	</form>
</body>
</html>