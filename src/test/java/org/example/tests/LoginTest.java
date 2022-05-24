package org.example.tests;

import org.example.page.HomePage;
import org.example.service.LoginPageService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.utils.StringConstants.*;

public class LoginTest extends BaseTest{

    private LoginPageService loginPageService = new LoginPageService();

    @Test
    public void loginTest() {
        HomePage homePage = loginPageService.login(USERNAME, PASSWORD, LOG_IN_URL);
        String actualNameHomePage = homePage.getNameHomePage();
        String expectedNameHomePage = "Sales";
        Assert.assertEquals(actualNameHomePage, expectedNameHomePage, "You aren't on the home page!");
    }

    @Test
    public void loginWithIncorrectInformationTest() {
        loginPageService.login(USERNAME, INCORRECTPASSWORD, LOG_IN_URL);
        String actualErrorMessage = loginPageService.getTextErrorMessage();
        String expectedErrorMessage = "Please check your username and password. If you still can't log in, contact your Salesforce administrator!";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }
}
