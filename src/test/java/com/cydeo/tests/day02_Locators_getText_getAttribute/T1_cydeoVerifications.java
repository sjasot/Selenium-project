package com.cydeo.tests.day02_Locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class T1_cydeoVerifications {

    public static void main(String[] args) {

        // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Go to https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

        // 3. Verify URL contains
        //    Expected: cydeo
        String expectedInURL = "cydeo";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedInURL)){
            System.out.println("URL verification PASSED!!!");
        }else {
            System.out.println("URL verification FAILED!!!");
        }

       // 4. Verify title:
       // Expected: Practice
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

       if (actualTitle.equals(expectedTitle)){
           System.out.println("Title verification PASSED!!!");
       }else{
           System.out.println("Title verification FAILED!!!");
       }

       //close browser
        driver.close();





    }
}
