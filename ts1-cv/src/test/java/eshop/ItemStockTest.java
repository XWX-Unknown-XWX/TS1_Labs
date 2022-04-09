package eshop;

import eshop.shop.Item;
import eshop.shop.StandardItem;
import eshop.storage.ItemStock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class ItemStockTest {

    public String name = "Jiri";
    public String category = "Java";
    public int id = 123321;
    public int loyaltyPoints = 200;
    public int count;
    public float price = 244323;

    ItemStock itemStock;
    Item refItem = new StandardItem(id, name, price, category, loyaltyPoints);

    @Test
    @DisplayName("Testing constructor is not NULL")
    public void itemStock_testing_constructorTest_isNotNull() {
        assertNotNull(refItem);
    }

    @Test
    @DisplayName("Testing Item ID")
    public void itemStock_testing_itemID() {
        assertEquals(refItem.getID(), id);
    }

    @Test
    @DisplayName("Testing Item Name")
    public void itemStock_testing_itemName() {
        assertEquals(refItem.getName(), name);
    }

    @Test
    @DisplayName("Testing Item Price")
    public void itemStock_testing_itemPrice() {
        assertEquals(refItem.getPrice(), price);
    }

    @Test
    @DisplayName("Testing Item Category")
    public void itemStock_testing_itemCategory() {
        assertEquals(refItem.getCategory(), category);
    }

    @Test
    @DisplayName("Testing Item Loyalty Points")
    public void itemStock_testing_itemLoyaltyPoints() {
        assertEquals(200, loyaltyPoints);
    }

    @BeforeEach
    @DisplayName("Setting @BeforeEach ItemStock")
    public void setItemStock() {
        itemStock = new ItemStock(refItem);
    }

    @Test
    @DisplayName("Testing Item Count")
    public void itemStock_testing_itemCount() {
        assertEquals(itemStock.getCount(), count);
    }

    @ParameterizedTest(name = "IncreaseItemCount changing")
    @CsvSource({"23, 5", "3, 2", "12, 10", "8, 3"})
    public void increaseChangingCountTest(int x) {
        assertNotEquals(count, itemStock.IncreaseItemCount(x));
    }

    @ParameterizedTest(name = "decreaseItemCount changing")
    @CsvSource({"12, 5", "7, 4", "3, 2", "1, 0"})
    public void decreaseItemCountTest(int x) {
        assertNotEquals(count, itemStock.decreaseItemCount(x));
    }
}
