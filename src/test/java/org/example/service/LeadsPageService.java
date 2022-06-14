package org.example.service;

import org.example.page.LeadsPage;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import static org.example.utils.StringConstants.*;

public class LeadsPageService extends LoginPageService{

    private final LeadsPage leadsPage = new LeadsPage();

    public String getTextLeadName() {
        return lead.getLastName();
    }

    public String getActualTextLeadName() {
        return leadsPage.getActualTextNameOfLeadPage();
    }

    public String getErrorMessage() {
        return leadsPage.getErrorMessage();
    }

    public void createNewLead() throws IOException, ParseException {
        login("userName", "password", LOG_IN_URL).openNextPage(LEADS_PAGE);
        leadsPage.clickCreateNewLeadButton()
                .fillLastNameField(lead)
                .fillCompanyField(lead)
                .choseLeadStatus(lead)
                .clickSaveButton();
    }

    public void createNewIncorrectLead() throws IOException, ParseException {
        login("userName", "password", LOG_IN_URL).openNextPage(LEADS_PAGE);
        leadsPage.clickCreateNewLeadButton()
                .fillLastNameField(incorrectLead)
                .fillCompanyField(incorrectLead)
                .choseLeadStatus(incorrectLead)
                .clickSaveButton();
    }

    public void deleteNewLead() throws IOException, ParseException {
        login("userName", "password", LOG_IN_URL).openNextPage(LEADS_PAGE);
        leadsPage.deleteCreatedLead();
    }

}
