package University;

public class Student {
	
//	Class Attributes
	
//	Class variable
	private static int numStudents = 0;
	public static String studentPath = "C:\\Users\\ab8961\\Desktop\\Students.csv";
	
//	Instance Variables
	private String firstName;
	private String lastName;
	private int dayOfBirth;
	private int monthOfBirth;
	private int yearOfBirth;
	private String city;
	
//	-----------------------------------------
	
//	Class Methods/Functions
	
//	Class Constructor
	public Student() {
		super();
	}
	
	public Student(String firstName, String lastName, int dayOfBirth,
			int monthOfBirth, int yearOfBirth, String city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dayOfBirth = dayOfBirth;
		this.monthOfBirth = monthOfBirth;
		this.yearOfBirth = yearOfBirth;
		this.city = city;
	}

//	Class Setters and getters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getDayOfBirth() {
		return dayOfBirth;
	}
	
	public void setDayOfBirth(int dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	
	public int getMonthOfBirth() {
		return monthOfBirth;
	}
	
	public void setMonthOfBirth(int monthOfBirth) {
		this.monthOfBirth = monthOfBirth;
	}
	
	public int getYearOfBirth() {
		return yearOfBirth;
	}
	
	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public static int getNumStudents(){
		return numStudents;
	}
}

