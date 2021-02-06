package com.cybertek.tests.day8_testBase_Properties_Driver;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingFromProperties {

    @Test
    public void reading_from_properties_file() throws IOException {

        // 1. create properties class object
        Properties properties = new Properties();

        // 2. open the file in JVM Memory and pass the path of the file
        String path = "configuration.properties";

        FileInputStream file = new FileInputStream(path);

        // 3. Load the opened file into the Properties object

        properties.load(file);

        // read values from the file

        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));

        System.out.println("properties.getProperty(\"user\") = " + properties.getProperty("username"));


    }

    @Test
    public void using_properties_util_method(){
        System.out.println("ConfigurationReader.getProperty(\"browser\") = " + ConfigurationReader.getProperty("browser"));
        System.out.println("ConfigurationReader.getProperty(\"url\") = " + ConfigurationReader.getProperty("webOrderUrl"));
    }
}
