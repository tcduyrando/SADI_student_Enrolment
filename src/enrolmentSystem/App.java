package enrolmentSystem;

import java.util.*;

import java.time.LocalDate;
import java.text.SimpleDateFormat;

public class App {
	
	final protected static StudentEnrolmentSystem ses = new StudentEnrolmentSystem();
	
	public static void main(String[] args) {
		
//		Data population for Student and Course
		Student s1 = new Student("s001", "Gorgeous George", LocalDate.of(2000, 12, 24));
		Student s2 = new Student("s002", "Posh Pete", LocalDate.of(2000, 2, 9));
		Student s3 = new Student("s003", "Ronald McDonald", LocalDate.of(2001, 5, 13));
		Course c1 = new Course("c001", "SADI", 3);
		Course c2 = new Course("c002", "SEPT", 4);
		Course c3 = new Course("c003", "Web Programming", 2);
		
		ses.addStudent(s1);
		ses.addStudent(s2);
		ses.addStudent(s3);
		ses.addCourse(c1);
		ses.addCourse(c2);
		ses.addCourse(c3);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(c1);
		System.out.println(c2);
		
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
					+ "Press 5 to Exit");
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
			// Press 5 to Exit
				case 5:
					System.out.println("Exiting program");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid option");
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
				System.out.print("Do you want to select another option? (Y/N): ");
				r = scanner.next().charAt(0);
				if (r == 'n' || r == 'N') {
					System.out.println("Exiting program");
					System.exit(0);
				} else if (r == 'y' || r == 'Y') {
					r1 = 1;
					break;
				} else {
					System.out.println("Invalid option");
				}
			}
			
		} while (r == 'y' || r == 'Y');
	}

}
