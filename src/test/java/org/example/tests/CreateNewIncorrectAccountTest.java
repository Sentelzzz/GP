package org.example.tests;

import org.example.service.AccountPageService;
import org.example.utils.Retry;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewIncorrectAccountTest extends BaseTest {

    private AccountPageService accountPageService;

    @BeforeTest
    public void setUp() {
        accountPageService = new AccountPageService();
    }

    @Test(description = "Creating account without account name", retryAnalyzer = Retry.class)
    public void createIncorrectAccount() {
        accountPageService.createIncorrectAccount();
        String expectedErrorMessage = "Review the errors on this page.";
        String actualErrorMessage = accountPageService.getTextErrorMessageCreatingNewAccount();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "You didn't get right error message!");
    }

}
