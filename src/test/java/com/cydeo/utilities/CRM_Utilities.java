package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
This class will store the method related to CRM project
 */
public class CRM_Utilities {
    //This method will login using below credentials
    // @username : "helpdesk2@cydeo.com"
    // @password : "UserUser"

    public static void login_crm(WebDriver driver){
        //3. Enter valid username
        WebElement usernameBox = driver.findElement(By.xpath("//input[@placeholder='Login']"));
        usernameBox.sendKeys("helpdesk2@cydeo.com");

        //4. Enter valid password
        WebElement passwordBox = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passwordBox.sendKeys("UserUser");

        //5. Click to `Log In` button
        WebElement logInButton = driver.findElement(By.className("login-btn"));
        logInButton.click();
    }

    public static void login_crm(WebDriver driver, String username, String password){
        //3. Enter valid username
        WebElement usernameBox = driver.findElement(By.xpath("//input[@placeholder='Login']"));
        usernameBox.sendKeys(username);

        //4. Enter valid password
        WebElement passwordBox = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passwordBox.sendKeys(password);

        //5. Click to `Log In` button
        WebElement logInButton = driver.findElement(By.className("login-btn"));
        logInButton.click();
    }





}
