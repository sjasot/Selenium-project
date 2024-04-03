package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws InterruptedException {

        //Setup browser driver
        WebDriverManager.chromedriver().setup();

        //create instance of Chrome browser
        WebDriver driver = new ChromeDriver();

        // this line will maximize the currently opened browser
        driver.manage().window().maximize();
       // driver.manage().window().fullscreen(); // makes it fullscreen

        //go to tesla.com
        driver.get("https://www.tesla.com");

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //get title of the page
        //System.out.println("driver.getTitle() = " + driver.getTitle());
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        //user navigate back() to go back
        driver.navigate().back();

        //stop execution for 3 seconds
        Thread.sleep(3000);

        //user navigate forward() to go forward
        driver.navigate().forward();

        //stop execution for 3 seconds
        Thread.sleep(3000);

        //user refreshes the page using navigate.refresh()
        driver.navigate().refresh();

        //stop execution for 3 seconds
        Thread.sleep(3000);

        //navigate to google.com using navigate().to()
        driver.navigate().to("https://www.google.com");

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //get title of the page
        //System.out.println("driver.getTitle() = " + driver.getTitle());
        currentTitle = driver.getTitle(); // reassigns from tesla title to the Google title
        System.out.println("currentTitle = " + currentTitle);

        driver.close(); // closes currently focused window

        // driver.quit(); // closing all of the opened browsers






    }
}
