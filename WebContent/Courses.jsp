<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Courses</title>
</head>
<body>
	<a href="http://localhost:8080/homework2/CoursesServlet">Course Management</a>
	<table border="1">
		<thead>
			<th>Course</th>
			<th>Assignments</th>
		</thead>
		<tbody>
			<c:forEach items="${coursesList}" var="value">
				<tr>
					<td><a href="http://localhost:8080/homework2/CourseAssignments?course=${value.getName()}">${value.getName()}</a></td>
					<td>${value.getAssignmentsCount()}</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
</body>
</html>