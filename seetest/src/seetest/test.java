package seetest;
//package <set your test package>;
import com.experitest.client.*;

import org.junit.*;
/**
 *
*/
public class test {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\708643\\workspace\\project2";
    protected Client client = null;

    @Before
    public void setUp(){
        client = new Client(host, port, true);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "test1");
    }

    @Test
    public void testtest1() throws InterruptedException{
        client.setDevice("adb:Nexus 5");
        client.launch("http://origin-preprod.mgmgrand.com/en.html#/", true, false);
       
        if(client.waitForElement("WEB", "xpath=//*[@class='nav-btn-lines']", 0, 10000)){
                	client.click("WEB", "xpath=//*[@class='nav-btn-lines']", 0, 1);
        }else{
     	   System.out.println("xpath=//*[@class='nav-btn-lines element not found");
        }
                
        client.click("WEB", "xpath=//*[@class='icon-restaurants']", 0, 1);
       client.wait(5000);
       if (client.waitForElement("WEB","xpath=//*[@id='cta-dmp-en-promotion-tiles-crush']", 0, 70000)){
    	   client.click("WEB", "xpath=//*[@id='dmp-en-promotion-tiles-crush']/*/*[@class='results-desc']/*[@id='cta-dmp-en-promotion-tiles-crush']/*[@text='Book Table']", 0, 1);
       }else{
    	   System.out.println("xpath=//*[@id='cta-dmp-en-promotion-tiles-crush element not found");
       }
       client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and ./*[@id='d-hours-select']]", 0, 1);
     /*  if(client.swipeWhileNotFound("Down", 0, 2000, "WEB", "xpath=//*[@nodeName='DIV' and @width>0 and ./*[@id='d-hours-select']]", 0, 1000, 1, true)){
    	   client.click("WEB", "xpath=//*[@nodeName='DIV' and @width>0 and ./*[@id='d-hours-select']]", 0, 1);
       }else {
    	   System.out.println("xpath=//*[@nodeName='DIV' and @width>0 and ./*[@id='d-hours-select element not found");
       }*/
    //   client.click("WEB","xpath=(//*[@class='android.widget.ListView']/*[@id='text1'])[2]",0,1);
       if (client.waitForElement("WEB","xpath=//*[@id='d-c-30-September']", 0, 30000)){
    	   client.click("WEB", "xpath=//*[@id='d-c-30-September']", 0, 1);
       }else{
    	   System.out.println("xpath=//*[@id='d-c-30-September'] element not found");
       }
       //client.click("WEB","xpath=//*[@id='d-c-30-September']",0,1);
       client.click("WEB","xpath=xpath=//*[@text='9:00 PM']",0,1);
       client.click("WEB","xpath=//*[@contentDescription='BOOK TABLE']",0,1);
        
     /*  if(client.waitForElement(WEB, "xpath=//*[@class='restaurant-img']", 0, 30000)){
    	   client.click
       }*/
    }
    @After
    public void tearDown(){
        // Generates a report of the test case.
        // For more information - http://experitest.com/studio/help2/WebHelp/help.htm#Report_Of_Executed_Script.htm .
        client.generateReport(false);
        // Releases the client so that other clients can approach the agent in the near future. 
        client.releaseClient();
    }
}
