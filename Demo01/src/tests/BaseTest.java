package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import utils.excelutils.ExcelUtil;


public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    //Global test data excel file
    public static final String testDataExcelFileName = "D:\\siva\\eclipse\\workspace\\Selenium_Demo01\\Login_TC01.xlsx";


    public BaseTest(WebDriver driver, WebDriverWait wait) {
		// TODO Auto-generated constructor stub
    	 this.driver = driver;
         this.wait = wait;
	}


	public WebDriver getDriver() {
        return driver;
    }


    @BeforeClass ()
    public void setup () {
        //Create a Chrome driver. All test classes use this.
    	System.setProperty("webdriver.chrome.driver", "D:\\siva\\eclipse\\workspace\\Demo01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        
        //Create a wait. All test classes use this.
        wait = new WebDriverWait(driver,15);

        //Maximize Window
        driver.manage().window().maximize();
    }

    @AfterClass()
    public void teardown () {
        driver.quit();
    }

}
