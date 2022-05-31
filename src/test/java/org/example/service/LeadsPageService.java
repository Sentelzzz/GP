package org.example.service;

import org.example.page.LeadsPage;

import static org.example.utils.StringConstants.*;

public class LeadsPageService extends LoginPageService{

    private LeadsPage leadsPage = new LeadsPage();

    public String getTextLeadName() {
        return lead.getLastName();
    }

    public String getActualTextLeadName() {
        return leadsPage.getActualTextNameOfLeadPage();
    }

    public String getErrorMessage() {
        return leadsPage.getErrorMessage();
    }

    public void createNewLead() {
        login(USERNAME, PASSWORD, LOG_IN_URL).openNextPage(LEADS_PAGE);
        leadsPage.clickCreateNewLeadButton()
                .fillLastNameField(lead)
                .fillCompanyField(lead)
                .choseLeadStatus(lead)
                .clickOnSaveButton();
    }

    public void createNewIncorrectLead() {
        login(USERNAME, PASSWORD, LOG_IN_URL).openNextPage(LEADS_PAGE);
        leadsPage.clickCreateNewLeadButton()
                .fillLastNameField(incorrectLead)
                .fillCompanyField(incorrectLead)
                .choseLeadStatus(incorrectLead)
                .clickOnSaveButton();
    }

    public void deleteNewLead() {
        login(USERNAME, PASSWORD, LOG_IN_URL).openNextPage(LEADS_PAGE);
        leadsPage.deleteCreatedLead();
    }

}
