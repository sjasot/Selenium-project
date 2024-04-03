package com.cydeo.tests.day04_findElements_checkboxes_radioButton;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_practices {
    public static void main(String[] args) throws InterruptedException {

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)
        //a. “Home” link
        WebElement homeLink = driver.findElement(By.cssSelector("a[class='nav-link']")); //tagName[attribute='value']

        //b. “Forgot password” header
        WebElement headerForgotPassword = driver.findElement(By.xpath("//h2[.='Forgot Password']")); //   //tagName[.='text']  same as //tagName[text()='text']

        //c. “E-mail” text
        WebElement emailText = driver.findElement(By.cssSelector("label[for='email']"));

        //d. E-mail input box
        WebElement emailInputBox = driver.findElement(By.xpath("//input[@type='text']"));

        //e. “Retrieve password” button
        WebElement passwordButton = driver.findElement(By.cssSelector("i[class='icon-2x icon-signin']"));

        //f. “Powered by Cydeo" text
        WebElement textPoweredByCydeo = driver.findElement(By.xpath("//div[@style='text-align: center;']"));


        //4. Verify all web elements are displayed.


        System.out.println("homeLink.isDisplayed() = " + homeLink.isDisplayed());
        System.out.println("headerForgotPassword.isDisplayed() = " + headerForgotPassword.isDisplayed());
        System.out.println("emailText.isDisplayed() = " + emailText.isDisplayed());
        System.out.println("emailInputBox.isDisplayed() = " + emailInputBox.isDisplayed());
        System.out.println("passwordButton.isDisplayed() = " + passwordButton.isDisplayed());
        System.out.println("textPoweredByCydeo.isDisplayed() = " + textPoweredByCydeo.isDisplayed());


        //First solve the task with using cssSelector only. Try to create 2 different
        //cssSelector if possible
        //Then solve the task using XPATH only. Try to create 2 different
        //XPATH locator if possible

        Thread.sleep(3000); // waits 3 sec before closing
        driver.close();





    }
}
