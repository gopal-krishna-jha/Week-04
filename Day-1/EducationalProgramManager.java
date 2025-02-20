
import java.util.List;
import java.util.ArrayList;

//Create an abstract class LearningCategory to representing a learning category
abstract class LearningCategory {
    // Create a variable learningTitle to store learning title
    private String learningTitle;

    // Create a constructor to initialize learning title
    public LearningCategory(String learningTitle) {
        this.learningTitle = learningTitle;
    }

    // Create a getter method to return learning title
    public String getLearningTitle() {
        return learningTitle;
    }

    // Create an abstract method displayLearningCategory to return category of
    // learning
    public abstract void displayLearningCategory();

}

// Create a class EvaluationCourse to representing evaluation Course
class EvaluationCourse extends LearningCategory {

    // Create a constructor to initialize evaluation course title
    public EvaluationCourse(String learningTitle) {
        super(learningTitle);
    }

    // Create a method displayLearningCategory to override a method
    // displayLearningCategory
    public void displayLearningCategory() {
        System.out.println("Evaluation Courses are : ");
    }
}

// Create a class PracticalCourse to representing practical course category
class PracticalCourse extends LearningCategory {

    // Create a constructor to initialize practical course title
    public PracticalCourse(String learningTitle) {
        super(learningTitle);
    }

    // Create a method displayLearningCategory to override a method
    // displayLearningCategory
    public void displayLearningCategory() {
        System.out.println("Practical Courses are : ");
    }

}

// Create a class DissertationCourse to representing DissertationCourse
class DissertationCourse extends LearningCategory {

    // Create a constructor to initialize dissertation course title
    public DissertationCourse(String learningTitle) {
        super(learningTitle);
    }

    // Create a method displayLearningCategory to override a method
    // displayLearningCategory
    public void displayLearningCategory() {
        System.out.println("Dissertation Courses Are: ");
    }

}

// Create a Generic LearningCollection class to store LearningCategories
class LearningCollection<T extends LearningCategory> {
    // Create a reference of the list interface
    List<T> learningList;

    // Create a constructor to initialize list
    public LearningCollection() {
        // Create an object of ArrayList class
        learningList = new ArrayList<>();
    }

    // Create a method addLearning to add learning in list
    public void addLearning(T learning) {
        learningList.add(learning);
    }

    // Create a method removeLearning to remove learning from list
    public void removeLearning(T learning) {
        learningList.remove(learning);
    }

    // Create a method to showLearningDetails to display all learnings details as
    // title
    public static void showLearningDetails(List<? extends LearningCategory> learningList) {
        if (!learningList.isEmpty()) {
            learningList.get(0).displayLearningCategory();
            for (LearningCategory learning : learningList) {
                System.out.printf("%-10s\n", learning.getLearningTitle());
            }
            System.out.println();
        }
    }

}

// Create a class EducationalProgramManager to use LearningCollection,
// EvaluationCourse, PracticalCourse, and DissertationCourse class
public class EducationalProgramManager {
    public static void main(String[] args) {

        // Create an object of LearningCollection class for storing EvaluationCourse
        // type learning
        LearningCollection<EvaluationCourse> evaluationCourseCollection = new LearningCollection<>();
        // Call the method addLearning to adding learnings to LearningCollection
        evaluationCourseCollection.addLearning(new EvaluationCourse("JEE Mains"));
        evaluationCourseCollection.addLearning(new EvaluationCourse("NEET UG"));
        // display learning details
        LearningCollection.showLearningDetails(evaluationCourseCollection.learningList);

        // Create an object of LearningCollection class for storing PracticalCourse type
        // learning
        LearningCollection<PracticalCourse> practicalCourseCollection = new LearningCollection<>();
        // Call the method addLearning to adding learnings to LearningCollection
        practicalCourseCollection.addLearning(new PracticalCourse("Development Communication"));
        practicalCourseCollection.addLearning(new PracticalCourse("Community Media"));
        // display learning details
        LearningCollection.showLearningDetails(practicalCourseCollection.learningList);

        // Create an object of LearningCollection class for storing DissertationCourse
        // type learning
        LearningCollection<DissertationCourse> dissertationCourseCollection = new LearningCollection<>();
        // Call the method addLearning to adding learnings to LearningCollection
        dissertationCourseCollection.addLearning(new DissertationCourse("Qualitative Research"));
        dissertationCourseCollection.addLearning(new DissertationCourse("Data Analysis"));
        // display learning details
        LearningCollection.showLearningDetails(dissertationCourseCollection.learningList);
    }
}
