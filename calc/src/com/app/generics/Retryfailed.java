package com.app.generics;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryfailed implements IRetryAnalyzer{
	static PropertyFileReader prop = new PropertyFileReader();
	private int retryCount = 0;
    private String maxRetryCount = prop.readPropFile("count");
    
    public boolean retry(ITestResult result) {
        if (retryCount < Integer.parseInt(maxRetryCount) && result.equals("SKIP")) {
            System.out.println("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retryCount+1) + " time(s).");
            retryCount++;
            return true;
        }
        return false;
    }
    
    public String getResultStatusName(int status) {
    	String resultName = null;
    	if(status==1)
    		resultName = "SUCCESS";
    	if(status==2)
    		resultName = "FAILURE";
    	if(status==3)
    		resultName = "SKIP";
		return resultName;
    }
}


