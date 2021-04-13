package enrolmentSystem;

public class Course {
	
	private String id;
	private String name;
	private int numOfCredits;
	
	/*
	 * This constructs the Course object
	 */
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
	
	/*
	 * Returns a Course in the form of a string 
	 */
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", numOfCredits=" + numOfCredits + "]";
	}

}
