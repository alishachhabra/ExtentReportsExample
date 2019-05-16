package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage{
	
	

    //*********Constructor*********
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Web Elements*********
//    String usenameId = "unameSignin";
//    String passwordId = "pwdSignin";
//    String loginButtonId = "btnsubmitdetails";
  

    //*********Page Methods*********

    public void doLogin (String username, String password){
        //Enter Username(Email)
       // writeText((By.id("unameSignin")),username);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnsubmitdetails")));
        driver.findElement(By.id("unameSignin")).sendKeys(username);
        //Enter Password
        writeText(By.id("pwdSignin"), password);
        //Click Login Button
        click(By.id("btnsubmitdetails"));
    }

    //Verify Username Condition
    public void verifyLoginUserName (String expectedText) {
    	
    	String errMsg = handleAlert();
        Assert.assertEquals(errMsg, expectedText);
    }

    //Verify Password Condition
    public void verifyLoginPassword (String expectedText) {
    	String errMsg = handleAlert();
        Assert.assertEquals(errMsg, expectedText);
    }

}
