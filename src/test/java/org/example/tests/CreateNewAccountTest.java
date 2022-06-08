package org.example.tests;

import org.example.service.AccountPageService;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateNewAccountTest extends BaseTest {

    private AccountPageService accountPageService;

    @BeforeClass
    public void setUp() {
        accountPageService = new AccountPageService();
    }

    @Test(description = "Create new Account, fill out all necessary fields")
    public void createNewAccountTest() throws IOException, ParseException {
        accountPageService.createNewAccount();
        String expectedNameNewAccount = accountPageService.getAccountName();
        String actualNameNewAccount = accountPageService.getTextNameCreatedAccount();
        Assert.assertEquals(actualNameNewAccount, expectedNameNewAccount, "You didn't create new account!");
    }

}
