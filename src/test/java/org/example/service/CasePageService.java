package org.example.service;

import org.example.page.CasePage;

import static org.example.utils.StringConstants.*;

public class CasePageService extends LoginPageService{

    private CasePage casePage = new CasePage();

    public String getTextPageName() {
        return casePage.getTextPageName();
    }

    public String getTextCurrentStatus() {
        return casePage.getTextCurrentStatus();
    }

    public void createNewCaseBug() {
        login(USERNAME, PASSWORD, LOG_IN_URL).openNextPage(CASE_PAGE);
        casePage.clickCreateNewCaseButton()
                .clickOnSelect(CASE_ORIGIN)
                .choseCaseOption(CASE_ORIGIN_OPTION)
                .clickOnSelect(STATUS)
                .choseCaseOption(STATUS_OPTION)
                .clickSaveButton();
    }

    public void createNewCase() {
        login(USERNAME, PASSWORD, LOG_IN_URL).openNextPage(CASE_PAGE);
        casePage.clickCreateNewCaseButton()
                .clickOnSelect(CASE_ORIGIN)
                .choseCaseOption(CASE_ORIGIN_OPTION)
                .clickSaveButton();
    }

    public void changeCurrentCaseStatus() {
        login(USERNAME, PASSWORD, LOG_IN_URL).openNextPage(CASE_PAGE);
        casePage.openCreatedCase()
                .changeCurrentCaseStatus(CLOSED)
                .confirmNewCaseStatus();
    }
}
