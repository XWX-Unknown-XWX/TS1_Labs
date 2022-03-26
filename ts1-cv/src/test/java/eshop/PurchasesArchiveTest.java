package eshop;

import eshop.archive.ItemPurchaseArchiveEntry;
import eshop.archive.PurchasesArchive;
import eshop.shop.Item;
import eshop.shop.Order;
import eshop.shop.ShoppingCart;
import eshop.shop.StandardItem;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


public class PurchasesArchiveTest {

    PurchasesArchive purchasesArchive;

    // For orderArchive test
    ShoppingCart cart = new ShoppingCart();
    String customerName = "Filip";
    String customerAddress = "Prague 10";

    // For ItemPurchaseArchiveEntry test
    int id = 23032011;
    String name = "Hero";
    float price = 33212;
    String category = "IDE";
    int loyaltyPoints = 90;

    @Test // FIXME: 25.03.2022 DON'T UNDERSTAND HOW TO IMPLEMENT
    @Disabled
    @DisplayName("Testing printItemPurchaseStatistics")
    public void PrintItemPurchaseStatisticsTest() {
        // code should be here
    }

    @Test // FIXME: 25.03.2022 DON'T UNDERSTAND HOW TO IMPLEMENT
    @Disabled
    @DisplayName("Testing getHowManyTimesHasBeenItemSold")
    public void GetHowManyTimesHasBeenItemSoldTest() {
        // code should be here
    }

    @Test // FIXME: 25.03.2022 DON'T UNDERSTAND HOW TO IMPLEMENT
    @Disabled
    @DisplayName("Testing putOrderToPurchasesArchive")
    public void PutOrderToPurchasesArchiveTest() {
        // code should be here
    }

    @Test // FIXME: 25.03.2022 DON'T UNDERSTAND HOW TO IMPLEMENT
    @Disabled
    @DisplayName("Testing println(stream)")
    public void PrintlnStreamTest() {
        // code should be here
    }

    @Test
    @DisplayName("Testing orderArchive with mock")
    public void OrderArchive_mockitoTest() {
        ArrayList<Order> mockArchiveOrder = new ArrayList<>();
        ArrayList<Order> mockOnArchive = spy(mockArchiveOrder);
        when(mockOnArchive.size()).thenReturn(0);
        assertEquals(0, mockArchiveOrder.size());
    }

    @Test
    @DisplayName("Testing ItemPurchaseArchiveEntry elements with mock")
    public void ItemPurchaseArchive_entryTest() {
        ItemPurchaseArchiveEntry archiveEntry = Mockito.mock(ItemPurchaseArchiveEntry.class);
        verify(archiveEntry);
    }

    @Test
    @DisplayName("Testing constructor and ItemPurchaseArchiveEntry")
    public void ItemPurchaseArchiveEntry_testingRightCall() {
        Item item = new StandardItem(id, name, price, category, loyaltyPoints);
        ItemPurchaseArchiveEntry itemPurchaseArchiveEntry = new ItemPurchaseArchiveEntry(item);
        purchasesArchive = new PurchasesArchive();
        assertNotNull(purchasesArchive.getItemPurchaseArchive(), String.valueOf(itemPurchaseArchiveEntry));
        assertNotNull(purchasesArchive);
    }
}
