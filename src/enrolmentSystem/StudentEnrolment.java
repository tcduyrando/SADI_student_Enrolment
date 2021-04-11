package enrolmentSystem;

import java.util.*;

public class StudentEnrolment {
	
	private Student student;
	private ArrayList<Course> courses;
	private String semester;
	
	public StudentEnrolment(Student student, ArrayList<Course> courses, String semester) {
		super();
		this.student = student;
		this.courses = courses;
		this.semester = semester;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		String str = "Enrolment {Student {id=" + student.getId() + ", name=" + student.getName() + ", birthdate=" + student.getBirthdate() + "}, "
				+ "Courses [";
		for (Course c:courses) {
			str = str + "{id=" + c.getId() + ", name=" + c.getName() + ", credits=" + c.getNumOfCredits() + "}";
		}
		str = str + "], semester=" + semester + "}";
		return str;
	}
	
	

}
