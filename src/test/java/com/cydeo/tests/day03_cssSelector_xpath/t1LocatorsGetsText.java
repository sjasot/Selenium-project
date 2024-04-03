package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class t1LocatorsGetsText {

    public static void main(String[] args) {

        //1- Open a chrome browser
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
       WebDriver driver = WebDriverFactory.getDriver("chrome"); // custom created method in utilities
        driver.manage().window().maximize();


        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");


        //3- Enter incorrect username: “incorrect”
        WebElement usernamebox  = driver.findElement(By.name("USER_LOGIN"));
        usernamebox.sendKeys("incorrect");


        //4- Enter incorrect password: “incorrect”
        WebElement passwordBox  = driver.findElement(By.name("USER_PASSWORD"));
        passwordBox.sendKeys("incorrect");

        //5- Click to login button.
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
       String expectedMessage = "Incorrect login or password";
       String actualMessage =  driver.findElement(By.className("errortext")).getText();

       if (actualMessage.equals(expectedMessage)){
           System.out.println("Error message verification Passed");
       }else{
           System.out.println("Error message verification Failed");
       }


    }


}
