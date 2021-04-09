package enrolmentSystem;

import java.util.ArrayList;
import java.util.List;

public class StudentEnrolmentSystem implements StudentEnrolmentManager {
	
	private ArrayList<StudentEnrolment> enrolmentList;
	
	public StudentEnrolmentSystem() {
		enrolmentList = new ArrayList<StudentEnrolment>();
	}
	
	@Override
	public void add(StudentEnrolment se) {
		enrolmentList.add(se);
		
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
			System.out.println("Student ID: " + se.getStudent().getId());
			System.out.println("Student name: " + se.getStudent().getName());
			System.out.println("Student birthdate: " + se.getStudent().getBirthdate());
			System.out.println("Course ID: " + se.getCourse().getId());
			System.out.println("Course name: " + se.getCourse().getName());
			System.out.println("Course credits: " + se.getCourse().getNumOfCredits());
			System.out.println("Semester: " + se.getSemester());
			
		}
	}

}
