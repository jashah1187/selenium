package test;

import java.sql.Driver;
import com.common.components.webdriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.app.components.appcommondrivers;
import com.app.components.percentilecalculator;



public class tc1 extends webdriver {

public void tc11(String val1, String val2){
	/*percentilecalculator pc = new percentilecalculator();
	pc.percentagecalculaton(val1,val2); */
	webdriver.webdriver();
	appcommondrivers ac=new appcommondrivers();
	ac.mathcalculator();
	ac.percentagecal(val1, val2);
	webdriver.stopdriver();
		}

public void tc12(String j, String k,String l, String m){
	percentilecalculator pc = new percentilecalculator();
	webdriver.webdriver();
	pc.factioncalculator(j,k,l,m);
	webdriver.stopdriver();
	}

public void tc13(){
	String a="20";
	String b="21";
	percentilecalculator pc = new percentilecalculator();
	pc.percentagecalculaton(a,b);
		}
}
