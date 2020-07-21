<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Submission</title>
</head>
<body>
	<a href="http://cs3.calstatela.edu:8080/cs3220stu21/Hw2CoursesServlet">Course Management</a>
	<br>
	<a href="http://cs3.calstatela.edu:8080/cs3220stu21/Hw2CourseAssignments?course=${param.course}">${param.course}</a>	
	<br>
	<a href="http://cs3.calstatela.edu:8080/cs3220stu21/Hw2Submissions?course=${param.course}&assignment=${param.assignment}">${param.assignment}</a>
	<h3>Create Submission</h3>
	
	<form action="http://cs3.calstatela.edu:8080/cs3220stu21/Hw2Submissions?course=${param.course}&assignment=${param.assignment}" method="post">
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