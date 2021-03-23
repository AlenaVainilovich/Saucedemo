package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import java.util.List;

public class CartPage extends BasePage {
    public static final String URL_CART_PAGE = "https://www.saucedemo.com/cart.html";
    public static final By CHECKOUT_BUTTON = By.cssSelector(".checkout_button");
    public static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//*[contains(text(),'Continue')]");
    private static final By REMOVE_BUTTON = By.xpath("//button[@class='btn_secondary cart_button']");
    public static final By CART_ITEM = By.cssSelector(".cart_item_label");
    public static final String COMMON_PATH_CART_ITEM = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']";
    public static final String ITEM_PRICE = COMMON_PATH_CART_ITEM + "//*[@class='inventory_item_price']";
    public static final String ITEM_QUANTITY = COMMON_PATH_CART_ITEM + "//*[@class='cart_quantity']";



    public CartPage(WebDriver browser) {

        super(browser);
    }

    @Override
    public CartPage open() {
        browser.get(URL_CART_PAGE);
        return this;
    }

    public void productShouldBeInTheList(String productName) {
        Assert.assertEquals(browser.findElement(By.xpath(String.format("//*[contains(text(),'%s')]", productName))).getText(), productName);

    }

    public int getNumberOfItemsInCart() {
        List<WebElement> itemsList = browser.findElements(CART_ITEM);
        return itemsList.size();
    }

    public String getItemPrice(String productName) {
        String productPrice = browser.findElement(By.xpath(String.format(ITEM_PRICE, productName))).getText();
        return productPrice;
    }

    public String getItemQuantity(String productName) {
        String productQuantity = browser.findElement(By.xpath(String.format(ITEM_QUANTITY, productName))).getText();
        return productQuantity;
    }

    public void removeFromCart() {
        browser.findElement(REMOVE_BUTTON).click();
    }


    public void buttonForContinueShoppingClick() {
        browser.findElement(CONTINUE_SHOPPING_BUTTON);
    }

    public void openCheckoutPage() {
        browser.findElement(CHECKOUT_BUTTON).click();
    }


    public CartPage isPageOpened() {
        Assert.assertTrue(browser.findElement(CHECKOUT_BUTTON).isDisplayed());;
        return this;
    }

}
