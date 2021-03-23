package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {
    public static final By LOGIN_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver browser) {

        super(browser);
    }

    public LoginPage open() {

        browser.get("https://www.saucedemo.com/index.html");
        return this;
    }

    public void login(String userName, String password) {
        browser.findElement(LOGIN_INPUT).sendKeys(userName);
        browser.findElement(PASSWORD_INPUT).sendKeys(password);
        browser.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMessage() {
        return browser.findElement(ERROR_MESSAGE).getText();
    }

    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(LOGIN_BUTTON));
        return this;
    }

}
