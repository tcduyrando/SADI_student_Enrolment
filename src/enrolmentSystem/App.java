package enrolmentSystem;

import java.util.*;

import java.time.LocalDate;

public class App {
	
	final protected static StudentEnrolmentSystem ses = new StudentEnrolmentSystem();
	
	public static void main(String[] args) {
		
		/*
		 * Data population for Student and Course
		 */
		Student s1 = new Student("s001", "Gorgeous George", LocalDate.of(2000, 12, 24));
		Student s2 = new Student("s002", "Posh Pete", LocalDate.of(2000, 2, 9));
		Student s3 = new Student("s003", "Ronald McDonald", LocalDate.of(2001, 5, 13));
		Student s4 = new Student("s004", "Norm McDormand", LocalDate.of(2001, 11, 19));
		Course c1 = new Course("c001", "SADI", 3);
		Course c2 = new Course("c002", "SEPT", 4);
		Course c3 = new Course("c003", "Web Programming", 2);
		Course c4 = new Course("c004", "Maths n Stuff", 2);
		Course c5 = new Course("c005", "Programming 1", 3);
		ArrayList<Course> cs1 = new ArrayList<Course>();
		ArrayList<Course> cs2 = new ArrayList<Course>();
		cs1.add(c1); 
		cs1.add(c2); 
		cs2.add(c2); 
		cs2.add(c3); 
		
		StudentEnrolment se1 = new StudentEnrolment(s1, cs1, "2020C");
		StudentEnrolment se2 = new StudentEnrolment(s2, cs2, "2021A");
		
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
		ses.addEnrolment(se1);
		ses.addEnrolment(se2);
		
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
//		StudentEnrolment se1 = new StudentEnrolment(s1, c1, "2021A");
//		StudentEnrolment se2 = new StudentEnrolment(
//				new Student("s002", "Posh Pete", LocalDate.of(2001, 4, 15)),
//				new Course("c002", "SEPT", 12),
//				"2020C"
//				);
//		
//		System.out.println(s1.toString());
//		System.out.println(c1.toString());		
		
		
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
					+ "Press 4 to Print courses for 1 Student in 1 Semester \n"
					+ "Press 5 to Print all students of 1 course in 1 semester \n"
					+ "Press 6 to Prints all courses offered in 1 semester \n"
					+ "Press 7 to Exit");
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter option: ");
			int a = scanner.nextInt();
			switch(a) {
				// Press 1 to Enroll a Student for 1 Semester
				case 1:
					System.out.println("\n ------Option 1 selected------");
					ses.add();
					break;
				// Press 2 to Update an Enrollment of a Student for 1 Semester
				case 2:
					System.out.println("\n ------Option 2 selected------");
					ses.update();
					break;
				// Press 3 to Display all Enrollments
				case 3:
					System.out.println("\n ------Option 3 selected------");
					ses.displayAllEnrolments();
					break;
				// Press 4 to Print courses for 1 Student in 1 Semester
				case 4:
					System.out.println("\n ------Option 4 selected------");
					break;
				// Press 5 to Print all students of 1 course in 1 semester
				case 5:
					System.out.println("\n ------Option 5 selected------");
					break;
				// Press 6 to Prints all courses offered in 1 semester
				case 6:
					System.out.println("\n ------Option 6 selected------");
					break;
				// Press 7 to Exit
				case 7:
					System.out.println("Exiting program");
					System.exit(0);
					break;
				default:
					System.out.println("ERROR: Invalid option");
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
				System.out.print("Do you want to go back to Main Menu (Y) or Quit (N)? (Y/N): ");
				r = scanner.next().charAt(0);
				if (r == 'n' || r == 'N') {
					System.out.println("Exiting program");
					scanner.close();
					System.exit(0);
				} else if (r == 'y' || r == 'Y') {
					r1 = 1;
					break;
				} else {
					System.out.println("ERROR: Invalid option");
				}
			}
			
		} while (r == 'y' || r == 'Y');
	}

}
