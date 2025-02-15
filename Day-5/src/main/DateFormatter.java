package com.javajunit.day05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Create a class ConvertDateIntoFormat to convert date format
class ConvertDateIntoFormat{
    public static String formatDate(String inputDate){
      try{
          //Create an object of LocalDate class
           LocalDate date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

           //Call the method and return the value
           return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
      } catch (Exception e) {//Catch block to handle exception
          //Print the statement
          System.out.println(e.getMessage());
      }
        return "Error";
    }
}
public class DateFormatter extends ConvertDateIntoFormat {
    public static void main(String[] args) {

        //Create a variable to store the value
        String Date="2025-02-16";

        //Call the method and print the result
        System.out.println(ConvertDateIntoFormat.formatDate(Date));

    }
}
