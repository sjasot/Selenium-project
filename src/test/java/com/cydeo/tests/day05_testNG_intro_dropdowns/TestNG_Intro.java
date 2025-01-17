package com.cydeo.tests.day05_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Intro {


    @BeforeMethod
    public void setupMethod (){
        System.out.println("-->>> Before method is running ... ");
    }
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("-->>> After method is running ... ");
    }


    @Test (priority = 2)
    public void test1(){
        System.out.println("Test 1 is running ...");


          String actual = "apple";
          String expected = "apple";


          Assert.assertEquals(actual,expected);


    }

    @Test (priority = 1)
    public void test2(){
        System.out.println("Test 2 is running ...");

        String expected = "white";
        String actuale =  "white" ;
        Assert.assertTrue(actuale.equals(expected));



    }



}
