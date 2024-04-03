package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {

    //#1 - Initialize the object of the class and driver instance inside the constructor
    public LibraryLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //#2 - Use @FindBy annotation instead of findElement() method

    @FindBy(id="inputEmail")
    public WebElement emailInput;

    @FindBy(id="inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath="//button[text()=\"Sign in\"]")
    public WebElement signInButton;

    @FindBy(xpath="//div[text()=\"This field is required.\"]")
    public WebElement fieldRequiredErrorMessage;

    @FindBy(xpath="//div[text()=\"Please enter a valid email address.\"]")
    public WebElement enterValidEmailErrorMessage;

    @FindBy(xpath="//div[text()=\"Sorry, Wrong Email or Password\"]")
    public WebElement wrongEmailErrorMessage;



}
