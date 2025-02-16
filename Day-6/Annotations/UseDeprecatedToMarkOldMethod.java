package com.javaannotation.day06;
//Create a class LegacyAPI
class LegacyAPI {
    //Use the @Deprecated Annotation
    @Deprecated
    //Create a method oldFeature()
    void oldFeature() {
        //Print the statement
        System.out.println("Old Features.");
    }

    //Create a method newFeature()
    void newFeature() {
        //Print the statement
        System.out.println("New Features.");
    }
}

//Create a class UseDeprecatedToMarkOldMethod
public class UseDeprecatedToMarkOldMethod {
    public static void main(String[] args) {

        //Create an object of LegacyAPI class
        LegacyAPI legacyAPI = new LegacyAPI();

        //Call the method
        legacyAPI.oldFeature();

        //Call the method
        legacyAPI.newFeature();
    }
}
