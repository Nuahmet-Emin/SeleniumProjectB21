package com.cybertek.tests.day9_driver_actions_uploads;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverPractice {

    @Test
    public void hover_test(){

        //1. Go to http://practice.cybertekschool.com/hovers
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

        // locationg all the web elements needed

        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement img2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement img3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        Actions actions = new Actions(Driver.getDriver());

        // 2. Hover over to first image
        actions.moveToElement(img1).perform();

        //3. Assert:
        //a. “name: user1” is displayed
        Assert.assertTrue(user1.isDisplayed(),"User1 is not displayed. FAILED!!!");

        // 4. Hover over to second image
        actions.moveToElement(img2).perform();
        //5. Assert:
        //a. “name: user2” is displayed
        Assert.assertTrue(user2.isDisplayed());

        // 6. Hover over to third image
        actions.moveToElement(img3).perform();

        //7. Confirm:
        //a. “name: user3” is displayed
        Assert.assertTrue(user3.isDisplayed(),"User3 is not displayed. FAILED!!!");


    }
}
