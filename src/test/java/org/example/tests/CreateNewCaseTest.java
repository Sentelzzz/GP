package org.example.tests;

import org.example.service.CasePageService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.example.utils.StringConstants.CLOSED;

public class CreateNewCaseTest extends BaseTest{

    private CasePageService casePageService;

    @BeforeTest
    public void setUp() {
        casePageService = new CasePageService();
    }

    @Test(description = "There is bug, whew you open create new case page, in dropdown Status already chosen option NEW, has to be --None--")
    public void createNewCaseBugTest() {
        casePageService.createNewCaseBug();
        String expectedPageName = "Case Details";
        String actualPageName = casePageService.getTextPageName();
        Assert.assertEquals(actualPageName, expectedPageName, "You didn't create new case!");
    }

    @Test(description = "Create new case")
    public void createNewCaseTest() {
        casePageService.createNewCase();
        String expectedPageName = "Case Details";
        String actualPageName = casePageService.getTextPageName();
        Assert.assertEquals(actualPageName, expectedPageName, "You didn't create new case!");
    }

    @Test(description = "Change current status and confirm it")
    public void changeCurrentStatusTest() {
        casePageService.changeCurrentCaseStatus();
        String expectedStatusName = "Status: " + CLOSED;
        String actualStatusName = casePageService.getTextCurrentStatus();
        Assert.assertEquals(actualStatusName, expectedStatusName, "Status wasn't changed!");
    }
}
