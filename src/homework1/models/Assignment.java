package homework1.models;


public class Assignment {
	
	private String name;
	private String latestSubmission;
	
	

	public Assignment(String name, String date) {
		this.name = name;
		this.latestSubmission = date;
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
