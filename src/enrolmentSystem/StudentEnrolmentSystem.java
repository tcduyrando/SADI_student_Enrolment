package enrolmentSystem;

import java.util.*;
import java.util.List;

public class StudentEnrolmentSystem implements StudentEnrolmentManager {
	
	private ArrayList<Student> studentList;
	private ArrayList<Course> courseList;
	private ArrayList<StudentEnrolment> enrolmentList;
	
	public StudentEnrolmentSystem() {
		studentList = new ArrayList<Student>();
		courseList = new ArrayList<Course>();
		enrolmentList = new ArrayList<StudentEnrolment>();
	}
	
	public void addStudent(Student s) {
		studentList.add(s);
	}
	
	public void addCourse(Course s) {
		courseList.add(s);
	}
	
//	Check if student with this ID is included
	private Student isStudentIncluded(String id) {
		for (Student s:studentList) {
			if (s.getId().equals(id)) {
				return s;
			}
		}
		return null;
	}
	
//	Check if course with this ID is included
	private Course isCourseIncluded(String id) {
		for (Course c:courseList) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}
	
	@Override
	public void addEnrolment() {
		Scanner scan1 = new Scanner(System.in);
		System.out.print("Enter student ID: ");
		String sId = scan1.next();
		Student s = isStudentIncluded(sId);
		if (s == null) {
			System.out.println("Student with ID " + sId + " does not exist");
		} else {
			System.out.print("Enter course ID: ");
			String cId = scan1.next();
			Course c = isCourseIncluded(cId);
			if (c == null) {
				System.out.println("Course with ID " + cId + " does not exist");
			} else {
				System.out.print("Enter semester: ");
				String sem = scan1.next();
				StudentEnrolment se = new StudentEnrolment(s, c, sem);
				enrolmentList.add(se);
				System.out.println("Enrolment added: \n"
						+ "[Student= {id=" + se.getStudent().getId() + ", name=" + se.getStudent().getName() + ", birthdate=" + se.getStudent().getBirthdate() + "}, "
						+ "Course= {id=" + se.getCourse().getId() + ", name=" + se.getCourse().getName() + ", number of credits=" + se.getCourse().getNumOfCredits() + "}, "
						+ "semester=" + se.getSemester() + "]");
			}
		}
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void getOne() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		
	}
	
	public void displayAllEnrolments() {
		for (StudentEnrolment se: enrolmentList) {
			System.out.println("[Student ID: " + se.getStudent().getId());
			System.out.println("Student name: " + se.getStudent().getName());
			System.out.println("Student birthdate: " + se.getStudent().getBirthdate());
			System.out.println("Course ID: " + se.getCourse().getId());
			System.out.println("Course name: " + se.getCourse().getName());
			System.out.println("Course credits: " + se.getCourse().getNumOfCredits());
			System.out.println("Semester: " + se.getSemester() + "]");
			
		}
	}

}
