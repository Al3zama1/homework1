package homework2.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework2.Model.Assignment;
import homework2.Model.Courses;
import homework2.Model.Submission;

/**
 * Servlet implementation class CoursesServlet
 */
@WebServlet("/CoursesServlet")
public class CoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	LinkedList<Courses> courses = new LinkedList<Courses>();
	HashMap<String, LinkedList<Submission>> assignmentsSubmissions = new HashMap<String, LinkedList<Submission>>(); 
	List<Assignment> web = new LinkedList<Assignment>();
	List<Assignment> paradigms = new LinkedList<Assignment>();

	
	

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoursesServlet() {
    	
    }
    
    

	@Override
	public void init() throws ServletException {
		
		Courses web = new Courses("CS3220 Web and Internet Programming");
		Courses paradigms = new Courses("CS3035 Programming Paradigms");
		
		

		web.setAssignmentsCount(0);
		paradigms.setAssignmentsCount(0);
		
		courses.add(web);
    	courses.add(paradigms);
	}
 


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getServletContext().setAttribute("coursesList", courses);
		request.getServletContext().setAttribute("allSubmissions", assignmentsSubmissions);
		request.getServletContext().setAttribute("web", web);
		request.getServletContext().setAttribute("paradigms", paradigms);
		
		
		
		response.setContentType( "text/html" );
		request.getRequestDispatcher("/Courses.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
