package testNG;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import test.tc1;
	

public class test1 extends tc1 {
		@Parameters({ "val1", "val2" })
		@Test	
		public void  testset1(String val1, String val2){
		{
			tc1 t=new tc1();
			t.tc11(val1,val2);
		}
	}	
	@Parameters({ "val3", "val4","val5", "val6" })
	@Test		
	public void  testset2(String val3, String val4,String val5, String val6){
		{
			tc1 t=new tc1();
			t.tc12(val3,val4,val5,val6);
		}
	}	
	
}
				