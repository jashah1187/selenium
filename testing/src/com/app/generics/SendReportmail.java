package com.app.generics;

public class SendReportmail  {


public void sendMail() {
   try {
	 
	   ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/C", "cd \""+"D:/MGMAutomation/XLReport"+"\" && Release.vbs");
	        builder.redirectErrorStream(true);
			 builder.start();

   }
   catch( Exception e ) {
      System.out.println(e);
      System.exit(0);
   }
	
}
public static void main(String[] ar) throws Exception
{ 
	SendReportmail	sm = new SendReportmail();
	sm.sendMail();
}
}
