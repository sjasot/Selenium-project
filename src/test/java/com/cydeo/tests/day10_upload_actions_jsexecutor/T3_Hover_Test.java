package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_Hover_Test {

    @Test
    public void hover_test(){

        //1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get("https://practice.cydeo.com/hovers");

        //2. Hover over to first image
        WebElement user1 = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[1]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(user1).perform();

        //3. Assert:
        //a. “name: user1” is displayed
        WebElement user1Message = Driver.getDriver().findElement(By.xpath("//h5[text()=\"name: user1\"]"));

        Assert.assertTrue(user1Message.isDisplayed());

        //4. Hover over to second image
        WebElement user2 = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[2]"));
        actions.moveToElement(user2).perform();

        //5. Assert:
        //a. “name: user2” is displayed
        WebElement user2Message = Driver.getDriver().findElement(By.xpath("//h5[text()=\"name: user2\"]"));

        Assert.assertTrue(user2Message.isDisplayed());

        //6. Hover over to third image
        WebElement user3 = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[3]"));
        actions.moveToElement(user3).perform();

        //7. Confirm:
        //a. “name: user3” is displayed
        WebElement user3Message = Driver.getDriver().findElement(By.xpath("//h5[text()=\"name: user3\"]"));

        Assert.assertTrue(user3Message.isDisplayed());

        Driver.closeDriver();

    }

}
