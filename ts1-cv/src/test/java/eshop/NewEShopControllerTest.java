package eshop;

import eshop.shop.*;
import eshop.storage.NoItemInStorage;
import eshop.storage.Storage;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewEShopControllerTest {
    Item[] storageItems;
    Storage storage = new Storage();
    ShoppingCart shoppingCart = new ShoppingCart();
    public String customerName = "Dmitrij";
    public String customerAddress = "Prague 10";
    public String name = "IntelliJ Idea";

    // For PurchaseArchive test
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @BeforeEach
    @DisplayName("set @BeforeEach storage items")
    public void setStorage() {
        storageItems = new Item[]{
                new StandardItem(1, "Dancing Panda v.2", 5000, "GADGETS", 5),
                new StandardItem(2, "Dancing Panda v.3 with USB port", 6000, "GADGETS", 10),
                new StandardItem(3, "Screwdriver", 200, "TOOLS", 5),
                new DiscountedItem(4, "Star Wars Jedi buzzer", 500, "GADGETS", 30, "1.8.2013", "1.12.2013"),
                new DiscountedItem(5, "Angry bird cup", 300, "GADGETS", 20, "1.9.2013", "1.12.2013"),
                new DiscountedItem(6, "Soft toy Angry bird (size 40cm)", 800, "GADGETS", 10, "1.8.2013", "1.12.2013")
        };
    }

    @Test
    @Order(1)
    @DisplayName("Testing Starting EShop")
    public void startingEShop_testing_init() {
        String expectedReturnedValue = "Storage is not null.";
        assertEquals(expectedReturnedValue, EShopController.startEShop());
    }

    @Test
    @Order(2)
    @DisplayName("Testing Inserting storage items into EShop")
    public void showingListOfStoredItems_testing() {
        assertEquals(storageItems[4].getID(), storage.insertItems(storageItems[4], 5));
    }


    @Test
    @Order(3)
    @DisplayName("Testing Showing list of stored items")
    public void storage_testing_printListOfStoredItems() {
        String expectedOutput = "STORAGE IS CURRENTLY CONTAINING:";
        storage.printListOfStoredItems();
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    @Order(4)
    @DisplayName("Testing purchasing shopping cart is empty")
    public void purchaseShoppingCart_testing_isEmpty() throws NoItemInStorage {
        String expectedOutput = "Error: shopping cart is empty";
        EShopController.startEShop();
        EShopController.purchaseShoppingCart(shoppingCart, customerName, customerAddress);
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    @Order(5)
    @DisplayName("Testing creating new cart and adding/removing items with expected error")
    public void creatingNewCart_testing() throws NoItemInStorage {
        EShopController.startEShop();
        ShoppingCart newCart = new ShoppingCart();
        shoppingCart.addItem(storageItems[1]);
        shoppingCart.addItem(storageItems[2]);
        shoppingCart.addItem(storageItems[3]);
        shoppingCart.addItem(storageItems[4]);
        shoppingCart.addItem(storageItems[5]);
        shoppingCart.removeItem(2);
        EShopController.purchaseShoppingCart(newCart, "Libuse Novakova", "Kosmonautu 25, Praha 8");
        String expectedOutput =
                        "Item with ID 2 added to the shopping cart.\n" +
                        "Item with ID 3 added to the shopping cart.\n" +
                        "Item with ID 4 added to the shopping cart.\n" +
                        "Item with ID 5 added to the shopping cart.\n" +
                        "Item with ID 6 added to the shopping cart.\n" +
                        "Error: shopping cart is empty\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @Order(6)
    @DisplayName("Testing printing list of stored items")
    public void printListOfStoredItems_testingStatistics() {
        String expectedOutput = "STORAGE IS CURRENTLY CONTAINING:";
        storage.printListOfStoredItems();
        assertEquals(expectedOutput, outContent.toString().trim());
    }
}
