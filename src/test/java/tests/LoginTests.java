package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utils.Listeners.Retry;

import java.lang.reflect.Method;

public class LoginTests extends BaseTest {
	

    // Extra information:
    // 1) @BeforeClass we declared driver and wait variables
    // 2) We send these driver and wait variables to the page class with below declaration
    //    Homepage homepage = new HomePage(driver,wait);
    // 3) super () method in page class transfer the driver and wait variables values to the BasePage class.

    //@Test (priority = 0, description="test1", retryAnalyzer = Retry.class)
    @Test
    public void invalidRegistrationTest_InvalidUserNameInvalidPassword (Method method) throws Exception {
        //ExtentReports Description
       // ExtentTestManager.startTest(method.getName(),"Invalid Registration Scenario with wrong username and password.");

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        //Open N11 HomePage
        homePage.goToHomePage();

        //Go to LoginPage
        homePage.goToLoginPage();

        
        loginPage.doLogin("Alisha", "test123");

        //*************ASSERTIONS***********************
        wait.until(ExpectedConditions.alertIsPresent());
        loginPage.verifyLoginPassword(("Failed! please enter strong password"));
    }

//    @Test (priority = 1, description="test2",retryAnalyzer = Retry.class)
//    public void invalidRegistrationTest_EmptyUserEmptyPassword (Method method) throws Exception  {
//        //ExtentReports Description
//       // ExtentTestManager.startTest(method.getName(),"Invalid registration Scenario with empty username and password.");
//
//        //*************PAGE INSTANTIATIONS*************
//        HomePage homePage = new HomePage(driver,wait);
//        LoginPage loginPage = new LoginPage(driver,wait);
//
//        //*************PAGE METHODS********************
//        homePage.goToHomePage();
//        homePage.goToLoginPage();
//
//        loginPage.doLogin("","");
//
//        //*************ASSERTIONS***********************
//        wait.until(ExpectedConditions.alertIsPresent());
//        loginPage.verifyLoginUserName("Failed! please enter password");
//        //loginPage.verifyLoginPassword("Failed! please enter password");
//    }

}
