package org.example.tests;

import org.example.service.ContactPageService;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateNewIncorrectContactTest extends BaseTest {

    private ContactPageService contactPageService;

    @BeforeClass
    public void setUp() {
        contactPageService = new ContactPageService();
    }

    @Test(description = "Create new contact, doesn't fill out all necessary fields")
    public void createNewIncorrectContactTest() throws IOException, ParseException {
        contactPageService.createNewIncorrectContact();
        String actualErrorMessage = contactPageService.getErrorMessage();
        String expectedErrorMessage = "We hit a snag.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "You didn't get right error message!");
    }

}
