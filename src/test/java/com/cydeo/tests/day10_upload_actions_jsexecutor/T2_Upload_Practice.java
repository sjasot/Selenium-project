package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {


    @Test
    public void uploading_test(){

        //TC #2 Upload Test
        //1. Go to https://practice.cydeo.com/upload

        //Driver.getDriver().get(ConfigurationReader.getProperty("practice.cydeo.URL"));

        Driver.getDriver().get("https://practice.cydeo.com/upload");
        //2. Find some small file from your computer, and get the path of it.

        String filePath ="C:\\Users\\ASOT\\Desktop\\Fusssoooooo.txt";

        //3. Upload the file. Use sendKeys() method to pass the path of the file

        WebElement uploadFile = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
       // uploadFile.sendKeys("C:\\Users\\ASOT\\Desktop\\Fusssoooooo.txt");
        //or
        uploadFile.sendKeys(filePath);

        WebElement uploadButton = Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']"));
        uploadButton.click();

        //4. Assert:
        //-File uploaded text is displayed on the page

        WebElement displayedText = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(displayedText.isDisplayed());



    }

}
