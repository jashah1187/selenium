package com.app.generics;

import org.testng.annotations.DataProvider;

import com.app.generics.ExcelUtils;

public class Dataprovider_test {
	public static  String workingDir = System.getProperty("user.dir");

	@DataProvider()
	public static Object[][] MGMdata() throws Exception{
		Object[][] testObjArray = ExcelUtils.getTableArray(Constant.excel_path, Constant.sheet_1);
		return (testObjArray);
	}	
	@DataProvider()
	public static Object[][] MGMWebdata() throws Exception{
		Object[][] testObjArray = ExcelUtils.getTableArray(Constant.excel_path, Constant.sheet_2);
		return (testObjArray);
	}
	@DataProvider()
	public static Object[][] TestCasesDriven() throws Exception{
		Object[][] testObjArray = ExcelUtils.getTableArray(Constant.TestCasesexcel_path, Constant.sheet_3);
		return (testObjArray);
	}
	
}



