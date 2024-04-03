package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_cssSelector {
    public static void main(String[] args) {

        //1- Open a Chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/

        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “Log in” button text is as expected:
        //Expected: Log In

        String expectedLogIn = "Log In";
        WebElement LogInButton = driver.findElement(By.cssSelector("input[value='Log In']"));

        String actualLogIn = LogInButton.getAttribute("value");

        if(actualLogIn.contains(expectedLogIn)){
            System.out.println("Verification Log In button Passed");
        }else {
            System.err.println("Verification Log In button Failed");
        }




    }
}
