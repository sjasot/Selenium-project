package com.cydeo.tests.day12_review;

import com.cydeo.pages.W3Page;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_DoubleClick_Practice {

    @Test
    public void t1_double_click_test(){

        //TC #1: Double Click Test
        //1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        //2. Switch to iframe.

        Driver.getDriver().switchTo().frame("iframeResult");

        //3. Double click on the text “Double-click me to change my text color.”
        //using W3Page object to reach to the "paragraph" webElement
        W3Page W3Page = new W3Page();
        Actions actions = new Actions(Driver.getDriver());

        actions.doubleClick(W3Page.paragraph).perform();

        //4. Assert: Text’s “style” attribute value contains “red”.

        //using Actions object to be able to "double-click" to the given WebElement
        String actualAttributeValue = W3Page.paragraph.getAttribute("style");
        String expectedInAttributeValue = "red";

        Assert.assertTrue(actualAttributeValue.contains(expectedInAttributeValue));


    }
}
