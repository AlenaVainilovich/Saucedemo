package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductsPage extends BasePage {
    public static final String ADD_TO_CARD = "//*[text()='%s']/ancestor::*[contains(@class,'inventory_item')]//button";
    public static final By PRODUCT_LABEL = By.cssSelector(".product_label");

    public ProductsPage(WebDriver browser) {
        super(browser);
    }

    @Override
    public ProductsPage open() {
        return this;
    }

    public ProductsPage buyProduct(String product_name) {
        browser.findElement(By.xpath(String.format(ADD_TO_CARD, product_name))).click();
        return this;
    }

    @Override
    public ProductsPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_LABEL));
        } catch (TimeoutException ex) {
            Assert.fail("Страница со списком продуктов не загрузилась");
        }
        return this;
    }
}
