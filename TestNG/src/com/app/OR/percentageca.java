package com.app.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.common.components.webdriver;

public class percentageca extends webdriver  {
public static WebElement element;
public WebElement clickpercentagecalculator(){
	element = driver.findElement(By.xpath("//*[@id='content']//*[contains(text(),'Percentage Calculator')]"));
	return element;
}
public WebElement entervalues1(){
	element = driver.findElement(By.id("cpar1"));
	return element;
}
public WebElement entervalues2(){
	element = driver.findElement(By.id("cpar2"));
	return element;
}
public WebElement calculate(){
	element = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[2]/td/input[2]"));
	return element;
}
public WebElement getresult(){
	element = driver.findElement(By.xpath(".//*[@id='content']/p[2]/font/b"));
	return element;
}
}
