package org.example.tests;

import org.example.service.AccountPageService;
import org.example.service.ContactPageService;
import org.example.service.LeadsPageService;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteCreatedContact extends BaseTest {

    ContactPageService contactPageService;

    @BeforeClass
    public void setUp() {
        contactPageService = new ContactPageService();
    }

    @Test
    public void deleteCreatedAccount() throws IOException, ParseException {
        contactPageService.deleteNewContact();
    }

}
