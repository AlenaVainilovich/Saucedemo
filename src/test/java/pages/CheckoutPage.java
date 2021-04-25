package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage{

    public static final By FIRST_NAME = By.id("first-name");
    public static final By LAST_NAME = By.id("last-name");
    public static final By ZIP_CODE = By.id("postal-code");
    public static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link.btn_secondary");
    public static final By CONTINUE_BUTTON = By.cssSelector(".btn_primary.cart_button");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click button 'Cancel'")
    public CartPage clickCancel() {
        browser.findElement(CANCEL_BUTTON).click();
        return new CartPage(browser);
    }

    @Step("Click button 'Continue'")
    public OverviewPage clickContinue() {
        browser.findElement(CONTINUE_BUTTON).click();
        return new OverviewPage(browser);
    }

    @Step("Fill Checkout Information")
    public CheckoutPage checkoutInformation(String firstName, String lastName, String zipCode) {
        browser.findElement(FIRST_NAME).sendKeys(firstName);
        browser.findElement(LAST_NAME).sendKeys(lastName);
        browser.findElement(ZIP_CODE).sendKeys(zipCode);
        return this;
    }

    @Step("Get text from Error Message")
    public String validateErrorMessage() {
        return browser.findElement(ERROR_MESSAGE).getText();
    }

    @Override
    @Step("Check that 'Checkout Page' was opened")
    public CheckoutPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CANCEL_BUTTON));
        return this;
    }

    @Override
    @Step("Open 'Checkout Page'")
    public CheckoutPage open() {
        browser.get("https://www.saucedemo.com/checkout-step-one.html");
        isPageOpened();
        return this;
    }



}
