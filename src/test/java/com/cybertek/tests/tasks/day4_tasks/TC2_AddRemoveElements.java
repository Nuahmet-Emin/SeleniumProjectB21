package com.cybertek.tests.tasks.day4_tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TC2_AddRemoveElements {
    public static void main(String[] args) {
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2. Go to http://practice.cybertekschool.com/add_remove_elements/
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // 3. Click to “Add Element” button
        WebElement addElementButton = driver.findElement(By.xpath("//button[.='Add Element']"));
        addElementButton.click();

        // 4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));
        if(deleteButton.isDisplayed()){
            System.out.println("Delete button is displayed, verification passed!");
        }else{
            System.out.println("Delete button is not displayed, verification FAILED!!!");
        }

        // 5. Click to “Delete” button.
        deleteButton.click();
        // 6. Verify “Delete” button is NOT displayed after clicking
        if(!deleteButton.isDisplayed()){
            System.out.println("Delete button is not displayed, verification passed!");
        }else{
            System.out.println("Delete button is displayed, verification FAILED!!!");
        }


    }
}
