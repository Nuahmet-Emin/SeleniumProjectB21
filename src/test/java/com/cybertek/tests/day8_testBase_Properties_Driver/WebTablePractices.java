package com.cybertek.tests.day8_testBase_Properties_Driver;

import com.cybertek.tests.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.utilities.WebOrderUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebTablePractices extends TestBase {


    @Test
    public void verify_order_test() throws InterruptedException, IOException {
        // 1. create properties class object
        Properties properties = new Properties();

        // 2. open the file in JVM Memory and pass the path of the file
        String path = "configuration.properties";

        FileInputStream file = new FileInputStream(path);

        // 3. Load the opened file into the Properties object

        properties.load(file);

        String url = properties.getProperty("webOrderUrl");

        driver.get(url);

        WebOrderUtils.loginToSmartBear(driver);

        BrowserUtils.sleep(1);

        //Verify "Mark Smith" is in the list
        WebOrderUtils.verifyOrder(driver,"Mark Smith");
    }

}
