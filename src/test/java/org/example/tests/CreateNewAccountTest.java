package org.example.tests;

import org.example.service.AccountPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewAccountTest extends BaseTest{

    private AccountPageService accountPageService;

    @BeforeTest
    public void setUp() {
        accountPageService = new AccountPageService();
    }

    @Test (description = "create new Account", priority = 0)
    public void createNewAccountTest() {
        accountPageService.createNewAccount();
        String expectedNameNewAccount = accountPageService.getAccountName();
        String actualNameNewAccount = accountPageService.getTextNameCreatedAccount();
        Assert.assertEquals(actualNameNewAccount, expectedNameNewAccount, "You didn't create new account!");
    }

    @Test (description = "delete account after creating", dependsOnMethods = "createNewAccountTest", priority = 1)
    public void deleteNewAccount() {
        accountPageService.deleteNewAccount();
    }

    @Test (description = "Creating account without account name", priority = 2)
    public void createIncorrectAccount() {
        accountPageService.createIncorrectAccount();
        String expectedErrorMessage = accountPageService.getTextErrorMessageCreatingNewAccount();
        String actualErrorMessage = "Review the errors on this page.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "You didn't get right error message!");
    }

}
