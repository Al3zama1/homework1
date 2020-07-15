<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assignments</title>
</head>
<body>
	<a href="http://localhost:8080/homework2/CoursesServlet">Course Management</a> 
	<br>
	<a href="http://localhost:8080/homework2/CourseAssignments?course=${param.course}">${param.course}</a>
	<h3>Assignments</h3>
	<table border="1">
		<thead>
			<th>Assignments</th>
			<th>Submissions</th>
			<th>Latest Submission</th>
		</thead>
		<tbody>
			
				
		    	<c:if test = "${param.course == 'CS3220 Web and Internet Programming'}">
         			
         			<c:forEach items="${web}" var="webValue">
         				<tr>
	         				<td><a href="http://localhost:8080/homework2/Submissions?course=${param.course}&assignment=${webValue.getName()}">${webValue.getName()}</td>
	         				<td>${webValue.getTotalSubmissions()}</td>
	         				<td>${webValue.getDate()}</td>
	         			</tr>

					</c:forEach>
         			
      			</c:if>
      			
      			
      			<c:if test = "${param.course == 'CS3035 Programming Paradigms'}">
         			
         			<c:forEach items="${paradigms}" var="paradigmValue">
         				<tr>
	         				<td><a href="http://localhost:8080/homework2/Submissions?course=${param.course}&assignment=${paradigmValue.getName()}">${paradigmValue.getName()}</td>
	         				<td>${paradigmValue.getTotalSubmissions()}</td>
	         				<td>${paradigmValue.getDate()}</td>
	         			</tr>

					</c:forEach>
         			
      			</c:if>
      			

		</tbody>
	</table>
	<br>
	 <a href="http://localhost:8080/homework2/CreateAssignment?course=${param.course}">Create Assignment</a>
</body>
</html>


<c:if test="${status.first}">(First)</c:if>