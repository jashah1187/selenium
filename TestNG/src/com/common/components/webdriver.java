package com.common.components;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class webdriver {
public static WebDriver driver;
//@BeforeTest
public static void  webdriver(){
	System.setProperty("webdriver.chrome.driver", "D://DriverFiles/chromedriver.exe");
    driver = new ChromeDriver();  
    System.out.println("Driver object created");
    //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	//Puts an Implicit wait, Will wait for 10 seconds before throwing exception
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   driver.navigate().to("http://www.calculator.net/");
  }
public static void startdriver(){
		driver.navigate().to("http://www.calculator.net/");
}
public static void stopdriver(){
	 driver.close();
}

}


