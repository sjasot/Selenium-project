package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class Understanding_closeDriver_method {

    @Test
    public void test1 (){

        Driver.getDriver().get("http://google.com");
        //verify something
        //Driver.getDriver().quit();
        Driver.closeDriver();
    }

    @Test
    public void test2 (){
        Driver.getDriver().get("http://google.com");
        //verify something else
        //Driver.getDriver().quit();
        Driver.closeDriver();
    }

    @Test
    public void test3 (){
        Driver.getDriver().get("http://google.com");
        //verify something completely different
        Driver.closeDriver();
    }
}
