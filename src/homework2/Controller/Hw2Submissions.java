package homework2.Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework2.Model.Hw2Courses;
import homework2.Model.Hw2Submission;

@WebServlet("/Hw2Submissions")
public class Hw2Submissions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

	public Hw2Submissions() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String course = request.getParameter("course");
		String assignment = request.getParameter("assignment");

		List<Hw2Submission> subs = findAssignment(course, assignment);
		request.setAttribute("submission", subs);

		response.setContentType("text/html");
		request.getRequestDispatcher("/Hw2Submissions.jsp").forward(request, response);
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
		LinkedList<Hw2Courses> courses = (LinkedList<Hw2Courses>) request.getServletContext().getAttribute("courses");
		String course = request.getParameter("course");
		String assignment = request.getParameter("assignment");
		String student = request.getParameter("student-name");
		String answer = request.getParameter("answer");

		for (int i = 0; i < courses.size(); i++) {

			if (courses.get(i).getName().equals(course)) {

				for (int j = 0; j < courses.get(i).getAssignments().size(); j++) {

					if (courses.get(i).getAssignments().get(j).getName().equals(assignment)) {

						courses.get(i).getAssignments().get(j).getSubmissions()
								.add(new Hw2Submission(student, answer, dtf.format(now)));
						courses.get(i).getAssignments().get(j).setLatestSubmissionDate(dtf.format(now));

						break;
					}

				}

			}

		}

		doGet(request, response);
	}

	@SuppressWarnings("unchecked")
	private List<Hw2Submission> findAssignment(String course, String assignment) {

		LinkedList<Hw2Courses> courses = (LinkedList<Hw2Courses>) getServletContext().getAttribute("courses");

		List<Hw2Submission> subs = null;

		for (int i = 0; i < courses.size(); i++) {

			if (courses.get(i).getName().equals(course)) {

				for (int j = 0; j < courses.get(i).getAssignments().size(); j++) {

					if (courses.get(i).getAssignments().get(j).getName().equals(assignment)) {

						subs = courses.get(i).getAssignments().get(j).getSubmissions();

						break;
					}

				}

			}

		}

		return subs;

	}

}
