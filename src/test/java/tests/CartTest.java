package tests;


import org.testng.annotations.Test;


public class CartTest extends BaseTest {

    @Test
    public void productShouldBeAddedIntoCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bike Light");
        cartPage.openPage();
        cartPage.productShouldBeInTheList("Sauce Labs Bike Light");

    }
}
