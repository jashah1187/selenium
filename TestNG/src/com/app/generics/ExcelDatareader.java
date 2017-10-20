package com.app.generics;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




public class ExcelDatareader {



int columns;

private DecimalFormat df = new DecimalFormat();
private String decimalToString(Double d){
	df.setMaximumFractionDigits(0);
	return df.format(d).replace(","," ");
	
}
	public Sheet getSheet(String sheetno) 
	
	{
		Sheet sheet = null;
		try {
			File file = new File(Constant.excel_path);
			FileInputStream fis=new FileInputStream(file);
			
			Workbook wb = HSSFWorkbook(fis);
			sheet = wb.getSheet(sheetno);
			System.out.println(sheet.getSheetName());

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sheet;
	}

	private Workbook HSSFWorkbook(FileInputStream fis) {
		// TODO Auto-generated method stub
		return null;
	}
}
