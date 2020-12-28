package com.cybertek.tests.day2_locators_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_SmartBearLoginVerification {
    public static void main(String[] args) {

        /*
        TC#5:	Basic	login	authentication1-Open	a	chrome	browser2-Go	to:
        	http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        	3-Verify	title
        	equals:Expected:	Web	Orders	Login
        	4-Enter	username:	Tester


        	7-Verify	titleequals:Expected:	Web	Orders
         */

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        //3-Verify	title
        //        	equals:Expected:	Web	Orders	Login
        String expectedTitle = "Web Orders Login";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Landing page title verification PASSED!");
        }else{
            System.out.println("Landing page title verificaiton FAILED!");
        }

        // 4-Enter	username:	Tester

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("tester");

        //5-Enter	password:test

        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

       // 6-Click	“Sign	In”	button
        driver.findElement(By.className("button")).click();

        //7-Verify	titleequals:Expected:	Web	Orders

        String expectedLoginTitle = "Web Orders";
        String actualLoginTitle = driver.getTitle();

        if(actualLoginTitle.equals(expectedLoginTitle)){
            System.out.println("Login title verification Passed");
        }else{
            System.out.println("Login title verification Failed!");
            System.out.println("Expected login title: " + expectedLoginTitle);
            System.out.println("Actual login title: " + actualLoginTitle);
        }
    }
}

