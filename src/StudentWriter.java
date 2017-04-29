import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;

public class StudentWriter {
	
//	Saves an ArrayList of students
	
	public static void saveStudentsCSV(ArrayList<Student> students, String filePath) {
		int numStudents = students.size();
		
		for (int i=0; i<numStudents; i++){
			saveStudentCSV(students.get(i), filePath);
		}
	}
	
//	Saves one student into a specific file
	public static void saveStudentCSV(Student student, String filePath) {
		
		try {
			
			BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(filePath ,true));
			
			bufferWriter.append(student.getFirstName()+","+student.getLastName()+","+
								student.getDayOfBirth()+","+student.getMonthOfBirth()+","+
								student.getYearOfBirth()+","+student.getCity());
			bufferWriter.newLine();
			
			bufferWriter.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void CreateStudentsXML(Student student, String filePath) {
		
		try {
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			
			Element rootElement = doc.createElement("Students");
			doc.appendChild(rootElement);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			
			StreamResult result = new StreamResult(new File(filePath));
			transformer.transform(source, result);
			
			
		} catch (Exception e){
			e.printStackTrace();
		}

	}
	
}
