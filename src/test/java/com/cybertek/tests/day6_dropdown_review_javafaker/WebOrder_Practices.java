package com.cybertek.tests.day6_dropdown_review_javafaker;

import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.utilities.WebOrderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebOrder_Practices {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        //2. Go to http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebOrderUtils.loginToSmartBear(driver);

    }


    @Test
    public void test1_link_verification(){




        //6. Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

        System.out.println("Number of all links on this page: " + allLinks.size());

        //7. Print out each link text on this page
        for (WebElement eachLink : allLinks) {
            System.out.println("eachLink: " +eachLink.getText());

        }


    }

    @AfterMethod
    public void tearDowMethod() throws InterruptedException {
        //additional 5 second before closing the browser
        Thread.sleep(5000);

        driver.close();
    }
}
