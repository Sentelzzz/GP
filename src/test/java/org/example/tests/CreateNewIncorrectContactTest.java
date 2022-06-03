package org.example.tests;

import org.example.service.ContactPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewIncorrectContactTest extends BaseTest {

    private ContactPageService contactPageService;

    @BeforeTest
    public void setUp() {
        contactPageService = new ContactPageService();
    }

    @Test(description = "Create new contact, doesn't fill out all necessary fields")
    public void createNewIncorrectContactTest() {
        contactPageService.createNewIncorrectContact();
        String actualErrorMessage = contactPageService.getErrorMessage();
        String expectedErrorMessage = "We hit a snag.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "You didn't get right error message!");
    }

}
