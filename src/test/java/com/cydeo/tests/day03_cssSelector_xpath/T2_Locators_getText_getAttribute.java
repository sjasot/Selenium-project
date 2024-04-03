package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_Locators_getText_getAttribute {
    public static void main(String[] args) {

        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        String expectedRememberMeLabel = "Remember me on this computer";
        String actualRememberMeLabel = driver.findElement(By.className("login-item-checkbox-label")).getText();

        if (actualRememberMeLabel.equals(expectedRememberMeLabel)){
            System.out.println("remember me text label verification PASSED");
        }else{
            System.out.println("remember me text label verification FAILED");
        }

        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        String expectedForgotPasswordText = "FORGOT YOUR PASSWORD?"; // gave an exception since required docs says "Forgot your password?"

        WebElement forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));
        String actualForgotPasswordText = forgotPasswordLink.getText();

        if (actualForgotPasswordText.equals(expectedForgotPasswordText)){
            System.out.println("forgot password link text verification PASSED");
        }else{
            System.out.println("actualForgotPasswordText = " + actualForgotPasswordText);
            System.out.println("expectedForgotPasswordText = " + expectedForgotPasswordText);
            System.out.println("forgot password link text verification FAILED");
        }

        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes
        String expectedHrefValue = "forgot_password=yes";
        String actualHrefValue = forgotPasswordLink.getAttribute("href");

        if (actualHrefValue.contains(expectedHrefValue)){
            System.out.println("forgot password” href attribute’s value verification PASSED");
        }else{
            System.out.println("forgot password” href attribute’s value verification FAILED");
        }











    }
}
