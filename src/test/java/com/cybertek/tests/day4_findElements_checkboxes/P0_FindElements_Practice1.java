package com.cybertek.tests.day4_findElements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P0_FindElements_Practice1 {
    public static void main(String[] args) {
        //#1- Open chrome browser and go to: http://practice.cybertekschool.com/forgot_password
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//#2- Locate all of the LINKS on the page, and print out all the texts
        //1.find the locator that is returning us all of the links on the page
        // 2. store all of the links in to a List
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        // 3. create java logit to print out all of the texts of all links
        for(WebElement eachLink: listOfLinks){
            System.out.println(eachLink.getText());
        }
//#3- Print out how many links on the page

        System.out.println("Number of links: " + listOfLinks.size());
        driver.close();


    }
}
