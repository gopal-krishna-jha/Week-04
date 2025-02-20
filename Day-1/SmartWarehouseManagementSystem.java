
// Creating a package to store all classes related to Smart Warehouse Management System.
import java.util.List;
import java.util.ArrayList;

// Creating an abstract class to representing a Warehouse Item.
abstract class WarehouseItem {
    // Creating a variable productName to store item name.
    private String productName;

    // Creating a constructor to initialize item name.
    public WarehouseItem(String productName) {
        this.productName = productName;
    }

    // Creating a getter method to return item name.
    public String getProductName() {
        return productName;
    }

    // Creating an abstract method getProductPrice and getProduct to return item.
    public abstract int getProductPrice();

    public abstract void getProduct();

}

// Creating a class Electronics to representing Electronics.
class Electronics extends WarehouseItem {
    // Creating a variable productPrice to store electronic item price.
    private int productPrice;

    // Creating a constructor to initialize electronic name and price.
    public Electronics(String productName, int productPrice) {
        super(productName);
        this.productPrice = productPrice;
    }

    // Creating a method getProductPrice to override a method getProductPrice.
    public int getProductPrice() {
        return productPrice;
    }

    // Creating a method getProduct to override a method getProduct.
    public void getProduct() {
        System.out.println("Electronics Product: ");
    }
}

// Creating a class Groceries to representing Groceries.
class Groceries extends WarehouseItem {
    // Creating a variable productPrice to store groceries item price.
    private int productPrice;

    // Creating a constructor to initialize groceries item name and price.
    public Groceries(String productName, int productPrice) {
        super(productName);
        this.productPrice = productPrice;
    }

    // Creating a method getProductPrice to override a method getProductPrice.
    public int getProductPrice() {
        return productPrice;
    }

    // Creating a method getProduct to override a method getProduct.
    public void getProduct() {
        System.out.println("Groceries Product: ");
    }

}

// Creating a class Furniture to representing Furniture.
class Furniture extends WarehouseItem {
    // Creating a variable productPrice to store furniture item price.
    private int productPrice;

    // Creating a constructor to initialize furniture name and price.
    public Furniture(String productName, int productPrice) {
        super(productName);
        this.productPrice = productPrice;
    }

    // Creating a method getProductPrice to override a method getProductPrice.
    public int getProductPrice() {
        return productPrice;
    }

    // Creating a method getProduct to override a method getProduct.
    public void getProduct() {
        System.out.println("Furniture Product: ");
    }

}

// Creating a Generic Inventory class to store WarehouseItems.
class Inventory<T extends WarehouseItem> {
    // Creating a reference of the list interface.
    List<T> products;

    // Creating a constructor to initialize list.
    public Inventory() {
        // Creating an object of ArrayList class.
        products = new ArrayList<>();
    }

    // Creating a method addProduct to add item in list.
    public void addProduct(T product) {
        products.add(product);
    }

    // Creating a method removeProduct to remove item from list.
    public void removeProduct(T product) {
        products.remove(product);
    }

    // Creating a method to displayProductDetails to display all items details as price and name.
    public static void displayProductDetails(List<? extends WarehouseItem> products) {
        if (!products.isEmpty()) {
            products.get(0).getProduct();
        }
        System.out.printf("%-10s %s\n", "Product Name", "Product Price");
        for (WarehouseItem product : products) {
            System.out.printf("%-10s %d\n", product.getProductName(), product.getProductPrice());
        }
        System.out.println();
    }

}

// Creating a class SmartWarehouseManagementSystem to use Inventory,Electronics, Groceries, and Furniture class
public class SmartWarehouseManagementSystem {
    public static void main(String[] args) {

        // Creating an object of Inventory class for storing Electronics type product.
        Inventory<Electronics> electronicsInventory = new Inventory<>();
        // Calling the method addProduct to adding items to Inventory.
        electronicsInventory.addProduct(new Electronics("Laptop", 5000));
        electronicsInventory.addProduct(new Electronics("TV", 500));
        // display product details
        Inventory.displayProductDetails(electronicsInventory.products);

        // Creating an object of Inventory class for storing Groceries type product.
        Inventory<Groceries> groceriesInventory = new Inventory<>();
        // Call the method addProduct to adding items to Inventory.
        groceriesInventory.addProduct(new Groceries("Apple", 500));
        groceriesInventory.addProduct(new Groceries("Rice", 5000));
        // display product details
        Inventory.displayProductDetails(groceriesInventory.products);

        // Creating an object of Inventory class for storing Furniture type product.
        Inventory<Furniture> furnitureInventory = new Inventory<>();
        // Calling the method addProduct to adding items to Inventory.
        furnitureInventory.addProduct(new Furniture("Chair", 500));
        furnitureInventory.addProduct(new Furniture("Table", 1000));
        // displaying product details.
        Inventory.displayProductDetails(furnitureInventory.products);
    }
}
