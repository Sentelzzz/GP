package org.example.tests;

import org.example.service.CasePageService;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.example.utils.StringConstants.CLOSED;

public class CreateNewCaseTest extends BaseTest{

    private CasePageService casePageService;

    @BeforeClass
    public void setUp() {
        casePageService = new CasePageService();
    }

    @Test(description = "Create new case")
    public void createNewCaseTest() throws IOException, ParseException {
        casePageService.createNewCase();
        String expectedPageName = "Case Details";
        String actualPageName = casePageService.getTextPageName();
        Assert.assertEquals(actualPageName, expectedPageName, "You didn't create new case!");
    }
}
