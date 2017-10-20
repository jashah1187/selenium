package auto;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class Parallel {
   
	@Test    
    public void executSessionOne(){
            //First session of WebDriver
        System.setProperty("webdriver.chrome.driver","C://softwares//chromedriver_win32//chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            //Goto guru99 site
            driver.get("http://demo.guru99.com/V4/");
            //find user name text box and fill it
            driver.findElement(By.name("uid")).sendKeys("Driver 1");
            System.out.print("test");
            
        }
        
 /*   @Test    
        public void executeSessionTwo(){
            //Second session of WebDriver
       	System.setProperty("webdriver.chrome.driver","C://softwares//chromedriver_win32//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
            //Goto guru99 site
        driver.get("http://demo.guru99.com/V4/");
        //find user name text box and fill it
        driver.findElement(By.name("uid")).sendKeys("Driver 2");
        
        }
        
    @Test 
        public void executSessionThree(){
            //Third session of WebDriver
       // System.setProperty("webdriver.firefox.marionette","C://softwares//geckodriver-v0.19.0-win642//geckodriver.exe");
        System.setProperty("webdriver.gecko.driver","C://softwares//geckodriver-v0.19.0-win64//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
            //Goto guru99 site
        driver.get("http://demo.guru99.com/V4/");
        //find user name text box and fill it
        driver.findElement(By.name("uid")).sendKeys("Driver 3");
        */
        }        
}