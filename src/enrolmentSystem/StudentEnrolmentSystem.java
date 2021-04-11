package enrolmentSystem;

import java.util.*;

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
	
	public void addEnrolment(StudentEnrolment se) {
		enrolmentList.add(se);
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
		Scanner scanner1 = new Scanner(System.in);
		System.out.print("Enter student ID: ");
		String sId = scanner1.next();
		Student sItem = isStudentIncluded(sId);
		if (sItem == null) {
			System.out.println("ERROR: Student with ID " + sId + " does not exist");
		} else {
			System.out.print("Enter semester: ");
			String sem = scanner1.next();
			ArrayList<Course> cs = new ArrayList<Course>();
			int u2 = 0;
			while(u2 == 0) {
				System.out.print("Enter course ID: ");
				String cId = scanner1.next();
				Course cItem = isCourseIncluded(cId);
				if (cItem == null) {
					System.out.println("ERROR: Course with ID " + cId + " does not exist");
				} else {
					cs.add(cItem);
					char u;
					int u3 = 0;
					while (u3 == 0) {
						System.out.print("Do you want to add another course? (Y/N): ");
						u = scanner1.next().charAt(0);
						
						if (u == 'n' || u == 'N') {
							StudentEnrolment se = new StudentEnrolment(sItem, cs, sem);
							enrolmentList.add(se);
							System.out.println("New enrolment added!");
							System.out.println(se);
							u2 = 1;
							scanner1.close();
							break;
							
						} else if (u == 'y' || u == 'Y') {
							u3 = 1;
						} else {
							System.out.println("ERROR: Invalid option");
						}
					}
				}
//				break;
			}
		}
	}
	
	@Override
	public void update() {
		Scanner scanner1 = new Scanner(System.in);
		System.out.print("Enter student ID: ");
		String sId = scanner1.next();
		Student sItem = isStudentIncluded(sId);
		if (sItem == null) {
			System.out.println("ERROR: Student with ID " + sId + " does not exist");
		} else {
			System.out.print("Enter semester: ");
			String sem = scanner1.next();
			StudentEnrolment se = getOneByStudentAndSemester(sItem, sem);
			if (se == null) {
				System.out.println("ERROR: Enrolment with student ID " + sId + " and semester " + sem + " does not exist");
			} else {
				System.out.println("Enrolment found: ");
//				System.out.println(se.getStudent() + ", Semester=" + se.getSemester());
//				for (Course c:se.getCourses()) {
//					System.out.println(c);
//				}
				System.out.println(" - " + se);
				System.out.println("Press 1 to Delete a course");
				System.out.println("Press 2 to Add a course");
				System.out.print("Enter option: ");
				int a = scanner1.nextInt();
				switch(a) {
					// Press 1 to Delete a course
					case 1:
						int i = 0;
						for (Course c:se.getCourses()) {
							i = i + 1;
							System.out.println(" " + i + ". " + c);
						}
						int u1 = 0;
						while (u1 == 0) {
							System.out.print("Enter the index number of the course you wish to delete \n"
									+ "(Example: Press 1 to delete the first course) : ");
							int cIndex = scanner1.nextInt() - 1;
							if (cIndex < 0 || cIndex > i - 1) {
								System.out.println("ERROR: Invalid index number");
							} else {
								System.out.println("Course " + se.getCourses().get(cIndex).getName() + " is removed from this enrolment");
								se.getCourses().remove(cIndex);
								break;
							}
						}
						break;
					// Press 2 to Add a course
					case 2:
						int u2 = 0;
						while(u2 == 0) {
							System.out.print("Enter course ID to add: ");
							String cId = scanner1.next();
							Course cItem = isCourseIncluded(cId);
							if (cItem == null) {
								System.out.println("ERROR: Course with ID " + cId + " does not exist");
							} else {
								boolean cExist = false;
								for (Course c:se.getCourses()) {
									if (cItem == c) {
										System.out.println("ERROR: Course " + cItem.getName() + " is already enrolled for this semester");
										cExist = true;
										break;
									}
								}
								if (!cExist) {
									se.getCourses().add(cItem);
									System.out.println("Course " + cItem.getName() + " is added to this enrolment");
									char u;
									int u3 = 0;
									while (u3 == 0) {
										System.out.print("Do you want to add another course? (Y/N): ");
										u = scanner1.next().charAt(0);
										if (u == 'n' || u == 'N') {
											u2 = 1;
//											scanner1.close();
											break;
										} else if (u == 'y' || u == 'Y') {
											break;
										} else {
											System.out.println("ERROR: Invalid option");
										}
									}
								}
							}
						}
						break;
				}
			}
		}
	}
	
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public StudentEnrolment getOneByStudentAndSemester(Student student, String semester) {
		for (StudentEnrolment se:enrolmentList) {
			if (se.getStudent().equals(student) && se.getSemester().equals(semester)) {
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
