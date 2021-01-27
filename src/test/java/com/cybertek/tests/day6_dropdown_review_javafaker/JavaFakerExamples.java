package com.cybertek.tests.day6_dropdown_review_javafaker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerExamples {

    @Test
    public void java_faker_test1(){
        // We need to create the object  of java faker
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);

        String lastName= faker.name().lastName();
        System.out.println("lastName = "+ lastName);

        String fullName = faker.name().fullName();
        System.out.println("fullName = "     + fullName);

        String address = faker.address().fullAddress();
        System.out.println("address = " + address);

    }
}
