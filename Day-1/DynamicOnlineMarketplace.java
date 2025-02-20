
// Importing required classes.
import java.util.List;
import java.util.ArrayList;

// Creating an abstract class to representing a Warehouse Item
abstract class WarehouseItem {
    // Creating a variable itemName to store item name
    private String itemName;

    // Creating a constructor to initialize item name
    public WarehouseItem(String itemName) {
        this.itemName = itemName;
    }

    // Creating a getter method to return item name
    public String getItemName() {
        return itemName;
    }

    // Creating an abstract method getItemPrice and getItem to return item price and
    // about item
    public abstract int getItemPrice();

    public abstract void getItem();
}

// Creating a class Electronics to representing Electronics
class Electronics extends WarehouseItem {
    // Creating a variable itemPrice to store electronic item price
    private int itemPrice;

    // Creating a constructor to initialize electronic name and price
    public Electronics(String itemName, int itemPrice) {
        super(itemName);
        this.itemPrice = itemPrice;
    }

    // Creating a method getItemPrice to override a method getItemPrice
    public int getItemPrice() {
        return itemPrice;
    }

    // Creating a method getItem to override a method getItem
    public void getItem() {
        System.out.println("Electronics Item: ");
    }
}

// Creating a class Groceries to representing Groceries
class Groceries extends WarehouseItem {
    // Creating a variable itemPrice to store groceries item price
    private int itemPrice;

    // Creating a constructor to initialize groceries item name and price
    public Groceries(String itemName, int itemPrice) {
        super(itemName);
        this.itemPrice = itemPrice;
    }

    // Creating a method getItemPrice to override a method getItemPrice
    public int getItemPrice() {
        return itemPrice;
    }

    // Creating a method getItem to override a method getItem
    public void getItem() {
        System.out.println("Groceries Item: ");
    }
}

// Creating a class Furniture to representing Furniture
class Furniture extends WarehouseItem {
    // Creating a variable itemPrice to store furniture item price
    private int itemPrice;

    // Creating a constructor to initialize furniture name and price
    public Furniture(String itemName, int itemPrice) {
        super(itemName);
        this.itemPrice = itemPrice;
    }

    // Creating a method getItemPrice to override a method getItemPrice
    public int getItemPrice() {
        return itemPrice;
    }

    // Creating a method getItem to override a method getItem
    public void getItem() {
        System.out.println("Furniture Item: ");
    }
}

// Creating a Generic Inventory class to store WarehouseItems
class Inventory<T extends WarehouseItem> {
    // Creating a reference of the list interface
    List<T> items;

    // Creating a constructor to initialize list
    public Inventory() {
        // Creating an object of ArrayList class
        items = new ArrayList<>();
    }

    // Creating a method addItem to add item in list
    public void addItem(T item) {
        items.add(item);
    }

    // Creating a method removeItem to remove item from list
    public void removeItem(T item) {
        items.remove(item);
    }

    // Creating a method to displayItemDetails to display all items details as price
    // and name
    public static void displayItemDetails(List<? extends WarehouseItem> items) {
        if (!items.isEmpty()) {
            items.get(0).getItem();
        }
        System.out.printf("%-10s %s\n", "Item Name", "Item Price");
        for (WarehouseItem item : items) {
            System.out.printf("%-10s %d\n", item.getItemName(), item.getItemPrice());
        }
        System.out.println();
    }
}

// Creating a class SmartWarehouseManagementSystem to use Inventory,
// Electronics, Groceries, and Furniture class
public class DynamicOnlineMarketplace {
    public static void main(String[] args) {

        // Creating an object of Inventory class for storing Electronics type item
        Inventory<Electronics> electronicsInventory = new Inventory<>();
        // Call the method addItem to adding items to Inventory
        electronicsInventory.addItem(new Electronics("Laptop", 5000));
        electronicsInventory.addItem(new Electronics("TV", 500));
        // display item details
        Inventory.displayItemDetails(electronicsInventory.items);

        // Creating an object of Inventory class for storing Groceries type item
        Inventory<Groceries> groceriesInventory = new Inventory<>();
        // Call the method addItem to adding items to Inventory
        groceriesInventory.addItem(new Groceries("Apple", 500));
        groceriesInventory.addItem(new Groceries("Rice", 5000));
        // display item details
        Inventory.displayItemDetails(groceriesInventory.items);

        // Creating an object of Inventory class for storing Furniture type item
        Inventory<Furniture> furnitureInventory = new Inventory<>();
        // Call the method addItem to adding items to Inventory
        furnitureInventory.addItem(new Furniture("Chair", 500));
        furnitureInventory.addItem(new Furniture("Table", 1000));
        // display item details
        Inventory.displayItemDetails(furnitureInventory.items);
    }
}
