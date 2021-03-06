package enrolmentSystem;

import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentEnrolmentSystem implements StudentEnrolmentManager {
	
	private ArrayList<Student> studentList;
	private ArrayList<Course> courseList;
	private ArrayList<StudentEnrolment> enrolmentList;
	
	/*
	 * This constructs the StudentEnrolment
	 */
	public StudentEnrolmentSystem() {
		studentList = new ArrayList<Student>();
		courseList = new ArrayList<Course>();
		enrolmentList = new ArrayList<StudentEnrolment>();
	}
	
	/*
	 * This displays all students
	 */
	public void displayAllStuents() {
		System.out.println("Displaying all " + studentList.size() + " students...");
		for (Student s: studentList) {
			System.out.println(" - " + s);	
		}
	}
	
	/*
	 * This displays all courses
	 */
	public void displayAllCourses() {
		System.out.println("Displaying all " + courseList.size() + " courses...");
		for (Course c: courseList) {
			System.out.println(" - " + c);	
		}
	}
	
	/*
	 * This displays all enrolments
	 */
	public void displayAllEnrolments() {
		System.out.println("Displaying all " + enrolmentList.size() + " enrolments...");
		for (StudentEnrolment se: enrolmentList) {
			System.out.println(" - " + se);	
		}
	}
	
	/*
	 * Check if student with this ID is included
	 * If yes, return that Student
	 */
	private Student isStudentIncluded(String id) {
		for (Student s:studentList) {
			if (s.getId().equals(id)) {
				return s;
			}
		}
		return null;
	}
	
	/*
	 * Check if course with this ID is included
	 * If yes, return that Course
	 */
	private Course isCourseIncluded(String id) {
		for (Course c:courseList) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}
	
	/*
	 * This will read the CSV file and add students to the studentList
	 */
	public void readStudentsFromCSV(String fileName) {
		Path pathToFile = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			System.out.println("Importing Students from CSV...");
			// Read the 1st line from csv file
			String line = br.readLine();
			
			// Loop until all lines are read
			while (line != null) {
				// split the array of strings to get the values
				String[] attributes = line.split(",");
				
				// Declare format of birthdate in csv file 
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
				
				String sId = attributes[0];
				String sName = attributes[1];
				LocalDate sBirthDate = LocalDate.parse(attributes[2], formatter);
				// Check if student is already in the studentList
				Student sItem = isStudentIncluded(sId);
				if (sItem == null) {
					Student s = new Student(sId, sName, sBirthDate);
					studentList.add(s);
				}
				// read next line before looping
				// if reached end of file, line would be null
				line = br.readLine();
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	/*
	 * This will read the CSV file and add course to the courseList
	 */
	public void readCoursesFromCSV(String fileName) {
		Path pathToFile = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			System.out.println("Importing Courses from CSV...");
			// Read the 1st line from csv file
			String line = br.readLine();
			
			// Loop until all lines are read
			while (line != null) {
				// split the array of strings to get the values
				String[] attributes = line.split(",");
								
				String cId = attributes[3];
				String cName = attributes[4];
				int cNumOfCredits = Integer.parseInt(attributes[5]);
				
				// Check if course is already in the courseList
				Course cItem = isCourseIncluded(cId);
				if (cItem == null) {
					Course c = new Course(cId, cName, cNumOfCredits);
					courseList.add(c);
				}
				// read next line before looping
				// if reached end of file, line would be null
				line = br.readLine();
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	/*
	 * This will read the CSV file and add enrollments to the enrolmentList
	 */
	public void readEnrolmentsFromCSV(String fileName) {
		Path pathToFile = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			System.out.println("Importing Courses from CSV...");
			// Read the 1st line from csv file
			String line = br.readLine();
			
			// Loop until all lines are read
			while (line != null) {
				// split the array of strings to get the values
				String[] attributes = line.split(",");
				
				// Declare format of birthdate in csv file 
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
				
				String sId = attributes[0];
				String sName = attributes[1];
				LocalDate sBirthDate = LocalDate.parse(attributes[2], formatter);
				String cId = attributes[3];
				String cName = attributes[4];
				int cNumOfCredits = Integer.parseInt(attributes[5]);
				String sem = attributes[6];
				
				// Check if student is included in the studentList
				Student sItem = isStudentIncluded(sId);
				if (sItem != null) {
					// Check if course is included in the courseList
					Course cItem = isCourseIncluded(cId);
					if (cItem != null) {
						StudentEnrolment se = new StudentEnrolment(sItem, cItem, sem);
						enrolmentList.add(se);
					}
					// read next line before looping
					// if reached end of file, line would be null
					line = br.readLine();
				}
				
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	/*
	 * This will ask the user to enter student ID and semester,
	 * then allows the user to enroll that student in a course in that semester.
	 * If the student is already enrolled in that semester, it will display error message
	 * and suggest the user choose Option 2 (Update), 
	 * which can allow them to add more courses to an existing enrollment with the same student ID and semester
	 */
	@Override
	public void add() {
		int k1 = 0;
		while(k1 == 0) {
			Scanner scanner1 = new Scanner(System.in);
			System.out.print("(Q to cancel) Enter student ID: ");
			String sId = scanner1.next();
			if (sId.equals("q") || sId.equals("Q")) {
				System.out.println("Enrolment cancelled");
				break;
			} else {
				Student sItem = isStudentIncluded(sId);
				if (sItem == null) {
					System.out.println("ERROR: Student with ID " + sId + " does not exist");
				} else {
					System.out.print("(Q to cancel) Enter semester: ");
					String sem = scanner1.next();
					if (sem.equals("q") || sem.equals("Q")) {
						System.out.println("Enrolment cancelled");
						break;
					} else {
						// check if enrolment with sID and sem already exists
						ArrayList<StudentEnrolment> seListCheck = getAllByStudentAndSemester(sItem, sem);
						if (seListCheck != null) {
							System.out.println("ERROR: Student " + sId + " is already enrolled in semester " + sem);
							System.out.println("If you wish to add another course into this enrolment, please choose Option 2 (Update)");
						} else {
							System.out.print("(Q to cancel) Enter course ID: ");
							String cId = scanner1.next();
							if (cId.equals("q") || cId.equals("Q")) {
								System.out.println("Enrolment cancelled");
								break;
							} else {
								Course cItem = isCourseIncluded(cId);
								if (cItem == null) {
									System.out.println("ERROR: Course with ID " + cId + " does not exist");
								} else {
									StudentEnrolment se = new StudentEnrolment(sItem, cItem, sem);
									enrolmentList.add(se);
									System.out.println("SUCCESS: New enrolment added!");
									System.out.println(se);
									char u;
									int k2 = 0;
									while (k2 == 0) {
										System.out.print("Do you want to add another enrolment? (Y/N): ");
										u = scanner1.next().charAt(0);
										if (u == 'n' || u == 'N') {
											k1 = 1;
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
					}
				}
			}
		}
	}
	
	/*
	 * This will ask the user to enter student ID and semester,
	 * then find enrolments with those parameters,
	 * then allow the user to choose between 2 options: 
	 * 1. Delete the enrolment with the course they want to delete
	 * 2. Add another course for that student in that semester 
	 */
	@Override
	public void update() {
		int k4 = 0;
		while (k4 == 0) {
			Scanner scanner1 = new Scanner(System.in);
			System.out.print("(Q to cancel) Enter student ID: ");
			String sId = scanner1.next();
			if (sId.equals("q") || sId.equals("Q")) {
				System.out.println("Update cancelled");
				break;
			} else {
				Student sItem = isStudentIncluded(sId);
				if (sItem == null) {
					System.out.println("ERROR: Student with ID " + sId + " does not exist");
				} else {
					System.out.print("(Q to cancel) Enter semester: ");
					String sem = scanner1.next();
					if (sem.equals("q") || sem.equals("Q")) {
						System.out.println("Update cancelled");
						break;
					} else {
						ArrayList<StudentEnrolment> seList = getAllByStudentAndSemester(sItem, sem);
						if (seList == null) {
							System.out.println("ERROR: Enrolment with student ID " + sId + " and semester " + sem + " does not exist");
						} else {
							System.out.println("Enrolments with student ID " + sId + " and semester " + sem + " found: ");
							for (StudentEnrolment se:seList) {
								System.out.println(" - " + se);
							}
							System.out.println("Press 1 to Delete a course");
							System.out.println("Press 2 to Add a course");
							System.out.print("Enter option: ");
							// try to catch exception if input is not an int
							try {
								int a = scanner1.nextInt();
								switch(a) {
									// Press 1 to Delete a course
									case 1:
										int i = 0;
										for (StudentEnrolment c:seList) {
											i = i + 1;
											System.out.println(" " + i + ". " + c.getCourse());
										}
										int u1 = 0;
										while (u1 == 0) {
											// try to catch exception if input is not an int
											try {
												System.out.print("Enter the index number of the course you wish to delete \n"
														+ "(Example: Press 1 to delete the first course): ");
												int seIndex = scanner1.nextInt() - 1;
												if (seIndex < 0 || seIndex > i - 1) {
													System.out.println("ERROR: Invalid index number");
												} else {
													char u2;
													int k3 = 0;
													while (k3 == 0) {
														String cName = seList.get(seIndex).getCourse().getName();
														System.out.print("Please confirm you want to delete course " + cName + " (Y/N): ");
														u2 = scanner1.next().charAt(0);
														if (u2 == 'n' || u2 == 'N') {
															System.out.println("FAILED: Deletion is not confirmed");
															u1 = 1;
															k4 = 1;
															break;
														} else if (u2 == 'y' || u2 == 'Y') {
															for (int j = 0; j < enrolmentList.size(); j++) {
																if (seList.get(seIndex).getCourse() == enrolmentList.get(j).getCourse()
																		&& seList.get(seIndex).getStudent() == enrolmentList.get(j).getStudent()
																		&& seList.get(seIndex).getSemester() == enrolmentList.get(j).getSemester()) {
																	enrolmentList.remove(j);
																	System.out.println("SUCCESS: Course " + cName + " is removed from this enrolment");
																	k4 = 1;
																}
															}
															
															u1 = 1;
															break;
														} else {
															System.out.println("ERROR: Invalid option");
														}
													}
												}
											} catch (InputMismatchException e) {
												System.out.println("Invlaid input type");
												break;
											}
										}
										break;
									// Press 2 to Add a course
									case 2:
										int k1 = 0;
										while(k1 == 0) {
											System.out.print("(Q to cancel) Enter course ID to add: ");
											String cId = scanner1.next();
											if (cId.equals("q") || cId.equals("Q")) {
												System.out.println("Cancelling...");
												k1 = 1;
												k4 = 1;
												break;
											} else {
												Course cItem = isCourseIncluded(cId);
												if (cItem == null) {
													System.out.println("ERROR: Course with ID " + cId + " does not exist");
												} else {
													boolean cExist = false;
													for (StudentEnrolment se:seList) {
														if (cItem == se.getCourse()) {
															System.out.println("ERROR: Course " + cItem.getName() + " is already enrolled for this semester");
															cExist = true;
															break;
														}
													}
													if (!cExist) {
														StudentEnrolment seItem = new StudentEnrolment(sItem, cItem, sem);
														enrolmentList.add(seItem);
														System.out.println("SUCCESS: Course " + cItem.getName() + " is added to this enrolment");
														char u;
														int k2 = 0;
														while (k2 == 0) {
															System.out.print("Do you want to add another course? (Y/N): ");
															u = scanner1.next().charAt(0);
															if (u == 'n' || u == 'N') {
																k1 = 1;
																k4 = 1;
//																scanner1.close();
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
										}
										break;
									default:
										System.out.println("Invalid option");
										k4 = 1;
								}
							} catch (InputMismatchException e) {
								System.out.println("Invlaid input type");
							}
						}
					}
				}
			}
			
		}
		
	}
	
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * This will get all enrollments by student ID and semester
	 */
	@Override
	public ArrayList<StudentEnrolment> getAllByStudentAndSemester(Student student, String semester) {
		ArrayList<StudentEnrolment> seList = new ArrayList<StudentEnrolment>();
		for (StudentEnrolment se:enrolmentList) {
			if (se.getStudent().equals(student) && se.getSemester().equals(semester)) {
				seList.add(se);
			}
		}
		if (!seList.isEmpty()) {
			return seList;
		} else {
			return null;
		}
	}
	
	/*
	 * This will get all enrollments by course ID and semester
	 */
	@Override
	public ArrayList<StudentEnrolment> getAllByCourseAndSemester(Course course, String semester) {
		ArrayList<StudentEnrolment> seList = new ArrayList<StudentEnrolment>();
		for (StudentEnrolment se:enrolmentList) {
			if (se.getCourse().equals(course) && se.getSemester().equals(semester)) {
				seList.add(se);
			}
		}
		if (!seList.isEmpty()) {
			return seList;
		} else {
			return null;
		}
	}
	
	/*
	 * This will get all enrollments by semester
	 */
	@Override
	public ArrayList<StudentEnrolment> getAllBySemester(String semester) {
		ArrayList<StudentEnrolment> seList = new ArrayList<StudentEnrolment>();
		for (StudentEnrolment se:enrolmentList) {
			if (se.getSemester().equals(semester)) {
				seList.add(se);
			}
		}
		if (!seList.isEmpty()) {
			return seList;
		} else {
			return null;
		}
	}
	
	/*
	 * This will get all enrollments
	 * (Never used)
	 */
	@Override
	public ArrayList<StudentEnrolment> getAll() {
		return enrolmentList;
		
	}
	
	/*
	 * This will print all courses enrolled by student ID and semester
	 */	
	public void printAllCoursesInOneStudentOneSem () throws IOException {
		int k1 = 0;
		while (k1 == 0) {
			Scanner scanner1 = new Scanner(System.in);
			System.out.print("(Q to cancel) Enter student ID: ");
			String sId = scanner1.next();
			if (sId.equals("q") || sId.equals("Q")) {
				System.out.println("Printing cancelled");
				break;
			} else {
				Student sItem = isStudentIncluded(sId);
				if (sItem == null) {
					System.out.println("ERROR: Student with ID " + sId + " does not exist");
				} else {
					System.out.print("(Q to cancel) Enter semester: ");
					String sem = scanner1.next();
					if (sem.equals("q") || sem.equals("Q")) {
						System.out.println("Printing cancelled");
						break;
					} else {
						ArrayList<StudentEnrolment> seList = getAllByStudentAndSemester(sItem, sem);
						if (seList == null) {
							System.out.println("ERROR: Enrolment with student ID " + sId + " and semester " + sem + " does not exist");
						} else {
							System.out.println("Enrolments with student ID " + sId + " and semester " + sem + " found: ");
							for (StudentEnrolment se:seList) {
								System.out.println(" - " + se);
							}
							File file = new File("courses_" + sItem.getId() + "_" + sem + ".csv");
							FileWriter fw = new FileWriter(file);
							PrintWriter pw = new PrintWriter(fw);
							
							System.out.println("Printing to CSV file...");
							for (StudentEnrolment se:seList) {
								pw.println(se.getStudent().getId() + "," + se.getStudent().getName() + "," + se.getStudent().getBirthdate() + ","
										+ se.getCourse().getId() + "," + se.getCourse().getName() + "," + se.getCourse().getNumOfCredits() +","
										+ se.getSemester());
							}
							pw.close();
							System.out.println("SUCCESS: Courses for Student " + sId + " in Semester " + sem + " are printed.");
							break;
						}
					}
				}
			}
		}
	}
	
	/*
	 * This will print all students by course ID and semester
	 */	
	public void printAllStudentsInOneCourseOneSem () throws IOException {
		int k1 = 0;
		while (k1 == 0) {
			Scanner scanner1 = new Scanner(System.in);
			System.out.print("(Q to cancel) Enter course ID: ");
			String cId = scanner1.next();
			if (cId.equals("q") || cId.equals("Q")) {
				System.out.println("Printing cancelled");
				break;
			} else {
				Course cItem = isCourseIncluded(cId);
				if (cItem == null) {
					System.out.println("ERROR: Course with ID " + cId + " does not exist");
				} else {
					System.out.print("(Q to cancel) Enter semester: ");
					String sem = scanner1.next();
					if (sem.equals("q") || sem.equals("Q")) {
						System.out.println("Printing cancelled");
						break;
					} else {
						ArrayList<StudentEnrolment> seList = getAllByCourseAndSemester(cItem, sem);
						if (seList == null) {
							System.out.println("ERROR: Enrolment with course ID " + cId + " and semester " + sem + " does not exist");
						} else {
							System.out.println("Enrolments with course ID " + cId + " and semester " + sem + " found: ");
							for (StudentEnrolment se:seList) {
								System.out.println(" - " + se);
							}
							File file = new File("students_" + cItem.getId() + "_" + sem + ".csv");
							FileWriter fw = new FileWriter(file);
							PrintWriter pw = new PrintWriter(fw);
							
							System.out.println("Printing to CSV file...");
							for (StudentEnrolment se:seList) {
								pw.println(se.getStudent().getId() + "," + se.getStudent().getName() + "," + se.getStudent().getBirthdate() + ","
										+ se.getCourse().getId() + "," + se.getCourse().getName() + "," + se.getCourse().getNumOfCredits() +","
										+ se.getSemester());
							}
							pw.close();
							System.out.println("SUCCESS: Students in Course " + cId + " in Semester " + sem + " are printed.");
							break;
						}
					}
				}
			}
		}
	}
	
	/*
	 * This will print all courses offered in 1 semester
	 */	
	public void printAllCoursesInOneSem () throws IOException {
		int k1 = 0;
		while (k1 == 0) {
			Scanner scanner1 = new Scanner(System.in);
			System.out.print("(Q to cancel) Enter semester: ");
			String sem = scanner1.next();
			if (sem.equals("q") || sem.equals("Q")) {
				System.out.println("Printing cancelled");
				break;
			} else {
				ArrayList<StudentEnrolment> seList = getAllBySemester(sem);
				if (seList == null) {
					System.out.println("ERROR: Enrolment with semester " + sem + " does not exist");
				} else {
					System.out.println("Enrolments with semester " + sem + " found: ");
					for (StudentEnrolment sec:seList) {
						System.out.println(" - " + sec);
					}
					File file = new File("courses_" + sem + ".csv");
					FileWriter fw = new FileWriter(file);
					PrintWriter pw = new PrintWriter(fw);
					
					System.out.println("Printing to CSV file...");
					for (StudentEnrolment sec:seList) {
						pw.println(sec.getCourse().getId() + "," + sec.getCourse().getName() + "," + sec.getCourse().getNumOfCredits() +","
								+ sec.getSemester());
					}
					pw.close();
					System.out.println("SUCCESS: Courses in Semester " + sem + " are printed.");
					break;
				}
			}
		}
	}
	
}
