package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_T2_T3_Alert_Practices {

    WebDriver driver;

    @BeforeMethod
    public void setupDriver(){
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }



    @Test
    public void informationAlert_t1 (){

        //3. Click to “Click for JS Alert” button
        WebElement jsAlertButton = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        jsAlertButton.click();

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();


        //5. Verify “You successfully clicked an alert” text is displayed.

        String expectedResult = "You successfully clicked an alert";
        String actualResult = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(expectedResult,actualResult);



    }

    @Test
    public void confirmation_alert (){

        // 3. Click to “Click for JS Confirm” button
        WebElement jsConfirmButton = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        jsConfirmButton.click();

        //4. Click to OK button from the alert

        Alert alert = driver.switchTo().alert(); //switching attention from Selenium to javascript alert
        alert.accept();

        // 5. Verify “You clicked: Ok” text is displayed.

        String expectedResult = "You clicked: Ok";
        String actualResult = driver.findElement(By.xpath("//p[text()='You clicked: Ok']")).getText();

        Assert.assertEquals(actualResult,expectedResult);


    }


    @Test
    public void prompt_alert_task3() throws InterruptedException {

        //3. Click to “Click for JS Prompt” button
        WebElement promptAlert = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        promptAlert.click();

        //4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.sendKeys("hello");

        //5. Click to OK button from the alert
        Thread.sleep(2000);
        alert.accept();

        //6. Verify “You entered: hello” text is displayed.

        WebElement textResult = driver.findElement(By.id("result"));

        Assert.assertTrue(textResult.isDisplayed(), "Result text is NOT displayed");




    }







    }



