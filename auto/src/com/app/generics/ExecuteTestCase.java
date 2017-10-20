package com.app.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;



public class ExecuteTestCase {

	static Logger logger = Logger.getLogger(ExecuteTestCase.class);

	public static void main(String[] ar) {

		PropertyFileReader fileReader = new PropertyFileReader();
		//String suite = fileReader.readPropFile("testSuite").trim();
		String testSetPath = fileReader.readPropFile("tsFilePath").trim();
		String testSetSheetName = fileReader.readPropFile("tsSheetName").trim();
		TestNG myTestNG = new TestNG();
		String suite = null;
		try {
			List<Map> rows = ExcelReader.read(testSetPath, testSetSheetName);
			
			System.out.println("Rows are::"+rows);
			for(Map map1:rows)
			{
				 suite=map1.get("TestClass").toString();
			}
		
					 XmlSuite mySuite = new XmlSuite();
					 mySuite.setName(suite);
					 List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
					 List<XmlTest> myTests = new ArrayList<XmlTest>();
					 Map<String,String> testngParams = new HashMap<String,String> ();
					 XmlTest myTest = new XmlTest(mySuite);
				 		List<XmlClass> myClasses = new ArrayList<XmlClass> ();
						 XmlClass cls = new XmlClass(suite);
						 List<XmlInclude> xmlInclude=new ArrayList<XmlInclude>();
						 myClasses.add(cls);
					 for(Map map:rows)
					 {
						 if((map.containsKey("TestCaseName") && map.get("SelectYN").toString().equals("Y")))
								 {
							 
							 		//System.out.println("Adding suite:"+map.get("TestCaseName").toString());
							 		xmlInclude.add(new XmlInclude(map.get("TestCaseName").toString()));
								 }
					 }
					 
					 cls.setIncludedMethods(xmlInclude);
					 myTest.setXmlClasses(myClasses);
					 myTests.add(myTest);
					 mySuite.setTests(myTests);
					 mySuites.add(mySuite);
					 myTestNG.setXmlSuites(mySuites);
					 myTestNG.run();
				
			

		} catch (ClassNotFoundException e) {
			logger.error("ERROR: TestSuite: " + suite + "- Class not found..!!");
		} catch (Exception e) {
			logger.error("ERROR: Problem while reading test set" + testSetPath
					+ "..!!" + e.getMessage());
		}
		
	}
}
