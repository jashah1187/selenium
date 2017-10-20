package com.app.generics;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Locator {
	
	public By locatorValue(String locatorTpye, String value) {
		By by;
		switch (locatorTpye) {
		case "id":
			by = By.id(value);
			break;
		case "name":
			by = By.name(value);
			break;
		case "xpath":
			by = By.xpath(value);
			break;
		case "css":
			by = By.cssSelector(value);
			break;
		case "linkText":
			by = By.linkText(value);
			break;
		case "partialLinkText":
			by = By.partialLinkText(value);
			break;
		default:
			by = null;
			break;
		}
		return by;
	}

	public WebElement getControl(String ctrlName) {
		final Map ctrlInfo = objectInfo.get(ctrlName);
		//System.out.println("Map Control:" + ctrlInfo);
		if (ctrlInfo == null)
			throwError(formatter.format("invalid control name:" + ctrlName).toString());
		return getControl(ctrlInfo);
	}
}
