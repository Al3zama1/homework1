package homework1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework1.models.Courses;

/**
 * Servlet implementation class CoursesServlet
 */
@WebServlet("/CoursesServlet")
public class CoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	LinkedList<Courses> courses = new LinkedList<Courses>();
//	CourseAssignments amnts = new CourseAssignments();
	
	
	Courses web = new Courses("CS3220 Web and Internet Programming");
	Courses paradigms = new Courses("CS3035 Programming Paradigms");
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoursesServlet() {
    	
    }
    
    

	@Override
	public void init() throws ServletException {

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
		
		
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>\n" + 
				"<html lang=\"en\">\n" + 
				"<head>\n" + 
				"    <meta charset=\"UTF-8\">\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" + 
				"    <title>Document</title>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"    <table border=\"1\">\n" + 
				"        <thead>\n" + 
				"            <th>Course</th>\n" + 
				"            <th>Assignments</th>\n" + 
				"        </thead>\n" + 
				"        <tbody>\n" + 
				"            <tr>");
		
		for(Courses course : courses) {
//			out.println("<td>" + course.getName() + "</td>");
			out.println("<td><a href=\"http://localhost:8080/homework1/CourseAssignments?course=" + course.getName() + "\">" + course.getName() + "</td>\n" + 
					"    <td>" + course.getAssignmentsCount() + "</td>");
			out.println("</tr>");
		}
		out.println(
				"        </tbody>\n" +  
				"\n" + 
				"    </table>\n" + 
				"</body>\n" + 
				"</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
