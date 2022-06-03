package org.example.tests;

import org.example.service.CasePageService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.example.utils.StringConstants.CLOSED;

public class ChangeCaseStatusTest extends BaseTest {

    private CasePageService casePageService;

    @BeforeTest
    public void setUp() {
        casePageService = new CasePageService();
    }

    @Test(description = "Change current status and confirm it")
    public void changeCurrentStatusTest() {
        casePageService.changeCurrentCaseStatus();
        String expectedStatusName = "Status: " + CLOSED;
        String actualStatusName = casePageService.getTextCurrentStatus();
        Assert.assertEquals(actualStatusName, expectedStatusName, "Status wasn't changed!");
    }

}
