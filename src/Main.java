import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import jaxbFiles.ObjectFactory;
import jaxbFiles.StudentsList;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {

	public static void main(String[] args) {
				
		Student student_1 = new Student("john", "Smith", 4, 8, 1995, "Coventry");
		Student student_2 = new Student("dsfds", "sdfds", 4, 6, 4535, "Coventry");
		Student student_3 = new Student("aeear", "adsad", 5, 67, 345435, "Coventry");
		
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(student_1);
		students.add(student_2);
		students.add(student_3);
		
		runTests();
				
//		try {
//			JAXBContext jaxbContext = JAXBContext.newInstance("jaxbFiles");
//		    Unmarshaller u = jaxbContext.createUnmarshaller();
//		    Object o = u.unmarshal( new File( "H:\\Documents\\College\\207IT_APRL_17\\Teaching Materials\\Week_3\\Students.xml" ) );
//		    ObjectFactory of = new ObjectFactory();
//		    
//		    System.out.println(o.getClass());
//		} catch (JAXBException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
	}
	
	public static void runTests() {
		Result results = JUnitCore.runClasses(myTest.class);
		 for (Failure failure : results.getFailures()) {
		      System.out.println(failure.toString());
		 }
		 System.out.println(results.wasSuccessful());
	}
	
}
