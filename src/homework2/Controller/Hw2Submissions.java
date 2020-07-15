package homework2.Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework2.Model.Hw2Assignment;
import homework2.Model.Hw2Submission;


@WebServlet("/Hw2Submissions")
public class Hw2Submissions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");  
  	 
  	 
       

    public Hw2Submissions() {
        super();
        // TODO Auto-generated constructor stub
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		@SuppressWarnings("unchecked")
		HashMap<String, LinkedList<Hw2Submission>> submitions = (HashMap<String, LinkedList<Hw2Submission>>) request.getServletContext().getAttribute("allSubmissions");
		
		LinkedList<Hw2Submission> submission = submitions.get(request.getParameter("assignment"));
		
		request.setAttribute("submission", submission);
		
		
		
		response.setContentType( "text/html" );
		request.getRequestDispatcher("/Hw2Submissions.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		@SuppressWarnings("unchecked")
		HashMap<String, LinkedList<Hw2Assignment>> allAssignments = (HashMap<String, LinkedList<Hw2Assignment>>) request.getServletContext().getAttribute("courseAssignments");
		
		LinkedList<Hw2Assignment> assignments = allAssignments.get(request.getParameter("course"));
		
		
		Hw2Submission newSubmition = new Hw2Submission(request.getParameter("student-name"), request.getParameter("answer"), dtf.format(LocalDateTime.now()));
		
		@SuppressWarnings("unchecked")
		HashMap<String, LinkedList<Hw2Submission>> submitions = (HashMap<String, LinkedList<Hw2Submission>>) request.getServletContext().getAttribute("allSubmissions");
		
		LinkedList<Hw2Submission> submition = submitions.get(request.getParameter("assignment"));
		
		submition.add(newSubmition);
		
		
		for (int i = 0; i < assignments.size(); i++) {
			if (assignments.get(i).getName().equals(request.getParameter("assignment"))) {
				assignments.get(i).setTotalSubmissions(String.valueOf(submition.size()));
				assignments.get(i).setLatestSubmission(dtf.format(LocalDateTime.now()));
			}
		}
			
		
		
		doGet(request, response);
	}

}
