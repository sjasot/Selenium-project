package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebOrderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_WebTables_Order_Verify {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.cydeo.com/web-tables");
    }


    @Test
    public void WebTables_practice_test(){


        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”

        WebElement BobsName = driver.findElement(By.xpath("//table[@class='SampleTable']//tr[7]//td[2]"));
        //Another option -> more specific and is useful if the table's order changes when we refresh:
        //locate Bob's cell using its name as a text: "//table[@class='SampleTable']//td[text()='Bob Martin']"
        System.out.println("BobsName.getText() = " + BobsName.getText());

        String expectedResult = "Bob Martin";
        String actualResult = BobsName.getText();

        Assert.assertEquals(actualResult,expectedResult);

        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021


        WebElement orderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[text()='Bob Martin']/following-sibling::td[3]"));

        System.out.println("orderDate.getText() = " + orderDate.getText());


        String dateExpectedResult = "12/31/2021";
        String dateActualResult = orderDate.getText();

        Assert.assertEquals(dateActualResult,dateExpectedResult);


    }

    @Test
    public void test2_use_verify_method(){

        //call the utility method we created
        String alexandraGray = WebOrderUtils.returnOrderDate(driver, "Alexandra Gray");

        System.out.println("alexandraGray = " + alexandraGray); // prints: alexandraGray = 04/15/2021

        WebOrderUtils.orderVerify(driver, "Alexandra Gray", "04/15/2021" );
    }


}
