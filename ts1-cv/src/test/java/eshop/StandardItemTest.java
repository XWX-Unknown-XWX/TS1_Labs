package eshop;

import eshop.shop.StandardItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StandardItemTest {

    int id = 3000;
    String name = "Dima";
    float price = 1232;
    String category = "Software";
    int loyaltyPoints = 100;

    StandardItem standardItem = new StandardItem(id, name, price, category, loyaltyPoints) ;

    @Test
    @DisplayName("Testing StandardItem Constructor ")
    public void StandardItem_constructorTest() {
        assertEquals(loyaltyPoints, standardItem.getLoyaltyPoints());
    }

    @Test
    @DisplayName("Testing StandardItem copy method")
    public void StandardItem_copyTest() {
        assertNotNull(standardItem.copy());
    }

    @ParameterizedTest
    @DisplayName("Testing equals method")
    @CsvSource({"12312, Petr, 23232, JTest, 150"})
    public void StandardItem_equalsTest(int id, String name, float price, String category, int loyaltyPoints) {
        boolean isEquals = false;
        StandardItem standardItem1 = new StandardItem(id, name, price, category, loyaltyPoints);
        assertEquals(standardItem.equals(standardItem1), isEquals);
    }

}
