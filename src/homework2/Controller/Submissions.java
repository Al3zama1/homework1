package homework2.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework2.Model.Assignment;
import homework2.Model.Submission;

/**
 * Servlet implementation class Submissions
 */
@WebServlet("/Submissions")
public class Submissions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");  
  	 
  	 
       
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
		
//		request.getServletContext().getAttribute("allSubmissions");
		
		@SuppressWarnings("unchecked")
		HashMap<String, LinkedList<Submission>> submitions = (HashMap<String, LinkedList<Submission>>) request.getServletContext().getAttribute("allSubmissions");
		
		LinkedList<Submission> submission = submitions.get(request.getParameter("assignment"));
		
		request.setAttribute("submission", submission);
		
		
		
		response.setContentType( "text/html" );
		request.getRequestDispatcher("/Submissions.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		@SuppressWarnings("unchecked")
		LinkedList<Assignment> web =  (LinkedList<Assignment>) request.getServletContext().getAttribute("web");
		
		@SuppressWarnings("unchecked")
		LinkedList<Assignment> paradigms = (LinkedList<Assignment>) request.getServletContext().getAttribute("paradigms");
		
		
		Submission newSubmition = new Submission(request.getParameter("student-name"), request.getParameter("answer"), dtf.format(LocalDateTime.now()));
		
		@SuppressWarnings("unchecked")
		HashMap<String, LinkedList<Submission>> submitions = (HashMap<String, LinkedList<Submission>>) request.getServletContext().getAttribute("allSubmissions");
		
		LinkedList<Submission> submition = submitions.get(request.getParameter("assignment"));
		
		submition.add(newSubmition);
		
		
		if (request.getParameter("course").equals("CS3220 Web and Internet Programming")) {
			
			for (int i = 0; i < web.size(); i++) {

				if (web.get(i).getName().equals(request.getParameter("assignment"))) {
					web.get(i).setTotalSubmissions(String.valueOf(submition.size()));
					web.get(i).setLatestSubmission(dtf.format(LocalDateTime.now()));
				}
			}

		} else if (request.getParameter("course").equals("CS3035 Programming Paradigms")) {
			
			for (int i = 0; i < paradigms.size(); i++) {
				
				if (paradigms.get(i).getName().equals(request.getParameter("assignment"))) {
					paradigms.get(i).setTotalSubmissions(String.valueOf(submition.size()));
					paradigms.get(i).setLatestSubmission(dtf.format(LocalDateTime.now()));
				}
			}
		}
		
		
		
		
		
		
		
		
		doGet(request, response);
	}

}
