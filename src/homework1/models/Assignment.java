package homework1.models;


public class Assignment {
	
	private String name;
	private String latestSubmission;
	private String submissionsCount;
	
	

	public Assignment(String name, String date) {
		this.name = name;
		this.latestSubmission = date;
	}
	
	
	
	
	

	public String getLatestSubmission() {
		return latestSubmission;
	}






	public void setLatestSubmission(String latestSubmission) {
		this.latestSubmission = latestSubmission;
	}






	public String getSubmissionsCount() {
		return submissionsCount;
	}






	public void setSubmissionsCount(String submissionsCount) {
		this.submissionsCount = submissionsCount;
	}






	public String getDate() {
		return latestSubmission;
	}




	public void setDate(String date) {
		this.latestSubmission = date;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
