package org.example.tests;

import org.example.models.Account;
import org.example.service.AccountPageService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CreateNewAccountTest extends BaseTest{

    AccountPageService accountPageService = new AccountPageService();

    @Test (description = "create new Account")
    public void createNewAccountTest() {
        accountPageService.createNewAccount();
        String expectedNameNewAccount = accountPageService.getAccountName();
        String actualNameNewAccount = accountPageService.getTextNameCreatedAccount();
        Assert.assertEquals(actualNameNewAccount, expectedNameNewAccount, "You didn't create new account!");
    }

    @Test (description = "delete account after creating", dependsOnMethods = "createNewAccountTest")
    public void deleteNewAccount() {
        accountPageService.deleteNewAccount();
    }

    @Test (description = "Creating account without account name")
    public void createIncorrectAccount() {
        accountPageService.createIncorrectAccount();
        String expectedErrorMessage = accountPageService.getTextErrorMessage();
        String actualErrorMessage = "Review the errors on this page.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "You didn't get right error message!");
    }

}
