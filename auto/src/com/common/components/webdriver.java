package com.common.components;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class webdriver {
public static RemoteWebDriver driver;
//@BeforeTest
public static void  webdriver(){
/* Code for Grid Execution */                    
	try {
	DesiredCapabilities cap =DesiredCapabilities.chrome();
	cap.setPlatform(Platform.WIN10);
	URL url;
	
		url = new URL("http://localhost:4444/wd/hub");
	    driver =new RemoteWebDriver(url,cap);
		System.out.println("Remote Driver object created");
		driver.navigate().to("http://www.calculator.net/"); 
		
		} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
/* Code for standalone Execution
	System.setProperty("webdriver.chrome.driver", "inputs//chromedriver.exe");
	driver = new ChromeDriver();  
    System.out.println("Driver object created");
    //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	//Puts an Implicit wait, Will wait for 10 seconds before throwing exception
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
    driver.navigate().to("http://www.calculator.net/"); */
   
  }
public static void startdriver(){
		driver.navigate().to("http://www.calculator.net/");
}
public static void stopdriver(){
	 driver.close();
}

}

