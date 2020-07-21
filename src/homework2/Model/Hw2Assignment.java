package homework2.Model;

import java.util.LinkedList;
import java.util.List;

public class Hw2Assignment {

	private String name;
	LinkedList<Hw2Submission> submissions;
	private String latestSubmissionDate;

	public Hw2Assignment(String name) {
		this.name = name;
		this.submissions = new LinkedList<Hw2Submission>();
		this.latestSubmissionDate = "No Submissions";
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<Hw2Submission> getSubmissions() {
		return submissions;
	}


	public String getLatestSubmissionDate() {
		return latestSubmissionDate;
	}


	public void setLatestSubmissionDate(String latestSubmissionDate) {
		this.latestSubmissionDate = latestSubmissionDate;
	}
	
	
	
	
	

}
