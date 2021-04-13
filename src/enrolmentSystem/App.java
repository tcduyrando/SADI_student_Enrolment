package enrolmentSystem;

import java.util.*;
import java.io.IOException;
import java.time.LocalDate;

public class App {
	
	final protected static StudentEnrolmentSystem ses = new StudentEnrolmentSystem();
	
	public static void main(String[] args) throws IOException {
		
		/*
		 * Data population from CSV
		 */
		ses.readStudentsFromCSV("default.csv");
		ses.readCoursesFromCSV("default.csv");
		ses.readEnrolmentsFromCSV("default.csv");
		ses.displayAllStuents();
		ses.displayAllCourses();
		ses.displayAllEnrolments();
		
		/*
		 * This will show the main menu
		 * As long as r = 'y', the program will run and the menu will show.
		 * If r = 'n', the program will exit
		 */
		char r = 'y';
		do {
			// Display options
			System.out.println("\n ************Student Enrolment System************ \n"
					+ "Press 1 to Enroll a Student for 1 Semester \n"
					+ "Press 2 to Update an Enrolment of a Student for 1 Semester \n"
					+ "Press 3 to Display all Enrolments \n"
					+ "Press 4 to Print all Courses for 1 Student in 1 Semester \n"
					+ "Press 5 to Print all Students of 1 Course in 1 Semester \n"
					+ "Press 6 to Print all Courses offered in 1 Semester \n"
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
							System.out.println("\n ------Option 1 selected: Enroll a Student for 1 Semester------");
							ses.add();
							r2 = 1;
							break;
						// Press 2 to Update an Enrollment of a Student for 1 Semester
						case 2:
							System.out.println("\n ------Option 2 selected: Update an Enrolment of a Student for 1 Semester------");
							ses.update();
							r2 = 1;
							break;
						// Press 3 to Display all Enrollments
						case 3:
							System.out.println("\n ------Option 3 selected: Display all Enrolments------");
							ses.displayAllEnrolments();
							r2 = 1;
							break;
						// Press 4 to Print all Courses for 1 Student in 1 Semester
						case 4:
							System.out.println("\n ------Option 4 selected: Print all Courses for 1 Student in 1 Semester------");
							ses.printAllCoursesInOneStudentOneSem();
							r2 = 1;
							break;
						// Press 5 to Print all Students of 1 Course in 1 Semester
						case 5:
							System.out.println("\n ------Option 5 selected: Print all Students of 1 Course in 1 Semester------");
							ses.printAllStudentsInOneCourseOneSem();
							r2 = 1;
							break;
						// Press 6 to Print all Courses offered in 1 Semester
						case 6:
							System.out.println("\n ------Option 6 selected: Print all Courses offered in 1 Semester------");
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
