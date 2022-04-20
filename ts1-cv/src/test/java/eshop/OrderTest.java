package eshop;

import eshop.shop.Order;
import eshop.shop.ShoppingCart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    ShoppingCart cart = new ShoppingCart();
    // variables for the first class
    public String customerName1 = "Petr";
    public String customerAddress1 = "Prague 1";
    public int state = 1;
    Order orderFirst = new Order(cart, customerName1, customerAddress1, state);
    // variables for the second class
    public String customerName2 = "Jiri";
    public String customerAddress2 = "Prague 2";
    Order orderSecond = new Order(cart, customerName2, customerAddress2);

    @Test
    @DisplayName("Controlling first Constructor Class Cart Item")
    public void orderFirstClass_testing_cartItem() {
        assertEquals(cart.getCartItems(), orderFirst.getItems());
    }

    @Test
    @DisplayName("Controlling first Constructor Class Customer Address")
    public void orderFirstClass_testing_address() {
        assertEquals(customerAddress1, orderFirst.getCustomerAddress());
    }

    @Test
    @DisplayName("Controlling first Constructor Class Customer Name")
    public void orderFirstClass_testing_customerName() {
        assertEquals(customerName1, orderFirst.getCustomerName());
    }

    @Test
    @DisplayName("Controlling first Constructor Class State")
    public void orderFirstClass_testing_state() {
        assertEquals(state, orderFirst.getState());
    }

    @Test
    @DisplayName("Controlling first Constructor Class Items is not NULL")
    public void orderFirstClass_testing_items_notNull() {
        assertNotNull(orderFirst.getItems());
    }

    @Test
    @DisplayName("Controlling first Constructor Class Customer Name is not NULL")
    public void orderFirstClass_testing_name_notNull() {
        assertNotNull(orderFirst.getCustomerName());
    }

    @Test
    @DisplayName("Controlling first Constructor Class Customer Address is not NULL")
    public void orderFirstClass_testing_customerAddress_notNull() {
        assertNotNull(orderFirst.getCustomerAddress());
    }

    @Test
    @DisplayName("Controlling first Order Class is not NULL")
    public void orderFirstClass_testing_firstOrderClass_notNull() {
        assertNotNull(orderFirst);
    }

    @Test
    @DisplayName("Controlling second Constructor Class Cart Item")
    public void orderSecondClass_testing_cartItem() {
        assertEquals(cart.getCartItems(), orderSecond.getItems());
    }

    @Test
    @DisplayName("Controlling second Constructor Class Customer Name")
    public void orderSecondClass_testing_customerName() {
        assertEquals(customerName2, orderSecond.getCustomerName());
    }

    @Test
    @DisplayName("Controlling second Constructor Class Customer Address")
    public void orderSecondClass_testing_customerAddress() {
        assertEquals(customerAddress2, orderSecond.getCustomerAddress());
    }

    @Test
    @DisplayName("Controlling second Constructor not equals state")
    public void orderSecondClass_testing_stateNotExists() {
        assertNotEquals(state, orderSecond.getState());
    }

    @Test
    @DisplayName("Controlling second Constructor Class Customer Name is not NULL")
    public void orderSecondClass_testing_customerName_notNull() {
        assertNotNull(orderSecond.getCustomerName());
    }

    @Test
    @DisplayName("Controlling second Constructor Class Customer Address is not NULL")
    public void orderSecondClass_testing_customerAddress_notNull() {
        assertNotNull(orderSecond.getCustomerAddress());
    }

    @Test
    @DisplayName("Controlling second Order Class is not NULL")
    public void orderFirstClass_testing_secondOrderClass_notNull() {
        assertNotNull(orderSecond);
    }

    @Test
    @DisplayName("Controlling Shopping Cart is not NULL")
    public void shoppingCart_testing_isNotNull() {
        assertNotNull(cart);
    }

}
