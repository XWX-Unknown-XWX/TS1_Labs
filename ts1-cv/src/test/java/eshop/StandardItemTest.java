package eshop;

import eshop.shop.StandardItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


public class StandardItemTest {

    public String name = "Dima";
    public String category = "Software";
    public int id = 3000;
    public int loyaltyPoints = 100;
    public float price = 1232;

    StandardItem standardItem = new StandardItem(id, name, price, category, loyaltyPoints);

    @Test
    @DisplayName("Testing StandardItem Constructor - ID ")
    public void standardItem_testingConstructor_id() {
        assertEquals(id, standardItem.getID());
    }

    @Test
    @DisplayName("Testing StandardItem Constructor - Name ")
    public void standardItem_testingConstructor_name() {
        assertEquals(name, standardItem.getName());
    }

    @Test
    @DisplayName("Testing StandardItem Constructor - Price")
    public void standardItem_testingConstructor_price() {
        assertEquals(price, standardItem.getPrice());
    }

    @Test
    @DisplayName("Testing StandardItem Constructor - Category")
    public void standardItem_testingConstructor_category() {
        assertEquals(category, standardItem.getCategory());
    }

    @Test
    @DisplayName("Testing StandardItem Constructor - Points")
    public void standardItem_testingConstructor_points() {
        assertEquals(loyaltyPoints, standardItem.getLoyaltyPoints());
    }

    @Test
    @DisplayName("Testing StandardItem Constructor - Class")
    public void standardItem_testingConstructor_class() {
        assertNotNull(standardItem.getClass());
    }

    @Test
    @DisplayName("Testing StandardItem Constructor - Type")
    public void standardItem_testingConstructor_type() {
        assertInstanceOf(standardItem.getClass(), standardItem);
    }

    @Test
    @DisplayName("Testing StandardItem Copy method equals")
    public void standardItem_testing_copyTest() {
        assertEquals(standardItem, standardItem.copy());
    }

    @Test
    @DisplayName("Testing StandardItem Copy method for NULL")
    public void standardItem_testNull() {
        assertNotNull(standardItem.copy());
    }

    @ParameterizedTest
    @DisplayName("Testing equals method")
    @CsvSource({"12312, Petr, 23232, JTest, 150", "222123, Jiri, 2123, OOP, 200", "123123, Dima, 25252, Java, 145"})
    public void standardItem_equalsTest(int id, String name, float price, String category, int loyaltyPoints) {
        boolean isEquals = false;
        StandardItem standardItem1 = new StandardItem(id, name, price, category, loyaltyPoints);
        assertEquals(standardItem.equals(standardItem1), isEquals);
    }
}
