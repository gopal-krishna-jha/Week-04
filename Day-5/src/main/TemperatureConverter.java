package com.javajunit.day05;

//Create a class ConvertTemperature to convert temperature
class ConvertTemperature{

    //Create a static method to  convert temperature Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        //Return the result
        return (celsius * 9/5) + 32;
    }

    //Create a static method to  convert temperature Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        //Return the result
        return (fahrenheit - 32) * 5/9;
    }
}

//Create a class TemperatureConverter
public class TemperatureConverter extends ConvertTemperature {
    public static void main(String[] args) {
        //Create a variable to store value
        double celsius = 10;

        //Call the method
        System.out.println("Temperature in celsius: "+ConvertTemperature.celsiusToFahrenheit(celsius));

        //Create a variable to store value
        double fahrenheit = 50;

        //Call the method
        System.out.println("Temperature in Fahrenheit: "+ConvertTemperature.fahrenheitToCelsius(fahrenheit));


    }
}
