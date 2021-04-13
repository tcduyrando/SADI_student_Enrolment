package enrolmentSystem;

import java.util.ArrayList;

public interface StudentEnrolmentManager {
	
	public void add();
	
	public void update();
	
	public void delete();
	
	public ArrayList<StudentEnrolment> getAllByStudentAndSemester(Student student, String semester);
	
	public ArrayList<StudentEnrolment> getAllByCourseAndSemester(Course course, String semester);
	
	public ArrayList<StudentEnrolment> getAllBySemester(String semester);
	
	public ArrayList<StudentEnrolment> getAll();
	
	
}