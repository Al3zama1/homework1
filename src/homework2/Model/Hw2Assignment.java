package homework2.Model;

public class Hw2Assignment {

	private String name;
	private String latestSubmission;
	private String totalSubmissions;

	public Hw2Assignment(String name, String date) {
		this.name = name;
		this.latestSubmission = date;
		this.totalSubmissions = "0";
	}

	public String getLatestSubmission() {
		return latestSubmission;
	}

	public void setLatestSubmission(String latestSubmission) {
		this.latestSubmission = latestSubmission;
	}

	public String getTotalSubmissions() {
		return totalSubmissions;
	}

	public void setTotalSubmissions(String totalSubmissions) {
		this.totalSubmissions = totalSubmissions;
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
