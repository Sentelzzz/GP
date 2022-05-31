package org.example.tests;

import org.example.service.LeadsPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewLeadTest extends BaseTest {

    private LeadsPageService leadsPageService;

    @BeforeTest
    public void setUp() {
        leadsPageService = new LeadsPageService();
    }

    @Test(description = "Create new lead, fill out all necessary fields")
    public void createNewCorrectLeadTest() {
        leadsPageService.createNewLead();
        String expectedNameOfLead = leadsPageService.getTextLeadName();
        String actualNameOfLead = leadsPageService.getActualTextLeadName();
        Assert.assertEquals(actualNameOfLead, expectedNameOfLead, "Name of new lead doesn't correct!");
    }

    @Test(description = "Create new lead, doesn't fill out all necessary fields")
    public void createNewIncorrectLeadTest() {
        leadsPageService.createNewIncorrectLead();
        String actualErrorMessage = leadsPageService.getErrorMessage();
        String expectedErrorMessage = "We hit a snag.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "You didn't get right error message!");
    }
}
