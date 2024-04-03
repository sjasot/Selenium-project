package com.cydeo.tests.day12_review;

import com.cydeo.pages.DynamicControlPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T2_T3_ExplicitWait_Practices {

    @BeforeMethod
    public void setUp(){
        //TC #2: Explicit wait practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
    }

    @AfterMethod
    public void tearDown (){
        Driver.closeDriver();
    }


    @Test
    public void t2_remove_checkbox_test(){

        //3- Click to “Remove” button
        DynamicControlPage dynamicControlPage = new DynamicControlPage();
        dynamicControlPage.removeButton.click();

        //4- Wait until “loading bar disappears”
        //Create the object of "WebDriverWait" class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the "wait" object with the proper syntax to create explicit wait condition
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlPage.loadingBar));

        //5- Verify:
        //a. Checkbox is not displayed

        //Assert.assertTrue(!dynamicControlPage.checkBox.isDisplayed()); // one way of doing it

        try{
            Assert.assertFalse(dynamicControlPage.checkBox.isDisplayed());
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("NoSuchElementException is thrown. It means that the Checkbox is not on the page");
            Assert.assertTrue(true);
        }

        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlPage.message.isDisplayed());
    }

    @Test
    public void t3_click_enable_button_test(){


        //3- Click to “Enable” button

        DynamicControlPage dynamicControlPage = new DynamicControlPage();
        dynamicControlPage.enableButton.click();


        //4- Wait until “loading bar disappears”

       // WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.invisibilityOf(dynamicControlPage.loadingBar));


        //using custom utility method
        BrowserUtils.waitForInvisibilityOf(dynamicControlPage.loadingBar);

        //5- Verify:
        //a. Input box is enabled.

        Assert.assertTrue(dynamicControlPage.enableInputBox.isEnabled());


        //b. “It’s enabled!” message is displayed.

        Assert.assertTrue(dynamicControlPage.enableMessage.isDisplayed());

        Assert.assertTrue(dynamicControlPage.enableMessage.getText().equals("It's enabled!")); //asserts that the expected and actual texts are equal




    }
}
