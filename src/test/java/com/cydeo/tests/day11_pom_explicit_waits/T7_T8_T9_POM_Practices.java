package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T7_T8_T9_POM_Practices {

    LibraryLoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");
        loginPage = new LibraryLoginPage();
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void t7_field_required_error_message_test(){

        //TC #7: Required field error message test
        //3- Do not enter any information
        //4- Click to “Sign in” button
        loginPage.signInButton.click();

        //5- Verify expected error is displayed:
        //Expected: This field is required.

        Assert.assertTrue(loginPage.fieldRequiredErrorMessage.isDisplayed());
        //NOTE: FOLLOW POM DESIGN PATTERN

    }

    @Test
    public void t8_email_format_error_message_test(){

        //TC #8: Invalid email format error message test
        //3- Enter invalid email format
        loginPage.emailInput.sendKeys("info.gmail.com");
        loginPage.signInButton.click();

        //4- Verify expected error is displayed:
        //Expected: Please enter a valid email address.
        Assert.assertTrue(loginPage.enterValidEmailErrorMessage.isDisplayed());


        //NOTE: FOLLOW POM DESIGN PATTERN
    }

    @Test
    public void t9_wrong_email_or_password_error_message(){

        //TC #9: Library negative login

        //3- Enter incorrect username or incorrect password
        loginPage.emailInput.sendKeys("abs@something.com" + Keys.ENTER);

        //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password
        Assert.assertTrue(loginPage.wrongEmailErrorMessage.isDisplayed());



        //NOTE: FOLLOW POM DESIGN PATTERN


    }
}
