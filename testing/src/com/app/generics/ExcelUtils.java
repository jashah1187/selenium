package com.app.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.relevantcodes.extentreports.LogStatus;

/**
 * @author Prashanth.T
 *
 */
public class ExcelUtils extends Commonstudio{

	private static Sheet ExcelWSheet;
	private static Workbook ExcelWBook;
	private static org.apache.poi.ss.usermodel.Cell Cell;
	private static org.apache.poi.ss.usermodel.Row Row;

	static ExcelUtils excel;

	public static Object[][] getTableArray(String FilePath,String SheetName) throws Exception
	{
		String[][] tabArray = null;

		try {
			String extension = FilenameUtils.getExtension(FilePath);//getting file extension from string given
			//System.out.println(extension);
			FileInputStream ExcelFile = new FileInputStream(FilePath);

//			if(extension.contentEquals("xlsx"))
//			{
				// Access the required test data sheet
				ExcelWBook = WorkbookFactory.create(ExcelFile);
				ExcelWSheet = ExcelWBook.getSheet(SheetName);
				int startRow = 1;
				int startCol = 0;
				int ci,cj;
				int totalRows = ExcelWSheet.getLastRowNum();
				//			   System.out.println("TotalRows: "+totalRows);
				// you can write a function as well to get Column count
				int totalCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
				// int totalCols = ExcelWSheet.getRow(i).getLastCellNum() ;
				System.out.println("Total Columns :"+totalCols);
				System.out.println("Total Rows :"+totalRows);
				tabArray=new String[totalRows][totalCols];
				ci=0;
				for (int i=startRow;i<=totalRows;i++, ci++) {
					cj=0;
					for (int j=startCol;j<totalCols;j++, cj++){
						tabArray[ci][cj]=getCellData(i,j);
						//System.out.println(tabArray[ci][cj]);
					}
				}
		}

		catch (FileNotFoundException e){
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}

		catch (IOException e){

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		return(tabArray);
	}

	//Method to get data from cell in excel
	/*public static String getCellData(int RowNum, int ColNum) throws Exception {
		int dataType = 0;
		try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = null;
			if(Cell == null){
				dataType = 3;
			}else{
				dataType = Cell.getCellType();
			}
			if  (dataType == 3) {
				return "";
			}
			else if(dataType==0){
				double CellData = Cell.getNumericCellValue();
				return String.valueOf(CellData);
			}
			else{
				String CellData = Cell.getStringCellValue();
				return CellData;
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
			throw (e);
		}
	}
	 */

	//Method to get data from cell in excel
	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try{
			int dataType = 0;
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = null;
			if(Cell == null){
				dataType = 3;
			}else{
				dataType = Cell.getCellType();
			}
			//                   System.out.println("Cell data type: "+dataType);
			if  (dataType == 3) {
				return "";
			}
			else if(dataType==0){
				if(HSSFDateUtil.isCellDateFormatted(Cell))
				{
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					CellData = df.format(Cell.getDateCellValue());

				}else{
					double doubleCellData = Cell.getNumericCellValue();
					CellData = String.valueOf((int)doubleCellData);
				}
				return String.valueOf(CellData);
			}
			else{
				CellData = Cell.getStringCellValue();
				return CellData;
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
			throw (e);
		}
	}



	public static String getExcelCellvalue(String xlpath,String sheetName, int rowNum,int cellNum) throws FileNotFoundException , IOException, IllegalStateException, InvalidFormatException	{
		// TODO Auto-generated method stub
		String cellVal;

		try{
			FileInputStream fis = new FileInputStream(xlpath);
			Workbook wb= WorkbookFactory.create(fis);
			cellVal=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
			//			System.out.println(cellVal);
		}
		catch(Exception e){
			cellVal="";
		}
		return cellVal;
	}

	private static Workbook workbook(FileInputStream fis) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Method to read all the values to an string array by passing a particular row name
	 */
	public static String[] getExcelRowValues(String xlPath,String xlSheet,String rowName) throws Exception
	{
		String[] detailsArray = null;
		try{
			FileInputStream ExcelFile = new FileInputStream(xlPath);
			// Access the required test data sheet
			ExcelWBook =  WorkbookFactory.create(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(xlSheet);
			int totalRows = ExcelWSheet.getLastRowNum();
			int ci = 0,totalCols=0;
			int rowNum=0;
			for(int i=1;i<=totalRows;i++)
			{
				//				String strExcelRow=ExcelWSheet.getRow(i).getCell(0).getStringCellValue();
				String strExcelRow = getCellData(i, 0);
				if(strExcelRow.equalsIgnoreCase(rowName))
				{
					rowNum = i;
				}


			}

			if(rowNum != 0){
				totalCols=ExcelWSheet.getRow(rowNum).getLastCellNum();
				detailsArray=new String[totalCols];
				for(int j=0;j<totalCols;j++,ci++)
				{
					detailsArray[ci]=getCellData(rowNum,j);
					//detailsArray[ci] =	ExcelWSheet.getRow(rowNum).getCell(j).getStringCellValue();
				}
			}
			else
			{
				//logger.log(LogStatus.FAIL, "Expected row not found in the excel");
			}
		}catch (IOException|NullPointerException e){
			//logger.log(LogStatus.FAIL, "Could not read the Excel sheet");
			e.printStackTrace();
		}


		return (detailsArray);
	}


	/*
	 * Method to read all the values to an string array by passing a particular column name
	 */
	public static String[] getExcelColumnValues(String xlPath,String xlSheet,String columnName) throws Exception
	{
		String[] arrColumnValues = null;
		try{
			FileInputStream ExcelFile = new FileInputStream(xlPath);
			// Access the required test data sheet
			ExcelWBook = WorkbookFactory.create(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(xlSheet);
			int totalRows = ExcelWSheet.getLastRowNum();

			int ci = 0,colNum=0;
			int rowNum=0;
			for(int i=0;i<ExcelWSheet.getRow(0).getPhysicalNumberOfCells();i++)
			{
				String strColName = getCellData(0, i);
				if(strColName.contains(columnName))
				{
					colNum = i;
					break;
				}else{
					colNum = -1;
				}
			}

			if(colNum != -1){
				//totalCols=ExcelWSheet.getRow(rowNum).getLastCellNum();
				arrColumnValues=new String[totalRows];
				for(int j=1;j<=totalRows;j++,ci++)
				{
					arrColumnValues[ci]=getCellData(j,colNum);
				}
			}
			else
			{
			//	logger.log(LogStatus.FAIL, "Expected column not found in the excel");
			}
		}catch (IOException|NullPointerException e){
			//logger.log(LogStatus.FAIL, "Could not read the Excel sheet");
			e.printStackTrace();
		}


		return (arrColumnValues);
	}


	/*public static void main(String args[]) throws Exception{
		String[] receiverDetails = ExcelUtils.getSenderReceiverDetails("./WoohooWeb/WoohooTestData.xls","ReceiverDetails","UserReceiver");
		for(int i=1;i<receiverDetails.length;i++){
			System.out.println(receiverDetails[i]);
		}
	}*/

	//Method to get data from cell in excel
	/* public static String getCellData(int RowNum, int ColNum) throws Exception {

           try{
                  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                  String CellData = null;
                  int dataType = Cell.getCellType();
                  //                   System.out.println("Cell data type: "+dataType);
                  if  (dataType == 3) {
                        return "";
                  }
                  else if(dataType==0){
                        if(HSSFDateUtil.isCellDateFormatted(Cell))
                        {
                               DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                               CellData = df.format(Cell.getDateCellValue());

                        }else{
                               double doubleCellData = Cell.getNumericCellValue();
                               CellData = String.valueOf((int)doubleCellData);
                        }
                        return String.valueOf(CellData);
                  }
                  else{
                           CellData = Cell.getStringCellValue();
                           return CellData;
                  }
           }catch (Exception e){
                  System.out.println(e.getMessage());
                  throw (e);
           }
    }
	 */

	//method to get values from excel from a specific sheet
	public static String[][] getValuesFrmExcel(String FilePath,String SheetName) throws Exception
	{
		String[][] arrExcelValues=null;
		excel = new ExcelUtils();
		try {

			FileInputStream ExcelFile = new FileInputStream(FilePath);
			// Access the required test data sheet
			ExcelWBook = WorkbookFactory.create(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int startRow = 1;
			int startCol = 0;
			int ci,cj;
			int totalRows = ExcelWSheet.getLastRowNum();
			int totalCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
			arrExcelValues=new String[totalRows][totalCols];
			//int totalCols=2;
			ci=0;
			for (int i=startRow;i<=totalRows;i++, ci++) {
				cj=0;
				for (int j=startCol;j<totalCols;j++, cj++){
					arrExcelValues[ci][cj]=excel.getCellData(i,j);
				}
			}
		}
		catch (FileNotFoundException e){
			//logger.log(LogStatus.FAIL, "Couldn't able to find the excel in given path "+FilePath);
			e.printStackTrace();
		}
		catch (IOException e){
			//logger.log(LogStatus.FAIL, "Error in reading the excel sheet");
			e.printStackTrace();
		}
		catch (Exception e){
			//logger.log(LogStatus.FAIL, "Exception occured during reading excel sheet");
			e.printStackTrace();
		}
		return(arrExcelValues);
	}

}
