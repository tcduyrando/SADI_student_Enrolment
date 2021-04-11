package enrolmentSystem;

import java.util.ArrayList;

public interface StudentEnrolmentManager {
	
	public void add();
	
	public void update();
	
	public void delete();
	
	public StudentEnrolment getOneByStudentAndSemester(Student student, String semester);
	
	public ArrayList<StudentEnrolment> getAll();
	
	
}