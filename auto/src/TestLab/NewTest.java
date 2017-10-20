package TestLab;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import test.tc1;

import com.app.generics.*;

public class NewTest {
  @Test(dataProvider = "dp", priority=1)
    public void  testset1(String val1, String val2){
	  		System.out.println(val1);
			tc1 t=new tc1();
			t.tc11(val1,val2);
	  }
  @Test(dataProvider = "dp", priority=1)
  public void  testset2(String val1, String val2){
	  		System.out.println(val1);
			tc1 t=new tc1();
			t.tc11(val1,val2);
	  }
  @DataProvider
  public Object[][] dp() throws Exception {
	//Object[][] arrayObject = ExcelUtils.getTableArray("C:\\softwares\\Book2.xls","Sheet1");
	//Object[][] arrayObject = ExcelUtils.getTableArray(Constant.excel_path, Constant.sheet_1);
	  Object[][] arrayObject = ExcelUtils.getTableArray("inputs\\Book2.xls","Sheet1");
    return (arrayObject);
  //return new Object[][] { {"10","20"},{"30","40"}};
         }
}
