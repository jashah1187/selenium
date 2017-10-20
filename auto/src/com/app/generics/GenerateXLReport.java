package com.app.generics;

public class GenerateXLReport   {
	final static String strRelPath = "./";
	
	public void generatexl() throws Exception{
	
	
	XL.generateReport("./XLReport", "Report_Excel.xlsm");
	XL.generateReport("Report_Excel"+ Commonstudio.getCurrentTimeStamp() + ".xlsm");
	XL1.generateReport("./XLReport", "Report_Excel"+ Commonstudio.getCurrentTimeStamp() + ".xlsx");
	} 

	public static void main(String[] ar) throws Exception
	{ 
		GenerateXLReport gen = new GenerateXLReport();
		gen.generatexl();
	}
}