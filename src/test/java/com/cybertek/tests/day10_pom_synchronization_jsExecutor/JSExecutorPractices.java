package com.cybertek.tests.day10_pom_synchronization_jsExecutor;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sun.security.util.DerEncoder;

public class JSExecutorPractices {

    @Test
    public void scrol_using_jsexecutor_test1(){
        // Get the page
        Driver.getDriver().get("http://practice.cybertekschool.com/infinite_scroll");

        // Create instance of JSExecutor and cast our driver type to it
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // Use "js" to reach JavascriptExecutor methods

        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");
        }

    }

    @Test
    public void using_jsexecutor_test2(){
        Driver.getDriver().get("http://practice.cybertekschool.com/large");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));


        // us "js" with different javascript function
        js.executeScript("arguments[0].scrollIntoView(true)", cybertekSchoolLink);
        // this functions says: scrollTo first argument (argument[0])

        BrowserUtils.sleep(2);
        js.executeScript("arguments[0].scrollIntoView(true)",homeLink);

    }

}
