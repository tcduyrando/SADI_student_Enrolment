package enrolmentSystem;

import java.util.*;

public class StudentEnrolment {
	
	private Student student;
	private Course course;
	private String semester;
	
	/*
	 * This constructs the StudentEnrolment object
	 */
	public StudentEnrolment(Student student, Course course, String semester) {
		super();
		this.student = student;
		this.course = course;
		this.semester = semester;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course courses) {
		this.course = course;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	/*
	 * Returns a StudentEnrolment in the form of a string 
	 */
	@Override
	public String toString() {
		String str = "Enrolment {Student [id=" + student.getId() + ", name=" + student.getName() + ", birthdate=" + student.getBirthdate() + "], "
				+ "semester=" + semester + ", "
				+ "Course [id=" + course.getId() + ", name=" + course.getName() + ", credits=" + course.getNumOfCredits() + "]}";
		return str;
	}
	
	

}
