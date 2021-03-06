package Visibility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
public class Visibility {

       /**
        * @param args
     * @throws MalformedURLException 
        */

       public static void main(String[] args) throws MalformedURLException {

              // objects and variables instantiation
                       // System.setProperty("webdriver.firefox.marionette","D:\\siva\\eclipse\\workspace\\Demo01\\drivers\\geckodriver.exe");
                   DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
                   System.setProperty("webdriver.chrome.driver", "/home/ec2-user/SELENIUMDEMO/Demo01/drivers/chromedriver.exe");
                   WebDriver driver = new RemoteWebDriver(new URL("http://52.15.40.24:4455/wd/hub"), chromeCapabilities);
              
              
              String appUrl = "https://google.com";

              // launch the firefox browser and open the application url
              driver.get(appUrl);

              // maximize the browser window
              driver.manage().window().maximize();

              // declare and initialize the variable to store the expected title of the webpage.
              String expectedTitle = "Google";

              // fetch the title of the web page and save it into a string variable
              String actualTitle = driver.getTitle();

              // compare the expected title of the page with the actual title of the page and print the result
              if (expectedTitle.equals(actualTitle))
              {
                     System.out.println("Verification Successful - The correct title is displayed on the web page.");
              }
              else
              {
                     System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
              }

              // verify if the �Google Search� button is displayed and print the result
              boolean submitbuttonPresence=driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")).isDisplayed();
              System.out.println(submitbuttonPresence);

              // enter the keyword in the �Google Search� text box by which we would want to make the request
              WebElement searchTextBox = driver.findElement(By.id("lst-ib"));
              //searchTextBox.clear();
              searchTextBox.sendKeys("Selenium");
              searchTextBox.sendKeys(Keys.TAB);

              // verify that the �Search button� is displayed and enabled
              boolean searchIconPresence = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")).isDisplayed();
              boolean searchIconEnabled = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")).isEnabled();

              if (searchIconPresence==true && searchIconEnabled==true)
              {
                     // click on the search button
                     WebElement searchIcon = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]"));
                     searchIcon.click();
              }
              else
              // close the web browser
              {
              driver.close();
              System.out.println("Unable to search");
              }
              
              
              System.out.println("Test script executed successfully.");
              driver.close();

              // terminate the program
              System.exit(0);
       }
}
