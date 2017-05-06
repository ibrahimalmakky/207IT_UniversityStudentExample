import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import jaxbFiles.ObjectFactory;
import jaxbFiles.StudentsList;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import University.Student;
import University.University;
import University.myTest;
import GUI.*;

public class Main {
	
	public static void main(String[] args) {
		
		University uni = new University();
		
		MainGUI.main(uni);
		
//		runTests();
				
	}
	
	public static void runTests() {
		Result results = JUnitCore.runClasses(myTest.class);
		 for (Failure failure : results.getFailures()) {
		      System.out.println(failure.toString());
		 }
		 System.out.println(results.wasSuccessful());
	}
	
}
