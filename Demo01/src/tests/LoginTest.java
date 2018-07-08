package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import LoginTC01.HomePage;
import LoginTC01.Login;
import utils.excelutils.ExcelUtil;
//import utils.extentreports.ExtentTestManager;
//import utils.listeners.TestListener;



//In order to eliminate attachment problem for Allure, you should add @Listener line.
//link: https://github.com/allure-framework/allure1/issues/730
//@Listeners({ TestListener.class })
//@Epic("Regression Tests")
//@Feature("Login Tests")
public class LoginTest extends BaseTest {
	
		public LoginTest (WebDriver driver, WebDriverWait wait) {
			super(driver, wait);
		}

        public void setupTestData () {
        //Set Test Data Excel and Sheet
        //BaseTest Basetest = new BaseTest(driver,wait);
        
        System.out.println("************Setup Test Level Data**********");
        ExcelUtil.setExcelFileSheet("Login_TC01");
    }

    
    public void invalidLoginTest_InvalidUserNameInvalidPassword () throws InterruptedException {
      
        
        //*************PAGE INSTANTIATIONS*************
    	HomePage homePage = new HomePage(driver,wait);
        Login loginPage = new Login(driver,wait);

        //*************PAGE METHODS********************
        
        
        //Open N11 HomePage
        homePage.goToN11();

        //Go to LoginPage
        homePage.goToLoginPage();

        //Login to N11 with first row of the login data
        loginPage.loginToN11(ExcelUtil.getRowData(1));

        //Set test row number to 1
        ExcelUtil.setRowNumber(1);

        //Set Test Status Column number to 5
        ExcelUtil.setColumnNumber(5);

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        //Verify password message by using excel's 2st row, 5th column
        //Row and Column numbers starting from 0. Thus we need to write 1 and 4, instead of 2 and 5!
        loginPage.verifyLoginPassword(ExcelUtil.getCellData(1,4));
    }

   
    public void invalidLoginTest_EmptyUserEmptyPassword () throws InterruptedException {
        

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        Login loginPage = new Login(driver,wait);

        //*************PAGE METHODS********************
        homePage.goToN11();
        homePage.goToLoginPage();

        //Login to N11 with second row of the login data
        loginPage.loginToN11(ExcelUtil.getRowData(2));

        //Set test row number to 2
        ExcelUtil.setRowNumber(2);

        //Set Test Status column number to 5
        ExcelUtil.setColumnNumber(5);

        //*************ASSERTIONS***********************
        Thread.sleep(500);
        //Verify by 3rd row and 4th column
        loginPage.verifyLoginUserName(ExcelUtil.getCellData(2,3));
        //Verify by 3rd row and 5th column
        loginPage.verifyLoginPassword(ExcelUtil.getCellData(2,4));
    }

}
}
