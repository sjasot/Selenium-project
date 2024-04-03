package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Dropdowns_T6_T7_T8 {

    WebDriver driver;

@BeforeMethod
    public void setupMethod (){

    //1. Open Chrome browser
    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    //2. Go to https://practice.cydeo.com/dropdown
    driver.get("https://practice.cydeo.com/dropdown");

}

@AfterMethod
    public void tearDown(){
        driver.quit();
}


@Test
    public void dropdowns_task6() throws InterruptedException {

        //3. Select “December 1st, 1933” and verify it is selected.
    Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));

    Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));

    Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //Select year using : visible text
    Thread.sleep(2000);
    yearDropdown.selectByVisibleText("1933");

        //Select month using : value attribute
    Thread.sleep(2000);
    monthDropdown.selectByValue("11");

    //Select day using : index number
    Thread.sleep(2000);
    dayDropdown.selectByIndex(0);

    //create expected values
    String expectedYear = "1933";
    String expectedMonth = "December";
    String expectedDay = "1";

    //getting actual values from the browser
    String actualYear = yearDropdown.getFirstSelectedOption().getText();
    String actualMonth = monthDropdown.getFirstSelectedOption().getText();
    String actualDay = dayDropdown.getFirstSelectedOption().getText();

    Assert.assertEquals(actualYear, expectedYear);
    Assert.assertTrue(actualMonth.equals(expectedMonth));
    Assert.assertEquals(actualDay, expectedDay);
}

@Test
    public void dropdowns_task7() throws InterruptedException {

    //locate state select dropdown
    Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

    //3. Select Illinois
    Thread.sleep(2000);
    stateDropdown.selectByValue("IL");

    //4. Select Virginia

    Thread.sleep(2000);
    stateDropdown.selectByVisibleText("Virginia");
    //5. Select California

    Thread.sleep(2000);
    stateDropdown.selectByIndex(5);
    //6. Verify final selected option is California.

    String expectedResult = "California";
    String actualResult = stateDropdown.getFirstSelectedOption().getText();

    Assert.assertEquals(actualResult,expectedResult);


    //Use all Select options. (visible text, value, index)


}

@Test

    public void dropdowns_task8 () throws InterruptedException {

    //3. Click to non-select dropdown

    WebElement nonSelectDropdown = driver.findElement(By.linkText("Dropdown link"));
    Thread.sleep(2000);
    nonSelectDropdown.click();

    //4. Select Facebook from dropdown

    WebElement dropdownMenu = driver.findElement(By.xpath("//div[@aria-labelledby='dropdownMenuLink']"));
    WebElement facebookOption = dropdownMenu.findElement(By.xpath("//a[text()='Facebook']"));
    facebookOption.click();


    //5. Verify title is “Facebook - log in or sign up”

    String expectedTitle = "Facebook - log in or sign up";
    String actualTitle =  driver.getTitle();

    Assert.assertEquals(actualTitle,expectedTitle);

}

}
