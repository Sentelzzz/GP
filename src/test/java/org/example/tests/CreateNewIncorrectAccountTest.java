package org.example.tests;

import org.example.service.AccountPageService;
import org.example.utils.Retry;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateNewIncorrectAccountTest extends BaseTest {

    private AccountPageService accountPageService;

    @BeforeClass
    public void setUp() {
        accountPageService = new AccountPageService();
    }

    @Test(description = "Creating account without account name", retryAnalyzer = Retry.class)
    public void createIncorrectAccount() throws IOException, ParseException {
        accountPageService.createIncorrectAccount();
        String expectedErrorMessage = "Review the errors on this page.";
        String actualErrorMessage = accountPageService.getTextErrorMessageCreatingNewAccount();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "You didn't get right error message!");
    }

}
