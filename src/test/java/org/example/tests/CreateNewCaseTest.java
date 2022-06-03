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

    @Test(description = "Create new case")
    public void createNewCaseTest() {
        casePageService.createNewCase();
        String expectedPageName = "Case Details";
        String actualPageName = casePageService.getTextPageName();
        Assert.assertEquals(actualPageName, expectedPageName, "You didn't create new case!");
    }
}
