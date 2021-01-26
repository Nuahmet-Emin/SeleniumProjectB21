package com.cybertek.tests.tasks.day4_tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC5_Apple_FindElements_02 {
    public static void main(String[] args) {
        //TC #02: FINDELEMENTS_APPLE
        // 1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // 2.Go to https://www.apple.com
        driver.get("https://www.apple.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // 3.Click to iPhone
        WebElement iPhone = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']"));
        iPhone.click();

        // 4.Print out the texts of all links
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

        int countLinkWithText = 0;
        int countLinkWithoutText = 0;

        for(WebElement eachLink: allLinks){
            String eachLinkText = eachLink.getText();
            System.out.println(eachLinkText );

            if(eachLinkText.isEmpty()){
                countLinkWithoutText++;
            }else {
                countLinkWithText++;
            }


        }
        // 5.Print out how many link is missing text
        System.out.println(countLinkWithoutText + " links are missing text");

        // 6.Print out how many link has text
        System.out.println(countLinkWithText + " links have text");

        // 7.Print out how many total link
        System.out.println("Total link: " + allLinks.size() );


    }
}
