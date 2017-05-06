package University;
import java.util.Calendar;

import org.junit.Test;

import static org.junit.Assert.*;

public class myTest {

	@Test
	public void checkStudent() {
		
		String firstName = "firstName";
		String lastName = "lastName";
		String city = "Coventry";
		
		Student studentTest = new Student(firstName, lastName,
				19, 5, 2000, city);
		
//		Check that the first name and last name match the parameters passed to
//		the constructor
		assertEquals("First Name is firstName", firstName, studentTest.getFirstName());
		assertEquals("Last Name is lastName", lastName, studentTest.getLastName());
		
//		Check that the day of birth is greater than 0 and less than 32
		assertTrue("Day of Birth > 0", studentTest.getDayOfBirth() > 0);
		assertTrue("Day of Birth < 32", studentTest.getDayOfBirth() < 32);
		
//		Make sure that the month is greater than 0 and less than 13
		assertTrue("Month of Birth > 0", studentTest.getMonthOfBirth() > 0);
		assertTrue("Month of Birth < 13", studentTest.getMonthOfBirth() < 13);
		
//		Get the current year
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
//		Make sure that the year is less then or equal to the current year minus
//		18 years. Also make sure that the year is more than the current year 
//		minus 65 years
		assertTrue("Year is less than the current year-18", studentTest.getYearOfBirth() <= year-18);
		assertTrue("Year is more than 65 years ago", studentTest.getYearOfBirth() > year-65);
		
//		Check if the city is the same
		assertEquals("City is Coventry", city, studentTest.getCity());
	}
	
}
