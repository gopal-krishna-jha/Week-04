

// import List and ArrayList class from java.util package.
import java.util.List;
import java.util.ArrayList;

//Creating an abstract class LearningModule to representing a learning module.
abstract class LearningModule {
    // Creating a variable moduleTitle to store module title.
    private String moduleTitle;

    // Creating a constructor to initialize module title.
    public LearningModule(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }

    // Creating a getter method to return module title.
    public String getModuleTitle() {
        return moduleTitle;
    }

    // Creating an abstract method showModuleCategory to return category of module.
    public abstract void showModuleCategory();

}

// Creating a class TestModule to representing test Module.
class TestModule extends LearningModule {

    // Creating a constructor to initialize test module title.
    public TestModule(String moduleTitle) {
        super(moduleTitle);
    }

    // Creating a method showModuleCategory to override a method showModuleCategory.
    public void showModuleCategory() {
        System.out.println("Test Modules are : ");
    }
}

// Creating a class HandsOnModule to representing hands-on module category.
class HandsOnModule extends LearningModule {

    // Creating a constructor to initialize hands-on module title.
    public HandsOnModule(String moduleTitle) {
        super(moduleTitle);
    }

    // Creating a method showModuleCategory to override a method showModuleCategory.
    public void showModuleCategory() {
        System.out.println("Hands-On Modules are : ");
    }

}

// Creating a class ThesisModule to representing ThesisModule.
class ThesisModule extends LearningModule {

    // Creating a constructor to initialize thesis module title.
    public ThesisModule(String moduleTitle) {
        super(moduleTitle);
    }

    // Creating a method showModuleCategory to override a method showModuleCategory.
    public void showModuleCategory() {
        System.out.println("Thesis Modules Are: ");
    }

}

// Creating a Generic ModuleCollection class to store LearningModules.
class ModuleCollection<T extends LearningModule> {
    // Creating a reference of the list interface.
    private List<T> moduleList;

    // Create a constructor to initialize list
    public ModuleCollection() {
        // Create an object of ArrayList class
        moduleList = new ArrayList<>();
    }

    // Creating a method addModule to add module in list.
    public void addModule(T module) {
        moduleList.add(module);
    }

    // Creating a method removeModule to remove module from list.
    public void removeModule(T module) {
        moduleList.remove(module);
    }

    // Creating a method to get the module list.
    public List<T> getModuleList() {
        return moduleList;
    }

    // Creating a method to displayModuleDetails to display all modules details as title
    public static void displayModuleDetails(List<? extends LearningModule> moduleList) {
        if (!moduleList.isEmpty()) {
            moduleList.get(0).showModuleCategory();
            for (LearningModule module : moduleList) {
                System.out.printf("%-10s\n", module.getModuleTitle());
            }
            System.out.println();
        }
    }

}

// Create a class LearningProgramManager to use ModuleCollection, TestModule,HandsOnModule, and ThesisModule class.
public class LearningProgramManager {
    public static void main(String[] args) {

        // Creating an object of ModuleCollection class for storing TestModule type module.
        ModuleCollection<TestModule> testModuleCollection = new ModuleCollection<>();
        // Calling the method addModule to adding modules to ModuleCollection.
        testModuleCollection.addModule(new TestModule("JEE Mains"));
        testModuleCollection.addModule(new TestModule("NEET UG"));
        // displaying module details.
        ModuleCollection.displayModuleDetails(testModuleCollection.getModuleList());

        // Creatig an object of ModuleCollection class for storing HandsOnModule type module.
        ModuleCollection<HandsOnModule> handsOnModuleCollection = new ModuleCollection<>();
        // Calling the method addModule to adding modules to ModuleCollection.
        handsOnModuleCollection.addModule(new HandsOnModule("Development Communication"));
        handsOnModuleCollection.addModule(new HandsOnModule("Community Media"));
        // displaying module details.
        ModuleCollection.displayModuleDetails(handsOnModuleCollection.getModuleList());

        // Creating an object of ModuleCollection class for storing ThesisModule type module.
        ModuleCollection<ThesisModule> thesisModuleCollection = new ModuleCollection<>();
        // Calling the method addModule to adding modules to ModuleCollection.
        thesisModuleCollection.addModule(new ThesisModule("Qualitative Research"));
        thesisModuleCollection.addModule(new ThesisModule("Data Analysis"));
        // displaying module details.
        ModuleCollection.displayModuleDetails(thesisModuleCollection.getModuleList());
    }
}
