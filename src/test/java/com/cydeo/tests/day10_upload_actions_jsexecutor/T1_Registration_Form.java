package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Registration_Form {

@Test
    public void registration_form(){

    //1. Open browser
    //2. Go to website: https://practice.cydeo.com/registration_form

    Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.URL"));

    //3. Enter first name

    WebElement firstName = Driver.getDriver().findElement(By.name("firstname"));
    firstName.sendKeys("Tom");

    //4. Enter last name
    WebElement lastName = Driver.getDriver().findElement(By.name("lastname"));
    lastName.sendKeys("Cruse");

    //5. Enter username
    WebElement userName = Driver.getDriver().findElement(By.name("username"));
    userName.sendKeys("tomcruse");

    //6. Enter email address
    WebElement emailAddress = Driver.getDriver().findElement(By.name("email"));
    emailAddress.sendKeys("tom-cruse@hollywood.com");

    //7. Enter password
    WebElement password = Driver.getDriver().findElement(By.name("password"));
    password.sendKeys("1234567890");


    //8. Enter phone number
    WebElement phoneNumber = Driver.getDriver().findElement(By.name("phone"));
    phoneNumber.sendKeys("011-110-1111");

    //9. Select a gender from radio buttons

    WebElement gender = Driver.getDriver().findElement(By.xpath("//input[@value='male']"));
    gender.click();

    //10.Enter date of birth

    WebElement dateOfBirth = Driver.getDriver().findElement(By.name("birthday"));
    dateOfBirth.sendKeys("05/12/2002");

    //11.Select Department/Office

    Select departmentDropdown = new Select(Driver.getDriver().findElement(By.name("department")));
    departmentDropdown.selectByValue("TO");

    //12.Select Job Title

    Select jobTitle = new Select(Driver.getDriver().findElement(By.name("job_title")));
    jobTitle.selectByVisibleText("Product Owner");

    //13.Select programming language from checkboxes

    WebElement programLanguage = Driver.getDriver().findElement(By.id("inlineCheckbox2"));
    programLanguage.click();

    //14.Click to sign up button

    WebElement signUpButton = Driver.getDriver().findElement(By.id("wooden_spoon"));
    signUpButton.click();

    //15.Verify success message “You’ve successfully completed registration.” is
    //displayed.


    WebElement verifyMessage = Driver.getDriver().findElement(By.xpath("//div[@role='alert']"));

    Assert.assertTrue(verifyMessage.isDisplayed());

    Driver.closeDriver();

}


}
