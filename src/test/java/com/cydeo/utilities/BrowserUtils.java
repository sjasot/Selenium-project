package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

/*
This class will be storing only the utility methods that can be used across the projects
 */
public class BrowserUtils {

    /*
    This method will accept int and execute Thread.sleep method for given duration
    Arg: int second
     */

    public static void sleep(int second){
        second *= 1000; // converting milliseconds to seconds
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

    public static void switchWindowAndVerify(WebDriver driver, String expectedInURL, String expectedInTitle){
        //4. Create a logic to switch to the tab where window is open

        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {

            driver.switchTo().window(each);
            System.out.println("Current URL: " + driver.getCurrentUrl() );
            if (driver.getCurrentUrl().contains(expectedInURL)){
                break;
            }
        }

        //5. Assert: Title contains “expectedInTitle”

        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    public static void verifyTitleContains(WebDriver driver, String expectedTitle){
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
    }

    //this method accepts WebElement target and waits for that WebElement not to be displayed on the page
    public static void waitForInvisibilityOf(WebElement target){
        //Create the object of "WebDriverWait" class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the "wait" object with the proper syntax to create explicit wait condition
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    //this method accepts String title and waits for that title to contain given String value
    public static void waitForTitleContains(String title){
        //Create the object of "WebDriverWait" class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the "wait" object with the proper syntax to create explicit wait condition
        wait.until(ExpectedConditions.titleContains(title));
    }





}
