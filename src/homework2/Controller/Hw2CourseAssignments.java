package homework2.Controller;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import homework2.Model.Hw2Assignment;
import homework2.Model.Hw2Courses;


@WebServlet("/Hw2CourseAssignments")
public class Hw2CourseAssignments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       

    public Hw2CourseAssignments() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String course = request.getParameter("course");
		
		LinkedList<Hw2Courses> courses = (LinkedList<Hw2Courses>) request.getServletContext().getAttribute("courses");
		
		
		for (int i = 0; i < courses.size(); i++) {
			
			if (courses.get(i).getName().equals(course)) {
				
				request.setAttribute("assignments", courses.get(i).getAssignments());
				
				break;
				
			}
			
		}
		
		
		response.setContentType( "text/html" );
		request.getRequestDispatcher("/Hw2Assignments.jsp").forward(request, response);
	} 


	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String course = request.getParameter("course");
		String assignment = request.getParameter("assignment-name");
		
		LinkedList<Hw2Courses> courses = (LinkedList<Hw2Courses>) request.getServletContext().getAttribute("courses");
		
		
		for (int i = 0; i < courses.size(); i++) {
			
			if (courses.get(i).getName().equals(course)) {
				
				courses.get(i).getAssignments().add(new Hw2Assignment(assignment));
				
			}
			
		}
		

		response.sendRedirect("Hw2CourseAssignments?course=" + course + "");
		
	}

}
