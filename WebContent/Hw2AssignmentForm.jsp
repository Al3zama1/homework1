<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Assignment</title>
</head>
<body>
	<a href="http://cs3.calstatela.edu:8080/cs3220stu21/Hw2CoursesServlet">Course Management</a>
	<br>
	<a href="http://cs3.calstatela.edu:8080/cs3220stu21/Hw2CourseAssignments?course=${param.course}">${param.course}</a>
	<form action="http://cs3.calstatela.edu:8080/cs3220stu21/Hw2CourseAssignments?course=${param.course}" method="post">
		<label for="assignment-name">Assignment Name:</label>
		<input type="text" name="assignment-name" id="assignment-name">
		<br>
		<input type="submit" value="Create">
	</form>
</body>
</html>