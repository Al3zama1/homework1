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
	<a href="http://cs3.calstatela.edu:8080/cs3220stu21/Hw2CoursesServlet">Course Management</a>
	<table border="1">
		<thead>
			<th>Course</th>
			<th>Assignments</th>
		</thead>
		<tbody>
			<c:forEach items="${courses}" var="value">
				<tr>
					<td><a href="http://cs3.calstatela.edu:8080/cs3220stu21/Hw2CourseAssignments?course=${value.getName()}">${value.getName()}</a></td>
					<td>${value.getAssignments().size()}</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
</body>
</html>