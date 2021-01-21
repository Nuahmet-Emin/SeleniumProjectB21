package com.cybertek.tests.tasks.day4_tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC3_Delete_50_FindElements {
    public static void main(String[] args) {
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // 2. Go to http://practice.cybertekschool.com/add_remove_elements/
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        // 3. Click to “Add Element” button 50 times
        WebElement addElementButton = driver.findElement(By.xpath("//button[.='Add Element']"));
        for(int i =1; i<=50; i++){
            addElementButton.click();
        }

        // 4. Verify 50 “Delete” button is displayed after clicking.
        List<WebElement> allDeleteButtons = driver.findElements(By.xpath("//body//button[.='Delete']"));
        int countDeleteButtons = 0;
        for(WebElement eachDeleteButton : allDeleteButtons){
           if(eachDeleteButton.isDisplayed()){
               countDeleteButtons++;
           }
        }
        System.out.println(countDeleteButtons);
        if(countDeleteButtons == 50){
            System.out.println("All 50 delete button is displayed, verification Passed!!!");
        }else{
            System.out.println("All 50 delete button is not displayed, verification FAILED!!!");
        }

        // 5. Click to ALL “Delete” buttons to delete them.

        for(WebElement eachDeleteButton : allDeleteButtons){
            eachDeleteButton.click();
        }
        // 6. Verify “Delete” button is NOT displayed after clicking.
        System.out.println(allDeleteButtons.get(0).isDisplayed());
    }
}
