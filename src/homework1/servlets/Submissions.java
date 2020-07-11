package homework1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework1.models.Submission;

/**
 * Servlet implementation class Submissions
 */
@WebServlet("/Submissions")
public class Submissions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");  
 	 
  	 LocalDateTime now = LocalDateTime.now();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Submissions() {
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
				"            <th>Student Name</th>\n" + 
				"            <th>Answer</th>\n" + 
				"            <th>Submitted Date</th>\n" + 
				"        </thead>\n" + 
				"        <tbody>\n" + 
				"            <tr>");
		out.println("<td>this</td>\n" + 
				"                <td>this</td>\n" + 
				"            </tr>");
		out.println("</tbody>\n" + 
				"\n" + 
				"    </table>");
		out.println("<br>\n" + 
				"    <br>\n" + 
				"    <a href=\"http://localhost:8080/homework1/CreateSubmission?course=" + request.getParameter("course") + "&assignment=" + request.getParameter("assignment") + "\">Create Submission</a>\n" + 
				"</body>\n" + 
				"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Submission submission = new Submission(request.getParameter("student-name"), "answer", dtf.format(now));
		
		doGet(request, response);
	}

}
