package eshop;

import eshop.archive.PurchasesArchive;
import eshop.shop.*;
import eshop.storage.NoItemInStorage;
import eshop.storage.Storage;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewEShopControllerTest {
    Item[] storageItems;
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

    @Test
    @Order(1)
    @DisplayName("Testing Starting EShop")
    public void startingEShop_testing_init() {
        EShopController.startEShop();
        assertTrue(
                EShopController.getStorage() != null &&
                        EShopController.getArchive() != null &&
                        EShopController.getCarts() != null &&
                        EShopController.getOrders() != null);
    }

    @BeforeEach
    @DisplayName("set @BeforeEach storage items")
    public void setStorage() {
        storageItems = new Item[] {
                new StandardItem(1, "Dancing Panda v.2", 5000, "GADGETS", 5),
                new StandardItem(2, "Dancing Panda v.3 with USB port", 6000, "GADGETS", 10),
                new StandardItem(3, "Screwdriver", 200, "TOOLS", 5),
                new DiscountedItem(4, "Star Wars Jedi buzzer", 500, "GADGETS", 30, "1.8.2013", "1.12.2013"),
                new DiscountedItem(5, "Angry bird cup", 300, "GADGETS", 20, "1.9.2013", "1.12.2013"),
                new DiscountedItem(6, "Soft toy Angry bird (size 40cm)", 800, "GADGETS", 10, "1.8.2013", "1.12.2013")
        };
    }

    @Test
    @Order(2)
    @DisplayName("Testing Inserting storage items into EShop + Showing list of stored items")
    public void showingListOfStoredItems_testing() {
        int[] items = new int[6];
        EShopController.startEShop();
        EShopController.ItemOutput(items, storageItems);
        Storage.printListOfStoredItems();
        String expectedOutput =
                "STORAGE IS CURRENTLY CONTAINING:\n" +
                        "STOCK OF ITEM:  Item   ID 1   NAME Dancing Panda v.2   CATEGORY GADGETS   PRICE 5000.0   LOYALTY POINTS 5    PIECES IN STORAGE: 0\n" +
                        "STOCK OF ITEM:  Item   ID 2   NAME Dancing Panda v.3 with USB port   CATEGORY GADGETS   PRICE 6000.0   LOYALTY POINTS 10    PIECES IN STORAGE: 0\n" +
                        "STOCK OF ITEM:  Item   ID 3   NAME Screwdriver   CATEGORY TOOLS   PRICE 200.0   LOYALTY POINTS 5    PIECES IN STORAGE: 0\n" +
                        "STOCK OF ITEM:  Item   ID 4   NAME Star Wars Jedi buzzer   CATEGORY GADGETS   ORIGINAL PRICE 500.0    DISCOUNTED PRICE 35000.0  DISCOUNT FROM Thu Aug 01 00:00:00 CEST 2013    DISCOUNT TO Sun Dec 01 00:00:00 CET 2013    PIECES IN STORAGE: 0\n" +
                        "STOCK OF ITEM:  Item   ID 5   NAME Angry bird cup   CATEGORY GADGETS   ORIGINAL PRICE 300.0    DISCOUNTED PRICE 24000.0  DISCOUNT FROM Sun Sep 01 00:00:00 CEST 2013    DISCOUNT TO Sun Dec 01 00:00:00 CET 2013    PIECES IN STORAGE: 0\n" +
                        "STOCK OF ITEM:  Item   ID 6   NAME Soft toy Angry bird (size 40cm)   CATEGORY GADGETS   ORIGINAL PRICE 800.0    DISCOUNTED PRICE 72000.0  DISCOUNT FROM Thu Aug 01 00:00:00 CEST 2013    DISCOUNT TO Sun Dec 01 00:00:00 CET 2013    PIECES IN STORAGE: 0\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @Order(3)
    @DisplayName("Testing purchasing shopping cart is empty")
    public void purchaseShoppingCart_testing_isEmpty() throws NoItemInStorage {
        String expectedOutput = "Error: shopping cart is empty";
        EShopController.startEShop();
        EShopController.purchaseShoppingCart(shoppingCart, customerName, customerAddress);
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    @Order(4)
    @DisplayName("Testing creating new cart, adding/removing items")
    public void processWithNewCart_testing() {
        EShopController.startEShop();
        ShoppingCart newCart = new ShoppingCart();
        newCart.addItem(storageItems[1]);
        newCart.addItem(storageItems[2]);
        newCart.addItem(storageItems[3]);
        newCart.addItem(storageItems[4]);
        newCart.addItem(storageItems[5]);
        newCart.removeItem(2);
        try {
            EShopController.purchaseShoppingCart(newCart, "Libuse Novakova", "Kosmonautu 25, Praha 8");
            Storage.printListOfStoredItems();
            String expectedOutput =
                    "Item with ID 2 added to the shopping cart.\n" +
                            "Item with ID 3 added to the shopping cart.\n" +
                            "Item with ID 4 added to the shopping cart.\n" +
                            "Item with ID 5 added to the shopping cart.\n" +
                            "Item with ID 6 added to the shopping cart.\n" +
                            "STORAGE IS CURRENTLY CONTAINING:\n";
            assertEquals(expectedOutput, outContent.toString());
        } catch (NoItemInStorage ignored) {}
    }

    @Test
    @Order(5)
    @DisplayName("Testing showing statistics of purchased Items")
    public void showingStatistics_test() {
        PurchasesArchive purchasesArchive = new PurchasesArchive();
        purchasesArchive.printItemPurchaseStatistics();
        String expectedOutput = "ITEM PURCHASE STATISTICS:\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
