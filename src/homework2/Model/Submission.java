package homework2.Model;

public class Submission {
	
private String studentName;
private String answer;
private String submissionDate;


public Submission(String studentName, String answer, String submissionDate) {
	this.studentName = studentName;
	this.answer = answer;
	this.submissionDate = submissionDate;
}


public String getStudentName() {
	return studentName;
}


public void setStudentName(String studentName) {
	this.studentName = studentName;
}


public String getAnswer() {
	return answer;
}


public void setAnswer(String answer) {
	this.answer = answer;
}


public String getSubmissionDate() {
	return submissionDate;
}


public void setSubmissionDate(String submissionDate) {
	this.submissionDate = submissionDate;
}





	
	
	

}
