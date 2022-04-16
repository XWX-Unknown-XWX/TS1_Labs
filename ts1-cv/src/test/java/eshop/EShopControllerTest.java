package eshop;

import eshop.shop.*;
import eshop.storage.NoItemInStorage;
import eshop.storage.Storage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EShopControllerTest {
    StandardItem item;
    Item[] storageItems;
    ArrayList<Item> purchasedItem = new ArrayList<>();
    Storage storage = new Storage();
    ShoppingCart mockedShoppingCart = Mockito.mock(ShoppingCart.class);
    EShopController eShopController = Mockito.mock(EShopController.class);

    public String customerName = "Dmitrij";
    public String customerAddress = "Prague 10";
    public String name = "IntelliJ Idea";
    public String category = "IDE";
    public int id = 25092001;

    public int loyaltyPoints = 100;
    public float price = 10032;

    // For PurchaseArchive test
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Test
    @DisplayName("Testing Constructor is not null")
    public void eshopController_testing_constructor() {
        assertNotNull(eShopController);
    }

    @Test
    @DisplayName("Testing get newCart")
    public void eShopController_testing_newCart() {
        eShopController.setNewCart(mockedShoppingCart);
        assertEquals(eShopController.getNewCart(), eShopController.newCart());
        verify(eShopController).newCart();
    }

    @BeforeEach
    @DisplayName("Implementation @BeforeEach for Item")
    public void setItem() {
        item = new StandardItem(id, name, price, category, loyaltyPoints);
    }

    ShoppingCart shoppingCart = new ShoppingCart();

    @Test
    @DisplayName("Testing getting cart items")
    public void purchaseShoppingCart_testing_gettingItem() {
        purchasedItem.add(item);
        shoppingCart.setCartItems(purchasedItem);
        assertNotNull(shoppingCart.getCartItems());
    }

    @Test
    @DisplayName("Testing adding items")
    public void shoppingCart_testing_addingItem() {
        assertTrue(shoppingCart.addItem(item));
    }

    @Test
    @DisplayName("Testing removing items")
    public void shoppingCart_testing_removingItem() {
        shoppingCart.addItem(item); // adding Item to remove it
        assertTrue(shoppingCart.removeItem(item.getID()));
    }

    @Test
    @DisplayName("Testing items count")
    public void shoppingCart_testing_getItemsCount() {
        shoppingCart.setCartItems(purchasedItem);
        assertEquals(shoppingCart.getItemsCount(), purchasedItem.size());
    }

    @Test
    @DisplayName("Testing item price")
    public void shoppingCart_testing_getItemPrice() {
        item.setPrice(price);
        assertEquals(item.getPrice(), price);
    }

    @Test
    @DisplayName("Testing get total price")
    public void shoppingCart_testing_getTotalPrice() {
        int noPrice = 0;
        assertEquals(mockedShoppingCart.getTotalPrice(), noPrice);
        verify(mockedShoppingCart).getTotalPrice();
    }

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
    @DisplayName("Testing purchasing shopping cart is empty by println(stream)")
    public void purchaseShoppingCart_testing() throws NoItemInStorage {
        String expectedOutput = "Error: shopping cart is empty";
        EShopController.startEShop();
        EShopController.purchaseShoppingCart(shoppingCart, customerName, customerAddress);
        assertEquals(expectedOutput, outContent.toString().trim());
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
    @DisplayName("Testing storage inserted items")
    public void storage_testing_insertedItems() {
        assertEquals(storage.insertItems(item, storageItems.length), storageItems.length);
    }

    @Test
    @DisplayName("Testing storage printList of stored items")
    public void storage_testing_printListOfStoredItems() {
        String expectedOutput = "STORAGE IS CURRENTLY CONTAINING:";
        storage.printListOfStoredItems();
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    @DisplayName("Testing startEshop storage is ready")
    public void startEshop_testing_implementation() {
        assertEquals(EShopController.startEShop(), "Storage is ready.");
    }
}
