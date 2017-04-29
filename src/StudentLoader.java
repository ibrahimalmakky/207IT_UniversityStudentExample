import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class StudentLoader {

	public static ArrayList<Student> loadStudents(String filePath) {
		
		ArrayList<Student> students = new ArrayList<Student>();
		
		try {
			
			BufferedReader bufferReader = new BufferedReader(new FileReader(filePath));
			
			String row = null;
			
			while ((row = bufferReader.readLine()) != null) {
				
				String[] elements = row.split(",");
				
				Student student = new Student(elements[0], elements[1], Integer.parseInt(elements[2]),
						Integer.parseInt(elements[3]), Integer.parseInt(elements[4]), elements[5]);
				
				students.add(student);
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return students;
	}
	
}
