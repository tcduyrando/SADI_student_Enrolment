package enrolmentSystem;

import java.time.LocalDate;

public class Student {
	
	private String id;
	private String name;
	private LocalDate birthdate;
	
	/*
	 * This constructs the Student object
	 */
	public Student(String id, String name, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
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

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	/*
	 * Returns a Student in the form of a string 
	 */
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}
	
	
	

}
