package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandlePractice {
    WebDriver driver;
    //1. Create a new class called: WindowHandlePractice
    //2. Create new test and make set ups
    //3. Go to : http://practice.cybertekschool.com/windows

    @BeforeMethod
    public void setUpMethod(){
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");

        //2. Go to website: http://practice.cybertekschool.com/windows
        driver.get("http://practice.cybertekschool.com/windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void window_handle_test(){
        //4. Assert: Title is “Practice”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice";
        Assert.assertEquals(actualTitle,expectedTitle);

        //5. Click to: “Click Here” text
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();
        String titleAfterClick = driver.getTitle();
        System.out.println("titleAfterClick = "+titleAfterClick);

        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

        Set<String> windowHandles =driver.getWindowHandles();

        //6. Switch to new Window.
       for(String each: windowHandles){
         driver.switchTo().window(each);

           System.out.println("Current title while switching = " + driver.getTitle());
       }
        //7. Assert: Title is “New Window”
        String finalExpectedTitle = "New Window";
        String finalActualTitle = driver.getTitle();

        Assert.assertEquals(finalActualTitle,finalExpectedTitle);
    }


    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
