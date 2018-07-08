package LoginTC01;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
//import org.junit.Test;

public class Login extends BasePage {

    //*********Constructor*********
    public Login(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Web Elements*********
    String usenameId = "email";
    String passwordId = "password";
    String loginButtonId = "loginButton";
    String errorMessageUsernameXpath = "//*[@id=\"txtuname_error\"]";
    String errorMessagePasswordXpath = "//*[@id=\"signinPanel_err\"]";

    //*********Page Methods*********
    //@Test()
    public void loginToN11 (XSSFRow row){
        //Enter Username(Email)
        writeText(By.id("txtuname"),row.getCell(1).toString());
        //Enter Password
        writeText(By.id("txtpwd"), row.getCell(2).toString());
        //Click Login Button
        click(By.id("btnsignin"));
    }

    //Verify Username Condition
    //@Test()
    public void verifyLoginUserName (String expectedUserNameMessage) {
        Assert.assertEquals(readText(By.xpath(errorMessageUsernameXpath)), expectedUserNameMessage);
    }

    //Verify Password Condition
    //@Test()
    public void verifyLoginPassword (String expectedPasswordMessage) {
        Assert.assertEquals(readText(By.xpath(errorMessagePasswordXpath)), expectedPasswordMessage);
    }

}

