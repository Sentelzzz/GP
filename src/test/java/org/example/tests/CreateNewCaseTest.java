package org.example.tests;

import org.example.service.CasePageService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.example.utils.StringConstants.CLOSED;

public class CreateNewCaseTest extends BaseTest{

    private CasePageService casePageService;

    @BeforeTest
    public void setUp() {
        casePageService = new CasePageService();
    }

    @Test(description = "Create new case", priority = 1)
    public void createNewCaseTest() {
        casePageService.createNewCase();
        String expectedPageName = "Case Details";
        String actualPageName = casePageService.getTextPageName();
        Assert.assertEquals(actualPageName, expectedPageName, "You didn't create new case!");
    }

    @Test(description = "Change current status and confirm it", priority = 2)
    public void changeCurrentStatusTest() {
        casePageService.changeCurrentCaseStatus();
        String expectedStatusName = "Status: " + CLOSED;
        String actualStatusName = casePageService.getTextCurrentStatus();
        Assert.assertEquals(actualStatusName, expectedStatusName, "Status wasn't changed!");
    }
}
