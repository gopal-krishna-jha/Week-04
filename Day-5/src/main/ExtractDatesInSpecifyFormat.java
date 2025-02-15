package com.javaregularexpression.day05;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Create a class ExtractDate to extract dates from a text into specific format
class ExtractDate{
    //Create a method extractDateInSpecificFormat to extract Date in format dd/mm/yyyy
    public static void extractDateInSpecificFormat(String text){
        //Create a variable to store the regular expression
        String  regex = "[0-9]{2}/[0-9]{2}/[0-9]{4}";

        //Create a reference  and call the compile method to compile the regular expression
        Pattern compileExpression = Pattern.compile(regex);

        //Create a reference of Matcher class and call the method
        Matcher matcher = compileExpression.matcher(text);

        //Use while to find the date in dd/mm/yyyy format
        while (matcher.find()) {
            //Print the result
            System.out.print(matcher.group()+" ");
        }
    }

}

public class ExtractDatesInSpecifyFormat {
    public static void main(String[] args) {
        //Create an object of Scanner class
        Scanner input = new Scanner(System.in);

        //Create a variable and take input
        System.out.print("Enter the Text: ");
        String text = input.nextLine();

        //Call the method and print the result
        System.out.println("Date: ");
        ExtractDate.extractDateInSpecificFormat(text);

        //Close the object
        input.close();
    }
}
