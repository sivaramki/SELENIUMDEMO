package LoginTC01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import LoginTC01.BasePage;
//import io.qameta.allure.Step;
//import org.junit.Test;	

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Page Variables*********
    String baseURL = "http://myaccount.sulekha.com/html/newsigninv5.html";

    //*********Web Elements*********
    String signInButtonClass = "btnSignIn";


    //*********Page Methods*********

    //Go to Homepage
    
    public void goToN11 (){
        driver.get(baseURL);
        driver.navigate().to(baseURL);
    }

    //Go to LoginPage
    
    public void goToLoginPage (){
        click(By.className(signInButtonClass));
    }

}
