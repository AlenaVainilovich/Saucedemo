package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OverviewPage extends BasePage{

    public static final By FINISH_BUTTON = By.cssSelector(".btn_action.cart_button");
    public static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link.btn_secondary");
    public static final By CONFIRMATION_TEXT = By.cssSelector(".complete-header");

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public void clickFinish() {
        browser.findElement(FINISH_BUTTON).click();
    }

    public ProductsPage clickCancel() {
        browser.findElement(CANCEL_BUTTON).click();
        return new ProductsPage(browser);
    }

    public String validateOrderCompletion() {
        String text = browser.findElement(CONFIRMATION_TEXT).getText();
        return text;
    }

    @Deprecated
    public OverviewPage open() {
        return this;
    }

    @Override
    public OverviewPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(FINISH_BUTTON));
        return this;
    }

}
