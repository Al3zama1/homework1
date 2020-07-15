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

@WebServlet("/Hw2CoursesServlet")
public class Hw2CoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	LinkedList<Hw2Courses> courses = new LinkedList<Hw2Courses>();
	HashMap<String, LinkedList<Hw2Submission>> assignmentsSubmissions = new HashMap<String, LinkedList<Hw2Submission>>(); 	
	HashMap<String, LinkedList<Hw2Assignment>> courseAssignments = new HashMap<String, LinkedList<Hw2Assignment>>();

	
	

       
    public Hw2CoursesServlet() {
    	
    }
    
    

	@Override
	public void init() throws ServletException {
		
		Hw2Courses web = new Hw2Courses("CS3220 Web and Internet Programming");
		Hw2Courses paradigms = new Hw2Courses("CS3035 Programming Paradigms");
		
		

		web.setAssignmentsCount(0);
		paradigms.setAssignmentsCount(0);
		
		courses.add(web);
    	courses.add(paradigms);
	}
 


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getServletContext().setAttribute("coursesList", courses);
		request.getServletContext().setAttribute("allSubmissions", assignmentsSubmissions);
		request.getServletContext().setAttribute("courseAssignments", courseAssignments);
		
		
		
		response.setContentType( "text/html" );
		request.getRequestDispatcher("/Hw2Courses.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
