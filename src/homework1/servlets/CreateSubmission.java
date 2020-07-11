package homework1.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateSubmission
 */
@WebServlet("/CreateSubmission")
public class CreateSubmission extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSubmission() {
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
				"    <form action=\"http://localhost:8080/homework1/Submissions?course=" + request.getParameter("course") + "&assignment=" + request.getParameter("assignment") + "\" method=\"post\">\n" + 
				"        <label for=\"student-name\">Student Name</label>\n" + 
				"        <input id=\"student-name\" type=\"text\" name=\"student-name\">\n" + 
				"        <br>\n" + 
				"        <br>\n" + 
				"        <label for=\"answer\">Answer</label>\n" + 
				"        <textarea id=\"student-name\" name=\"answer\"></textarea>\n" + 
				"        <br>\n" + 
				"        <br>\n" + 
				"        <input type=\"submit\" value=\"Create\">\n" + 
				"    </form>\n" + 
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
