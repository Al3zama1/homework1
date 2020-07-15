package homework2.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import homework2.Model.Hw2Assignment;
import homework2.Model.Hw2Courses;
import homework2.Model.Hw2Submission;


@WebServlet("/Hw2CourseAssignments")
public class Hw2CourseAssignments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       

    public Hw2CourseAssignments() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    protected LinkedList<Hw2Assignment> loadCourseAssignments(HttpServletRequest request, String course) {
    	
    	@SuppressWarnings("unchecked")
		HashMap<String, LinkedList<Hw2Assignment>> allAssignments = (HashMap<String, LinkedList<Hw2Assignment>>) request.getServletContext().getAttribute("courseAssignments");
		return allAssignments.get(course);
    	
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String course = request.getParameter("course");
		LinkedList<Hw2Assignment> courseAssignments = loadCourseAssignments(request, course);
		
		
		request.setAttribute("assignments", courseAssignments);
		response.setContentType( "text/html" );
		request.getRequestDispatcher("/Hw2Assignments.jsp").forward(request, response);
	} 


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String course = request.getParameter("course");
		
		@SuppressWarnings("unchecked")
		HashMap<String, LinkedList<Hw2Assignment>> allAssignments = (HashMap<String, LinkedList<Hw2Assignment>>) request.getServletContext().getAttribute("courseAssignments");
		
		LinkedList<Hw2Assignment> courseAssignments = loadCourseAssignments(request, course);
		
		
		if (courseAssignments == null) {
			allAssignments.put(request.getParameter("course"), new LinkedList<Hw2Assignment>());
			courseAssignments = allAssignments.get(course);
		}
		
		
		@SuppressWarnings("unchecked")
		HashMap<String, LinkedList<Hw2Submission>> assignmentsSubmissions = (HashMap<String, LinkedList<Hw2Submission>>) request.getServletContext().getAttribute("allSubmissions");
		
      	 
      	 @SuppressWarnings("unchecked")
		LinkedList<Hw2Courses> courses =  (LinkedList<Hw2Courses>) request.getServletContext().getAttribute("coursesList");
      	 
		
		String value = request.getParameter("assignment-name");
		
		
		courseAssignments.add(new Hw2Assignment(value, "No Submissions" ));
		
		
		for (int i = 0; i < courses.size(); i++) {
			if (request.getParameter("course").equals(courses.get(i).getName())) {
				courses.get(i).setAssignmentsCount(courseAssignments.size());
				break;
			}
		}
		
		assignmentsSubmissions.put(value, new LinkedList<Hw2Submission>());
		

		response.sendRedirect("Hw2CourseAssignments?course=" + course + "");
		
	}

}
