<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assignments</title>
</head>
<body>
	<a href="http://localhost:8080/homework2/Hw2CoursesServlet">Course
		Management</a>
	<br>
	<a
		href="http://localhost:8080/homework2/Hw2CourseAssignments?course=${param.course}">${param.course}</a>
	<h3>Assignments</h3>
	<table border="1">
		<thead>
			<th>Assignments</th>
			<th>Submissions</th>
			<th>Latest Submission</th>
		</thead>
		<tbody>
		
			<c:forEach items="${assignments}" var="value">
				<tr>
					<td><a
						href="http://localhost:8080/homework2/Hw2Submissions?course=${param.course}&assignment=${value.getName()}">${value.getName()}</td>
					<td>${value.getTotalSubmissions()}</td>
					<td>${value.getDate()}</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
	<br>
	<a
		href="http://localhost:8080/homework2/Hw2CreateAssignment?course=${param.course}">Create
		Assignment</a>
</body>
</html>


<c:if test="${status.first}">(First)</c:if>