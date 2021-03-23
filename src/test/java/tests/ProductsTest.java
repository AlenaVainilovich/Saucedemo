package tests;

import org.testng.annotations.Test;
import tests.BaseTest;

public class ProductsTest extends BaseTest {

    @Test
    public void productsShouldBeAvailableInCard() {
        loginPage
                .open()
                .login("standard_user", "secret_sauce");
        productsPage
                .buyProduct("Sauce Labs Bolt T-Shirt")
                .buyProduct("Sauce Labs Fleece Jacket");
    }
}
