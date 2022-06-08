package org.example.tests;

import org.example.page.HomePage;
import org.example.service.LoginPageService;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.example.utils.StringConstants.*;

public class LoginTest extends BaseTest {

    private LoginPageService loginPageService;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
    }

    @Test(description = "Login with correct user info")
    public void loginTest() throws IOException, ParseException {
        HomePage homePage = loginPageService.login("userName", "password", LOG_IN_URL);
        String actualNameHomePage = homePage.getNameHomePage();
        String expectedNameHomePage = "Sales";
        Assert.assertEquals(actualNameHomePage, expectedNameHomePage, "You aren't on the home page!");
    }

    @Test(description = "Login with incorrect user info")
    public void loginWithIncorrectInformationTest() throws IOException, ParseException {
        loginPageService.login("userName", "incorrectPassword", LOG_IN_URL);
        String actualErrorMessage = loginPageService.getTextErrorMessage();
        String expectedErrorMessage = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message isn't correct!");
    }
}
