package enrolmentSystem;

public class Course {
	
	private String id;
	private String name;
	private int numOfCredits;
	
	public Course(String id, String name, int numOfCredits) {
		super();
		this.id = id;
		this.name = name;
		this.numOfCredits = numOfCredits;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumOfCredits() {
		return numOfCredits;
	}

	public void setNumOfCredits(int numOfCredits) {
		this.numOfCredits = numOfCredits;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Course ID: %s\nCourse name: %s\nCourse credits: %s\n",
				this.id, this.name, this.numOfCredits
		);
	}

}
