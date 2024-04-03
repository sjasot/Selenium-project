package com.cydeo.tests.review.week2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T2_Login {
    public static void main(String[] args) throws InterruptedException {

        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //it looks the given seconds or sooner to find the element
                                                                            // it will give time to the web app until webElement found
        // 2. Go to https://practice.cydeo.com/login
        driver.get("https://practice.cydeo.com/login");

        // 3. Enter username: "tomsmith"
        WebElement usernameInputBox = driver.findElement(By.cssSelector("input[name='username']"));
        Thread.sleep(2000); // stops/freezes our code for given seconds
        usernameInputBox.sendKeys("tomsmith");


        // 4. Enter password: "SuperSecretPassword"
        WebElement passwordInputBox = driver.findElement(By.name("password"));
        Thread.sleep(2000);
        passwordInputBox.sendKeys("SuperSecretPassword");

        // 5. Click to Login button
        WebElement LoginButton = driver.findElement(By.xpath("//button[.='Login']"));
        Thread.sleep(2000);
        LoginButton.click();

        // 6. Verify text displayed on page
        //    Expected: "You logged into a secure area!"
        String expectedText =  "You logged into a secure area!";
      //  String actualText = driver.findElement(By.cssSelector("div[class='flash success']")).getText();

       String actualText = driver.findElement(By.xpath("//div[normalize-space(text())='You logged into a secure area!']")).getText();


        //if (actualText.equals(expectedText)){ // equals() won't pass since there are more extra spaces in the actual text from the Web
        if (actualText.contains(expectedText)){
            System.out.println("Text verification PASSED");
        }else{
            System.out.println("actualText = " + actualText);
            System.out.println("expectedText = " + expectedText);
            System.out.println("Text verification Failed");
        }

        Thread.sleep(2000);
        driver.close();





    }
}
