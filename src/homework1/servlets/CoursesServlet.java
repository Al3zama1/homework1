package homework1.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CoursesServlet
 */
@WebServlet("/CoursesServlet")
public class CoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoursesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
				"            <tr>\n" + 
				"                <td><a href=\"http://localhost:8080/homework1/CourseAssignments?course=paradims\">CS3035 Programming Paradigms</a></td>\n" + 
				"                <td>0</td>\n" + 
				"            </tr>\n" + 
				"            <tr>\n" + 
				"                <td><a href=\"http://localhost:8080/homework1/CourseAssignments?course=web\">CS3220 Web and Internet Programming</a></td>\n" + 
				"                <td>2</td>\n" + 
				"            </tr>\n" + 
				"        </tbody>\n" + 
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
