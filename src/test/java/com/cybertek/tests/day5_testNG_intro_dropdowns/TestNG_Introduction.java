package com.cybertek.tests.day5_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Introduction {

    @BeforeMethod
    public void setupMethod(){
        System.out.println("Before method is running...");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After method is running...");
    }

    @BeforeClass
    public void setupClass(){
        System.out.println("Before class is running");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("After class is running");
    }

    @Test
    public void test1(){
        System.out.println("Running test1...");
    }

    @Test
    public void test2(){
        System.out.println("Running test2...");
    }

    @Test
    public void test3(){
        System.out.println("Running test3...");

        String str1 = "hello";
        String str2 = "hello";

        Assert.assertTrue(str1.equals(str2), "Self note to ourself");

        Assert.assertEquals(str1,str2, "Asserting with assertEquals on line 56");
    }

}
