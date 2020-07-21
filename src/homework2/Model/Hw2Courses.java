package homework2.Model;

import java.util.LinkedList;
import java.util.List;

public class Hw2Courses {
	
	private String name;
//	each course has a list of assignments
	private LinkedList<Hw2Assignment> assignments;
	
	
	
	
	
	public Hw2Courses(String name) {
		this.name = name;
		this.assignments = new LinkedList<Hw2Assignment>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Hw2Assignment> getAssignments() {
		return assignments;
	}

	
	
	
	
	
	

}
