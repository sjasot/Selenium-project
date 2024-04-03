package com.cydeo.tests.review.week2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T1_Navigations_GetMethods {

    public static void main(String[] args) throws InterruptedException {


        // 1. Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       /* File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // program that takes screenshots of every step?
        try{
            FileUtils.copyFile(screenshot, new File("C:\\Temp\\homePageScreenshot.png")); //i'm not sure how it works
        } catch (IOException e){
            e.printStackTrace();
        }

        */

        // 2. Go to: https://www.etsy.com
        driver.get("https://www.etsy.com");

        // 3. Navigate to https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        // 4. Navigate back, forward and refresh
        Thread.sleep(2000);
        driver.navigate().back();

        Thread.sleep(2000);
        driver.navigate().forward();

        Thread.sleep(2000);
        driver.navigate().refresh();


        // 5. Write “selenium” in search box
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Thread.sleep(2000);
        searchBox.sendKeys("selenium");


        // 6. Press search button to search
        WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));
        Thread.sleep(2000);
        searchButton.click();

        // 7. Verify title is "Amazon.com : selenium"
        String expectedInTitle = "Amazon.com : selenium";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedInTitle)){
            System.out.println("Title verification PASSED");
        }else{
            System.out.println("Title verification FAILED");
        }


        // 8. Verify url contains "selenium"
        String expectedInURL = "selenium";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedInURL)){
            System.out.println("URL contains 'selenium', verification PASSED");
        }else{
            System.out.println("URL DOES NOT contain 'selenium', verification FAILED");
        }



        Thread.sleep(2000);
        driver.close();


    }
}
