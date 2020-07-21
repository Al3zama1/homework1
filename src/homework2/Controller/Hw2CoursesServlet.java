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

@WebServlet("/Hw2CoursesServlet")
public class Hw2CoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	

       
    public Hw2CoursesServlet() {
    	
    }
    
    

	@Override
	public void init() throws ServletException {
		
		LinkedList<Hw2Courses> courses = new LinkedList<Hw2Courses>();
		
		Hw2Courses web = new Hw2Courses("CS3220 Web and Internet Programming");
		Hw2Courses paradigms = new Hw2Courses("CS3035 Programming Paradigms");
		
		
		courses.add(web);
    	courses.add(paradigms);
    	
    	courses.get(0).getAssignments().add(new Hw2Assignment("lol"));
    
    	
    	getServletContext().setAttribute("courses", courses);
	}
 


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		response.setContentType( "text/html" );
		request.getRequestDispatcher("/Hw2Courses.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
