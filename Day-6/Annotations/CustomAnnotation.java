package com.javaannotation.day06;

import java.lang.reflect.Method;

//Create a class TaskManager
class TaskManager {
    //Use the TaskInfo Annotation
    @TaskInfo(priority = "High", assignedTo = "Anchal")
    //Create a method assignTask
    public void assignTask() {
        System.out.println("Task has been Assigned");
    }
}

//Create a class CustomAnnotation
public class CustomAnnotation {
    public static void main(String[] args) throws NoSuchMethodException {
        //Create an object of TaskManager
        TaskManager manageTask = new TaskManager();

        //Create a reference variable and Call the method
        Method method = manageTask.getClass().getMethod("assignTask");

        //Check the condition
        if (method.isAnnotationPresent(TaskInfo.class)) {
            //create a reference variable and call the method
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

            //print the details
            System.out.println("Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }
    }
}
