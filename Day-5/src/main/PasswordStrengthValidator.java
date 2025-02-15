package com.javajunit.day05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Create a class PasswordValidator to check the password
class PasswordValidator{
    //Create a static method isValidPassword to check PassWord is valid or not
    public static boolean isValidPassword(String password){
        //Create a variable to store the regular expression
        String  regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

        //Create a reference  and call the compile method to compile the regular expression
        Pattern compileExpression = Pattern.compile(regex);

        //Create a reference of Matcher class and call the method
        Matcher matcher = compileExpression.matcher(password);

        //Call the method and return the result
        return matcher.matches();
    }
}

//Create a class PasswordStrengthValidator
public class PasswordStrengthValidator extends PasswordValidator {
    public static void main(String[] args) {
        //Create a Variable to store value
        String password = "Xyz@1234";

        //Create a variable to store the result and call the method
        boolean isValid =PasswordValidator.isValidPassword(password);

        //Print the result
        if(isValid){
            System.out.println("Valid Password.");
        } else {
            System.out.println("Invalid Password.");
        }
    }
}
