package com.cydeo.tests.day07_webtabels_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_CRM_Login_Task {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Create new test and make set ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");
    }

    @Test
    public void login_test() {

        /*
        //3. Enter valid username
        WebElement usernameBox = driver.findElement(By.xpath("//input[@placeholder='Login']"));
        usernameBox.sendKeys("helpdesk2@cydeo.com");

        //4. Enter valid password
        WebElement passwordBox = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passwordBox.sendKeys("UserUser");

        //5. Click to `Log In` button
        WebElement logInButton = driver.findElement(By.className("login-btn"));
        logInButton.click();

         */

        CRM_Utilities.login_crm(driver, "helpdesk2@cydeo.com", "UserUser");



        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver,"(3) Portal");


        //      USERNAME            PASSWORD
        //helpdesk1@cydeo.com       UserUser
        //helpdesk2@cydeo.com       UserUser

    }

    @Test

    public void login_crm_test2() {
        // logging in using the utility method we created in CRM_Utilities class
        CRM_Utilities.login_crm(driver);


        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver,"(3) Portal");


        //      USERNAME            PASSWORD
        //helpdesk1@cydeo.com       UserUser
        //helpdesk2@cydeo.com       UserUser

    }


}
