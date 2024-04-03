package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlPage {

    public DynamicControlPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//button[text()='Remove']")
    public WebElement removeButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkBox;

    @FindBy(id="message")
    public WebElement message;

    @FindBy(id="loading")
    public WebElement loadingBar;


    @FindBy(xpath = "//button[text()='Enable']")
    public WebElement enableButton;


    @FindBy(xpath = "//p[text()=\"It's enabled!\"]")
    public WebElement enableMessage;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement enableInputBox;




}
