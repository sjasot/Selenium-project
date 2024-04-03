package com.cydeo.tests.review.week2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_RegistrationFormTask {


        // TC#3: Registration Form Page Testing

        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/registration_form
        // 3. Verify title is as expected:
        // Expected: "Registration Form"


        // TC#4: Registration Form Page Filling Form Test

        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/registration_form
        // 3. Enter First name: "John"
        // 4. Enter Last name: "Smith"
        // 5. Enter Username: "johnsmith123"
        // 6. Enter Email address: "john.smith@email.com"
        // 7. Enter password: "John1234"
        // 8. Enter Phone number: "123-456-7890"
        // 9. Click to "Male" from Gender
        // 10. Enter Date of birth "01/28/1990"
        // 11. Select "Department of Engineering" from Department/Office dropdown
        // 12. Select "SDET" from Job title dropdown
        // 13. Click to "Java" from languages
        // 14. Click to "Sign up" button
        // 15. Verify text displayed on page
        //     Expected: "Well done!"

   @BeforeMethod
   public void setup(){
       // 1. Open Chrome browser
       WebDriver driver = WebDriverFactory.getDriver("chrome");
       driver. manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       // 2. Go to https://practice.cydeo.com/registration_form
       driver.get("https://practice.cydeo.com/registration_form");
   }





    @Test
    public void registrationFormPageTest(){
        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver. manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Go to https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        // 3. Verify title is as expected:
        // Expected: "Registration Form"
        String expectedTitle = "Registration Form";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.equals(expectedTitle),"Title verification FAILED");


    }


}
