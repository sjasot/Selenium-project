package com.cydeo.tests.day02_Locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_LibraryVerification {
    public static void main(String[] args) {

        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //2. Go to https://library2.cybertekschool.com/login.html
        driver.get("https://library2.cybertekschool.com/login.html");


         // Locate username input box using “className” locator
        //3. Enter username: “incorrect@email.com”
        WebElement inputEmail = driver.findElement(By.className("form-control"));
        inputEmail.sendKeys("incorrect@email.com");

        //Locate password input box using “id” locator
        //4. Enter password: “incorrect password”
        WebElement password = driver.findElement(By.id("inputPassword"));
        password.sendKeys("incorrect password" );

        //Locate Sign in button using “tagName” locator
        WebElement signInButton = driver.findElement(By.tagName("button") );
        signInButton.click();

        //5. Verify: visually “Sorry, Wrong Email or Password” displayed
        // Verified












    }
}
