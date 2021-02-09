package tests;

import org.testng.annotations.Test;
import tests.BaseTest;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void wrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "1234");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service",
                "Error message is not correct");
    }
}

