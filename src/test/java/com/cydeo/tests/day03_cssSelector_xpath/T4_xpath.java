package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_xpath {
    public static void main(String[] args) {

        //1- Open a Chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/

        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “Log in” button text is as expected:
        //Expected: Log In
        String expectedLogIn = "Log In";

        //tagName[@attribute='value']  // syntax of xpath

        //Locating logInButton using xpath type attribute and it's value
        //WebElement LogInButton = driver.findElement(By.xpath("//input[@type='submit']"));

        // Locating logInButton using xpath value attribute and it's value
        //WebElement LogInButton = driver.findElement(By.xpath("input[@value='Log In']"));

        // Locating logInButton using xpath class attribute and value
        WebElement LogInButton = driver.findElement(By.xpath("//input[@class='login-btn']"));

        String actualLogIn = LogInButton.getAttribute("value");

        if(actualLogIn.contains(expectedLogIn)){
            System.out.println("Verification Log In button Passed");
        }else {
            System.err.println("Verification Log In button Failed");
        }

    }
}
