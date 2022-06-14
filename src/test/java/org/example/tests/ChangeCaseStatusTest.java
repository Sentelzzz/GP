package org.example.tests;

import org.example.service.CasePageService;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.example.utils.StringConstants.CLOSED;

public class ChangeCaseStatusTest extends BaseTest {

    private CasePageService casePageService;

    @BeforeClass
    public void setUp() {
        casePageService = new CasePageService();
    }

    @Test(description = "Change current status and confirm it")
    public void changeCurrentStatusTest() throws IOException, ParseException {
        casePageService.changeCurrentCaseStatus();
        String expectedStatusName = "Status: " + CLOSED;
        String actualStatusName = casePageService.getTextCurrentStatus();
        Assert.assertEquals(actualStatusName, expectedStatusName, "Status wasn't changed!");
    }

}
