package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoad7Page {

    //1. Initialize the driver and object

    public  DynamicLoad7Page (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //#2 - Use @FindBy annotation instead of findElement() method

    @FindBy(xpath = "//strong[text()='Done!']")
    public WebElement doneMessage;

    @FindBy(xpath = "//img[@alt='square pants']")
    public WebElement spongeBobImage;

}
