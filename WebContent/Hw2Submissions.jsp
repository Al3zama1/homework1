<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Submissions</title>
</head>
<body>
	<a href="http://cs3.calstatela.edu:8080/cs3220stu21/Hw2CoursesServlet">Course Management</a> 
	<br>
	<a href="http://cs3.calstatela.edu:8080/cs3220stu21/Hw2CourseAssignments?course=${param.course}">${param.course}</a>
	<table border="1">
		<thead>
			<th>Student Name</th>
			<th>Answer</th>
			<th>Submitted Date</th>
		</thead>
		<tbody>
			<c:forEach items="${submission}" var="sub">
				<tr>
				<td>${sub.getStudentName()}</td>
				<td>${sub.getAnswer()}</td>
				<td>${sub.getSubmissionDate()}
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="http://cs3.calstatela.edu:8080/cs3220stu21/Hw2CreateSubmission?course=${param.course}&assignment=${param.assignment}">Create Submission</a>
</body>
</html>