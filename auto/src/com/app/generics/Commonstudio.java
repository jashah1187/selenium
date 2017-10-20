package com.app.generics;

import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Factory;
import org.xml.sax.SAXException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class Commonstudio {
	private static String host = "localhost";
	private static int port = 8889;
	//public static WebDriver wdriver;
    public static RemoteWebDriver wdriver;
	public static NewIOSDriver<IOSElement> driver;
	public static NewAndroidDriver<AndroidElement> Adriver;
	public static ObjectMap ObjMap;
	public static String runType;
	static PropertyFileReader prop = new PropertyFileReader();
	public static String workingDir = System.getProperty("user.dir");
	public final static ExtentReports logger = ExtentReports.get(Commonstudio.class);
	final static String strRelPath = "./";
	
	
	
	@BeforeMethod
	//@Parameters("udid")
	@Factory(dataProvider = "TestCasesDriven" , dataProviderClass = Dataprovider_test.class)
	public static void setcaps(Method m,String udid) throws MalformedURLException {
		String testname = m.getName(); 
		   	
		runType = prop.readPropFile("runType");

		if (prop.readPropFile("runType").contains("mobile")) {
			if (prop.readPropFile("appType").equalsIgnoreCase("web")) {
				if (prop.readPropFile("platform").equalsIgnoreCase("iOS")) {
					DesiredCapabilities caps = new DesiredCapabilities();
					caps.setCapability(MobileCapabilityType.UDID,prop.readPropFile("UDID"));
					caps.setBrowserName(MobileBrowserType.SAFARI);
					 driver = new NewIOSDriver<IOSElement>(new URL("http://localhost:8889/wd/hub"), caps);
					//logger.log(LogStatus.INFO,"Framework assigned for Web - iOS : - Successfull");
				}

				else if (prop.readPropFile("platform").equalsIgnoreCase("Android")) {
					DesiredCapabilities caps = new DesiredCapabilities();
					caps.setCapability(MobileCapabilityType.UDID,prop.readPropFile("UDID"));					
					caps.setBrowserName(MobileBrowserType.CHROMIUM);
					Adriver = new NewAndroidDriver<AndroidElement>(new URL("http://localhost:8889/wd/hub"), caps);
					//logger.log(LogStatus.INFO,"Framework assigned for Web - Android : - Successfull");
				}

			} else if (prop.readPropFile("appType").equalsIgnoreCase("native")) {
				if (prop.readPropFile("platform").equalsIgnoreCase("iOS")) {

					File classpathRoot = new File(System.getProperty("user.dir"));
					File appDir = new File(classpathRoot, "Application");
					File app = new File(appDir, "MGM_Resorts.ipa");
					DesiredCapabilities dc = new DesiredCapabilities();
//					  dc.setCapability("reportDirectory", prop.readPropFile("path"));
//					  dc.setCapability("reportFormat", "html");
					// dc.setCapability("testName", testname);
				     dc.setCapability(MobileCapabilityType.PLATFORM, "ios");
					//dc.setCapability(MobileCapabilityType.UDID,prop.readPropFile("UDID"));
				     //dc.setCapability(MobileCapabilityType.UDID,udid);
					dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID,prop.readPropFile("bundleId"));
					 driver = new NewIOSDriver<IOSElement>(new URL("http://localhost:8889/wd/hub"), dc);
					//logger.log(LogStatus.INFO,"Framework assigned for Native - iOS : - Successfull");
				} else if (prop.readPropFile("platform").equalsIgnoreCase("Android")) {
					
					DesiredCapabilities dc = new DesiredCapabilities();
					//dc.setCapability(MobileCapabilityType.UDID,prop.readPropFile("UDID"));
					// System.out.println("UDID of the device :::::"+UDID);
					dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,prop.readPropFile("appPackage"));
					dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,prop.readPropFile("appActivity"));
					Adriver = new NewAndroidDriver<AndroidElement>(new URL("http://localhost:8889/wd/hub"), dc);
					//logger.log(LogStatus.INFO,"Framework assigned for Native - Android : - Successfull");
				}
			}
		} else if (prop.readPropFile("runType").equalsIgnoreCase("desktop")) {
			if (prop.readPropFile("webBrowser").contains("chrome")) {
				DesiredCapabilities caps = new DesiredCapabilities();
				System.out.println("Chrome");
				System.setProperty("webdriver.chrome.driver", strRelPath
						+ "Drivers/chromedriver.exe");
				caps = DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				caps.setCapability(ChromeOptions.CAPABILITY, options);
				wdriver = new ChromeDriver();
			} else if (prop.readPropFile("webBrowser").contains("safari")) {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setBrowserName("safari");
				caps.setCapability("Platform", "Mac");
				wdriver = new SafariDriver();
				System.out.println(caps + "    in safari setings");
			} else if (prop.readPropFile("webBrowser").contains("firefox")) {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setBrowserName("firefox");
				caps.setCapability("Platform", "Mac");
				wdriver = new FirefoxDriver();
			
			}
		}
    	}
	
	@AfterSuite
	public void tearDown() throws Exception { 
		logger.endTest();
	}
	@AfterMethod
	public void closeapp(){
		if (prop.readPropFile("platform").equalsIgnoreCase("iOS")) {
		driver.quit();
	}
		else if (prop.readPropFile("platform").equalsIgnoreCase("Android")) {
			Adriver.quit();
		}
		else if (prop.readPropFile("webBrowser").contains("chrome")) {
			wdriver.quit();
		}
	}

    @BeforeSuite 
	public void Ereport() throws ParserConfigurationException, IOException, SAXException{
		logger.init("./Reports/EReports/MGMiOSSuite"+ Commonstudio.getCurrentTimeStamp() + ".html", true); 
		
	}

public static void setcapsWeb(){
	DesiredCapabilities caps = new DesiredCapabilities();
	System.out.println("Chrome");
	System.setProperty("webdriver.chrome.driver", strRelPath
			+ "Drivers/chromedriver.exe");
	caps = DesiredCapabilities.chrome();
	ChromeOptions options = new ChromeOptions();
	caps.setCapability(ChromeOptions.CAPABILITY, options);
	wdriver = new ChromeDriver();
}
	
	// ////////////////Get failed screen
	// shot/////////////////////////////////////////////////
	public void getScreenshotdata(
			String errMsg, boolean isScreenshotReqd) throws IOException {
		System.out.println("Taking screenshot");
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		if (isScreenshotReqd == true) {
				//logger.log(LogStatus.FAIL, errMsg, "Test error - Screenshot:");
				FileUtils.copyFile(srcfile, new File(workingDir + "/"
						+ "Reports" + "/" + "EReports" + "/" + "ScreenShots" + "/"
						+ Commonstudio.getCurrentTimeStamp() + ".png"));
				logger.attachScreenshot(workingDir + "/" + "Reports" + "/" 
						+ "EReports" + "/" + "ScreenShots" + "/"
						+ Commonstudio.getCurrentTimeStamp() + ".png");
			} 	
			}

	

	// //////////////////////////Current time
	// stap/////////////////////////////////////
	public static String getCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");// dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate; // returns current date and time in format mentioned
	}

	public static void getScreenshotstep(boolean isScreenshotReqd)
			throws Exception {
		
		File srcfile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);

		if (isScreenshotReqd == true) {
			
			logger.log(LogStatus.PASS, "Test Step - Screenshot:");
			FileUtils.copyFile(srcfile, new File(workingDir + "/"
					+ "Reports" + "/" + "EReports" + "/" + "/" + "ScreenShots" + "/"
					+ Commonstudio.getCurrentTimeStamp() + ".png"));
			logger.attachScreenshot(workingDir + "/" + "Reports" + "/"
					+ "EReports" + "/" + "ScreenShots" + "/"
					+ Commonstudio.getCurrentTimeStamp() + ".png");
		}
	}
	
    public static void implicitWait(){
    	if (prop.readPropFile("platform").equalsIgnoreCase("iOS")) {
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	} else if (prop.readPropFile("platform").equalsIgnoreCase("Android")) {
    		Adriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		
    	}
    		
    	}
    }