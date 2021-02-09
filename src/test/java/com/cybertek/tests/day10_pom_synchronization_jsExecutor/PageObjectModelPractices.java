package com.cybertek.tests.day10_pom_synchronization_jsExecutor;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.annotations.Test;

public class PageObjectModelPractices {


     @Test
    public void logIntoSmartBear(){
         String url = ConfigurationReader.getProperty("webOrderUrl");
         Driver.getDriver().get(url);

         //When we create object of this class, the object and driver instance will be already initialized //
         //(recognize each other)
         LoginPage loginPage = new LoginPage();

         // We are allowed to use object of this class to reach we elements and use selenium methods
         String username=ConfigurationReader.getProperty("usernameSmartBear");
         loginPage.inputUsername.sendKeys(username);

         String password = ConfigurationReader.getProperty("passwordSmartBear");
         loginPage.inputPassword.sendKeys(password);

         loginPage.loginButton.click();
     }

}
