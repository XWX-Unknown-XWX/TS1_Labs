package eshop;

import eshop.shop.EShopController;
import eshop.shop.ShoppingCart;
import eshop.storage.NoItemInStorage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class EShopControllerTest {
    EShopController eShopController = Mockito.mock(EShopController.class);

    ShoppingCart shoppingCart = new ShoppingCart();
    String customerName = "Dmitrij";
    String customerAddress = "Prague 10";


    @Test
    @DisplayName("Controlling constructor implementation")
    public void EShopController_constructorTest() {
        verify(eShopController);
    }

    @Test
    @Disabled
    @DisplayName("Controlling purchaseShoppingCart implementation")
    public void PurchaseShoppingCart_testImplementation() throws NoItemInStorage {
        // FIXME: 26.03.2022 Don't understand how to be implemented
    }

    @Test
    @Disabled
    @DisplayName("Controlling newCart implementation")
    public void NewCart_testingImplementation() {
        // FIXME: 26.03.2022 Don't understand how to be implemented
    }
}
