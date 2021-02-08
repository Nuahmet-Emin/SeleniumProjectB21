package com.cybertek.tests.day9_driver_actions_uploads;

public class SingleTon {

    // by making the constructor private, we are liming creating object from this class
    private SingleTon(){}

    // by making the String, we can only reach this using getter method
    private static String word;

    // by creating getter method, we will allow user to reach to String in the way we allow them to
    public static  String getWord() {

        if(word == null){
            System.out.println("First time call. Word object is null" +
                    "Assigning value to it now");
            word = "something";
        }else{
            System.out.println("Word already has a value.");
        }
        return word;
    }


}
