package enrolmentSystem;

import java.util.*;
import java.time.LocalDate;
import java.text.SimpleDateFormat;

public class Test {
	
	public static void main(String[] args) {
				
		LocalDate bd1 = LocalDate.of(2000, 12, 24);
		System.out.println(bd1.getYear());
		Student s1 = new Student("s001", "Gorgeous George", bd1);
		
		Course c1 = new Course("c001", "SADI", 12);
		
		System.out.println(s1.toString());
		System.out.println(c1.toString());
	}

}
