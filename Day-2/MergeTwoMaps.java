import java.util.HashMap;
import java.util.Map;

// Create a class Merge to merge two maps
class Merge {
    // Create a static method mergeTwoMap to merge two maps
    public static void mergeTwoMap(Map<String, Integer> inputMap1, Map<String, Integer> inputMap2) {
        // Create a map mergeMap to store merged maps
        Map<String, Integer> mergeMap = new HashMap<>(inputMap1);
        for (Map.Entry<String, Integer> entry : inputMap2.entrySet()) {
            mergeMap.put(entry.getKey(), entry.getValue());
        }

        // Use for-each loop to print merged map
        for (Map.Entry<String, Integer> entry : mergeMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}

// Create a class MergeTwoMaps to use Merge class
public class MergeTwoMaps {
    public static void main(String[] args) {
        // Create two maps
        Map<String, Integer> inputMap1 = new HashMap<>();
        Map<String, Integer> inputMap2 = new HashMap<>();

        // Put key and value in inputMap1 and inputMap2
        inputMap1.put("A", 1);
        inputMap1.put("B", 2);
        inputMap2.put("B", 3);
        inputMap2.put("C", 4);

        // Call the method mergeTwoMap to merge the maps and print the merged map
        Merge.mergeTwoMap(inputMap1, inputMap2);
    }
}
