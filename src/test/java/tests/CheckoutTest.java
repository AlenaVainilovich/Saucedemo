package tests;

import io.qameta.allure.Description;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {


    @Test(description = "Checkout Page")
    @Description("Validate that 'Checkout Page' was opened")
    public void checkoutButton() {
        loginPage
                .open()
                .isPageOpened()
                .login("standard_user", "secret_sauce");
        cartPage
                .open()
                .isPageOpened()
                .openCheckoutPage();
        checkoutPage
                .isPageOpened();
    }

    @Test
    public void cancelButton() {
        loginPage
                .open()
                .isPageOpened()
                .login("standard_user", "secret_sauce");
        cartPage
                .open()
                .isPageOpened()
                .openCheckoutPage();
        checkoutPage
                .clickCancel();
        cartPage
                .isPageOpened();
    }

    @Test
    public void correctCheckout() {
        loginPage
                .open()
                .isPageOpened()
                .login("standard_user", "secret_sauce");
        cartPage
                .open()
                .isPageOpened()
                .openCheckoutPage();
        checkoutPage
                .checkoutInformation("Dow", "Jones", "50450")
                .clickContinue();
        overviewPage
                .isPageOpened();
    }

    @Test(description = "Complete order")
    public void сompleteOrder() {
        loginPage
                .open()
                .isPageOpened()
                .login("standard_user", "secret_sauce");
        productsPage
                .open()
                .isPageOpened()
                .buyProduct("Sauce Labs Bolt T-Shirt");
        cartPage
                .open()
                .isPageOpened()
                .openCheckoutPage();
        checkoutPage
                .open()
                .isPageOpened()
                .checkoutInformation("Dow", "Jones", "50450")
                .clickContinue();
        overviewPage
                .open()
                .isPageOpened()
                .clickFinish();
        assertEquals(overviewPage.validateOrderCompletion(), "THANK YOU FOR YOUR ORDER");
    }
}
