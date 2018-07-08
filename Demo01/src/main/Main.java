package main;


import tests.BaseTest;
import tests.LoginTest;

//import org.openqa.selenium.ie.InternetExplorerDriver;
public class Main {

   /**
    * @param args
    */

	public static void main(String[] args) {       	
		@SuppressWarnings("unused")
		BaseTest testcase = new BaseTest();
		testcase.setup();
		LoginTest logincase = new LoginTest();
		try {
			logincase.invalidLoginTest_InvalidUserNameInvalidPassword();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}