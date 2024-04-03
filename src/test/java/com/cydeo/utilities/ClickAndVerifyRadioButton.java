package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ClickAndVerifyRadioButton {


    public  static void  clickAndVerifyRadioButton (WebDriver driver, String nameAttribute , String expectedID){

        // Locate all of the 'sports' radio buttons, and store them in a List<WebElement>
        //List<WebElement> sportsRadioButtons = driver.findElements(By.xpath("//input[@name='"+nameAttribute+"']"));
        List<WebElement> radioButtons = driver.findElements(By.name(nameAttribute));

        for (WebElement each : radioButtons) {
            String actualID = each.getAttribute("id");
            System.out.println("actualID = " + actualID);

            if(actualID.equals(expectedID)){
                each.click();
                System.out.println(actualID + " is Selected: " + each.isSelected());
                break;
            }
        }

    }


}
