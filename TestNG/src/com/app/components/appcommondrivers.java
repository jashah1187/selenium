package com.app.components;

import com.app.OR.landing;
import com.app.OR.percentageca;

public class appcommondrivers {
	public void mathcalculator(){
		landing ma=new landing();
		ma.clickmathcalculator().click();
	}
	public void percentagecal(String j, String k){
		percentageca pe=new percentageca();
		pe.clickpercentagecalculator().click();
		pe.entervalues1().sendKeys(j);
		pe.entervalues2().sendKeys(k);
		pe.calculate().click();
		String result= pe.getresult().getText();
		System.out.println(" The Result is " + result);
	}
}