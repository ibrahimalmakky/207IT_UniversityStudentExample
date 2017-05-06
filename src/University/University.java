package University;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import jaxbFiles.*;

public class University {
	
	private ObjectFactory of;
    private StudentsList stList;
    
    private ArrayList<Student> students;
    
    private String csvFilePath = "H:\\Documents\\College\\207IT_APRL_17\\Teaching Materials\\Week_5\\Students.csv";
    
    public University() {
    	students = new ArrayList<Student>();
    	of = new ObjectFactory();
        stList = of.createStudentsList();
    }

    public University(ArrayList<Student> students) {
    	super();
    	this.students = students;
    	of = new ObjectFactory();
        stList = of.createStudentsList();
    }
    
    public void addStudent(Student student) {
    	students.add(student);
    }
    
    public void setStudents(ArrayList<Student> students) {
    	this.students = students;
    }
    
    public void make() {
    	
    	for (int i=0; i<students.size(); i++) {
        	StudentType st = of.createStudentType();
        	st.setID("");
        	st.setFirstName(students.get(i).getFirstName());
        	st.setLastName(students.get(i).getLastName());
        	stList.getStudent().add(st);
    	}
    	
    }
    
    public void marshall() throws JAXBException, FileNotFoundException {
    	 JAXBElement<StudentsList> stl = of.createStudents(stList);
    	 JAXBContext jc = JAXBContext.newInstance( "jaxbFiles" );
    	 Marshaller m = jc.createMarshaller();
    	 OutputStream os = new FileOutputStream("H:\\Documents\\College\\207IT_APRL_17\\Teaching Materials\\Week_5\\Students.xml");
    	 m.marshal( stl, os );
    }
    
    public void saveXML() throws JAXBException, FileNotFoundException {
    	this.make();
    	this.marshall();
    }
    
    public ArrayList<Student> getStudents() {
    	return this.students;
    }
    
    public void saveNewStudent(Student student){
    	saveStudentCSV(student, this.csvFilePath);
    }
    
//	Saves an ArrayList of students
	public void saveStudentsCSV() {
		int numStudents = this.students.size();
		
		for (int i=0; i<numStudents; i++){
			saveStudentCSV(students.get(i), this.csvFilePath);
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
    
}
