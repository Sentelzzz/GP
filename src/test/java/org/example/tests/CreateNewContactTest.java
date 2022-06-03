package org.example.tests;

import org.example.service.ContactPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewContactTest extends BaseTest {

    private ContactPageService contactPageService;

    @BeforeTest
    public void setUp() {
        contactPageService = new ContactPageService();
    }

    @Test(description = "Create new contact, fill out all necessary fields")
    public void createNewContactTest(){
        contactPageService.createNewContact();
        String actualNewContact = contactPageService.getTextActualCreatedContact();
        String expectedNewContact = contactPageService.getFirstName() + " " + contactPageService.getLastName();
        Assert.assertEquals(actualNewContact, expectedNewContact, "New contact wasn't created!");
    }

}
