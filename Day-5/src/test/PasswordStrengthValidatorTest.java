import com.javajunit.day05.PasswordStrengthValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Create a class PasswordStrengthValidator to  test the password validate
public class PasswordStrengthValidatorTest {
    @Test
    //Create a method isValidPasswordTest to test the password
    void isValidPasswordTest(){
        //Create a variable to store value
        String password = "Abcd@1234";

        //Call the method to compare the actual and expected
        assertEquals(true, PasswordStrengthValidator.isValidPassword(password));

        //Create a variable to store value
        String password2 ="132465";

        //Call the method to compare the actual and expected
        assertEquals(false, PasswordStrengthValidator.isValidPassword(password2));
    }
}
