package org.example.tests;

import org.example.service.LeadsPageService;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateNewLeadTest extends BaseTest {

    private LeadsPageService leadsPageService;

    @BeforeClass
    public void setUp() {
        leadsPageService = new LeadsPageService();
    }

    @Test(description = "Create new lead, fill out all necessary fields")
    public void createNewCorrectLeadTest() throws IOException, ParseException {
        leadsPageService.createNewLead();
        String expectedNameOfLead = leadsPageService.getTextLeadName();
        String actualNameOfLead = leadsPageService.getActualTextLeadName();
        Assert.assertEquals(actualNameOfLead, expectedNameOfLead, "Name of new lead doesn't correct!");
    }
}
