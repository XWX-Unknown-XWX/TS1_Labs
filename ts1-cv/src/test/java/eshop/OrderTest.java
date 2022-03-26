package eshop;

import eshop.shop.Order;
import eshop.shop.ShoppingCart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    Order order;
    ShoppingCart cart = new ShoppingCart();

    String customerName;
    String customerAddress;
    int state;

    @Test
    @DisplayName("Controlling first constructor of Order class")
    public void FirstOrderIsNotNull_controllingConstructorTest() {
        customerName = "Petr";
        customerAddress = "Prague 1";
        state = 1;

        order = new Order(cart, customerName, customerAddress, state);
        assertEquals(cart.getCartItems(), order.getItems());
        assertEquals(customerAddress, order.getCustomerAddress());
        assertEquals(customerName, order.getCustomerName());
        assertEquals(state, order.getState());
        // Checking if objects are not NULL (or variable is not 0)
        assertNotNull(order.getItems());
        assertNotNull(order.getCustomerName());
        assertNotNull(order.getCustomerAddress());
        assertNotNull(order);
    }

    @Test
    @DisplayName("Controlling second constructor of Order class")
    public void SecondOrderIsNull_controllingConstructorTest() {
        customerName = "Jiri";
        customerAddress = "Prague 2";

        order = new Order(cart, customerName, customerAddress);
        assertEquals(cart.getCartItems(), order.getItems());
        assertEquals(customerName, order.getCustomerName());
        assertEquals(customerAddress, order.getCustomerAddress());

        assertNotNull(order.getCustomerName());
        assertNotNull(order.getCustomerAddress());
    }
}
