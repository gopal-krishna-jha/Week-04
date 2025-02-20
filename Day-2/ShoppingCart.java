
// importing java.util package to use the classes of this package.
import java.util.*;

// Implementations of Voting System.
class VotingSystem {
    // Storing the candidate votes.
    private Map<String, Integer> voteMap = new HashMap<>(); 
    // Maintaining the order of votes.
    private Map<String, Integer> orderedVotes = new LinkedHashMap<>();
     // Displaying the results in sorted order.
    private Map<String, Integer> sortedVotes = new TreeMap<>(); 

    // Method for casting a vote for a candidate.
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        orderedVotes.put(candidate, voteMap.get(candidate));
        sortedVotes.put(candidate, voteMap.get(candidate));
    }

    // Method for display votes in insertion order.
    public void displayVotesInOrder() {
        
        System.out.println("Votes in order of casting:");

        // Displaying the votes in the order of casting.
        for (var entry : orderedVotes.entrySet()) {

            // Displaying the candidate and the number of votes.
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    // Method for displaying results in sorted order.
    public void displayResultsSorted() {
        System.out.println("Votes in sorted order:");

        // Displaying the votes in sorted order.
        for (var entry : sortedVotes.entrySet()) {

            // Displaying the candidate and the number of votes.
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}

// Implementations of Shopping Cart.
class ShopCart {
    // Storing the price of the products.
    private Map<String, Double> productPrices = new HashMap<>();
    
    // Maintaining order of items added.
    private Map<String, Double> cart = new LinkedHashMap<>(); 
    private Map<String, Double> sortedCart = new TreeMap<>(Comparator.comparingDouble(productPrices::get)); 

    // Method for add a product to the cart
    public void addProduct(String product, double price) {

        // Adding the product to the cart.
        productPrices.put(product, price);
        cart.put(product, price);
        sortedCart.put(product, price);
    }

    // Method for displaying the cart items in insertion order.
    public void displayCartInOrder() {
        System.out.println("Cart items in order of addition:");
        // Displaying the cart items in the order of addition.
        for (var entry : cart.entrySet()) {
            // Displaying the product and the price.
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    // Method for display cart items sorted by price.
    public void displayCartSorted() {
        System.out.println("Cart items sorted by price:");
        for (var entry : sortedCart.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}

// Main class named ShoppingCart to test Voting System and Shopping Cart
public class ShoppingCart{
    public static void main(String[] args) {
        // Testing the Voting System.
        VotingSystem votingSystem = new VotingSystem();
        votingSystem.castVote("Ram"); // Casting vote for Ram
        votingSystem.castVote("Shyam"); // Casting vote for Shyam
        votingSystem.castVote("Radha"); // Casting vote for Radha
        votingSystem.displayVotesInOrder(); // Display votes in order of casting
        votingSystem.displayResultsSorted(); // Display votes in sorted order

        // Testing Shopping Cart
        ShopCart cart = new ShopCart();
        // Adding Laptop to cart.
        cart.addProduct("Laptop", 1200);
         // Adding Mouse to cart.
        cart.addProduct("Mouse", 25); 
        // Adding Keyboard to cart.
        cart.addProduct("Keyboard", 45);
         // Display cart in insertion order.
        cart.displayCartInOrder(); 
        // Display cart sorted by price
        cart.displayCartSorted(); 
    }
}
