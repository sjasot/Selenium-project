package com.cydeo.tests.day09_review_javafaker_driverUtils;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T2_driverUtil_Practice {
    /*
    WebDriver driver;

    public void setUpMethod (){

        //1- Open a chrome browser
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

     */

    @Test
    public void bing_search_test(){

        //2- Go to: https://bing.com
        //Driver.getDriver() --> will return me the "driver"
        //instead of writing "driver" from now on, we will write Driver.getDriver()
        Driver.getDriver().get(ConfigurationReader.getProperty("bingURL"));


        //3- Write “apple” in search box
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//textarea[@id='sb_form_q']"));

        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Search
        String expectedResult = ConfigurationReader.getProperty("searchValue") + " - Search";
        String actualResult = Driver.getDriver().getTitle();

        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test
    public void bing_search_test2(){

        //2- Go to: https://bing.com
        //Driver.getDriver() --> will return me the "driver"
        //instead of writing "driver" from now on, we will write Driver.getDriver()
        Driver.getDriver().get(ConfigurationReader.getProperty("bingURL"));


        //3- Write “apple” in search box
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//textarea[@id='sb_form_q']"));

        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Search
        String expectedResult = ConfigurationReader.getProperty("searchValue") + " - Search";
        String actualResult = Driver.getDriver().getTitle();

        Assert.assertEquals(actualResult,expectedResult);

    }

    @AfterMethod
    public void tearDown(){

        //Driver.getDriver().quit(); //we won't be using the selenium's quit method directly anymore
        Driver.closeDriver();
    }
}
