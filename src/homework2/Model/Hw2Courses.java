package homework2.Model;

import java.util.LinkedList;

public class Hw2Courses {
	
	private String name;
	private int AssignmentsCount;
	private LinkedList<Hw2Assignment> assignments;
	
	
	
	
	
	public Hw2Courses(String name) {
		this.name = name;
//		this.assignments = new LinkedList<Assignment>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAssignmentsCount() {
		return AssignmentsCount;
	}
	public void setAssignmentsCount(int assignmentsCount) {
		AssignmentsCount = assignmentsCount;
	}
//	public LinkedList<Assignment> getAssignments() {
//		return assignments;
//	}
//	public void setAssignments(LinkedList<Assignment> assignments) {
//		this.assignments = assignments;
//	}
	
	
	
	
	
	

}
