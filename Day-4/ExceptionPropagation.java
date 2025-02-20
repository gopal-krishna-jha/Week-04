public class ExceptionPropagation {

    // Method that throws an ArithmeticException.
    public static void method1() {
        int result = 10 / 0; // This will throw ArithmeticException
    }

    // Method that calls method1()
    public static void method2() {
        method1();
    }

    public static void main(String[] args) {
        try {
            // Call method2, which propagates the exception from method1.
            method2();
        } catch (ArithmeticException e) {
            // Handle the exception in main.
            System.out.println("Handled exception in main");
        }
    }
}
