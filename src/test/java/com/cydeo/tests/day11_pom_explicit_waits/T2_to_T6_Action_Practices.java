package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T2_to_T6_Action_Practices {

    @BeforeMethod
    public void setupMethod(){
        //1. Go to https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");

    }

    @AfterMethod
    public void tearDownMethod(){
        Driver.closeDriver();
    }

    @Test
    public void test1_drag_and_drop_default_verification(){
        //TC1 #: Drag and drop default value verification
        //2. Verify big circle default text is as below.

        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        //3. Assert:
        //-Text in big circle changed to: “Drag the small circle here.”

        String actualDefaultCircleText = bigCircle.getText();
        String expectedDefaultCircleText = "Drag the small circle here.";

        Assert.assertEquals(actualDefaultCircleText,expectedDefaultCircleText);

    }

    @Test
    public void test2_drag_and_drop_to_big_circle (){


        //TC2 #: Drag and drop into the big circle
        //2. Drag and drop the small circle to bigger circle.

        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        Actions actions = new Actions(Driver.getDriver());

        actions.dragAndDrop(smallCircle,bigCircle).perform();

        //3. Assert:
        //-Text in big circle changed to: “You did great!”

        String expectedBigCircleText = "You did great!";
        String actualBigCircleText = bigCircle.getText();

        Assert.assertEquals(actualBigCircleText,expectedBigCircleText);

    }

    @Test
    public void test3_click_and_hold_small_circle (){

        //TC4 #: Click and hold
        //2. Click and hold the small circle.

        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement CydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        Actions actions = new Actions(Driver.getDriver());

        actions.clickAndHold(smallCircle).moveToElement(CydeoLink).perform();

        //3. Assert:
        //-Text in big circle changed to: “Drop here.”

        String expectedBigCircleText = "Drop here.";
        String actualBigCircleText = bigCircle.getText();

        Assert.assertEquals(actualBigCircleText,expectedBigCircleText);

    }

    @Test
    public void test4_drag_and_drop_outside_big_circle (){

        //2. Drag and drop the small circle to bigger circle.

        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement CydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        Actions actions = new Actions(Driver.getDriver());

        actions.dragAndDrop(smallCircle,CydeoLink).release().perform();

        //3. Assert:
        //-Text in big circle changed to: “Try again!”

        String expectedBigCircleText = "Try again!";
        String actualBigCircleText = bigCircle.getText();

        Assert.assertEquals(actualBigCircleText,expectedBigCircleText);


    }


    @Test
    public void test5_drag_and_hover () {

        //2. Drag the small circle on top of the big circle, hold it, and verify.

        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        Actions actions = new Actions(Driver.getDriver());

        actions.clickAndHold(smallCircle).moveToElement(bigCircle).perform();

        //3. Assert:
        //-Text in big circle changed to: “Now drop...”

        String expectedBigCircleText = "Now drop...";
        String actualBigCircleText = bigCircle.getText();

        Assert.assertEquals(actualBigCircleText,expectedBigCircleText);

    }

}
