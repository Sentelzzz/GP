package org.example.tests;

import org.example.service.AccountPageService;
import org.example.service.ContactPageService;
import org.example.service.LeadsPageService;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteCreatedAccount extends BaseTest {

    AccountPageService accountPageService;

    @BeforeClass
    public void setUp() {
        accountPageService = new AccountPageService();
    }

    @Test
    public void deleteCreatedAccount() throws IOException, ParseException {
        accountPageService.deleteNewAccount();
    }

}
