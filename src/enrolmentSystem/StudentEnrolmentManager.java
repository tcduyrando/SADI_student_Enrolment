package enrolmentSystem;

public interface StudentEnrolmentManager {
	
	public void add();
	
	public void update();
	
	public void delete();
	
	public StudentEnrolment getOneByStudentAndSemester(Student student, String semester);
	
	public void getAll();
	
	
}