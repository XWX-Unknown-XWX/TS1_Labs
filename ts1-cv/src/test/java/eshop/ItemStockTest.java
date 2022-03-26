package eshop;

import eshop.shop.Item;
import eshop.shop.StandardItem;
import eshop.storage.ItemStock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class ItemStockTest {
    int id = 123321;
    String name = "Jiri";
    float price = 244323;
    String category = "Java";
    int loyaltyPoints = 200;
    int count;

    Item refItem = new StandardItem(id, name, price, category, loyaltyPoints);
    ItemStock itemStock = new ItemStock(refItem);

    @Test
    @DisplayName("Testing constructor")
    public void ItemStock_constructorTest() {
        assertNotNull(refItem);
        assertEquals(refItem.getID(), id);
        assertEquals(refItem.getName(), name);
        assertEquals(refItem.getPrice(), price);
        assertEquals(refItem.getCategory(), category);
        assertEquals(200, loyaltyPoints);
        assertEquals(itemStock.getCount(), count);
    }

    @ParameterizedTest(name = "IncreaseItemCount changing")
    @CsvSource({"0, 1", "1, 2", "3, 4", "7, 5"})
    public void IncreaseChangingCountTest(int count, int x) {
        assertNotEquals(count, itemStock.IncreaseItemCount(x));
    }

    @ParameterizedTest(name = "decreaseItemCount changing")
    @CsvSource({"12, 5", "7, 4", "3, 2", "1, 0"})
    public void DecreaseItemCountTest(int count, int x) {
        assertNotEquals(count, itemStock.decreaseItemCount(x));
    }
}
