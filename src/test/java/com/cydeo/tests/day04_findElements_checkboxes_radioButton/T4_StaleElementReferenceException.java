package com.cydeo.tests.day04_findElements_checkboxes_radioButton;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T4_StaleElementReferenceException {

    public static void main(String[] args) throws InterruptedException {

        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //2- Go to: https://practice.cydeo.com/abtest

        driver.get("https://practice.cydeo.com/abtest");

        //3- Locate “CYDEO” link, verify it is displayed.

        WebElement linkCydeo = driver.findElement(By.cssSelector("a[href='https://cydeo.com/']"));
        System.out.println("Before refreshing: linkCydeo.isDisplayed() expecting TRUE = " + linkCydeo.isDisplayed());



        Thread.sleep(3000);
        //4- Refresh the page.

        driver.navigate().refresh();



        //5- Verify it is displayed, again.
        linkCydeo = driver.findElement(By.cssSelector("a[href='https://cydeo.com/']")); // handles StaleElementReferenceException by reassigning the variable
        System.out.println("After refreshing: linkCydeo.isDisplayed() expecting TRUE = " + linkCydeo.isDisplayed());


        //This is a simple StaleElementReferenceException to understand what is
        //this exception and how to handle it.


        driver.close();


    }
}
