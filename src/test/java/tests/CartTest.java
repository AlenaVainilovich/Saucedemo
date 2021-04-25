package tests;


import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class CartTest extends BaseTest {

    @Test
    public void productShouldBeAddedIntoCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bike Light");
        cartPage.open();
        cartPage.productShouldBeInTheList("Sauce Labs Bike Light");

    }

    @Test
    public void validateRemoveButtonInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bike Light");
        productsPage.buyProduct("Sauce Labs Onesie");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        cartPage.open();
        cartPage.removeFromCart();
        assertEquals(cartPage.getNumberOfItemsInCart(), 2, "Количество товаров в корзине неправильное");

    }
}
