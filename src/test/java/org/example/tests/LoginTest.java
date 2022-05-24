package org.example.tests;

import org.example.page.HomePage;
import org.example.service.LoginPageService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    private LoginPageService loginPageService = new LoginPageService();

    @Test
    public void loginTest() {
        HomePage homePage = loginPageService.login("davsrd-fyd2@force.com", "TMSonlAQA12Java", "https://login.salesforce.com/");
        String actualNameHomePage = homePage.getNameHomePage();
        String expectedNameHomePage = "Sales";
        Assert.assertEquals(actualNameHomePage, expectedNameHomePage, "You aren't on the home page");
    }
}
