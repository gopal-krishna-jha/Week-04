package com.javaannotation.day06;
import java.lang.annotation.*;

//Create a BugReports Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

//Create a BugReport Annotation and use Repeatable,Retention and Target Annotation
@Repeatable(BugReports.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReport {
    String description();
}

//Create a class UseBugReport
class UseBugReport {
    @BugReport(description = "Unchecked Exception")
    @BugReport(description = "Checked Exception")
    //Create a method
    public void getRepeatableMethod() {
        System.out.println("Hii");
    }
}

//Create a class UseRepeatableAnnotation
public class UseRepeatableAnnotation {
    public static void main(String[] args) throws NoSuchMethodException {
        //Create an array of BugReport Class
        BugReport[] bugReports = UseBugReport.class.getMethod("getRepeatableMethod").getAnnotationsByType(BugReport.class);

        //Print the result
        for (BugReport bugReport : bugReports) {
            System.out.println("Bug Report: " + bugReport.description());
        }
    }
}
