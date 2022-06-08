package org.example.tests;

import org.example.service.LeadsPageService;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateNewIncorrectLeadTest extends BaseTest {

    private LeadsPageService leadsPageService;

    @BeforeClass
    public void setUp() {
        leadsPageService = new LeadsPageService();
    }

    @Test(description = "Create new lead, doesn't fill out all necessary fields")
    public void createNewIncorrectLeadTest() throws IOException, ParseException {
        leadsPageService.createNewIncorrectLead();
        String actualErrorMessage = leadsPageService.getErrorMessage();
        String expectedErrorMessage = "We hit a snag.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "You didn't get right error message!");
    }

}
