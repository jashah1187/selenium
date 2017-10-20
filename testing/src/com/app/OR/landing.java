package com.app.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.common.components.webdriver;

public class landing extends webdriver  {
public static WebElement element;
public WebElement clickmathcalculator(){
    //Launch website
   	System.out.println("click Math calculators");
	element = driver.findElement(By.xpath("//*[contains(text(),'Math Calculators')]"));
	return element;
}
}
