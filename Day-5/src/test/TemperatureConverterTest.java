import com.javajunit.day05.TemperatureConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Create a class TemperatureConverterTest to perform test
public class TemperatureConverterTest {

    @Test
    //create a method celsiusToFahrenheitTest to Test the result
    void celsiusToFahrenheitTest(){
        //Call  the method to compare the actual and expected result
        assertEquals(50, TemperatureConverter.celsiusToFahrenheit(10));
    }

    @Test
    //Create a method fahrenheitToCelsiusTest to test the method
    void fahrenheitToCelsiusTest(){
        //Call  the method to compare the actual and expected result
        assertEquals(122, TemperatureConverter.celsiusToFahrenheit(50));
    }
}
