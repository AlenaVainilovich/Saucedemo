package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver browser;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    OverviewPage overviewPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        browser = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(browser);
        productsPage = new ProductsPage(browser);
        cartPage = new CartPage(browser);
        overviewPage = new OverviewPage(browser);
        checkoutPage = new CheckoutPage(browser);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if (browser !=null){
            browser.quit();
        }
    }
}
