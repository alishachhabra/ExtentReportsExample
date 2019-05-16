package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    Alert alert;

    //Constructor
    public BasePage (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    //Click Method
    public void click (By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    //Write Text
    public void writeText (By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    //Read Text
    public String readText (By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }
    
    public String handleAlert() {
    	String errMsg;
    	if(isAlertPresent()) {
    		//Alert alert = driver.switchTo().alert();
    		errMsg = alert.getText();
    		alert.accept();
    		
    	}else {
    		errMsg = "no Alert";
    	}
		return errMsg;
    	
    	
    }
    
    public boolean isAlertPresent(){
    	 try{
    	  alert = driver.switchTo().alert();
    	  return true;
    	 }catch(NoAlertPresentException ex){
    	  return false;
    	 }
    }
}
