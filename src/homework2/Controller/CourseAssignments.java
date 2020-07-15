package homework2.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework2.Model.Assignment;
import homework2.Model.Courses;
import homework2.Model.Submission;

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
		
		
		for (Assignment assignment: web) {
			if (assignment.getTotalSubmissions() == null) {
				assignment.setTotalSubmissions("0");
			}
		}
		
		for (Assignment assignment: paradigms) {
			if (assignment.getTotalSubmissions() == null) {
				assignment.setTotalSubmissions("0");
			}
		}
		
		response.setContentType( "text/html" );
		request.getRequestDispatcher("/Assignments.jsp").forward(request, response);
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
