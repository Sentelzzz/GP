package org.example.tests;

import org.example.service.AccountPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewAccountTest extends BaseTest {

    private AccountPageService accountPageService;

    @BeforeTest
    public void setUp() {
        accountPageService = new AccountPageService();
    }

    @Test(description = "Create new Account, fill all necessary fields")
    public void createNewAccountTest() {
        accountPageService.createNewAccount();
        String expectedNameNewAccount = accountPageService.getAccountName();
        String actualNameNewAccount = accountPageService.getTextNameCreatedAccount();
        Assert.assertEquals(actualNameNewAccount, expectedNameNewAccount, "You didn't create new account!");
    }

    @Test(description = "Creating account without account name")
    public void createIncorrectAccount() {
        accountPageService.createIncorrectAccount();
        String expectedErrorMessage = accountPageService.getTextErrorMessageCreatingNewAccount();
        String actualErrorMessage = "Review the errors on this page.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "You didn't get right error message!");
    }

}
