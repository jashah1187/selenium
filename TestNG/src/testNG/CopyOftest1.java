package testNG;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import test.tc1;
	
public class CopyOftest1 extends tc1 {
	
		@Test	
		public void  testset1(){
		{
			String val1="20";
			String val2="25";
			tc1 t=new tc1();
			t.tc11(val1,val2);
		}
	}	
}

				