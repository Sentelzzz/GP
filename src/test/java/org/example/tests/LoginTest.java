package org.example.tests;

import org.example.page.HomePage;
import org.example.service.LoginPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.example.utils.StringConstants.*;

public class LoginTest extends BaseTest {

    private LoginPageService loginPageService;

    @BeforeTest
    public void setUp() {
        loginPageService = new LoginPageService();
    }

    @Test(description = "Login with correct user info")
    public void loginTest() {
        HomePage homePage = loginPageService.login(USERNAME, PASSWORD, LOG_IN_URL);
        String actualNameHomePage = homePage.getNameHomePage();
        String expectedNameHomePage = "Sales";
        Assert.assertEquals(actualNameHomePage, expectedNameHomePage, "You aren't on the home page!");
    }

    @Test(description = "Login with incorrect user info")
    public void loginWithIncorrectInformationTest() {
        loginPageService.login(USERNAME, INCORRECTPASSWORD, LOG_IN_URL);
        String actualErrorMessage = loginPageService.getTextErrorMessage();
        String expectedErrorMessage = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message isn't correct!");
    }
}
