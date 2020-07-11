package homework1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import homework1.models.Assignment;
import homework1.models.Courses;
import homework1.models.Submission;

/**
 * Servlet implementation class CourseAssignments
 */
@WebServlet("/CourseAssignments")
public class CourseAssignments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseAssignments() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		@SuppressWarnings("unchecked")
		LinkedList<Assignment> web =  (LinkedList<Assignment>) request.getServletContext().getAttribute("web");
		@SuppressWarnings("unchecked")
		LinkedList<Assignment> paradigms = (LinkedList<Assignment>) request.getServletContext().getAttribute("paradigms");
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>\n" + 
				"<html lang=\"en\">\n" + 
				"<head>\n" + 
				"    <meta charset=\"UTF-8\">\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" + 
				"    <title>Document</title>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"<a href=\"http://localhost:8080/homework1/CoursesServlet\"><h3>Course Management</h3></a>\n" + 
				"<a href=\"http://localhost:8080/homework1/CourseAssignments?course=" + request.getParameter("course") + "\"><h3>" + request.getParameter("course") + "</h3></a>" +
				"<h3>Assignments</h3>" +
				"    <table border=\"1\">\n" + 
				"        <thead>\n" + 
				"            <th>Assignments</th>\n" + 
				"            <th>Submissions</th>\n" + 
				"            <th>Latest Submission</th>\n" + 
				"        </thead>\n" + 
				"        <tbody>\n" + 
				"            <tr>");
		
//		out.println("<td><a href=\"http://localhost:8080/homework1/CourseAssignments?course=" + course.getName() + "\">" + course.getName() + "</td>\n" + 
		
		if (request.getParameter("course").equals("CS3220 Web and Internet Programming")) {
			
			for(Assignment assignment : web) {
				
				
				if (assignment.getTotalSubmissions() == null) {
					assignment.setTotalSubmissions("0");
				}
				
				

				out.println("<td><a href=\"http://localhost:8080/homework1/Submissions?course=" + request.getParameter("course") + "&assignment=" + assignment.getName() + "\">" + assignment.getName() + "</td>\n");
				out.println("<td>" + assignment.getTotalSubmissions() + "</td>\n");
				out.println("<td>" + assignment.getDate() + "</td>\n");
				out.println("</tr>");
				
			}
			
		} else if (request.getParameter("course").equals("CS3035 Programming Paradigms")) {
			
			for(Assignment assignment : paradigms) {
				
				
				if (assignment.getTotalSubmissions() == null) {
					assignment.setTotalSubmissions("0");
				}
				
				
				out.println("<td><a href=\"http://localhost:8080/homework1/Submissions?course=" + request.getParameter("course") + "&assignment=" + assignment.getName() + "\">" + assignment.getName() + "</td>\n");
				out.println("<td>" + assignment.getTotalSubmissions() + "</td>\n");
				out.println("<td>" + assignment.getDate() + "</td>\n");
				out.println("</tr>");
			}
			
		}
		out.println(
				"        </tbody>\n" +  
				"\n" + 
				"    </table>\n" + 
				"    <br>\n" + 
				"    <br>\n" + 
				"    <a href=\"http://localhost:8080/homework1/CreateAssignment?course=" + request.getParameter("course") + "\">Create Assignment</a>\n" +
				"</body>\n" + 
				"</html>");
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		@SuppressWarnings("unchecked")
		LinkedList<Assignment> web =  (LinkedList<Assignment>) request.getServletContext().getAttribute("web");
		@SuppressWarnings("unchecked")
		LinkedList<Assignment> paradigms = (LinkedList<Assignment>) request.getServletContext().getAttribute("paradigms");
		
		
		@SuppressWarnings("unchecked")
		HashMap<String, LinkedList<Submission>> assignmentsSubmissions = (HashMap<String, LinkedList<Submission>>) request.getServletContext().getAttribute("allSubmissions");
		
		
		

      	 
      	 @SuppressWarnings("unchecked")
		LinkedList<Courses> courses =  (LinkedList<Courses>) request.getServletContext().getAttribute("coursesList");
      	 
		
		String value = request.getParameter("assignment-name");
		

		if (request.getParameter("course").equals("CS3035 Programming Paradigms")) {
			
//			new assignment is added to paradigms list
			paradigms.add(new Assignment(value, "No Submissions" ));

			courses.get(1).setAssignmentsCount(paradigms.size());
			
			
			assignmentsSubmissions.put(value, new LinkedList<Submission>());

			
		} else if (request.getParameter("course").equals("CS3220 Web and Internet Programming")) {
			
//			new assignment is aded to web list
			web.add(new Assignment(value, "No Submissions"));
			
			courses.get(0).setAssignmentsCount(web.size());
			
			assignmentsSubmissions.put(value, new LinkedList<Submission>());
			
			
		}
		

		response.sendRedirect("CourseAssignments?course=" + request.getParameter("course") + "");
		
	}

}
