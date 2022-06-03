package org.example.tests;

import org.example.service.LeadsPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewIncorrectLeadTest extends BaseTest {

    private LeadsPageService leadsPageService;

    @BeforeTest
    public void setUp() {
        leadsPageService = new LeadsPageService();
    }

    @Test(description = "Create new lead, doesn't fill out all necessary fields")
    public void createNewIncorrectLeadTest() {
        leadsPageService.createNewIncorrectLead();
        String actualErrorMessage = leadsPageService.getErrorMessage();
        String expectedErrorMessage = "We hit a snag.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "You didn't get right error message!");
    }

}
