package enrolmentSystem;

import java.util.*;

import java.time.LocalDate;
import java.text.SimpleDateFormat;

public class App {
	
	final protected static StudentEnrolmentSystem ses = new StudentEnrolmentSystem();
	
	public static void main(String[] args) {
				
		LocalDate bd1 = LocalDate.of(2000, 12, 24);
		System.out.println(bd1.getYear());
		
		Student s1 = new Student("s001", "Gorgeous George", bd1);
		Course c1 = new Course("c001", "SADI", 12);
		StudentEnrolment se1 = new StudentEnrolment(s1, c1, "2021A");
		
		ses.add(se1);
		
		System.out.println(s1.toString());
		System.out.println(c1.toString());
		ses.displayAllEnrolments();
		
		char r;
		do {
			System.out.println("************Student Enrolment System************ \n"
					+ "Press 1 to Enrol a Student for 1 Semester \n"
					+ "Press 2 to Update an Enrolment of a Student for 1 Semester \n"
					+ "Press 3 to Print courses for 1 Student in 1 Semester \n"
					+ "Press 4 to Exit");
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter option: ");
			int a = scanner.nextInt();
			switch(a) {
				case 1:
					System.out.println("option 1");
					break;
				case 2:
					System.out.println("option 2");
					break;
				case 3:
					System.out.println("option 3");
					break;
				case 4:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid option");
			}
			System.out.println("Do you want to select another option? (Y/N)");
			r = scanner.next().charAt(0);
			if (r == 'n' || r == 'N') {
				System.exit(0);
			} 
		} while (r == 'y' || r == 'Y');
	}

}
