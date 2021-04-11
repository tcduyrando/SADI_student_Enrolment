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
	public void add() {
		Scanner scan1 = new Scanner(System.in);
		System.out.print("Enter student ID: ");
		String sId = scan1.next();
		Student sItem = isStudentIncluded(sId);
		if (sItem == null) {
			System.out.println("Student with ID " + sId + " does not exist");
		} else {
			System.out.print("Enter semester: ");
			String sem = scan1.next();
			ArrayList<Course> cs = new ArrayList<Course>();
			int r2 = 0;
			while(r2 == 0) {
				System.out.print("Enter course ID: ");
				String cId = scan1.next();
				Course cItem = isCourseIncluded(cId);
				if (cItem == null) {
					System.out.println("Course with ID " + cId + " does not exist");
				} else {
					cs.add(cItem);
					char r;
					int r3 = 0;
					while (r3 == 0) {
						System.out.print("Do you want to add another course? (Y/N): ");
						r = scan1.next().charAt(0);
						
						if (r == 'n' || r == 'N') {
							StudentEnrolment se = new StudentEnrolment(sItem, cs, sem);
							enrolmentList.add(se);
							System.out.println("New enrolment added!");
							System.out.println(se);
							r2 = 1;
							break;
							
						} else if (r == 'y' || r == 'Y') {
							r3 = 1;
						} else {
							System.out.println("Invalid option");
						}
					}
				}
//				break;
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
	public StudentEnrolment getOneByStudentAndSemester(String sId, String semester) {
		for (StudentEnrolment se:enrolmentList) {
			if (se.getStudent().getId().equals(sId) && se.getSemester().equals(semester)) {
				return se;
			}
		}
		return null;
		
	}
	
	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		
	}
	
	public void displayAllEnrolments() {
		System.out.println("Displaying all enrolments...");
		for (StudentEnrolment se: enrolmentList) {
			System.out.println(se);	
		}
	}

}
