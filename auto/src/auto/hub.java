package auto;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.common.components.webdriver;

public class hub {
	public static RemoteWebDriver driver;
	
	@Test
public void testrun() 
{
	try {
	DesiredCapabilities cap =DesiredCapabilities.chrome();
	cap.setPlatform(Platform.WIN10);
	URL url=new URL("http://localhost:4444/wd/hub");
	WebDriver driver =new RemoteWebDriver(url,cap);
	driver.navigate().to("http://www.calculator.net/"); 
	driver.findElement(By.xpath("//*[contains(text(),'Math Calculators')]")).click();
	     //   driver.findElement(By.xpath(".//*[@id='menu']/div[3]/a")).click();
	    
	    // Click on Percent Calculators
	    driver.findElement(By.xpath("//*[@id='content']//*[contains(text(),'Percentage Calculator')]")).click();
	    
	    // Enter value 10 in the first number of the percent Calculator
	    driver.findElement(By.id("cpar1")).sendKeys("20");
	    
	    // Enter value 50 in the second number of the percent Calculator
	    driver.findElement(By.id("cpar2")).sendKeys("10");
	    
	    // Click Calculate Button
	    driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[2]/td/input[2]")).click();

	    
	    // Get the Result Text based on its xpath
	    String result = driver.findElement(By.xpath(".//*[@id='content']/p[2]/font/b")).getText();

	    
	    // Print a Log In message to the screen save
	    System.out.println(" The Result is " + result);
	    driver.close();
	}
	 catch (MalformedURLException e) {
	{
		//
	}
	}
	    
	
}	
}
