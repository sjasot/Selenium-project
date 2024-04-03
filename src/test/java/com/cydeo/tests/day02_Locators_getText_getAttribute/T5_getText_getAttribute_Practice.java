package com.cydeo.tests.day02_Locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_getText_getAttribute_Practice {
    public static void main(String[] args) {

        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        //3- Verify header text is as expected:
        //Expected: Registration form
        WebElement header = driver.findElement(By.tagName("h2"));

        String expectedHeaderText = "Registration form";
        String actualHeaderText = header.getText();

        if (actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Verification Passed!");
        }else{
            System.out.println("Verification Fail!!!");
        }

        //4- Locate “First name” input box
        WebElement firstNameInputBox = driver.findElement(By.name("firstname"));

        //5- Verify placeholder attribute’s value is as expected:
        //Expected: first name
        String expectedAttributeValue = "first name";
        String actualAttributeValue = firstNameInputBox.getAttribute("placeholder");

        if (actualAttributeValue.equals(expectedAttributeValue)){
            System.out.println("Placeholder attribute verification Passed!");
        }else {
            System.out.println("Placeholder attribute verification Failed!");
        }








    }
}
