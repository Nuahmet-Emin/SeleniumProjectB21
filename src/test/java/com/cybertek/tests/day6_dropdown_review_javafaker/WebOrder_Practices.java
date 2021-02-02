package com.cybertek.tests.day6_dropdown_review_javafaker;

import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.utilities.WebOrderUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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
    @Test
    public void test2_OrderPlacing() throws InterruptedException {
        /*TC#2: Smartbear software order placing
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        //3. Enter username: “Tester”
        //4. Enter password: “test”
          5. Click on Login button
        */

        //6. Click on Order

         WebElement order = driver.findElement(By.linkText("Order"));

        order.click();

        //7. Select familyAlbum from product, set quantity to 2
        Select productSelect = new Select(driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
        WebElement inputQuantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));

        productSelect.selectByVisibleText("FamilyAlbum");

        //inputQuantity.click();
        Thread.sleep(1000);
        inputQuantity.sendKeys(Keys.BACK_SPACE);
        inputQuantity.sendKeys("2");

        //8. Click to “Calculate” button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();

        //9. Fill address Info with JavaFaker

        //Locating web elements using ID locator
        WebElement nameinput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement streetInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement cityAddress = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement zipCode = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        //9. Fill address Info with JavaFaker
        Faker faker = new Faker();

        nameinput.sendKeys(faker.name().fullName());
        streetInput.sendKeys(faker.address().streetAddress());
        cityAddress.sendKeys(faker.address().cityName());

        zipCode.sendKeys(faker.address().zipCode().replaceAll("-",""));



        //• Generate: name, street, city, state, zip code
        //10. Click on “visa” radio button
        WebElement visaRadioButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaRadioButton.click();

        //11. Generate card number using JavaFaker
        WebElement inputCreditCard =driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        inputCreditCard.sendKeys(faker.finance().creditCard().replaceAll("-",""));

        //Enter expiration date
        WebElement inputExpirationDate = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        inputExpirationDate.sendKeys("01/26");

        //12. Click on “Process”
        WebElement processButton = driver.findElement(By.linkText("Process"));
        processButton.click();


        //13. Verify success message “New order has been successfully
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
        Assert.assertTrue(successMessage.isDisplayed(), "Success message is not displayed!!");
    }

    @AfterMethod
    public void tearDowMethod() throws InterruptedException {
        //additional 5 second before closing the browser
        Thread.sleep(5000);

        driver.close();
    }
}
