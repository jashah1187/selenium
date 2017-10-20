package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class tc1 extends webdriver {
	@Parameters({ "val1", "val2" })
	@Test	
public void tc11(String val1, String val2){
	webdriver web = new webdriver();
	web.percentagecalculaton(val1,val2);
		}
	@Parameters({ "val3", "val4","val5", "val6" })
	@Test	
public void tc12(String j, String k,String l, String m){
	webdriver web = new webdriver();;
	web.factioncalculator(j,k,l,m);
	}

public void tc13(){
	String a="20";
	String b="21";
	webdriver web = new webdriver();
	web.percentagecalculaton(a,b);
		}

}
