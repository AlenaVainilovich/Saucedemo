import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class LoginTest {

    @Test
    public void checkFirstLogin() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("https://www.saucedemo.com/index.html");
        WebElement username = browser.findElement(By.id("user-name"));
        WebElement password = browser.findElement(By.id("password"));
        WebElement loginbutton = browser.findElement(By.id("login-button"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginbutton.click();
        String actualUrl = browser.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        assertEquals(actualUrl, expectedUrl, "Неверный логин или пароль");
        browser.quit();
    }
}
