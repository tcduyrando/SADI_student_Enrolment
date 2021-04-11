package enrolmentSystem;

public interface StudentEnrolmentManager {
	
	public void add();
	
	public void update();
	
	public void delete();
	
	public StudentEnrolment getOneByStudentAndSemester(String sId, String semester);
	
	public void getAll();
	
	
}