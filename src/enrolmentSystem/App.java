package enrolmentSystem;

import java.util.*;
import java.io.IOException;
import java.time.LocalDate;

public class App {
	
	final protected static StudentEnrolmentSystem ses = new StudentEnrolmentSystem();
	
	public static void main(String[] args) throws IOException {
		
		/*
		 * Data population for Student and Course and StudentEnrolment
		 */
		Student s1 = new Student("s001", "Gorgeous George", LocalDate.of(2000, 12, 24));
		Student s2 = new Student("s002", "Posh Pete", LocalDate.of(2000, 2, 9));
		Student s3 = new Student("s003", "Ronald McDonald", LocalDate.of(2001, 5, 13));
		Student s4 = new Student("s004", "Norm McDormand", LocalDate.of(2001, 11, 19));
		Course c1 = new Course("c001", "Software Architecture: Design & Implementation", 3);
		Course c2 = new Course("c002", "Software Engineering: Process & Tools", 4);
		Course c3 = new Course("c003", "Web Programming", 2);
		Course c4 = new Course("c004", "Maths n Stuff", 2);
		Course c5 = new Course("c005", "Programming 1", 3);
		
		StudentEnrolment se0101 = new StudentEnrolment(s1, c1, "2020C");
		StudentEnrolment se0102 = new StudentEnrolment(s1, c2, "2020C");
		StudentEnrolment se0103 = new StudentEnrolment(s1, c3, "2021A");
		StudentEnrolment se0201 = new StudentEnrolment(s2, c4, "2020B");
		StudentEnrolment se0202 = new StudentEnrolment(s2, c5, "2020B");
		StudentEnrolment se0203 = new StudentEnrolment(s2, c3, "2021A");
		StudentEnrolment se0301 = new StudentEnrolment(s3, c5, "2021A");
		StudentEnrolment se0302 = new StudentEnrolment(s3, c1, "2020B");
		StudentEnrolment se0303 = new StudentEnrolment(s3, c3, "2021A");
		
		/*
		 * Add Students to studentList and Courses to courseList
		 */
		ses.addStudent(s1);
		ses.addStudent(s2);
		ses.addStudent(s3);
		ses.addStudent(s4);
		ses.addCourse(c1);
		ses.addCourse(c2);
		ses.addCourse(c3);
		ses.addCourse(c4);
		ses.addCourse(c5);
		ses.addEnrolment(se0101);
		ses.addEnrolment(se0102);
		ses.addEnrolment(se0103);
		ses.addEnrolment(se0201);
		ses.addEnrolment(se0202);
		ses.addEnrolment(se0203);
		ses.addEnrolment(se0301);
		ses.addEnrolment(se0302);
		ses.addEnrolment(se0303);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);	
		System.out.println(c4);	
		System.out.println(c5);	
		System.out.println(se0101);
		System.out.println(se0102);
		System.out.println(se0103);
		System.out.println(se0201);
		System.out.println(se0202);
		System.out.println(se0203);
		
		/*
		 * This will show the main menu
		 * As long as r = 'y', the program will run and the menu will show.
		 * If r = 'n', the program will exit
		 */
		char r = 'y';
		do {
			System.out.println("\n ************Student Enrolment System************ \n"
					+ "Press 1 to Enroll a Student for 1 Semester \n"
					+ "Press 2 to Update an Enrolment of a Student for 1 Semester \n"
					+ "Press 3 to Display all Enrolments \n"
					+ "Press 4 to Print all Courses for 1 Student in 1 Semester \n"
					+ "Press 5 to Print all Students of 1 Course in 1 Semester \n"
					+ "Press 6 to Prints all Courses offered in 1 Semester \n"
					+ "Press 7 to Exit");
			Scanner scanner = new Scanner(System.in);
			int r2 = 0;
			while (r2 == 0) {
				try {
					System.out.print("Enter option: ");
					int a = scanner.nextInt();
					switch(a) {
						// Press 1 to Enroll a Student for 1 Semester
						case 1:
							System.out.println("\n ------Option 1 selected------");
							ses.add();
							r2 = 1;
							break;
						// Press 2 to Update an Enrollment of a Student for 1 Semester
						case 2:
							System.out.println("\n ------Option 2 selected------");
							ses.update();
							r2 = 1;
							break;
						// Press 3 to Display all Enrollments
						case 3:
							System.out.println("\n ------Option 3 selected------");
							ses.displayAllEnrolments();
							r2 = 1;
							break;
						// Press 4 to Print all Courses for 1 Student in 1 Semester
						case 4:
							System.out.println("\n ------Option 4 selected------");
							ses.printAllCoursesInOneStudentOneSem();
							r2 = 1;
							break;
						// Press 5 to Print all Students of 1 Course in 1 Semester
						case 5:
							System.out.println("\n ------Option 5 selected------");
							ses.printAllStudentsInOneCourseOneSem();
							r2 = 1;
							break;
						// Press 6 to Prints all Courses offered in 1 Semester
						case 6:
							System.out.println("\n ------Option 6 selected------");
							ses.printAllCoursesInOneSem();
							r2 = 1;
							break;
						// Press 7 to Exit
						case 7:
							System.out.println("Exiting program");
							System.exit(0);
							break;
						default:
							System.out.println("ERROR: Invalid option");
//							break;
					}
					int r1 = 0;
					/*
					 * This is the prompt after finishing an option.
					 * As long as r1 = 0, this prompt will show again.
					 * If r1 != 0, this will break the while loop.
					 * The while loop is used to account for the case where r != 'y' and r != 'n',
					 * so the prompt would appear again.
					 */
					while (r1 == 0) {
						System.out.print("Do you want to go back to Main Menu (Y) or Exit the Program (N)? (Y/N): ");
						r = scanner.next().charAt(0);
						if (r == 'n' || r == 'N') {
							System.out.println("Exiting program");
							scanner.close();
							System.exit(0);
						} else if (r == 'y' || r == 'Y') {
							r2 = 1;
							break;
						} else {
							System.out.println("ERROR: Invalid option");
						}
					}
				} catch (InputMismatchException e) {
					System.out.println("ERROR: Invalid input type");
					break; // r2 = 1;
				}
			}
			
			
			
		} while (r == 'y' || r == 'Y');
	}

}
