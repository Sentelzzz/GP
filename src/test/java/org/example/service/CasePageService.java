package org.example.service;

import org.example.page.CasePage;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import static org.example.utils.StringConstants.*;

public class CasePageService extends LoginPageService{

    private CasePage casePage = new CasePage();

    public String getTextPageName() {
        return casePage.getTextPageName();
    }

    public String getTextCurrentStatus() {
        return casePage.getTextCurrentStatus();
    }

    public void createNewCaseBug() throws IOException, ParseException {
        login("userName", "password", LOG_IN_URL).openNextPage(CASE_PAGE);
        casePage.clickCreateNewCaseButton()
                .clickOnSelect(CASE_ORIGIN)
                .choseCaseOption(CASE_ORIGIN_OPTION)
                .clickOnSelect(STATUS)
                .choseCaseOption(STATUS_OPTION)
                .clickSaveButton();
    }

    public void createNewCase() throws IOException, ParseException {
        login("userName", "password", LOG_IN_URL).openNextPage(CASE_PAGE);
        casePage.clickCreateNewCaseButton()
                .clickOnSelect(CASE_ORIGIN)
                .choseCaseOption(CASE_ORIGIN_OPTION)
                .clickSaveButton();
    }

    public void changeCurrentCaseStatus() throws IOException, ParseException {
        login("userName", "password", LOG_IN_URL).openNextPage(CASE_PAGE);
        casePage.openCreatedCase()
                .changeCurrentCaseStatus(CLOSED)
                .confirmNewCaseStatus();
    }
}
