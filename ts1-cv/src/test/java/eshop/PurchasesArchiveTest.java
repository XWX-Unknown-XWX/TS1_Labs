package eshop;

import eshop.archive.ItemPurchaseArchiveEntry;
import eshop.archive.PurchasesArchive;
import eshop.shop.Item;
import eshop.shop.Order;
import eshop.shop.ShoppingCart;
import eshop.shop.StandardItem;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class PurchasesArchiveTest {

    // For orderArchive test
    Order order;
    ShoppingCart cart = new ShoppingCart();
    public String customerName = "Filip";
    public String customerAddress = "Prague 10";

    // For ItemPurchaseArchiveEntry test
    StandardItem item;
    PurchasesArchive purchasesArchive = Mockito.mock(PurchasesArchive.class);
    public String name = "Hero";
    public String category = "IDE";
    public int id = 23032011;
    public int loyaltyPoints = 90;
    public float price = 33212;

    // For OutputStream test
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
    @DisplayName("Testing printItemPurchaseStatistics correct output")
    public void printOutput_printItemPurchaseStatistics() {
        String expectedOut = "ITEM PURCHASE STATISTICS:";
        PurchasesArchive purchasesArchive = new PurchasesArchive();
        purchasesArchive.printItemPurchaseStatistics();
        assertEquals(expectedOut, outContent.toString().trim());
    }

    @BeforeEach
    @DisplayName("Setting @BeforeEach for item")
    public void setItem() {
        item = new StandardItem(id, name, price, category, loyaltyPoints);
    }

    @Test
    @DisplayName("Testing getHowManyTimesHasBeenItemSold method")
    public void getHowManyTimesHasBeenItemSold_testing() {
        assertEquals(purchasesArchive.getHowManyTimesHasBeenItemSold(item), 0);
        verify(purchasesArchive).getHowManyTimesHasBeenItemSold(item);
    }

    @BeforeEach
    @DisplayName("Setting @BeforeEach for order")
    public void setOrder() {
        order = new Order(cart, customerName, customerAddress);
    }

    @Test
    @DisplayName("Testing putOrderToPurchasesArchive method with new println(stream)")
    public void putOrderToPurchasesArchive_testing() {
        purchasesArchive.setTrue(true);
        boolean isTrue = purchasesArchive.getIsTrue();
        assertFalse(purchasesArchive.putOrderToPurchasesArchive(order, isTrue));
        verify(purchasesArchive).putOrderToPurchasesArchive(order, isTrue);
    }

    @Mock
    private ArrayList<Order> mockedOrderArchive;

    @Test
    @DisplayName("Testing PurchaseArchive constructor orderArchive")
    public void purchaseArchive_testing_constructorFirstParam() {
        purchasesArchive.setOrderArchive(mockedOrderArchive);
        assertNotNull(purchasesArchive.getOrderArchive());
        verify(purchasesArchive).getOrderArchive();
    }

    @Mock
    private HashMap<Integer, ItemPurchaseArchiveEntry> mockedItemPurchaseArchive;

    @Test
    @DisplayName("Testing PurchaseArchive constructor itemArchive")
    public void purchaseArchive_testing_constructorSecondParam() {
        purchasesArchive.setItemPurchaseArchive(mockedItemPurchaseArchive);
        assertNotNull(purchasesArchive.getItemPurchaseArchive());
        verify(purchasesArchive).getItemPurchaseArchive();
    }

    @Mock
    private ItemPurchaseArchiveEntry mockedArchiveEntry;

    @Test
    @DisplayName("Testing ItemPurchaseArchiveEntry elements with mock")
    public void purchaseArchive_testing_ArchiveEntry() {
        purchasesArchive.setPurchaseArchiveEntry(mockedArchiveEntry);
        assertNull(purchasesArchive.getPurchaseArchiveEntry());
        verify(purchasesArchive).getPurchaseArchiveEntry();
    }

    @Test
    @DisplayName("Testing PurchasesArchive constructor with mock")
    public void purchaseArchiveEntry_testing_itemPurchaseArchive() {
        Item item = new StandardItem(id, name, price, category, loyaltyPoints);
        ItemPurchaseArchiveEntry itemPurchaseArchiveEntry = new ItemPurchaseArchiveEntry(item);
        assertNotNull(purchasesArchive.getItemPurchaseArchive(), String.valueOf(itemPurchaseArchiveEntry));
        verify(purchasesArchive).getItemPurchaseArchive();
    }
}
