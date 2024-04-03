package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T5_WindowsPractice {

    WebDriver driver;

    @BeforeMethod
    public void setupDriver(){
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to website: https://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void windows_test() {
        //4. Assert: Title is “Windows”
        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        String mainHandle = driver.getWindowHandle();

        //5. Click to: “Click Here” link
        WebElement clickLink = driver.findElement(By.linkText("Click Here"));
        clickLink.click();

        //6. Switch to new Window. We need to use driver.getWindowHandle() method
        // driver.getWindowHandles();
        //1 - windowHandle : mainHandle
        //2 - windowHandle : 2nd window

        for (String each : driver.getWindowHandles() ) {

            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: "+ driver.getTitle());
        }


        //7. Assert: Title is “New Window”
        String expectedNewTitle = "New Window";
        String actualNewTitle = driver.getTitle();

        Assert.assertEquals(actualNewTitle, expectedNewTitle);

        //if we have to go back to the main page to continue our test case
        // we can use mainHandle() to switch
        driver.switchTo().window(mainHandle);
        //code

    }


}
