package com.app.components;

import com.common.components.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class percentilecalculator extends webdriver {

	
public void percentagecalculaton(String j, String k){
	
	
    //Launch website
    driver.navigate().to("http://www.calculator.net/");
      
    //Maximize the browser
    driver.manage().window().maximize();
    
    // Click on Math Calculators
    
      driver.findElement(By.xpath("//*[contains(text(),'Math Calculators')]")).click();
     //   driver.findElement(By.xpath(".//*[@id='menu']/div[3]/a")).click();
    
    // Click on Percent Calculators
    driver.findElement(By.xpath("//*[@id='content']//*[contains(text(),'Percentage Calculator')]")).click();
    
    // Enter value 10 in the first number of the percent Calculator
    driver.findElement(By.id("cpar1")).sendKeys(j);
    
    // Enter value 50 in the second number of the percent Calculator
    driver.findElement(By.id("cpar2")).sendKeys(k);
    
    // Click Calculate Button
    driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[2]/td/input[2]")).click();

    
    // Get the Result Text based on its xpath
    String result = driver.findElement(By.xpath(".//*[@id='content']/p[2]/font/b")).getText();

    
    // Print a Log In message to the screen
    System.out.println(" The Result is " + result);
    
    //Close the Browser.
   // driver.close();
}

public void factioncalculator(String j, String k,String l, String m){
  
    //Launch website
    //driver.navigate().to("http://www.calculator.net/");
      
    //Maximize the browser
   // driver.manage().window().maximize();
    
    // Click on Math Calculators
  
    driver.findElement(By.xpath("//*[contains(text(),'Math Calculators')]")).click();
 //   driver.findElement(By.xpath(".//*[@id='menu']/div[3]/a")).click();
    
    // Click on Fraction Calculators
    driver.findElement(By.xpath("//*[@id='content']//*[contains(text(),'Fraction Calculator')]")).click();
    
    // Enter value 10 in the first number of the percent Calculator`
  //*[@id="t1"]
    driver.findElement(By.id("t1")).sendKeys(j);
    
    // Enter value 50 in the second number of the percent Calculator
    driver.findElement(By.id("t2")).sendKeys(k);
    
 // Enter value 50 in the second number of the percent Calculator
    driver.findElement(By.id("b1")).sendKeys(l);
    
 // Enter value 50 in the second number of the percent Calculator
    driver.findElement(By.id("b2")).sendKeys(m);
    
  //*[@id="content"]/table[1]/tbody/tr[4]/td/input[2]
    // Click Calculate Button
    driver.findElement(By.xpath(".//*[@id='content']/table[1]/tbody/tr[4]/td/input[2]")).click();

    
    // Get the Result Text based on its xpath
    String result = driver.findElement(By.xpath("//*[@id='fcoutput']/tbody/tr/td[2]/table/tbody/tr[1]/td[2]")).getText();
    String result1 = driver.findElement(By.xpath("//*[@id='fcoutput']/tbody/tr/td[2]/table/tbody/tr[1]/td[2]//following::tr[2]/td[1]")).getText();
    
      
    // Print a Log In message to the screen
    System.out.println(" The Result is " + result);
    System.out.println(" The Result is " + result1);
    
    //Close the Browser.
    driver.close();
}

}
