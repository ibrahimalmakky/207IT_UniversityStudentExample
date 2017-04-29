import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import jaxbFiles.*;

public class Students {
	
	private ObjectFactory of;
    private StudentsList stList;
    
    private ArrayList<Student> students;

    public Students(ArrayList<Student> students) {
    	super();
    	this.students = students;
    	of = new ObjectFactory();
        stList = of.createStudentsList();
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
    	 OutputStream os = new FileOutputStream("H:\\Documents\\College\\207IT_APRL_17\\Teaching Materials\\Week_3\\Students.xml");
    	 m.marshal( stl, os );
    }
    
    public void saveXML() throws JAXBException, FileNotFoundException {
    	this.make();
    	this.marshall();
    }
    
    public ArrayList<Student> getStudents() {
    	return this.students;
    }
    
}
